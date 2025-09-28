package com.mySite.MyJavaSite.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModel extends JpaRepository<Users, Long> {
}
