package com.example.crudintermediario.controllers.mappers;

import com.example.crudintermediario.controllers.dtos.requests.UserRequestDTO;
import com.example.crudintermediario.controllers.dtos.responses.UserResponseDTO;
import com.example.crudintermediario.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toDomain(UserRequestDTO userRequestDTO);

    UserResponseDTO fromDomain(User user);

    List<UserResponseDTO> fromDomainList(List<User> userList);

}
