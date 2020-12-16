package com.progracol.bingo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.progracol.bingo.entity.user.Usuario;
import com.progracol.bingo.exception.ModelNotFoundException;
import com.progracol.bingo.repo.user.UsuarioRepo;
import com.progracol.bingo.service.IUsuarioService;


@Service
public class UsuarioServiceImp implements IUsuarioService, UserDetailsService{
	
	@Autowired
	private UsuarioRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByUsername(username);
		if(usuario == null)
			throw new ModelNotFoundException("----Nick o password incorecto");
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add((GrantedAuthority) new SimpleGrantedAuthority(usuario.getRol().getName()));
		
		UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), roles);		
		return ud;
	}
}
