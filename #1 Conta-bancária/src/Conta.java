
import java.util.Scanner;
public class Conta {
	Scanner scan = new Scanner(System.in);
	
	//Variáveis
	int saldo;
	int transacaoAnterior;
	String clienteNome;
	String clienteID;
	
	//Construtor
	Conta(String cNome, String cID){
		clienteNome = cNome;
		clienteID = cID;
	}
	//Função para depositar dinheiro
	void fazerDeposito(int quantia) {
		if(quantia != 0) {
			saldo = saldo + quantia;
			transacaoAnterior = quantia;
		}
	}
	//Função para Sacar dinheiro
	void fazerSaque(int quantia) {
		if(quantia != 0) {
			saldo = saldo - quantia;
			transacaoAnterior = -quantia;
		}
	}
	//Função para ver as transações 
	void getTransacaoAnterior() {
		if(transacaoAnterior > 0) {
			System.out.println("Depositado: " + transacaoAnterior);
		} else if (transacaoAnterior < 0) {
			System.out.println("Saque: " + Math.abs(transacaoAnterior));
		} else {
			System.out.println("Não existe nenhuma transação");
		}
	}
	//Função para calcular juros baseado na taxa SELIC 12/2021 
	void calculoJuros(int anos) {
		double taxaSelic = .0775;
		double novoSaldo = (saldo*taxaSelic*anos) + saldo;
		System.out.println("A taxa de juros atual e de " + (100 * taxaSelic) + "%");
		System.out.println("Apos " + anos + " anos, seu saldo vai ser de: " + novoSaldo);
	}
	//Função para aprensentar o Menu
	void showMenu() {
		char opcao = '\0';
		Scanner scan = new Scanner(System.in);
		System.out.println("Seja bem vindo, " + clienteNome + "!");
		System.out.println("Seu ID e: " + clienteID);
		System.out.println();
		System.out.println("O que voce gostaria de fazer?");
		System.out.println();
		System.out.println("A. Ver seu saldo");
		System.out.println("B. Fazer um deposito");
		System.out.println("C. Fazer um saque");
		System.out.println("D. Ver transcoes anteriores");
		System.out.println("E. Calcular juros");
		System.out.println("F. Sair");
		do {
			System.out.println();
			System.out.println("Escolha uma opcao: ");
			char opcao1 = scan.next().charAt(0);
			opcao = Character.toUpperCase(opcao1);
			System.out.println();
			
			switch(opcao) {
			//Case 'A' Checar conta do cliente
			case 'A':
				System.out.println("===============================");
				System.out.println("Saldo = $" + saldo);
				System.out.println("===============================");
				System.out.println();
				break;
			//Case 'B' Faz um depósito na conta usando a função "fazerDeposito"
			case 'B':
				System.out.println("Escolha o valor de deposito: ");
				int quantia = scan.nextInt();
				fazerDeposito(quantia);
				System.out.println();
				break;
			//Case 'C' Faz um saque da conta usando a função "fazerSaque"
			case 'C':
				System.out.println("Escolha o valor de saque: ");
				int quantia2 = scan.nextInt();
				fazerSaque(quantia2);
				System.out.println();
				break;
			//Case 'D' visualiza a transação anterior usando o método "getTransacaoAnterior"
			case 'D':
				System.out.println("===============================");
				getTransacaoAnterior();
				System.out.println("===============================");
				System.out.println();
				break;
			//Case 'E' Calcula juros acumulado de rentabilidade com base taxa Selic (7,75%) 12/2021
			case 'E':
				System.out.println("Escolha quantos anos de rentabilidade deseja");
				int anos = scan.nextInt();
				calculoJuros(anos);
				break;
			//Case 'F' Faz o cliente sair da conta
			case 'F':
				System.out.println("==========================");
				break;
			default:
				System.out.println("Erro: opção inválida. Por favor escolha A, B, C, D, ou E.");
				break;
			}
			
			
			
		} while(opcao != 'F');
			System.out.println("Obrigado por usar o SlaterBank!");
		
	}
}
