package com.nsgrigorjev.springmvchibernate.service;

import com.nsgrigorjev.springmvchibernate.database.entity.User;
import com.nsgrigorjev.springmvchibernate.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findById(Long id) {
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
}
