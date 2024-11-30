package com.example.indentity_service.repository;

import com.example.indentity_service.entity.Dotcuutro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotcuutroRepository extends JpaRepository<Dotcuutro, String> {

}
