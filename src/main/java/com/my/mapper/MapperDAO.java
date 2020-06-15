package com.my.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.my.DTO.MemberDTO;

public interface MapperDAO {	
	public ArrayList<MemberDTO> selectAll();
	public void insert(@Param("id")String id, 
			@Param("name") String name);
	public void del(String id);
	public MemberDTO selectOne(String id);
	public void modify(MemberDTO memberDTO);
	public void modifyhash(HashMap<String,String> map);
}
