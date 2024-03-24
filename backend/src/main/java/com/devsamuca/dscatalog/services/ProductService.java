package com.devsamuca.dscatalog.services;

import com.devsamuca.dscatalog.dto.CategoryDTO;
import com.devsamuca.dscatalog.dto.ProductDTO;
import com.devsamuca.dscatalog.entities.Category;
import com.devsamuca.dscatalog.entities.Product;
import com.devsamuca.dscatalog.projections.ProductProjection;
import com.devsamuca.dscatalog.repositories.CategoryRepository;
import com.devsamuca.dscatalog.repositories.ProductRepository;
import com.devsamuca.dscatalog.services.exceptions.DatabaseException;
import com.devsamuca.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> list = repository.findAll(pageable);
        Page<ProductDTO> listDTO = list.map(x -> new ProductDTO(x));
        return listDTO;

        //forma de converter entity Product para ProductDTO
        /*List<ProductDTO> listDto = new ArrayList<>();
        for (Product cat : list) {
            listDto.add(new ProductDTO(cat));
        }
        return listDto;*/
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDate(dto.getDate());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPrice(dto.getPrice());

        entity.getCategories().clear();
        for (CategoryDTO catDto : dto.getCategories()) {
            Category category = categoryRepository.getReferenceById(catDto.getId());
            entity.getCategories().add(category);
        }

    }

    @Transactional(readOnly = true)
    public Page<ProductProjection> findAllPaged(String name, String categoryId, Pageable pageable) {

        List<Long> categoryIds = Arrays.asList();
        if (!"0".equals(categoryId)) {
            String[] vet = categoryId.split(",");
            List<String> list = Arrays.asList(vet);
            categoryIds = list.stream().map(x -> Long.parseLong(x)).toList();

            //categoryIds = Arrays.asList(categoryId.split(",")).stream().map(Long::parseLong).toList();
        }

        return repository.searchProducts(categoryIds, name, pageable);
    }
}
