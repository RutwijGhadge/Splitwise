package com.project.Splitwise.Service.IMPLs;

import com.project.Splitwise.DTO.UserDTO;
import com.project.Splitwise.Exception.UserNotFoundException;
import com.project.Splitwise.Models.User;
import com.project.Splitwise.Repository.UserRepository;
import com.project.Splitwise.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO getUserById(int userId) throws UserNotFoundException {
        User user = fetchUserById(userId);
        UserDTO userDTO=modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    private User fetchUserById(int userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User is Not Registered with the ID :"+userId));
    }
}
