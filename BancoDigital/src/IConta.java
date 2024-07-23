package BancoDigital.src;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, @SuppressWarnings("rawtypes") Conta contaDestino);

    void imprimirExtrato();
}