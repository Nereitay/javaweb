package es.kiwi.service;

import es.kiwi.domain.PageBean;
import es.kiwi.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    User login(User user);

    void addUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    void updateUser(User user);

    void delSelectedUser(String[] uids);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
