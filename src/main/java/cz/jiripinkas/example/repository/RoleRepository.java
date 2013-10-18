package cz.jiripinkas.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.example.entity.Role;
import cz.jiripinkas.example.entity.Role.ROLE_TYPE;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByName(ROLE_TYPE name);
}
