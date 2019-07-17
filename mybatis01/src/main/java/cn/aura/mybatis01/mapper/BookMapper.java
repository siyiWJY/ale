package cn.aura.mybatis01.mapper;

import java.util.List;

import cn.aura.mybatis01.entity.Book;

public interface BookMapper {

	Book findById(int bid);
	List<Book> selAll();
	int delete(int bid);
	int insert(Book book);
}
