package me.henji.picpaysimplificado.dtos;

import me.henji.picpaysimplificado.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal value, String email, String password, UserType userType) {}
