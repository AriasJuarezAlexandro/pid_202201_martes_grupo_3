package com.proyecto.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Administrador;
import com.proyecto.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AdministradorRepository repository;
	
	@Override
	public Administrador registrarAdministrador(Administrador administrador) {
		administrador.setPassword(passwordEncoder.encode(administrador.getPassword()));
		return repository.save(administrador);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Administrador bean = repository.findByEmail(username );
		if(bean == null) {
			throw new UsernameNotFoundException("Usuario o password invalidos");
		}
		Set<GrantedAuthority>authorities=new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("admin"));
		
		return new User(bean.getEmail() , bean.getPassword() , authorities);
	}

}
