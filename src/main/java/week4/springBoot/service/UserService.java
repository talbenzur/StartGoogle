package week4.springBoot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week4.springBoot.repository.UserRepository;
import week4.springBoot.model.User;
import week4.springBoot.utilities.UniqueNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static week4.springBoot.service.TokenService.getIDFromToken;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository = UserRepository.getInstance();
    private HashMap<Long, Long> userIdTokenMap = new HashMap<>();
    private Set<Long> tokenSet = new HashSet<>();
    private UniqueNumber tokenUniqueNumber = new UniqueNumber();
    private Set<Long> loggedIdUsers = new HashSet<>();
    private TokenService tokenService = new TokenService();

    public void updateName(long token, String newName) {
        Long id = getIDFromToken(token);
        if (id != null) {
            Optional<User> user = userRepository.getUserById(id);
            if (user.isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        user.get().getEmail(), newName, user.get().getPassword());
                userRepository.updateUser(updatedUser);
                System.out.println("User Name updated successfully");
            } else {
                System.out.println("Can't update name");
            }
        } else {
            System.out.println("The token is invalid");
        }
    }

    public void updateEmail( long token, String newEmail) {
        Long id = getIDFromToken(token);
        if (id != null) {
            Optional<User> user = userRepository.getUserById(id);
            if (user.isPresent() && !userRepository.getUserByEmail(newEmail).isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        newEmail, user.get().getName(), user.get().getPassword());
                userRepository.updateUser(updatedUser);
                System.out.println("User Email updated successfully");
            } else {
                System.out.println("Can't update email");
            }
        } else {
            System.out.println("The token is invalid");
        }
    }

    public void userUpdatePassword( long token, String newPassword) {
        Long id = getIDFromToken(token);
        if (id != null) {
            Optional<User> user = userRepository.getUserById(id);
            if (user.isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        user.get().getEmail(), user.get().getName(), newPassword);
                userRepository.updateUser(updatedUser);
                System.out.println("User Password updated successfully");
            } else {
                System.out.println("Can't update password");
            }
        } else {
            System.out.println("The token is invalid");
        }
    }

    public void deleteUser( long token) {
        Long id = getIDFromToken(token);
        if (id != null) {
            Optional<User> user = userRepository.getUserById(id);
            if (user.isPresent()) {
                if (userRepository.deleteUser(user.get())){
                    System.out.println("User Account deleted successfully");
                }
            } else {
                System.out.println("Can't delete user.");
            }
        } else {
            System.out.println("The token is invalid");
        }
    }
}
