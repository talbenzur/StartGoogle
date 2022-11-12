package week4.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week4.springBoot.repository.UserRepository;
import week4.springBoot.model.User;
import week4.springBoot.utilities.UniqueNumber;

import java.util.*;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository = UserRepository.getInstance();

    private HashMap<Long, Long> userIdToToken = new HashMap<>();
    private UniqueNumber tokenUniqueNumber = new UniqueNumber();
    private Set<Long> tokenSet = new HashSet<>();

    @Autowired
    private TokenService tokenService = new TokenService();


    public Long createUser(String email, String name, String password) {
        Optional<List<String>> emails = userRepository.getEmails();

        if (emails.isPresent()) {
            if (emails.get().contains(email)) {
                System.out.println(("Account with given Email already exists"));
                return null;
            }
        }

        UniqueNumber userId = new UniqueNumber();
        long userIdNum = userId.getID();
        User newUser = new User(userIdNum, email, name, password);
        userRepository.writeUser(newUser);
        System.out.println("User registered successfully");
        return userIdNum;
    }

    public Long logIn(String email, String password) {

        Optional<User> user =  userRepository.getUserByEmail(email);

        if (!user.isPresent()) {
            System.out.println(String.format("User with email %s doesn't exists.", email));
        }
        if (!user.get().getPassword().equals(password)) {
            System.out.println("Error! Incorrect password!");
        }

        Long token;
        do {
            token = tokenUniqueNumber.getID();
        } while (tokenSet.contains(token));
        tokenService.setSession(token, user.get().getId());
        return token;
    }
}