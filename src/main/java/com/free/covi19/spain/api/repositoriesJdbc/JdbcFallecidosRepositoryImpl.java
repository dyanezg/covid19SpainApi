package com.free.covi19.spain.api.repositoriesJdbc;

import static com.free.covi19.spain.api.util.Utilities.currentDateString;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.free.covi19.spain.api.dto.FallecidosDto;

@Repository
public class JdbcFallecidosRepositoryImpl implements JdbcFallecidosRepository {

	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
		@Override
		public void delelteAll() {
			 jdbcTemplate.execute("DELETE FROM fallecidos;");
			
		}

	@Override
	public int[] batchInsert(List<FallecidosDto> fallecidosDtoDtoList) {
		 return jdbcTemplate.batchUpdate(" insert into fallecidos (id, fecha, ccaa, num, fecha_importacion) VALUES (?, ?, ?, ?, ?) ",
			        new BatchPreparedStatementSetter() {
			            @Override
			            public void setValues(PreparedStatement ps, int i) throws SQLException {			                
			            				            	
			            	ps.setInt(1, fallecidosDtoDtoList.get(i).getId());			            
			            	ps.setString(2, fallecidosDtoDtoList.get(i).getFecha());
			            	ps.setString(3, fallecidosDtoDtoList.get(i).getCcaa());			                
			                ps.setInt(4, fallecidosDtoDtoList.get(i).getNum()!=null? fallecidosDtoDtoList.get(i).getNum():0);			                			                			                
			                ps.setString(5, currentDateString());
			            }
			            @Override
			            public int getBatchSize() {
			                return fallecidosDtoDtoList.size();
			            }
			        });		
	}

	
}
