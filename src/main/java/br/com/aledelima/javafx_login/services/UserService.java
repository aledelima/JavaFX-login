/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aledelima.javafx_login.services;

import br.com.aledelima.javafx_login.model.entities.User;
import br.com.aledelima.javafx_login.model.enums.UserLevel;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aledelima
 */
public class UserService {
    
	List<User> mockedUsers = Arrays.asList(
			new User(1, "recepcinist", "frontend", UserLevel.OPERATOR, true), 
			new User(2, "cashier", "money", UserLevel.OPERATOR, true),
			new User(3, "manager", "littleboss", UserLevel.MANAGER, true),
			new User(4, "director", "bigboss", UserLevel.MANAGER, true)
		);	
	
    public User findByName(String name) {
        for (User u: mockedUsers)
        	if (u.getName().equals(name))
        		return u;
        return null;
    }
    
    public List<User> findAll() {
        return this.mockedUsers;
    }    
    
}
