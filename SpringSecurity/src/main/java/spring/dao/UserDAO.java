package spring.dao;

import spring.model.User;

public interface UserDAO {
	 
    public User getUser(String login);

}