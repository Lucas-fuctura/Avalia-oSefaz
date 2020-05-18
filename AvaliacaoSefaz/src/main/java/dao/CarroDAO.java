package dao;

import java.util.List;

import entidade.Carro;
import entidade.CorCarro;
import entidade.ModeloCarro;
import entidade.PecasCarro;

public interface CarroDAO {

	public void inserir(Carro carro);
	
	public void alterar(Carro carro);
	
	public void remover(Carro carro);
	
	public Carro pesquisar(String seriecarro);
	
	public List<Carro> listarCarros();
	
	public List<ModeloCarro> listarModelos();
	
	public List<CorCarro> listarCores();
	
	public List<PecasCarro> listarPlacas();
}
