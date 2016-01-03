package lctst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lctst.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByName(String name);
}
