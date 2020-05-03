package com.free.covi19.spain.api.repositoriesJdbc;

import static com.free.covi19.spain.api.util.Utilities.currentDateString;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.free.covi19.spain.api.dto.TestRealizadoDto;

@Repository
public class JdbcTestRealizadosRepositoryImpl implements JdbcTestRealizadosRepository {

	

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public void delelteAll() {
		 jdbcTemplate.execute("DELETE FROM test_realizados;");		
	}

	@Override
	public int[] batchInsert(List<TestRealizadoDto> testRealizadoDtoList) {
	
		 return jdbcTemplate.batchUpdate(" insert into test_realizados (id, fecha, ccaa, pcr, test_anticuerpos, total_pruebas, fecha_importacion) VALUES (?, ?, ?, ?, ?, ?, ?) ",
			        new BatchPreparedStatementSetter() {
			            @Override
			            public void setValues(PreparedStatement ps, int i) throws SQLException {			                
			            				            	
			            	ps.setInt(1, testRealizadoDtoList.get(i).getId());			            
			            	ps.setString(2, testRealizadoDtoList.get(i).getFecha());
			                ps.setString(3, testRealizadoDtoList.get(i).getCcaa());
			                ps.setInt(4, testRealizadoDtoList.get(i).getPcr()!=null? testRealizadoDtoList.get(i).getPcr():0);
			                ps.setInt(5, testRealizadoDtoList.get(i).getTestAnticuerpos()!=null? testRealizadoDtoList.get(i).getTestAnticuerpos():0);
			                ps.setInt(6, testRealizadoDtoList.get(i).getTotalPruebas()!=null?testRealizadoDtoList.get(i).getTotalPruebas():0);			                
			                ps.setString(7, currentDateString());
			            }
			            @Override
			            public int getBatchSize() {
			                return testRealizadoDtoList.size();
			            }
			        });				
		
	}

}
