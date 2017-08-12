package controller.modelo;
import java.io.IOException;
import java.util.Scanner;

public class ControleRemoto {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira a sequência");
		String entrada = sc.nextLine();
		
		eSequenciaValida(entrada);

		Controller controller = new Controller(entrada);
		String saida = controller.execute();
		
		System.out.println(saida);
	}
	public static void eSequenciaValida(String entrada){
		char[] sequenciaDeComandos = entrada.toCharArray();
		for (int i = 0; i < sequenciaDeComandos.length; i++) {
			if(sequenciaDeComandos[i] != 'P' && sequenciaDeComandos[i] != 'O' && sequenciaDeComandos[i] != '.')
				throw new IllegalArgumentException("Squencia Invalida");
		}
	}
}
