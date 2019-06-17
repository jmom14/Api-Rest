package com.example.main.service.abstrct;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IServices<T> {

	T create (T t);
	T findById(long id);
	boolean delete(long id);
	boolean update(T t, long id);
	List<T> findAll();
	
	
}
