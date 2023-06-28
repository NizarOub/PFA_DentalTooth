package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.Dto.UserDto;
import ma.dentaltooth.dentaltooth.model.users.Staff;

public interface UserService {
    void saveUser(UserDto userDto);

    Staff findUserByEmail(String email);
}