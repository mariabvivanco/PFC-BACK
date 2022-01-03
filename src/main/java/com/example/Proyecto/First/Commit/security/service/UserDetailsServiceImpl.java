package com.example.Proyecto.First.Commit.security.service;

import com.example.Proyecto.First.Commit.entities.User;
import com.example.Proyecto.First.Commit.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Autentica un usuario de la base de datos
 *
 * Authentication Manager llama al método loadUserByUsername de esta clase
 * para obtener los detalles del usuario de la base de datos cuando
 * se intente autenticar un usuario
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByemail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),user.getPassword(),new ArrayList<>());
    }
}
