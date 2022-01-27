package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController()   {
	Connection conn=null;
	try {
		conn = new ConnectionFactory().recuperarConexao();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.categoriaDAO=new CategoriaDAO(conn);
	}

	public List<Categoria> listar()  {
		List<Categoria> categorias = 
				new ArrayList<Categoria>();
		categorias.add(new Categoria(1, "Categoria de teste")); 
		return this.categoriaDAO.listar();
	}
}
