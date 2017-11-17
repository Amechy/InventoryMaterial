package com.example.inventoryMaterial.data.db.repository;

import com.example.inventoryMaterial.pojo.User;

import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {
    private ArrayList<User> users;
    private static UserRepository userRepository;

    static {
        userRepository = new UserRepository();
    }

    public UserRepository(){
        this.users = new ArrayList<>();
        initialize();
    }

    public static UserRepository getInstance(){
        if (userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;

    }


    private void initialize(){

        addUser(new User(1,"AMechy", "1234", "Alejanro", "alex.x.ulom@gmail.com", true, false ));
        addUser(new User(2,"AMechy2", "1234", "Alejanro2", "alex.x.ulom2@gmail.com", false, true ));
        addUser(new User(3,"AMechy3", "1234", "Alejanro3", "alex.x.ulom3@gmail.com", false, false ));


    }
    public void addUser(User user){
        users.add(user);
    }
    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * Método que comprueba si el usuario está duplicado.
     * @return
     * @param user
     */
    public boolean isUserExists(User user){
        return true;
    }
}
