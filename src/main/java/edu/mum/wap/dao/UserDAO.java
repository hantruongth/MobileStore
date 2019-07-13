package edu.mum.wap.dao;

import edu.mum.wap.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {

    Map<String, User> usersDB;

    {
        usersDB = new HashMap<>();
        usersDB.put("tuyen", new User(1, "tuyen", "123", "Thanh Tuyen Le", "ttle@mum.edu", "2000 N. Court St., Fairfield, Iowa", "(641) 234 - 7689"));
        usersDB.put("han", new User(2, "han","456", "Han Thuong Truong", "hantruong@mum.edu", "301 Main St., Fairfield, Iowa", "(641) 656 - 8908"));
    }

    public boolean checkExistUser(String username, String password){
        if(usersDB.containsKey(username) && usersDB.get(username).getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public boolean checkExitsByUsername (String username){
        if(usersDB.containsKey(username))
            return true;
        return false;
    }

    public boolean addUser (String username, String password, String fullname, String email, String address, String phone){
        if (checkExitsByUsername(username))
            return false;
        else
        {
            usersDB.put(username, new User(usersDB.size()+1, username, password, fullname, email, address, phone));
            return true;
        }
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(usersDB.values());
    }
    public User getUserByUsername(String username){
        return usersDB.get(username);
    }

    public Map<String, User> getUsersDB(){
        return this.usersDB;
    }
}
