package com.billa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billa.user.entities.UserPass;

@Repository
public interface UserPassRepo extends JpaRepository<UserPass, String>  {

}
