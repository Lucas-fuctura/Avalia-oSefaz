package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARRO")
public class Carro {
	
	@Id
	@Column(name="SERIECARRO", nullable = false)
	private String seriecarro;
	
	@Column(name="ANO", nullable = false)
	private int ano;
	
	@ManyToOne
	@JoinColumn(name = "COR_CARRO", referencedColumnName = "COR", nullable = false)
	private CorCarro corcarro;
	
	@ManyToOne
	@JoinColumn(name="MODELO_CARRO", referencedColumnName = "MODELO", nullable = false)
	private ModeloCarro modelocarro;
	
	@ManyToOne
	@JoinColumn(name = "PECAS_CARRO", referencedColumnName = "PLACA", nullable = false)
	private PecasCarro pecascarro;

	public String getSeriecarro() {
		return seriecarro;
	}

	public void setSeriecarro(String seriecarro) {
		this.seriecarro = seriecarro;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public CorCarro getCorcarro() {
		return corcarro;
	}

	public void setCorcarro(CorCarro corcarro) {
		this.corcarro = corcarro;
	}

	public ModeloCarro getModelocarro() {
		return modelocarro;
	}

	public void setModelocarro(ModeloCarro modelocarro) {
		this.modelocarro = modelocarro;
	}

	public PecasCarro getPecascarro() {
		return pecascarro;
	}

	public void setPecascarro(PecasCarro pecascarro) {
		this.pecascarro = pecascarro;
	}
	
	

}
