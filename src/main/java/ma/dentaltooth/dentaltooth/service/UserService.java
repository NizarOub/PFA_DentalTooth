package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.Dto.UserDto;
import ma.dentaltooth.dentaltooth.model.Userr;

public interface UserService {
    void saveUser(UserDto userDto);

    Userr findUserByEmail(String email);
}