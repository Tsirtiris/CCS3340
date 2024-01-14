package com.blood.bloodglucose.respositories;

import com.blood.bloodglucose.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
