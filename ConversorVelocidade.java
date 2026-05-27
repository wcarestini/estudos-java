import java.util.Scanner;

public class ConversorVelocidade {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			exibeMenu();
			var opcao = scan.nextInt();

			if (opcao == 0) {
				break;
			} else if((opcao > 6) || (opcao < 0)) {
				System.out.println("Erro: opção invalida, tente novamente.");
				continue;
			}

			System.out.print("Digite a velocidade: ");
			var velocidade = scan.nextDouble();

			if (velocidade < 0) {
				System.out.print("Error: velocidade não pode ser negativa.");
				continue;
			}

			var resultado = convertorPorOpcao(opcao, velocidade);
			System.out.print("O resultado é :" + resultado);
		}
	}

	private static void exibeMenu() {
		System.out.println("===== CONVERSOR DE VELOCIDADE =====");
		System.out.println("Escolha uma conversão:");
		System.out.println("1 - Mbps para Kbps");
		System.out.println("2 - Kbps para Mbps");
		System.out.println("3 - Mbps para Gbps");
		System.out.println("4 - Gbps para Mbps");
		System.out.println("5 - Mbps para MB/s");
		System.out.println("6 - MB/s para Mbps");
		System.out.println("0 - Sair");
		System.out.println("Opção:");
	}

	private static double convertorPorOpcao(int opcao, double velocidade) {
		return switch (opcao) {
			case 1 -> converteMegaBitPraKiloBit(velocidade);
			case 2 -> converteKiloBitPraMegaBit(velocidade);
			case 3 -> converteMegaBitPraGigaBit(velocidade);
			case 4 -> converteGigaBitParaMegaBit(velocidade);
			case 5 -> converteMegaBitEmMegaByte(velocidade);
			case 6 -> converteMegaBytePraMegaBit(velocidade);
			default -> {
				System.out.print("Opção invalida.");
				yield 0;
			}
		};
	}

	private static double converteMegaBitPraKiloBit(double velocidade) {
		return velocidade * 1000;
	}

	private static double converteKiloBitPraMegaBit(double velocidade) {
		return velocidade / 1000;
	}

	private static double converteMegaBitPraGigaBit(double velocidade) {
		return velocidade / 1000;
	}

	private static double converteGigaBitParaMegaBit(double velocidade) {
		return velocidade * 1000;
	}

	private static double converteMegaBitEmMegaByte(double velocidade) {
		return velocidade / 8;
	}

	private static double converteMegaBytePraMegaBit(double velocidade) {
		return velocidade * 8;
	}
}