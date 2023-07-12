import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeVendas sistema = new SistemaDeVendas();
        sistema.executar();
    }
    

    public class SistemaDeVendas {

        public List<Venda> listarVendas;
        public List<Cliente> listarClientes;
        public List<Vendedor> listaVendedores;

        public void exibirMenu() {
            System.out.println("===== MENU =====");
            System.out.println("1. Cadastrar Vendas");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Cadastrar Vendedor");
            System.out.println("4. Listar Vendas");
            System.out.println("5. Listar Vendedores");
            System.out.println("6. Listar Clientes");
            System.out.println("7. Listar Vendas por CPF do Cliente");
            System.out.println("8. Listar Vendedores");
            System.out.println("9. Sair");
            System.out.println("================");
            System.out.print("Escolha uma opção: ");
        }

        public void executar() {

            Scanner scanner = new Scanner(System.in);
            int opcao;
            boolean sair = false;

            while (!sair) {
                exibirMenu();
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do vendedor: ");
                        String nome = scanner.nextLine();

                        System.out.print("Digite o CPF do vendedor: ");
                        String cpf = scanner.next();

                        System.out.print("Digite o e-mail do vendedor: ");
                        String email = scanner.next();
                        Vendedor vendedor = new Vendedor(nome, cpf, email);
                        cadastrarVendedor(vendedor);

                        break;
                    case 2:

                        System.out.print("Digite o nome do cliente: ");
                        String nomeCliente = scanner.nextLine();

                        System.out.print("Digite o CPF do cliente: ");
                        String cpfCliente = scanner.next();

                        System.out.print("Digite o e-mail do cliente: ");
                        String emailCliente = scanner.next();

                        Cliente cliente = new Cliente(nomeCliente, cpfCliente, emailCliente);
                        cadastrarCliente(cliente);

                        break;
                    case 3:
                        cadastraVendas(vendedor, cliente);
                        break;
                    case 4:
                        listarVendas();
                        break;
                    case 5:
                        listarVendedores();
                        break;
                    case 6:
                        listarClientes();
                        break;
                    case 7:
                        listarVendasPorClienteCPF();
                        break;
                    case 8:
                        listarVendedores();
                        break;
                    case 9:
                        sair = true;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        }

        public void cadastrarVendedor(Vendedor vendedor) {

            for (Vendedor v : listaVendedores) {
                if (v.getCpf().equals(vendedor.getCpf())) {
                    System.out.println("CPF já cadastrado. Não é possível cadastrar o vendedor.");
                    return;
                }
            }
            for (Vendedor v : listaVendedores) {
                if (v.getEmail().equals(vendedor.getEmail())) {
                    System.out.println("E-mail já cadastrado. Não é possível cadastrar o vendedor.");
                    return;
                }
            }

            listaVendedores.add(vendedor);
            System.out.println("Vendedor cadastrado com sucesso!");
        }

        public void cadastrarCliente(Cliente cliente) {

            for (Cliente c : listarClientes) {
                if (c.getCpf().equals(cliente.getCpf())) {
                    System.out.println("CPF já cadastrado. Não é possível cadastrar o cliente.");
                    return;
                }
            }

            for (Cliente c : listarClientes) {
                if (c.getEmail().equals(cliente.getEmail())) {
                    System.out.println("E-mail já cadastrado. Não é possível cadastrar o cliente.");
                    return;
                }
            }
            listarClientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        }

        public void cadastraVendas(Venda venda) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o nome do produto: ");
            String nomeProduto = scanner.next();

            System.out.println(" Digite o codigo do cliente");
            int codigo = scanner.nextInt();

            System.out.print("Digite o preço do produto: ");
            double preco = scanner.nextDouble();

            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();

            System.out.println(" Digite o cpf do Cliente");
            int cpfCliente = scanner.nextInt();

            System.out.print("Digite o e-mail do vendedor: ");
            String email = scanner.next();

            SistemaDeVendas.cadastraVendas();

            List<Cliente> listasClientes = new ArrayList<>();

            Cliente clienteSelecionado = new Cliente();

            for (Cliente c : listasClientes) {
                if (c.getCpf().equals(cpfCliente)) {
                    cliente = c;
                    break;
                }
            }
            Cliente Cliente;
            if (Cliente == null) {
                System.out.println("Cliente não cadastrado. Não é possível realizar a venda.");
                return;
            }

            List<Vendedor> listaVendedores = new ArrayList<>();

            Vendedor vendedor = null;
            for (Vendedor v : listaVendedores) {
                if (v.getEmail().equals(email)) {
                    vendedor = v;
                    break;
                }
            }

            if (vendedor == null) {
                System.out.println("Vendedor não cadastrado. Não é possível realizar a venda.");
                return;
            }

            Venda venda = new Venda(vendedor, Cliente, preco, nomeProduto, quantidade, codigo);
            List<Venda> todasAsVendas = new ArrayList<>();
            todasAsVendas.add(venda);
            System.out.println("Venda cadastrada com sucesso!");

        }

        public static List<Venda> listarVendas() {
            List<Venda> listaVendas = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Qual o seu nome?");
            String nome = scanner.next();

            System.out.println("Digite seu cpf ");
            int cpf = scanner.nextInt();
            return listaVendas;
        }

        public static void listarVendedores() {
            List<Vendedor> listaVendedores = new ArrayList<>();
            System.out.println("===== LISTA DE VENDEDORES =====");
            if (listaVendedores.isEmpty()) {
                System.out.println("Nenhum vendedor cadastrado.");
            } else {
                for (Vendedor vendedor : listaVendedores) {
                    System.out.println("Nome: " + vendedor.getNome() + "CPF: " + vendedor.getCpf() + "E-mail: " + vendedor.getEmail());
                }
            }
        }

        public static void listarClientes() {
            List<Cliente> listasClientes = new ArrayList<>();
            System.out.println("===== LISTA DE CLIENTES =====");
            if (listasClientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado.");
            } else {
                for (Cliente cliente : listasClientes) {
                    System.out.println("Nome: " + cliente.getNome() + "CPF" + cliente.getCpf() + " Email" + cliente.getEmail());
                }
            }
        }

        public static List<Venda> listarVendasPorClienteCPF(List<Venda> vendas, String cpf) {
            List<Venda> vendasDoCliente = new ArrayList<>();

            for (Venda venda : vendas) {
                if (venda.getCliente().getCpf().equals(cpf)) {
                    vendasDoCliente.add(venda);
                }

            }
            return vendasDoCliente;
        }

        public Vendedor buscarVendedorPorEmail(String email) {
            for (Vendedor vendedor : listaVendedores) {
                if (vendedor.getEmail().equals(email)) {
                    return vendedor;

                }
            }
            System.out.println(" Vendedor nao cadastrado");
            return null;

        }

        public Cliente buscarClientePorCpf(String cpf) {
            for (Cliente cliente : listarClientes) {
                if (cliente.getEmail().equals(cpf)) {
                    return cliente;

                }
            }
            System.out.println(" Cliente nao cadastrado");
            return null;
        }
    }
}