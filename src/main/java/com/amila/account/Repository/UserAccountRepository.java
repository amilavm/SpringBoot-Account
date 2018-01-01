package com.amila.account.Repository;

import com.amila.account.Model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
    UserAccount findByFirstname(String firstname);
    UserAccount findByToken(String token);
    UserAccount findByEmail(String email);
    UserAccount findByUsername(String username);
    UserAccount findById(Integer id);
}
