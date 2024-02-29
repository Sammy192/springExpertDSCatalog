package com.devsamuca.dscatalog.repositories;

import com.devsamuca.dscatalog.entities.Product;
import com.devsamuca.dscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
