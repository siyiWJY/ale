package cn.aura.mybatis01.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.aura.mybatis01.entity.Book;
import cn.aura.mybatis01.mapper.BookMapper;

public class MapperTest {

	@Test
	public void test1() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		Book book = mapper.findById(1);
		System.out.println(book);
		session.close();
	}

	@Test
	public void test2() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> book = mapper.selAll();
		Iterator<Book> it = book.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		session.close();
	}

	@Test
	public void test3() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		int b = mapper.delete(17);
		System.out.println(b);
		session.close();
	}
	@Test
	public void test4() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		Book book=new Book("西厢","鬼知道",54.30);
		int b = mapper.insert(book);
		System.out.println(b);
		session.close();
	}
}
