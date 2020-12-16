package com.progracol.bingo.repo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progracol.bingo.entity.user.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findByUsername(String username);
}
