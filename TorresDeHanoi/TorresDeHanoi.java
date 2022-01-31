import java.util.Scanner;

public class TorresDeHanoi {
	public static void main(String[] args){
		//Coleta dados do teclado, coloca em uma variável int
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o número de discos:");
		int discos = scan.nextInt();

		hanoi(discos, 'A', 'B', 'C');
	}

	private static void hanoi(int discos, char origem, char trabalho, char destino){
		if (discos > 0){
			hanoi(discos-1, origem, destino, trabalho); //origem para o trabalho (n-1 discos)
			System.out.printf("Mover de %s para %s\n", origem, destino); //movimento da origem para o destino
			hanoi(discos-1, trabalho, origem, destino); // trabalho para o destino (n-1 discos)
		}
	}	
}