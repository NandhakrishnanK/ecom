package com.base.ecom.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    @Autowired UserRepository userRepository;

    public void add(UserDto userDto) {
    	userRepository.save(toEntity(userDto));
    }

    public List<UserDto> getUsers() {
    	List<User> users = (List<User>) userRepository.findAll();
    	List<UserDto> userDtoList = toDtoList(users);
        return userDtoList;
    }

    public void deleteById(Long id) {
    	userRepository.deleteById(id);
    }

    User toEntity(UserDto userDto) {
    	User user = null;
    	if (null != userDto) {
            user = new User(userDto.getId(), userDto.getUserName(),
    				userDto.getPassword());
    	}
    	return user;
    }

    UserDto toDto(User user) {
    	UserDto userDto = null;
    	if (null != user) {
    		userDto = new UserDto.Builder().id(user.getId()).
    				userName(user.getUserName()).
    				password(user.getPassword()).build();
    	}
    	return userDto;
    }

    List<UserDto> toDtoList(List<User> users) {
    	List<UserDto> userDtoList = new ArrayList<UserDto>();
    	if (!CollectionUtils.isEmpty(users)) {
    		for (User user: users) {
    			userDtoList.add(toDto(user));
    		}
    	}
    	return userDtoList;
    }
}
