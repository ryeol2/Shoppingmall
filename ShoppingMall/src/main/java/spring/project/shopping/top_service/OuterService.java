package spring.project.shopping.top_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.project.shopping.paging.PageSet;
import spring.project.shopping.top_interface.Outer;
import spring.project.shopping.topdto.TopDTO;

@Repository
public class OuterService implements Outer {
@Autowired
private SqlSession sqlSession;

	@Override
	public List<TopDTO> itemList(PageSet criteria) {
		// TODO Auto-generated method stub
		
		
		return sqlSession.selectList("spring.project.shopping.outerMapper.outerList",criteria);
	}
	
	@Override
		public int itemCount() {
			// TODO Auto-generated method stub
			return  sqlSession.selectOne("spring.project.shopping.outerMapper.itemTotal"); // mapper namespace . mapper id
		}
	
@Override
		public void registryOuter(TopDTO outerDto) {
			// TODO Auto-generated method stub
	sqlSession.insert("spring.project.shopping.outerMapper.registryOuter", outerDto);
	
		
		}

@Override
	public TopDTO detailOuter(int productId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("spring.project.shopping.outerMapper.detailOuter", productId);
	}

@Override
	public void purchaseOuter(TopDTO outerDto) {
		// TODO Auto-generated method stub
		sqlSession.update("spring.project.shopping.outerMapper.purchaseOuter", outerDto);
	}

@Override
	public void modifyOuter(TopDTO outerDto) {
		// TODO Auto-generated method stub
		sqlSession.update("spring.project.shopping.outerMapper.modifyOuter", outerDto);
	}

@Override
	public void deleteOuter(int productId) {
		// TODO Auto-generated method stub
	sqlSession.delete("spring.project.shopping.outerMapper.deleteOuter", productId);
		
	}

}
