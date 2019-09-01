package ru.geekbrains.jsf;

import ru.geekbrains.persist.item.User;
import ru.geekbrains.persist.repository.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class UserService {

    @EJB
    private UserRepository userRepository;

    @Transactional
    public User merge(UserRepr user) {
        return userRepository.merge(new User(user));
    }

    @Transactional
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Transactional
    public UserRepr findById(int id) {
        return new UserRepr(userRepository.findById(id));
    }

    @Transactional
    public boolean existsById(int id) {
        return userRepository.findById(id) != null;
    }

    @Transactional
    public List<UserRepr> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }

}
