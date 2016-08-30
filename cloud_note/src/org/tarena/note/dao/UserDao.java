package org.tarena.note.dao;

import org.tarena.note.entity.User;

public interface UserDao {
	public User findByName(String name);
	public int save(User user);
	public int chagePassword(User user);
}
