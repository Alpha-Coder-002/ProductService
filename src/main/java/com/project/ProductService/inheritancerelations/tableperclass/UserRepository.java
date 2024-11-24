package com.project.ProductService.inheritancerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
   User save(User user);
}
