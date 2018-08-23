package spring.project.shopping.top_service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.project.shopping.paging.Criteria;
import spring.project.shopping.top_interface.Jacket;
import spring.project.shopping.topdto.TopDTO;

@Repository
public class JacketService implements Jacket {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<TopDTO> itemList(Criteria criteria) {
		// TODO Auto-generated method stub
		
		
		return sqlSession.selectList("spring.project.shopping.jacketMapper.JacketList",criteria);
	}
	
	@Override
		public int itemCount() {
			// TODO Auto-generated method stub
			return  sqlSession.selectOne("spring.project.shopping.jacketMapper.itemTotal");
		}
	
@Override
		public void registryJacket(TopDTO jacketDto) {
			// TODO Auto-generated method stub
	sqlSession.insert("spring.project.shopping.jacketMapper.registryJacket", jacketDto);
	
		
		}

@Override
	public TopDTO detailJacket(int productId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("spring.project.shopping.jacketMapper.detailJacket", productId);
	}

@Override
	public void purchaseJacket(TopDTO jacketDto) {
		// TODO Auto-generated method stub
		sqlSession.update("spring.project.shopping.jacketMapper.purchaseJacket", jacketDto);
	}

@Override
	public void modifyJacket(TopDTO jacketDto) {
		// TODO Auto-generated method stub
		sqlSession.update("spring.project.shopping.jacketMapper.modifyJacket", jacketDto);
	}

@Override
	public void deleteJacket(int productId) {
		// TODO Auto-generated method stub
	sqlSession.delete("spring.project.shopping.jacketMapper.deleteJacket", productId);
		
	}

}
