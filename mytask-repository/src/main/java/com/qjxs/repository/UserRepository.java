package com.qjxs.repository;

import com.qjxs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,String> ,QuerydslPredicateExecutor<User>{



}
