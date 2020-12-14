package com.rentpal.accounts.common;/*
 * @author frank
 * @created 12 Dec,2020 - 11:25 PM
 */

import com.rentpal.accounts.dto.UserDTO;
import com.rentpal.accounts.model.User;

public class DTOModelMapper {

    public UserDTO userModelDTOMapper(User user) {
        UserDTO userDTO=new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setCreationTime(Utils.getDate(user.getCreationTime()));
        userDTO.setVerified(user.isVerified());
        return userDTO;
    }
}
