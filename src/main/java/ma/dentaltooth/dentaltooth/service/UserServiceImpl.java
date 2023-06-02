package ma.dentaltooth.dentaltooth.service;

import ma.dentaltooth.dentaltooth.Dto.TbConstants;
import ma.dentaltooth.dentaltooth.Dto.UserDto;
import ma.dentaltooth.dentaltooth.model.Roles;
import ma.dentaltooth.dentaltooth.model.Userr;
import ma.dentaltooth.dentaltooth.model.users.Staff;
import ma.dentaltooth.dentaltooth.repository.RolesRepository;
import ma.dentaltooth.dentaltooth.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserrRepository userRepository;

    @Autowired
    private RolesRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        Roles role = roleRepository.findByName(TbConstants.Roles.USER);

        if (role == null)
            role = roleRepository.save(new Roles(TbConstants.Roles.USER));

        Staff user = new Staff(userDto.getName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
                Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public Staff findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}