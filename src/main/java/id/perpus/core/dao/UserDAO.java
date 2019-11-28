package id.perpus.core.dao;

import id.perpus.core.entity.User;
import java.util.List;

/**
 * create date 12/11/2019
 */

public interface UserDAO extends BaseDAO<User>{

    User findByUsername(String param);

    List<User> find();

    List<User> findById2();

    User updatePassword(User param);
}
