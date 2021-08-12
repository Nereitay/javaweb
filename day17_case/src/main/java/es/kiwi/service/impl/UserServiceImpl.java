package es.kiwi.service.impl;

import es.kiwi.dao.UserDAO;
import es.kiwi.dao.impl.UserDAOImpl;
import es.kiwi.domain.PageBean;
import es.kiwi.domain.User;
import es.kiwi.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDAO dao = new UserDAOImpl();

    @Override
    public List<User> findAll() {
        //调用DAO完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        // 注意：进行健壮性判断
        if (uids != null && uids.length > 0) {
            for (String uid : uids) {
                dao.delete(Integer.parseInt(uid));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        PageBean<User> pb = new PageBean<User>();

        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        int rows = Integer.parseInt(_rows);
        pb.setRows(rows);

        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);

        int currentPage = Integer.parseInt(_currentPage);
        if (currentPage <= 0)
            currentPage = 1;
        else if (currentPage >= totalPage)
            currentPage = totalPage;

        pb.setCurrentPage(currentPage);

        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);

        return pb;
    }
}
