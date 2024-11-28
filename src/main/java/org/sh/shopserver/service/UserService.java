package org.sh.shopserver.service;

import org.sh.shopserver.model.Role;
import org.sh.shopserver.model.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    void changeRole(Role newRole, String username);
    List<User> findAllUsers();
}