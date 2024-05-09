import static javax.swing.JOptionPane.*;

import javax.swing.JOptionPane;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        SistemaReservas<Reserva> reservas = new SistemaReservas<>();

        String menu = "";
        menu += "Sistema de Reservas do Restaurante\n\n" +
                "1 - Reserva mesa\n" +
                "2 - Pesquisar reserva\n" +
                "3 - Imprimir reservas\n" +
                "4 - Imprimir lista de espera\n" +
                "5 - Cancelar reserva\n" +
                "6 - Finalizar";

        int opcao;

        do {
            opcao = parseInt(showInputDialog(menu));
            switch (opcao) {
                case 1: // Adiciona reserva
                    String nomeCliente = JOptionPane.showInputDialog("Nome do Cliente:");
                    boolean pagamentoAVista = JOptionPane.showConfirmDialog(null,
                            "Pagamento à vista?") == JOptionPane.YES_OPTION;
                    // Aqui, você precisa corrigir para criar uma instância correta de Cliente.
                    // Exemplo, usando PessoaFisica:
                    Cliente cliente = new PessoaFisica(nomeCliente, "CPF"); // CPF deve ser obtido como entrada do
                                                                            // usuário
                    Reserva novaReserva = new Reserva(cliente, pagamentoAVista);
                    reservas.adicionarReserva(novaReserva);
                    JOptionPane.showMessageDialog(null, "Reserva adicionada com sucesso.");
                    break;
                case 2: // Pesquisar reserva
                    // Implementação depende da maneira como Reserva é comparada e buscada
                    break;
                case 3: // Imprimir reservas
                    showMessageDialog(null, reservas.listarReservas());
                    break;
                case 4: // Listar lista de espera
                    showMessageDialog(null, reservas.listarListaDeEspera());
                    break;
                case 5: // Cancelar reserva
                    // Similar ao caso 2, a implementação depende de detalhes específicos do objeto
                    // Reserva
                    break;
                case 6: // Sair não precisa de ação
                    break;
                default:
                    showMessageDialog(null, "Opção inválida");
                    break;
            }
        } while (opcao != 6);
    }
}