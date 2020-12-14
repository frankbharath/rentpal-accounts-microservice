package com.rentpal.accounts.service.interfaces;/*
 * @author frank
 * @created 12 Dec,2020 - 2:53 AM
 */

import com.rentpal.accounts.dto.UserDTO;
import com.rentpal.accounts.model.User;

public interface UserService {
    UserDTO addOAuthUser(User user);

    UserDTO getUser();

    UserDTO getUserById(Long id);

    UserDTO getUserByEmail(String email);
}
