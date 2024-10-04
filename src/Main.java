import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nDigite a sequência de código Morse (use espaço entre as letras) ou 'end' para encerrar: ");
                String entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("end")) {
                    System.out.println("Encerrando o programa...");
                    break;
                }

                String mensagemDecodificada = arvore.decodificar(entrada);
                System.out.println("Mensagem decodificada: " + mensagemDecodificada);
            }
        }

        System.out.println("\nÁrvore Morse:");
        arvore.printTree();
    }
}