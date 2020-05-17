package com.free.covi19.spain.api.repositoriesJdbc;

import static com.free.covi19.spain.api.util.Utilities.currentDateString;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.free.covi19.spain.api.dto.AfectadosEdadSexoDto;

@Repository
public class JdbcAfectadosEdadSexoRepositoryImpl implements JdbcAfectadosEdadSexoRepository {

	
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public void delelteAll() {
		 jdbcTemplate.execute("DELETE FROM afectados_edad_sexo;");
		
	}

	@Override
	public int[] batchInsert(List<AfectadosEdadSexoDto> afectadosRangoDeEdadDtoList) {
		 return jdbcTemplate.batchUpdate(" insert into afectados_edad_sexo (id, fecha, rango_edad , sexo, hospitalizados, ingresos_uci, fallecidos, casos_confirmados ,fecha_importacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ",
			        new BatchPreparedStatementSetter() {
			            @Override
			            public void setValues(PreparedStatement ps, int i) throws SQLException {			                
			            				            	
			            	ps.setInt(1, afectadosRangoDeEdadDtoList.get(i).getId());			            			            	
			                ps.setString(2, afectadosRangoDeEdadDtoList.get(i).getFecha());			                
			                ps.setString(3, afectadosRangoDeEdadDtoList.get(i).getRangoDeEdad()!=null? afectadosRangoDeEdadDtoList.get(i).getRangoDeEdad():"-");			                
			                ps.setString(4, afectadosRangoDeEdadDtoList.get(i).getSexo()!=null? afectadosRangoDeEdadDtoList.get(i).getSexo():"-");
			                ps.setInt(5, afectadosRangoDeEdadDtoList.get(i).getHospitalizados()!=null? afectadosRangoDeEdadDtoList.get(i).getHospitalizados():0);			                
			                ps.setInt(6, afectadosRangoDeEdadDtoList.get(i).getIngresosUci()!=null? afectadosRangoDeEdadDtoList.get(i).getIngresosUci():0);
			                ps.setInt(7, afectadosRangoDeEdadDtoList.get(i).getFallecidos()!=null? afectadosRangoDeEdadDtoList.get(i).getFallecidos():0);
			                ps.setInt(8, afectadosRangoDeEdadDtoList.get(i).getCasosConfirmados()!=null? afectadosRangoDeEdadDtoList.get(i).getCasosConfirmados():0);			                
			                ps.setString(9, currentDateString());
			            }
			            @Override
			            public int getBatchSize() {
			                return afectadosRangoDeEdadDtoList.size();
			            }
			        });				 		
	}

}
