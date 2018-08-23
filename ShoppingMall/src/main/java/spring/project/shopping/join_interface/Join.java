package spring.project.shopping.join_interface;

import spring.project.shopping.userdto.UserDTO;

public interface Join {
void joinUser(UserDTO user);
UserDTO idCheck(String userId);

}
