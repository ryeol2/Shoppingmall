package spring.project.shopping.join_service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.project.shopping.join_interface.Join;
import spring.project.shopping.userdto.UserDTO;

@Repository
public class JoinService implements Join {
@Autowired
private SqlSession sqlSession;

	@Override
	public void joinUser(UserDTO user) {
		// TODO Auto-generated method stub
		Join joinUser = sqlSession.getMapper(Join.class);
		joinUser.joinUser(user);

	}

@Override
	public UserDTO idCheck(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("spring.project.shopping.join_interface.Join.checkId", userId);
	}
	
}
