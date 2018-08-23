package spring.project.shopping.login_service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.project.shopping.login_interface.Login;
import spring.project.shopping.userdto.UserDTO;

@Repository
public class LoginService implements Login {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserDTO LoginCheck(UserDTO user) {
		// TODO Auto-generated method stub

		return sqlSession.selectOne("spring.project.shopping.loginMapper.LoginCheck", user);
	}

}
