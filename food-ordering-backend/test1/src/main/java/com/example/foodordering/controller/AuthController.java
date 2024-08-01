package com.example.foodordering.controller;

import com.example.foodordering.dto.JwtResponseDTO;
import com.example.foodordering.dto.UserDTO;
import com.example.foodordering.model.User;
import com.example.foodordering.service.UserService;
import com.example.foodordering.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public UserDTO register(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.register(userDTO);
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getFullName(), user.getAddress(), user.getPhoneNumber());
    }

    @PostMapping("/login")
    public JwtResponseDTO login(@Valid @RequestBody UserDTO userDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid email or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getEmail());
        final String jwtToken = jwtUtil.generateToken(userDetails);

        return new JwtResponseDTO(jwtToken);
    }
}
