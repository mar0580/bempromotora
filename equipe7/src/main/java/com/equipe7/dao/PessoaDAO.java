package com.equipe7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.equipe7.util.DataConnect;

public class PessoaDAO {

	

	public static boolean insert(String nome, String sexo, int tipoDocumento, String numDocumento, String email,
			String telefone, String endereco, long idade) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("INSERT INTO tb_pessoa (nome, sexo, tipoDocumento, numDocumento, email, telefone,  endereco,  idade, dt_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, now()");
						
			ps.setString(1, nome);
			ps.setString(2, sexo);
			ps.setLong(3, tipoDocumento);
			ps.setString(4, numDocumento);
			ps.setString(5, email);
			ps.setString(6, telefone);
			ps.setString(7, endereco);
			ps.setString(8, numDocumento);
			ps.setLong(9, idade);
			
			
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			}

//			if (rs.next()) {
//				// result found, means valid inputs
//				return true;
//			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
}
