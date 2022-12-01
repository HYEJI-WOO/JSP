package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.common.ConnectionUtil;
import com.domain.BoardVO;

public class BoardDao {
	
	private DataSource dataSource;
	
	public BoardDao() {
		dataSource = ConnectionUtil.getDataSource();
	}

	public List<BoardVO> selectAll() {
		String query = "select * from board_tbl order by bno desc";
		List<BoardVO> list = new ArrayList();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				BoardVO vo = BoardVO.builder()
					.bno(rs.getInt("bno"))
					.title(rs.getString("title"))
					.content(rs.getString("content"))
					.writer(rs.getString("writer"))
					.writeDate(rs.getDate("writeDate"))
					.imageFileName(rs.getString("imageFileName"))
					.build();
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
