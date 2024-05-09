public class Reserva implements Pagamento {
    private Cliente cliente;
    private boolean pagamentoAVista;
    private final static double valor = 3200.00;

    public Reserva(Cliente cliente, boolean pagamentoAVista) {
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isPagamentoAVista() {
        return pagamentoAVista;
    }

    @Override
    public double calcularPagamento() {
        if (pagamentoAVista) {
            return valor * 0.9;
        } else {
            return valor;
        }
    }

    @Override
    public String toString() {
        String tipoPagamento = pagamentoAVista ? "à vista" : "parcelado";
        return "Reserva para o cliente: " + cliente + "\nTipo de pagamento: " + tipoPagamento + "\nValor: R$ " + calcularPagamento();
    }
}