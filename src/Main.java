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
                        case 1: {
                            String tipoCliente = showInputDialog(null, "Tipo de Cliente: (F)isica ou (J)uridica?", "Tipo de Cliente", JOptionPane.QUESTION_MESSAGE);

                            if (tipoCliente == null) {
                                break;
                            }

                            tipoCliente = tipoCliente.toUpperCase();
                            if (!tipoCliente.equals("F") && !tipoCliente.equals("J")) {
                                showMessageDialog(null, "Tipo de cliente inválido. Escolha 'F' ou 'J'.");
                                break; 
                            }

                            String nomeCliente = showInputDialog("Nome do Cliente:");
                            String cpfCnpj = showInputDialog((tipoCliente.equals("F") ? "CPF: " : "CNPJ: "));
                            boolean pagamentoAVista = showConfirmDialog(null, "Pagamento à vista?") == JOptionPane.YES_OPTION;

                            Cliente cliente = tipoCliente.equals("F") ? new PessoaFisica(nomeCliente, cpfCnpj) : new PessoaJuridica(nomeCliente, cpfCnpj);
                            Reserva novaReserva = new Reserva(cliente, pagamentoAVista);
                            reservas.adicionarReserva(novaReserva);

                            if (reservas.getTotalReservas() <= SistemaReservas.MAX_RESERVAS) {
                                showMessageDialog(null, "Reserva adicionada com sucesso. Mesa reservada!");
                            } else {
                                showMessageDialog(null, "Reserva adicionada com sucesso. Você está na lista de espera.");
                            }
                            break;
                        }
                        case 2: {
                            String cpfCnpj = showInputDialog("Informe o CPF ou CNPJ para pesquisar a reserva:");
                            Reserva reserva = reservas.pesquisarReserva(cpfCnpj);
                            if (reserva != null) {
                                showMessageDialog(null, "Reserva encontrada:\n" + reserva.toString());
                            } else {
                                showMessageDialog(null, "Nenhuma reserva encontrada para este CPF/CNPJ.");
                            }
                            break;
                        }
                        case 3:
                            showMessageDialog(null, reservas.listarReservas());
                            break;
                        case 4:
                            showMessageDialog(null, reservas.listarListaDeEspera());
                            break;
                        case 5: {
                            String cpfCnpj = showInputDialog("Informe o CPF ou CNPJ para cancelar a reserva:");
                            boolean cancelada = reservas.cancelarReserva(cpfCnpj);
                            if (cancelada) {
                                showMessageDialog(null, "Reserva cancelada com sucesso.");
                            } else {
                                showMessageDialog(null, "Nenhuma reserva encontrada para este CPF/CNPJ.");
                            }
                            break;
                        }
                        case 6:
                            showMessageDialog(null, "Saindo do sistema...");
                            break; 
                        default:
                            showMessageDialog(null, "Opção inválida");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Opção inválida! Digite um número.");
            }
        } while (opcao != 6);
    }
}