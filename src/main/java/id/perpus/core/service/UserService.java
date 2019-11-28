package id.perpus.core.service;

import id.perpus.core.dao.UserDAO;
import id.perpus.core.entity.User;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Service
public class UserService extends AbstractGenericService<User> implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    private PasswordEncoder bcryptEncoder;

//    @Transactional
//    @Caching(
//            evict = {
//                    @CacheEvict(cacheNames = CacheName.)
//            }
//    )

    public Map<String, Object> login(User param){
        User currentUser = userDAO.findByUsername(param.getUsername());

        if(currentUser == null){
            return null;
        }

        return null;
    }

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(s);

        if (user == null){
            throw new UsernameNotFoundException("User not found with username: "+s);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    @Override
    @Transactional
    public User save(User entity) {
            User user = new User();
            user.setName(entity.getName());
            user.setPassword(bcryptEncoder.encode(entity.getPassword()));
            user.setUsername(entity.getUsername());
            userDAO.save(user);

        return null;
    }

    @Override
    @Transactional
    public User delete(User entity) {
        User user = userDAO.findReference(entity.getId());
        userDAO.delete(user);
        return null;
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Collection<User> find() {

        return userDAO.find();
    }
}