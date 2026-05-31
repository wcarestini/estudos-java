import java.util.Scanner;

public class CalculoDesconto {
	private static double[] valorPlanos = {99.90, 129.90, 159.90};

	public static void main(String[] args) {
		var scan = new Scanner(System.in);

		while (true) {
			exibeMenu();
			var opcao = scan.nextInt();

			if ((opcao < 1) || (opcao > 3)) {
				System.out.println("Opção invalida.");
				continue;
			}

			perguntaClienteAtivo();
			var ativo = scan.nextInt();
			if ((ativo < 1) || (ativo > 2)) {
				System.out.println("Opção invalida.");
			}
			if (ativo == 2) {
				System.out.println("Cliente inativo. Não é possivel calcular.");
				break;
			}

			perguntaSeClienteAntigo();
			var clienteAntigo = scan.nextInt();
			if ((clienteAntigo < 1) || (clienteAntigo > 2)) {
				System.out.println("Opção invalida.");
			}

			var result = calculaMensalidade(opcao, clienteAntigo);
			System.out.println("O valor do plano ficou: " + result);
		}
	}

	private static void exibeMenu() {
		System.out.println("===== CÁLCULO DE MENSALIDADE =====");
		System.out.println("Escolha o plano:");
		System.out.println("1 - 300 mega - R$ 99,90");
		System.out.println("2 - 500 mega - R$ 129,90");
		System.out.println("3 - 700 mega - R$ 159,90");
		System.out.println("Opção:");
	}

	private static void perguntaClienteAtivo() {
		System.out.println("Cliente está ativo?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Opção: ");
	}

	private static void perguntaSeClienteAntigo() {
		System.out.println("Cliente é antigo?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Opção: ");
	}

	private static double calculaMensalidade(int plano, int antigo) {
		var valorMensalidade = valorPlanos[plano - 1];
		if (antigo == 1) {
			valorMensalidade -= 10;
		}
		return valorMensalidade;
	}
}