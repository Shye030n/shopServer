package org.sh.shopserver.repository;

import org.sh.shopserver.model.Role;
import org.sh.shopserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Modifying
    @Query("update User set role =: role where username =: username")
    void updateUserRole(@Param("username")String username, @Param("role") Role role);

}
