package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CORCARRO")
public class CorCarro {
	
	@Id
	@Column(name="COR", nullable = false)
	private String cor;
	
	@OneToMany(mappedBy = "corCarro", cascade = CascadeType.ALL)
	private List<Carro> carros;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	

}
