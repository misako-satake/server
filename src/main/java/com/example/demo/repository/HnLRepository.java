package com.example.demo.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cards;

@Repository
public class HnLRepository {

	private static final RowMapper<Cards> CARDS_ROW_MAPPER = (rs,i)->{
		Cards card = new Cards();
		card.setId(rs.getInt("id"));
		card.setNumber(rs.getInt("number"));
		card.setMark(rs.getString("mark"));
		card.setImagepath(rs.getString("imagepath"));
		return card;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public Cards findCard(int num) {
		String sql = "SELECT * FROM cards WHERE number=:number;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("number", num);
		Cards card = new Cards();
		card = template.queryForObject(sql, param, CARDS_ROW_MAPPER);
		return card;
		
	}
	
}
