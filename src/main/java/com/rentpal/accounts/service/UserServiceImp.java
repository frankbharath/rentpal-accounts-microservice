package com.rentpal.accounts.service;
import com.rentpal.accounts.common.DTOModelMapper;
import com.rentpal.accounts.common.Utils;
import com.rentpal.accounts.dto.UserDTO;
import com.rentpal.accounts.exception.APIRequestException;
import com.rentpal.accounts.model.User;
import com.rentpal.accounts.repository.UserRepository;
import com.rentpal.accounts.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/*
 * @author frank
 * @created 12 Dec,2020 - 2:50 AM
 */

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final DTOModelMapper dtoModelMapper;

    @Autowired
    public UserServiceImp(UserRepository userRepository, DTOModelMapper dtoModelMapper){
        this.userRepository=userRepository;
        this.dtoModelMapper=dtoModelMapper;
    }

    @Override
    public UserDTO addOAuthUser(User user) {
        user.setVerified(true);
        user.setCreationTime(System.currentTimeMillis());
        if(!userRepository.existsByEmail(user.getEmail())) {
            userRepository.save(user);
        }
        return getUserByEmail(user.getEmail());
    }

    @Override
    public UserDTO getUser(){
        Long userId=Utils.getUserId();
        String email;
        if(userId!=null){
            return getUserById(userId);
        }else if((email = Utils.getUserEmail())!=null){
            return getUserByEmail(email);
        }
        throw new APIRequestException("No user session found");
    }

    @Override
    public UserDTO getUserById(Long id){
        User dbUser= userRepository.findById(id).orElse(null);
        if(dbUser==null){
            throw new APIRequestException("User not found");
        }
        return dtoModelMapper.userModelDTOMapper(dbUser);
    }

    @Override
    public UserDTO getUserByEmail(String email){
        User dbUser= userRepository.findByEmail(email).orElse(null);
        if(dbUser==null){
            throw new APIRequestException("User not found");
        }
        return dtoModelMapper.userModelDTOMapper(dbUser);
    }
}
