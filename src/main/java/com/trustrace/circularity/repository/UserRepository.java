package com.trustrace.circularity.repository;

import com.trustrace.circularity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
