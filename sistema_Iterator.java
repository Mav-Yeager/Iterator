// Interface Iterator personalizada
interface ClienteIterator {
    boolean hasNext();
    String next();
}

// Interface para coleção iterável
interface ClienteCollection {
    ClienteIterator getIterator();
}

// Implementação concreta do Iterator
class ListaClientesIterator implements ClienteIterator {
    private String[] clientes;
    private int posicao;
    private int tamanho;

    public ListaClientesIterator(String[] clientes, int tamanho) {
        this.clientes = clientes;
        this.tamanho = tamanho;
        this.posicao = 0;
    }

    @Override
    public boolean hasNext() {
        return posicao < tamanho;
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return clientes[posicao++];
        }
        return null;
    }
}

// Implementação da empresa usando o padrão Iterator
public class Empresa implements ClienteCollection {
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

    @Override
    public ClienteIterator getIterator() {
        return new ListaClientesIterator(clientesMaisCompras, tamanhoAtual);
    }

    // Método que usa o Iterator para mostrar todos os clientes
    public void mostrarTodosClientes() {
        ClienteIterator iterator = this.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Método que usa o Iterator para filtrar clientes
    public void filtrarClientesPorLetra(char letra) {
        ClienteIterator iterator = this.getIterator();
        while (iterator.hasNext()) {
            String cliente = iterator.next();
            if (cliente.charAt(0) == letra) {
                System.out.println(cliente);
            }
        }
    }
}

// Classe para demonstrar o uso
public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        
        empresa.adicionarCliente("Ana Silva");
        empresa.adicionarCliente("Carlos Santos");
        empresa.adicionarCliente("Beatriz Oliveira");
        empresa.adicionarCliente("Daniel Lima");
        
        System.out.println("=== Todos os clientes usando Iterator ===");
        empresa.mostrarTodosClientes();
        
        System.out.println("\n=== Clientes que começam com 'C' usando Iterator ===");
        empresa.filtrarClientesPorLetra('C');
        
        System.out.println("\n=== Demonstração direta do uso do Iterator ===");
        ClienteIterator iterator = empresa.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Cliente: " + iterator.next());
        }
    }
}
