package com.github3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.github3.beans.*;

public class FilmeDao {
	//metodo para conectar com o banco
		public static Connection getConnection() {
			//Conexao inicia vazia
			Connection con = null;
			
			try {
				//Driver do mysql
				Class.forName("com.mysql.jdbc.Driver");
				//faz a conexao com as configuracoes de acesso
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/github3", "root", "1234567");
			} catch(Exception e) {
				System.out.println(e);
			}
			//retorna a conexao
			return con;
		}
		
		public static int deletarFilme(Filme f) {
			int status = 0;
			
			try {
				Connection con = getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM filme WHERE id=?");
				ps.setInt(1, f.getId());
				status = ps.executeUpdate();
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return status;
		}
		
		public static int salvarFilme(Filme f) {
			int status = 0;
			
			try {
				Connection con = getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO filme (nome, diretor, genero) VALUES (?, ?, ?)");
				ps.setString(1, f.getNome());
				ps.setString(2, f.getDiretor());
				ps.setString(3, f.getGenero());
				status = ps.executeUpdate();
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return status;
		}
		
		public static Filme getRegistroById(int id) {
			Filme filme = null;
			
			try {
				Connection con = getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM filme WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					filme = new Filme();
					filme.setId(rs.getInt("id"));
					filme.setNome(rs.getString("nome"));
					filme.setDiretor(rs.getString("diretor"));
					filme.setGenero(rs.getString("genero"));
				}
			} catch(Exception e ) {
				System.out.println(e);
			}
			
			return filme;
		}
		
		public static int updateFilme(Filme f) {
			int status = 0;
			
			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE filme SET nome=?, diretor=?, genero=? WHERE id=?");
				ps.setString(1, f.getNome());
				ps.setString(2, f.getDiretor());
				ps.setString(3, f.getGenero());
				ps.setInt(4, f.getId());
				status = ps.executeUpdate();
			} catch(Exception e) {
				System.out.println(e);
			}
			return status;
		}
		
		public static List<Filme> getAllFilmes() {
			List<Filme> list = new ArrayList<Filme>();
			
			try {
				//pega a conexão
				Connection con = getConnection();
				//Prepara ação
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM filme");
				//Executa query
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Filme filme = new Filme();
					filme.setId(rs.getInt("id"));
					filme.setNome((rs.getString("nome")));
					filme.setDiretor((rs.getString("diretor")));
					filme.setGenero((rs.getString("genero")));
					list.add(filme);
				}
			} catch(Exception e ) {
				System.out.println(e);
			}
			
			return list;
		}
}
