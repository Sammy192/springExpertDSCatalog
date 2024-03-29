package com.devsamuca.dscatalog.repositories;

import com.devsamuca.dscatalog.entities.PasswordRecover;
import com.devsamuca.dscatalog.entities.User;
import com.devsamuca.dscatalog.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordRecoverRepository extends JpaRepository<PasswordRecover, Long> {

}
