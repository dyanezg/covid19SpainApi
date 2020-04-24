package com.free.covi19.spain.api.repositoriesJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcModeloACumulativoHistoricoRepositoryImpl implements JdbcModeloAcumulativoHistoricoRepository {
	
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	@Override
	public void inertAll() {		
		jdbcTemplate.execute("insert into modelo_acumulativo_historico (ccaa, fecha, casos, hospitalizados, uci, fallecidos, recuperados, fecha_importacion) select ccaa, fecha, casos, hospitalizados, uci, fallecidos, recuperados, fecha_importacion from modelo_acumulativo");					
	}

	 
	
		
	
	

}
