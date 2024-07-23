package BancoDigital.src;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Banco bancoInicial = new Banco(); // Instancia novo banco

        bancoInicial.setNome("First Bank"); // Insere nome do banco

        Cliente carla = new Cliente("Carla", bancoInicial);  // Criado novo cliente Carla
        carla.setNome("Carla Edila Silveira"); // Insere o nome do cliente

        Conta ccorrente = new ContaCorrente(carla); // Instanciada nova conta corrente

        ccorrente.depositar(100); // Criado um deposito em conta corrente

        Cliente alisson = new Cliente("Alisson", bancoInicial);  // Instancia novo cliente
        Conta cpoupanca = new ContaPoupanca(alisson);  // Instanciada nova conta poupanca

        ccorrente.imprimirExtrato();  // Imprime extrato de ccorrente Carla
        cpoupanca.imprimirExtrato();  // Imprime estrato de cpoupanca Alisson

        ccorrente.transferir(48, cpoupanca);  // Faz transferência de ccorrente Carla pra cpoupanca Alisson

        ccorrente.imprimirExtrato(); // Imprime extrato atualizado de ccorrente Carla
        cpoupanca.imprimirExtrato(); // Imprime extrato atualizado de cpoupanca Alisson
        bancoInicial.mostrarClientes(); // Mostra lista de clientes

        Cliente carolina = new Cliente("Carolina", bancoInicial);  // Instancia novo cliente Carolina
        Conta ccorrente2 = new ContaCorrente(carolina); // Instancia nova ccorrente2 de Carolina
        ccorrente2.imprimirExtrato();  // Imprime ccorrente2 de Carolina
        bancoInicial.mostrarClientes(); // Mostra lista atualizada de clientes do banco
    }
}

// Classe Banco
class Banco {
    @SuppressWarnings("unused")
    private String nome;
    private List<Cliente> clientes = new ArrayList<>();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarCliente(Cliente cliente) {        clientes.add(cliente);
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }
    }
}

// Classe Cliente
class Cliente {
    private String nome;
    @SuppressWarnings("unused")
    private Banco banco;

    public Cliente(String nome, Banco banco) {
        this.nome = nome;
        this.banco = banco;
        banco.adicionarCliente(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

// Classe Conta
abstract class Conta {
    protected Cliente cliente;
    protected double saldo;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.depositar(valor);
        }
    }

    public void imprimirExtrato() {
        System.out.println("Cliente: " + cliente.getNome() + " Saldo: " + saldo);
    }
}

// Classe ContaCorrente
class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }
}

// Classe ContaPoupanca
class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
}