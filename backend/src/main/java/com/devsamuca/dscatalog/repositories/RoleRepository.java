package com.devsamuca.dscatalog.repositories;

import com.devsamuca.dscatalog.entities.Role;
import com.devsamuca.dscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByAuthority(String authority);
}
