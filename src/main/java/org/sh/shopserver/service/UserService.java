package org.sh.shopserver.service;

import org.sh.shopserver.dto.UserDTO;
import org.sh.shopserver.model.Role;
import org.sh.shopserver.model.User;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO findByUsername(String username);
    void changeRole(Role newRole, String username);
    List<UserDTO> findAllUsers();

    default User dtoToEntity(UserDTO userDTO) {
        User user = User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .build();
        return user;
    }
    default UserDTO entityToDto(User user){
        UserDTO userDTO=UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .createTime(user.getCreateTime())
                .role(user.getRole())
                .build();
        return userDTO;
    }
}
