public class Reserva implements Pagamento {
    private Cliente cliente;
    private boolean pagamentoAVista;
    private final static double valor = 3200.00;
    private final static double descontoAVista = 0.1;

    public Reserva(Cliente cliente, boolean pagamentoAVista) {
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public double calcularPagamento() {
        if (pagamentoAVista) {
            return valor - (valor * descontoAVista);
        } else {
            return valor;
        }
    }

    @Override
    public String toString() {
        String tipoCliente = cliente instanceof PessoaFisica ? "Pessoa Física" : "Pessoa Jurídica";
        String tipoPagamento = pagamentoAVista ? "à vista" : "parcelado";
        return tipoCliente + " - " + cliente + "\nPagamento: " + tipoPagamento + "\nValor: R$ " + String.format("%.2f", calcularPagamento());
    }
}