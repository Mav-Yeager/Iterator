public class Empresa {
    private String[] clientesMaisCompras;
    private int tamanhoAtual;
    private static final int CAPACIDADE_MAXIMA = 100;

    public Empresa() {
        this.clientesMaisCompras = new String[CAPACIDADE_MAXIMA];
        this.tamanhoAtual = 0;
    }

    public void adicionarCliente(String nomeCliente) {
        if (tamanhoAtual < CAPACIDADE_MAXIMA) {
            clientesMaisCompras[tamanhoAtual] = nomeCliente;
            tamanhoAtual++;
        } else {
            System.out.println("Lista de clientes está cheia!");
        }
    }

    // Este método mostra a necessidade de um Iterator
    public void mostrarTodosClientes() {
        // Atualmente, precisamos conhecer a estrutura interna para iterar
        for (int i = 0; i < tamanhoAtual; i++) {
            System.out.println(clientesMaisCompras[i]);
        }
    }

    // Este método também mostra a necessidade de um Iterator
    public void filtrarClientesPorLetra(char letra) {
        // Novamente, precisamos conhecer a estrutura interna
        for (int i = 0; i < tamanhoAtual; i++) {
            if (clientesMaisCompras[i].charAt(0) == letra) {
                System.out.println(clientesMaisCompras[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        
        empresa.adicionarCliente("Ana Silva");
        empresa.adicionarCliente("Carlos Santos");
        empresa.adicionarCliente("Beatriz Oliveira");
        empresa.adicionarCliente("Daniel Lima");
        
        System.out.println("Todos os clientes:");
        empresa.mostrarTodosClientes();
        
        System.out.println("\nClientes que começam com 'C':");
        empresa.filtrarClientesPorLetra('C');
    }
}
