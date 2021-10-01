package com.dh.Integrador.service.impl;

import com.dh.Integrador.model.User.Rol;
import com.dh.Integrador.model.User.User;
import com.dh.Integrador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

   @Autowired
   UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> usuario = userRepository.getUserByName(s);

        Set<GrantedAuthority> autorizaciones = new HashSet<>();

        for (Rol rol: usuario.get().getRoles()){
            GrantedAuthority autorizacion = new SimpleGrantedAuthority(rol.getName());
            autorizaciones.add(autorizacion);
        }

        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(usuario.get().getName(),"{noop}" + usuario.get().getPassword(), true, true, true, true, autorizaciones);
        return userDetail;
    }
}
