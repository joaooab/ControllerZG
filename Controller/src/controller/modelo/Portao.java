package controller.modelo;

public class Portao {
	
	MovimentoPortao movimento;

	public Portao() {
		this.movimento = MovimentoPortao.PARADO;
	}

	public MovimentoPortao getMovimento() {
		return movimento;
	}

	public void setMovimento(MovimentoPortao movimento) {
		this.movimento = movimento;
	}

}
