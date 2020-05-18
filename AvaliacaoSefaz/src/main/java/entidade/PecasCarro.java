package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PECASCARRO")
public class PecasCarro {
	
	@Id
	@Column(name="PLACA", nullable = false)
	private String placa;

	@OneToMany(mappedBy = "pecascarro", cascade = CascadeType.ALL)
	private List<Carro> carros;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	

}
