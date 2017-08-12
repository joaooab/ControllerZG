package controller.modelo;

public class Controller {

	char[] sequenciaDeComandos;
	Portao portao = new Portao();
	Integer posicaoEmSegundos;
	String saida = "";

	public Controller(String sequenciaDeComandos) {
		this.sequenciaDeComandos = sequenciaDeComandos.toCharArray();
	}

	public String execute() {

		for (int i = 0; i < sequenciaDeComandos.length; i++) {
			char acao = sequenciaDeComandos[i];
			alteraMovimentoPortao(acao);
			saida += posicaoEmSegundos;
		}
		return saida;
	}

	public void alteraMovimentoPortao(char acao) {
		if (saida == "") {
			if (acao == 'P') {
				posicaoEmSegundos = 1;
				portao.movimento = MovimentoPortao.ABRINDO;
			} else {
				posicaoEmSegundos = 0;
			}
		} else {
			if (portao.movimento.equals(MovimentoPortao.PARADO)) {
				if (acao == 'P') {
					posicaoEmSegundos++;
					portao.setMovimento(MovimentoPortao.ABRINDO);
					eConcluido();
				} else if (acao == 'O') {
					posicaoEmSegundos--;
					eConcluido();
				}
			} else if (portao.movimento.equals(MovimentoPortao.ABRINDO)) {
				if (acao == '.') {
					posicaoEmSegundos++;
					eConcluido();
				} else if (acao == 'O') {
					posicaoEmSegundos--;
					portao.setMovimento(MovimentoPortao.FECHANDO);
					eConcluido();
				} else {
					portao.setMovimento(MovimentoPortao.PARADO);
				}
			} else if (portao.movimento.equals(MovimentoPortao.FECHANDO)) {
				if (acao == 'O') {
					posicaoEmSegundos++;
					portao.setMovimento(MovimentoPortao.ABRINDO);
				} else if (acao == '.') {
					posicaoEmSegundos--;
					eConcluido();
				}
			}
		}
	}

	public void eConcluido() {
		if (posicaoEmSegundos < 0)
			posicaoEmSegundos = 0;
		else if (posicaoEmSegundos > 5)
			posicaoEmSegundos = 5;
	}
}
