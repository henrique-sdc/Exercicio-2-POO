public class Reserva implements Pagamento {
    private Cliente cliente;
    private boolean pagamentoAVista;
    private final static double VALOR = 3200.00;

    public Reserva(Cliente cliente, boolean pagamentoAVista) {
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }

    @Override
    public double calcularPagamento() {
        // Aqui, você pode implementar qualquer lógica de desconto ou acréscimo.
        // Vamos manter o valor fixo por enquanto.
        return VALOR;
    }

    @Override
    public String toString() {
        String tipoPagamento = pagamentoAVista ? "à vista" : "parcelado";
        return "Reserva para o cliente: " + cliente +
                "\nTipo de pagamento: " + tipoPagamento +
                "\nValor: R$ " + calcularPagamento();
    }
}