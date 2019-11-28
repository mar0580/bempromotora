package com.equipe7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.equipe7.util.DataConnect;

public class PessoaDAO {
	public static boolean insert(String nome, String sexo, int tipoDocumento, String numDocumento, String email,
			String telefone, String endereco, long idade, String dataCadastro) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"INSERT INTO tb_pessoa (nome, idade, sexo, tipoDocumento, numDocumento, dataCadastro, email, telefone,  endereco, id_usuario_cadastro) VALUES (?,?,?,?,?,?,?,?,?,1)");

			ps.setString(1, nome);
			ps.setLong(2, idade);
			ps.setString(3, sexo);
			ps.setLong(4, tipoDocumento);
			ps.setString(5, numDocumento);
			ps.setString(6,
					(String) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			ps.setString(7, email);
			ps.setString(8, telefone);
			ps.setString(9, endereco);

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Registro inserido com sucesso!");
			}

		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
}
