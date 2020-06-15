package com.my.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.DTO.MemberDTO;
import com.my.mapper.MapperDAO;

@Service("testDB")
public class MyTestService implements ControllerToModel{
	
	private MapperDAO mapper;

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<MemberDTO> selectAll() {
		mapper = sqlSession.getMapper(MapperDAO.class);
		ArrayList<MemberDTO> dTOs = mapper.selectAll();
		return dTOs;
	}

	@Override
	public void insert(String id, String name) {
		// TODO Auto-generated method stub
		mapper = sqlSession.getMapper(MapperDAO.class);
		mapper.insert(id, name);
	}

	@Override
	public void del(String id) {
		// TODO Auto-generated method stub
		mapper = sqlSession.getMapper(MapperDAO.class);
		mapper.del(id);
	}

	@Override
	public MemberDTO selectOne(String id) {
		// TODO Auto-generated method stub
		mapper = sqlSession.getMapper(MapperDAO.class);
		return mapper.selectOne(id);
	}

	@Override
	public void modify(MemberDTO memberdto) {
		// TODO Auto-generated method stub
		mapper = sqlSession.getMapper(MapperDAO.class);
		mapper.modify(memberdto);
	}

	@Override
	public void modifyhash(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		mapper = sqlSession.getMapper(MapperDAO.class);
		mapper.modifyhash(map);
	}


}
