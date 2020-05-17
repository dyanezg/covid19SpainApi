package com.free.covi19.spain.api.repositoriesJdbc;

import static com.free.covi19.spain.api.util.Utilities.currentDateString;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.free.covi19.spain.api.dto.CcaaMascarillasDto;

@Repository
public class JdbcCcaaMascarillasRepositoryImpl implements JdbcCcaaMascarillasRepository {

	
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public void delelteAll() {
		 jdbcTemplate.execute("DELETE FROM ccaa_mascarillas;");
		
	}

	@Override
	public int[] batchInsert(List<CcaaMascarillasDto> ccaaMascarillasDtoList) {
		 return jdbcTemplate.batchUpdate(" insert into ccaa_mascarillas (id, fecha, ccaa, acumulado, fecha_importacion) VALUES (?, ?, ?, ?, ?) ",
			        new BatchPreparedStatementSetter() {
			            @Override
			            public void setValues(PreparedStatement ps, int i) throws SQLException {			                
			            				            	
			            	ps.setInt(1, ccaaMascarillasDtoList.get(i).getId());			            
			            	ps.setString(2, ccaaMascarillasDtoList.get(i).getFecha());
			            	ps.setString(3, ccaaMascarillasDtoList.get(i).getCcaa());			                
			                ps.setInt(4, ccaaMascarillasDtoList.get(i).getAcumulado()!=null? ccaaMascarillasDtoList.get(i).getAcumulado():0);			                			                			                
			                ps.setString(5, currentDateString());
			            }
			            @Override
			            public int getBatchSize() {
			                return ccaaMascarillasDtoList.size();
			            }
			        });		
								
	}

}
