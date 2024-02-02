package com.devsamuca.dscatalog.services;

import com.devsamuca.dscatalog.dto.CategoryDTO;
import com.devsamuca.dscatalog.entities.Category;
import com.devsamuca.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = repository.findAll();
        List<CategoryDTO> listDTO = list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
        return listDTO;

        //forma de converter entity Category para CategoryDTO
        /*List<CategoryDTO> listDto = new ArrayList<>();
        for (Category cat : list) {
            listDto.add(new CategoryDTO(cat));
        }
        return listDto;*/
    }
}