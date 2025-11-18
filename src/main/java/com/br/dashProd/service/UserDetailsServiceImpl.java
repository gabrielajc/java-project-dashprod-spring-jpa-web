package com.br.dashProd.service;

import com.br.dashProd.respository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() ->
                new UsernameNotFoundException("Usuário não encontrado"));
    }

    public UserDetailsServiceImpl(UserRepository userRepository1) {
        this.userRepository = userRepository1;
    }
}
