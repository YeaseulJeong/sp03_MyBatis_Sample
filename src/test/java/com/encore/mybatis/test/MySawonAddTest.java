package com.encore.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;


public class MySawonAddTest {

	public static void main(String[] args) throws Exception {
		// 1. 화면에서 받았다고 치고 받아들인 값으로 VO생성 
		MySawon vo = new MySawon();
		vo.setId("lees34");
		vo.setPwd("24689");
		vo.setName("King");
		vo.setAge(10);
		
		// 2. MyBatis Framework 사용
		Reader r= Resources.getResourceAsReader("config/SqlMapConfig.xml");    // 모든걸 다 갖고있는 SqlMapConfig 설정문서를 넘겨주고 
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);  // 모든걸 다 갖고있는 SqlMapConfig 을 가지고 SqlSessionFactory로 가서 factory를 만든다
		SqlSession session = factory.openSession();   // SqlSession 이 쿼리문을 실행하는 것  
		
		// session.insert("mysawonMapper.sawonAdd", vo);   // insert, delete, update. selectList, selectOne .......
		// session.delete("mysawonMapper.sawonDel", "lees34");
		//List<MySawon> list = session.selectList("mysawonMapper.sawonAll");
		// session.commit();
		
		//System.out.println(vo.getName()+" 님이 회원으로 가입하셨습니다.");
		// System.out.println("삭제 성공");
		
//		for(MySawon sawon: list) {
//			System.out.println(sawon);
//		}
		
		MySawon v2 = new MySawon();
		v2.setId("encore");
		v2.setPwd("1234");
		
		MySawon sawon = session.selectOne("mysawonMapper.login", v2);
		session.commit();
		System.out.println(sawon);
	}

}
