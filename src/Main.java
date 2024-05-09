import static javax.swing.JOptionPane.*;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws Exception {
        SistemaReservas<Reserva> reservas = new SistemaReservas<>();

        String menu = "";
        menu += "Restaurante SABOR SOFISTICADO \n\n" + "1. Reservar mesa\n2. Pesquisar reservar\n3 - Imprimir reservas\n4. Imprimir lista de espera\n5. Cancelar reserva\n6. Finalizar";
        int opcao = 0;

        do {
            try {
                opcao = parseInt(showInputDialog(menu));
                if (opcao < 1 || opcao > 6) {
                    showMessageDialog(null, "Opção inválida");
                } else {
                    switch (opcao) {
                        case 1:
                            String nomeCliente = JOptionPane.showInputDialog("Nome do Cliente:");
                            boolean pagamentoAVista = JOptionPane.showConfirmDialog(null, "Pagamento à vista?") == JOptionPane.YES_OPTION;

                            Cliente cliente;
                            if (/* lógica para determinar se o cliente é pessoa física ou jurídica */) {
                                cliente = new PessoaFisica(nomeCliente, "CPF");
                            } else {
                                cliente = new PessoaJuridica(nomeCliente, "CNPJ");
                            }

                            Reserva novaReserva = new Reserva(cliente, pagamentoAVista);

                            if (reservas.getQuantidadeReservas() < 6) {
                                reservas.adicionarReserva(novaReserva);
                                JOptionPane.showMessageDialog(null, "Reserva adicionada com sucesso.");
                            } else {
                                reservas.adicionarListaDeEspera(novaReserva);
                                JOptionPane.showMessageDialog(null, "Você está na lista de espera.");
                            }
                            break;
                        case 2:
                            // Implementação depende da maneira como Reserva é comparada e buscada
                            break;
                        case 3:
                            showMessageDialog(null, reservas.listarReservas());
                            break;
                        case 4:
                            showMessageDialog(null, reservas.listarListaDeEspera());
                            break;
                        case 5: 
                            // Similar ao caso 2, a implementação depende de detalhes específicos do objeto
                            // Reserva
                            break;
                        default:
                            showMessageDialog(null, "Opção inválida");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Por favor, digite uma opção numérica.");
            }
        } while (opcao != 6);
    }
}