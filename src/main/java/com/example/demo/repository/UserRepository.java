package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.model.inout.UserIn;
import com.example.demo.model.inout.UserOut;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<Integer, User> users = new HashMap<>();
    private int userCount = 0;

    public UserOut createUser(UserIn userIn) {
        var userId = userCount++;
        users.put(userId, new User(userIn.name(), userIn.email()));
        return new UserOut(userId, userIn.name(), userIn.email());
    }

    public UserOut getUserById(Integer id) {
        var findUser = users.get(id);
        if (findUser != null) {
            return new UserOut(id, findUser.name(), findUser.email());
        }
        return null;
    }

    public List<UserOut> getAllUsers() {
        return users.entrySet().stream()
                .map(entry -> new UserOut(entry.getKey(), entry.getValue().name(), entry.getValue().email()))
                .toList();
    }

    public UserOut updateUserById(Integer id, UserIn userIn) {
        var savedValue = users.put(id, new User(userIn.name(), userIn.email()));
        return new UserOut(id, userIn.name(), userIn.email());
    }

    public void deleteUserById(Integer id) {
        users.remove(id);
    }
}
