package com.project.ProductService.inheritancerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    Student save(Student student);
}
