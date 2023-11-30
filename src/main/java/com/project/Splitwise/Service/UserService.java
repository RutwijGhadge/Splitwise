package com.project.Splitwise.Service;

import com.project.Splitwise.DTO.UserDTO;
import com.project.Splitwise.Exception.UserNotFoundException;

public interface UserService {
    UserDTO getUserById(int userId) throws UserNotFoundException;
}
