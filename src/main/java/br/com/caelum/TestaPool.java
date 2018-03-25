package br.com.caelum;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestaPool {

	public static void main(String[] args) throws PropertyVetoException, SQLException {
		ComboPooledDataSource dataSource = (ComboPooledDataSource) new JpaConfigurator().getDataSource();
		
		for(int i = 0; i < 10; i++) {
			dataSource.getConnection();
			
			System.out.println("Conexões Existentes: " + dataSource.getNumConnections());
			System.out.println("Conexões Ocupadas" + dataSource.getNumBusyConnections());
			System.out.println("Conexões Ociosas: " + dataSource.getNumIdleConnections());
			System.out.println("______________");
		}
	}

}
