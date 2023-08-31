package com.jiangren.movie.mapper;

import com.jiangren.movie.dto.user.UserGetDto;
import com.jiangren.movie.dto.user.UserPostDto;
import com.jiangren.movie.dto.user.UserPutDto;
import com.jiangren.movie.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

        UserGetDto fromEntity(User user);

        User toEntity(UserPostDto userPostDto);

        void copy(UserPutDto userPutDto, @MappingTarget User user);
}
