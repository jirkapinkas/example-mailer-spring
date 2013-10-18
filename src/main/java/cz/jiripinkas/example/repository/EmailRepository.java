package cz.jiripinkas.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.example.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {

}
