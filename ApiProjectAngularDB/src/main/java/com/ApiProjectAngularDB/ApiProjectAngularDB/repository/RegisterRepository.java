package com.ApiProjectAngularDB.ApiProjectAngularDB.repository;

import com.ApiProjectAngularDB.ApiProjectAngularDB.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<User, Integer> {
    public User findUserByEmail(String emailUser);
    public User findUserByEmailAndPassword(String emailUser, String passwordUser);

}
