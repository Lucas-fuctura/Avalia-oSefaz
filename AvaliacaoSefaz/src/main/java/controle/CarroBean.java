package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.CarroDAO;
import dao.CarroDAOImpl;
import entidade.Carro;
import entidade.CorCarro;
import entidade.ModeloCarro;
import entidade.PecasCarro;

@ManagedBean(name="CarroBean")
@SessionScoped
public class CarroBean {
	private String txtSerie;
	private String txtpesquisa;
	private int txtAno;
	private List<Carro> listaCarros;
	private List<ModeloCarro> listamodelos;
	private List<CorCarro> listacores;
	private List<PecasCarro> listaplacas;
	private Carro carro;
	private CorCarro cor;
	private ModeloCarro modelo;
	private PecasCarro placa;
	private CarroDAO carroDAO;
	
	
	public CarroBean(){
		this.carroDAO = new CarroDAOImpl();
		this.carro = new Carro();
		
		this.carro.setModelocarro(new ModeloCarro());
		this.carro.setCorcarro(new CorCarro());
		this.carro.setPecascarro(new PecasCarro());
		
		this.listamodelos = new ArrayList<ModeloCarro>();
		this.listacores = new ArrayList<CorCarro>();
		this.listaplacas = new ArrayList<PecasCarro>();
		
		this.listamodelos = this.carroDAO.listarModelos();
		this.listacores = this.carroDAO.listarCores();
		this.listaplacas = this.carroDAO.listarPlacas();	
	}
	
	public void salvarCarro() {
		this.carroDAO.inserir(this.carro);
		this.carro = new Carro();
	}
	
	public void editarCarro() {
		this.carroDAO.alterar(carro);
		this.carro = new Carro();
	}
	
	public void removerCarro() {
		this.carroDAO.remover(carro);
		this.carro = new Carro();
	}
	
	public Carro pesquisarCarro() {
		this.carroDAO.pesquisar(txtSerie);
		return carro;
	}
	public List<Carro> tabela(){
		this.carroDAO.listarCarros();
		this.carroDAO.listarCores();
		this.carroDAO.listarModelos();
		this.carroDAO.listarPlacas();
		return listaCarros;
	}
	
	public String sair() {
		return "login.xhtml";
	}
	
	public String getTxtSerie() {
		return txtSerie;
	}
	public void setTxtSerie(String txtSerie) {
		this.txtSerie = txtSerie;
	}
	public int getTxtAno() {
		return txtAno;
	}
	public void setTxtAno(int txtAno) {
		this.txtAno = txtAno;
	}
	public List<Carro> getListaCarros() {
		return listaCarros;
	}
	public void setListaCarros(List<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public CorCarro getCor() {
		return cor;
	}
	public void setCor(CorCarro cor) {
		this.cor = cor;
	}
	public ModeloCarro getModelo() {
		return modelo;
	}
	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}
	public PecasCarro getPlaca() {
		return placa;
	}
	public void setPlaca(PecasCarro placa) {
		this.placa = placa;
	}
	public CarroDAO getCarroDAO() {
		return carroDAO;
	}
	public void setCarroDAO(CarroDAO carroDAO) {
		this.carroDAO = carroDAO;
	}
	public List<ModeloCarro> getModelos() {
		return listamodelos;
	}
	public void setModelos(List<ModeloCarro> modelos) {
		this.listamodelos = modelos;
	}
	public List<CorCarro> getCores() {
		return listacores;
	}
	public void setCores(List<CorCarro> cores) {
		this.listacores = cores;
	}
	public List<PecasCarro> getPlacas() {
		return listaplacas;
	}
	public void setPlacas(List<PecasCarro> placas) {
		this.listaplacas = placas;
	}

	public String getTxtpesquisa() {
		return txtpesquisa;
	}

	public void setTxtpesquisa(String txtpesquisa) {
		this.txtpesquisa = txtpesquisa;
	}

	public List<ModeloCarro> getListamodelos() {
		return listamodelos;
	}

	public void setListamodelos(List<ModeloCarro> listamodelos) {
		this.listamodelos = listamodelos;
	}

	public List<CorCarro> getListacores() {
		return listacores;
	}

	public void setListacores(List<CorCarro> listacores) {
		this.listacores = listacores;
	}

	public List<PecasCarro> getListaplacas() {
		return listaplacas;
	}

	public void setListaplacas(List<PecasCarro> listaplacas) {
		this.listaplacas = listaplacas;
	}
	

}
