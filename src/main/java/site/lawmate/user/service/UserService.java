package site.lawmate.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import site.lawmate.user.component.Messenger;
import site.lawmate.user.domain.model.User;
import site.lawmate.user.domain.dto.UserDto;

public interface UserService extends UserDetailsService {

//    default User dtoToEntity(UserDto dto) {
//        return User.builder()
//                .email(dto.getEmail())
//                .name(dto.getName())
//                .phone(dto.getPhone())
//                .age(dto.getAge())
//                .sex(dto.getSex())
//                .point(dto.getPoint())
//                .password(dto.getPassword())
//                .build();
//    }
//
//    default UserDto entityToDto(User user) {
//        return UserDto.builder()
//                .id(user.getId())
//                .email(user.getEmail())
//                .name(user.getName())
//                .phone(user.getPhone())
//                .age(user.getAge())
//                .sex(user.getSex())
//                .point(user.getPoint())
//                .password(user.getPassword())
//                .build();
//    }
//
//    Messenger login(UserDto param);
//
//    Boolean logout(String accessToken);
//
//    Messenger modify(UserDto user);
//
//    User autoRegister();
//
//    Boolean existsByEmail(String email);

}
