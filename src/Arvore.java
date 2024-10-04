import java.util.HashMap;
import java.util.Map;

public class Arvore {
    private NoArvore raiz;
    private static final Map<String, Character> morseMap = new HashMap<>();

    static {
        String[] codigosMorse = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        char[] letras = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        for (int i = 0; i < codigosMorse.length; i++) {
            morseMap.put(codigosMorse[i], letras[i]);
        }
    }

    public Arvore() {
        raiz = new NoArvore(' ');
        morseMap.forEach(this::add);
    }

    public void add(String codigoMorse, char letra) {
        NoArvore atual = raiz;

        for (char c : codigoMorse.toCharArray()) {
            if (c == '.') {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new NoArvore(' '));
                }
                atual = atual.getEsquerda();
            } else if (c == '-') {
                if (atual.getDireita() == null) {
                    atual.setDireita(new NoArvore(' '));;
                }
                atual = atual.getDireita();
            }
        }
        atual.setLetra(letra);
    }

    public String decodificar(String codigoMorse) {
        StringBuilder mensagemDecodificada = new StringBuilder();
        String[] letrasMorse = codigoMorse.split(" ");
        for (String letra : letrasMorse) {
            mensagemDecodificada.append(letraDecodificada(letra));
        }
        return mensagemDecodificada.toString();
    }

    public char letraDecodificada(String codigoMorse) {
        NoArvore atual = raiz;
        for (char c : codigoMorse.toCharArray()) {
            if (c == '.') {
                atual = atual.getEsquerda();
            } else if (c == '-') {
                atual = atual.getDireita();
            }
            if (atual == null) {
                return '?';
            }
        }
        return atual.getLetra();
    }

    public void printTree() {
        printTreeHelper(raiz, 0);
    }

    private void printTreeHelper(NoArvore no, int nivel) {
        if (no != null) {
            printTreeHelper(no.getDireita(), nivel + 1);

            for (int i = 0; i < nivel; i++) {
                System.out.print("        ");
            }
            System.out.println(no.getLetra());

            printTreeHelper(no.getEsquerda(), nivel + 1);
        }
    }
}

