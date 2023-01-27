package com.fundamentosplatzi.springboot.fundamentos2.service;

import com.fundamentosplatzi.springboot.fundamentos2.emtity.User;
import com.fundamentosplatzi.springboot.fundamentos2.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    private final Log Log= LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void  saveTransactional(List<User>users ){
        users.stream()
                .peek(user -> Log.info(" Usuario insertado"+user))
                .forEach(userRepository::save);
//                .forEach(user -> userRepository.save(user));


    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User newUser, Long id) {
        return
                userRepository.findById(id)
                .map(
                        user -> {
                            user.setEmail(newUser.getEmail());
                            user.setBirthdate(newUser.getBirthdate());
                            user.setName(newUser.getName());
                            return userRepository.save(user);
                        }
                ).get();
    }
}
