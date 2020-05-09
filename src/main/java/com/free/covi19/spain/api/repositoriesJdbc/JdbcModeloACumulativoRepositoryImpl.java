package com.free.covi19.spain.api.repositoriesJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.free.covi19.spain.api.dto.ModeloAcumulativoDto;
import static com.free.covi19.spain.api.util.Utilities.currentDateString;

@Repository
public class JdbcModeloACumulativoRepositoryImpl implements JdbcModeloAcumulativoRepository {
	
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	 
	 public void delelteAll(){	
		 jdbcTemplate.execute("DELETE FROM modelo_acumulativo;");
	 }	 	 
	 
	 
	@Override
	public int[] batchInsert(List<ModeloAcumulativoDto> modeloAcumulativoDtoList) {
				

		 return jdbcTemplate.batchUpdate(" insert into modelo_acumulativo (id, ccaa, fecha, casos, hospitalizados, uci, fallecidos, recuperados, fecha_importacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ",
			        new BatchPreparedStatementSetter() {
			            @Override
			            public void setValues(PreparedStatement ps, int i) throws SQLException {			                
			            				            	
			            	ps.setInt(1, modeloAcumulativoDtoList.get(i).getId());			            
			            	ps.setString(2, modeloAcumulativoDtoList.get(i).getCcaa());
			                ps.setString(3, modeloAcumulativoDtoList.get(i).getFecha());
			                ps.setInt(4, modeloAcumulativoDtoList.get(i).getCasos()!=null? modeloAcumulativoDtoList.get(i).getCasos():0);
			                ps.setInt(5, modeloAcumulativoDtoList.get(i).getHospitalizados()!=null? modeloAcumulativoDtoList.get(i).getHospitalizados():0);
			                ps.setInt(6, modeloAcumulativoDtoList.get(i).getUci()!=null?modeloAcumulativoDtoList.get(i).getUci():0);
			                ps.setInt(7, modeloAcumulativoDtoList.get(i).getFallecidos()!=null? modeloAcumulativoDtoList.get(i).getFallecidos():0);
			                ps.setInt(8, modeloAcumulativoDtoList.get(i).getRecuperados()!=null?modeloAcumulativoDtoList.get(i).getRecuperados():0);
			                ps.setString(9, currentDateString());
			            }
			            @Override
			            public int getBatchSize() {
			                return modeloAcumulativoDtoList.size();
			            }
			        });				 		 
		 
	}

	
		
	
	

}
