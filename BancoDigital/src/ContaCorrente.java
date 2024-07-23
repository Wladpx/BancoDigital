package BancoDigital.src;

@SuppressWarnings({ "rawtypes", "hiding" })
public class ContaCorrente<Cliente> extends Conta {

    @SuppressWarnings("unchecked")
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrente() {  //construtor sugerido pela IDE
        super();
    }

    public void imprimirExtrato() {
        System.out.println("#### Extrato de Conta Corrente #####");
        super.imprimirInfosComuns(); //metodo protegido para acesso de classes filhas
    }

}