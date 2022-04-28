package com.peaksoft.SpringBootCrud.repository;

import com.peaksoft.SpringBootCrud.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}