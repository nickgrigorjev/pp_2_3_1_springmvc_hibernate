package com.nsgrigorjev.service;

import com.nsgrigorjev.database.entity.User;
import com.nsgrigorjev.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Transactional
    public <S extends User> void persist(S entity) {
        userRepository.persist(entity);
    }

    @Transactional
    public <S extends User> void update(S entity) {
        userRepository.update(entity);
    }

    @Transactional
    public void executeNativeQuery(String sql) {
        userRepository.executeNativeQuery(sql);
    }
}