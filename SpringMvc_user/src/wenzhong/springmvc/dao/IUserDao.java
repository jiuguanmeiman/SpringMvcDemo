package wenzhong.springmvc.dao;

import java.util.List;

import wenzhong.springmvc.model.Pager;
import wenzhong.springmvc.model.User;

public interface IUserDao {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list();
	public Pager<User> find();
	public User loadByUsername(String username);
}
