import java.util.Scanner;

public class CalculoMensalidade {
	private static double[] valorPlanos = {99.90, 129.90, 159.90};

	public static void main(String[] args) {
		var scan = new Scanner(System.in);
		while (true) {
			exibeMenu();
			var opcao = scan.nextInt();

			if ((opcao < 0) || (opcao > 3)) {
				System.out.println("Opção invalida.");
				continue;
			}
			
			perguntaTemRoteadorComodato();
			var roteadorComodato = scan.nextInt();
			if ((roteadorComodato < 1) || (roteadorComodato > 2)) {
				System.out.println("Opção invalida.");
				continue;
			}

			perguntaSeTemIpFixo();
			var ipFixo = scan.nextInt();
			if ((ipFixo < 1) || (ipFixo > 2)) {
				System.out.println("Opção invalida.");
				continue;
			}

			perguntaTemDesconto();
			var desconto = scan.nextInt();
			if ((desconto < 1) || (desconto > 2)) {
				System.out.println("Opção invalida.");
				continue;
			}

			double valorDesconto = 0;

			if (desconto == 1) {
				System.out.println("Digite o valor do desconto: ");
				valorDesconto = scan.nextDouble();
			}

			var valorMensalidade = calculaMensalidade(opcao, roteadorComodato, ipFixo, valorDesconto);

			System.out.println("O valor da mensalidade ficou: " + valorMensalidade);
		}
	}

	private static void exibeMenu() {
		System.out.println("===== CÁLCULO DE MENSALIDADE =====");
		System.out.println("Escolha o plano do cliente:");
		System.out.println("1 - 300 mega - R$ 99,90");
		System.out.println("2 - 500 mega - R$ 129,90");
		System.out.println("3 - 700 mega - R$ 159,90");
		System.out.println("0 - Sair");
		System.out.println("Opção:");
	}

	private static void perguntaTemRoteadorComodato() {
		System.out.println("Tem roteador comodato");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Opção: ");
	}

	private static void perguntaSeTemIpFixo() {
		System.out.println("Cliente possui IP fixo?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Opção: ");
	}

	private static void perguntaTemDesconto() {
		System.out.println("Cliente possui desconto?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Opção: ");
	}

	private static double calculaMensalidade(int plano,int roteadorComodato,int ipFixo,double desconto) {
		var valorDoPlanoAtual = valorPlanos[plano - 1];

		if (roteadorComodato == 1) {
			valorDoPlanoAtual += 15;
		}
		if (ipFixo == 1) {
			valorDoPlanoAtual += 25;
		}

		valorDoPlanoAtual -= desconto;

		return valorDoPlanoAtual;
	}
}