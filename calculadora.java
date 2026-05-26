import java.util.Scanner;

public class Calculadora {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			exibeMenu();
			var opcao = scanner.nextInt();

			if (opcao > 4) {
				System.out.println("Opção inválida!");
				continue;
			} else if(opcao == 0) {
				System.out.println("Calculadora encerrada. Até mais!");
				break;
			}

			System.out.println("Digite o primeiro valor: ");
			var primeiroValor = scanner.nextInt();
			System.out.println("Digite o segundo valor: ");
			var segundoValor = scanner.nextInt();

			var resultado = calculaPorOpcao(opcao, primeiroValor, segundoValor);

			System.out.println("O resultado é " + resultado);
		}
	}

	private static void exibeMenu() {
		System.out.println("===== CALCULADORA JAVA =====");
		System.out.println("Escolha uma operação:");
		System.out.println("1 - Somar");
		System.out.println("2 - Subtrair");
		System.out.println("3 - Multiplicar");
		System.out.println("4 - Dividir");
		System.out.println("0 - Sair");
		System.out.println("Opção:");
	}

	private static int calculaPorOpcao(int opcao, int primeiroValor, int segundoValor) {
		return switch (opcao) {
	        case 1 -> somar(primeiroValor, segundoValor);
	        case 2 -> subtrair(primeiroValor, segundoValor);
	        case 3 -> multiplicar(primeiroValor, segundoValor);
	        case 4 -> dividir(primeiroValor, segundoValor);
	        default -> {
	            System.out.println("Opção inválida.");
	            yield 0;
	        }
	    };
	}

	private static int somar(int primeiroValor, int segundoValor) {
	    return primeiroValor + segundoValor;
	}

	private static int subtrair(int primeiroValor, int segundoValor) {
	    return primeiroValor - segundoValor;
	}

	private static int multiplicar(int primeiroValor, int segundoValor) {
	    return primeiroValor * segundoValor;
	}

	private static int dividir(int primeiroValor, int segundoValor) {
	    if (segundoValor == 0) {
	        System.out.println("Não é possível dividir por zero.");
	        return 0;
	    }

	    return primeiroValor / segundoValor;
	}
}