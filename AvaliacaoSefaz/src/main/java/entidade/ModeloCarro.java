package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MODELOCARRO")
public class ModeloCarro {
	
	@Id
	@Column(name="Modelo", nullable = false)
	private String modelo;
	
	@OneToMany(mappedBy = "modeloCarro", cascade = CascadeType.ALL)
	private List<Carro> carros;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	
}
