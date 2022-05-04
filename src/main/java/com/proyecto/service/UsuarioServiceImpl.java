package com.proyecto.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Usuario;
import com.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService , UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		return repository.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario bean = repository.findByUsername(username);
		if (bean == null) {
			throw new UsernameNotFoundException("Usuario o password invalidos");
		}
		Set<GrantedAuthority>authorities=new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("admin"));
		
		return new User(bean.getUsername() , bean.getPassword() , authorities);
	}

}
