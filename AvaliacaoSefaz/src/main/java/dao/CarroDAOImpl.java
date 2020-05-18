package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidade.Carro;
import entidade.CorCarro;
import entidade.ModeloCarro;
import entidade.PecasCarro;
import util.JpaUtil;

public class CarroDAOImpl implements CarroDAO {
	
	public void inserir(Carro carro) {
		String sql = "INSERT INTO CARRO (SERIECARRO, ANO, MODELO_CARRO, COR_CARRO, PECAS_CARRO)"
				+ "VALUES(?, ?, ?, ?, ?)";
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, carro.getSeriecarro());
			ps.setInt(2, carro.getAno());
			ps.setString(3, carro.getModelocarro().getModelo());
			ps.setString(4, carro.getCorcarro().getCor());
			ps.setString(5, carro.getPecascarro().getPlaca());
			
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Carro carro) {
		String sql = "UPDATE CARRO SET ANO = ?, MODELO_CARRO = ?, COR_CARRO = ?, PECAS_CARRO"
				+ " WHERE SERIECARRO = ?";
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, carro.getAno());
			ps.setString(2, carro.getModelocarro().getModelo());
			ps.setString(3, carro.getCorcarro().getCor());
			ps.setString(4, carro.getPecascarro().getPlaca());
			ps.setString(5, carro.getSeriecarro());
			
			ps.executeUpdate();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(Carro carro) {
		String sql = "DELETE FROM CARRO WHERE SERIECARRO = ?";
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, carro.getSeriecarro());
			
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Carro pesquisar(String seriecarro) {
		String sql = "SELECT C.SERIECARRO, C.ANO, C.MODELO_CARRO, C.COR_CARRO FROM CARRO C "
				+ "WHERE SERIECARRO = ?";
		
		Carro carro = null;
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, seriecarro);
			
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				carro = new Carro();
				carro.setSeriecarro(res.getString("SERIECARRO"));
				carro.setAno(res.getInt("ANO"));
				
			}
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return carro;
	}
	
	public List<Carro> listarCarros(){
		String sql = "SELECT C.SERIECARRO, C.ANO FROM CARRO C";
		
		List<Carro> listaCarros = new ArrayList<Carro>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				Carro carro = new Carro();
				carro.setSeriecarro(res.getString("SERIECARRO"));
				carro.setAno(res.getInt("ANO"));
				
				listaCarros.add(carro);
				
			}
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaCarros;
	}
	
	public List<ModeloCarro> listarModelos(){
		String sql = "SELECT M.MODELO FROM MODELOCARRO M";
		
		List<ModeloCarro> listaModelo = new ArrayList<ModeloCarro>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				ModeloCarro modelo = new ModeloCarro();
				modelo.setModelo(res.getString("MODELO"));
				
				listaModelo.add(modelo);
			
			}
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaModelo;
	}
	
	public List<CorCarro> listarCores(){
		String sql = "SELECT C.COR FROM CORCARRO C";
		
		List<CorCarro> listaCores = new ArrayList<CorCarro>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				CorCarro cores = new CorCarro();
				cores.setCor(res.getString("COR"));
				
				listaCores.add(cores);
			
			}
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listarCores();
	}
	
	public List<PecasCarro> listarPlacas(){
		String sql = "SELECT FROM P.PLACAS FROM PECASCARRO P";
		
		List<PecasCarro> listaPlacas = new ArrayList<PecasCarro>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				PecasCarro placas = new PecasCarro();
				placas.setPlaca(res.getString("PLACA"));
				
				listaPlacas.add(placas);
				
			}
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaPlacas;
	}
}
