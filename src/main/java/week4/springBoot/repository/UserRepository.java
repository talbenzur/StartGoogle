package week4.springBoot.repository;

import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import week4.springBoot.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {

    private static UserRepository instance;

    private static final String USERS_REPO_PATH = "src/main/java/App/Repository/users/";

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private HashMap<Long, User> users;

    private UserRepository() {
        this.users = new HashMap<>();
        initUsers();
    }

    public void writeUser(User user) {
        Gson gson = new Gson();
        String filePath = USERS_REPO_PATH + user.getId();
        try(FileWriter fileWriter = new FileWriter(filePath)) {
            users.put(user.getId(), user);
            gson.toJson(user, fileWriter);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<List<String>> getEmails() {
        return Optional.of(users.values().stream()
                .map(User::getEmail)
                .collect(Collectors.toList()));
    }

    public Optional<User> getUserById(long id) {
        return Optional.of(users.get(id));
    }

    public Optional<User> getUserByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public void updateUser(User user) {
        users.put(user.getId(), user);
        writeUser(user);
    }

    public boolean deleteUser(User user) {
        users.remove(user.getId());
        Path path = Paths.get(USERS_REPO_PATH + user.getId());
        try {
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initUsers() {
        Optional<List<String>> filePaths = getFilePaths();
        if (!filePaths.isPresent()) {
            return;
        }
        Gson gson = new Gson();
        for (String path : filePaths.get()) {
            try(BufferedReader reader = new BufferedReader(new FileReader(path));) {
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                // delete the last new line separator
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                User user = gson.fromJson(stringBuilder.toString(), User.class);
                this.users.put(user.getId(), user);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Optional<List<String>> getFilePaths() {
        List<String> paths;
        try (Stream<Path> stream = Files.list(Paths.get(USERS_REPO_PATH))) {
            paths = stream
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(paths);
    }
}
