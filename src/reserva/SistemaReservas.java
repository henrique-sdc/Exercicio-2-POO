package reserva;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservas<T extends Reserva> { 
    public static final int maxReservas = 6;
    private List<T> reservas; 
    private List<T> listaDeEspera;

    public SistemaReservas() {
        reservas = new ArrayList<>();
        listaDeEspera = new ArrayList<>();
    }

    public void adicionarReserva(T reserva) { 
        if (reservas.size() < maxReservas) {
            reservas.add(reserva);
        } else {
            listaDeEspera.add(reserva);
        }
    }

    public Reserva pesquisarReserva(String cpfCnpj) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente() instanceof PessoaFisica && ((PessoaFisica) reserva.getCliente()).getCpf().equals(cpfCnpj)) {
                return reserva;
            } else if (reserva.getCliente() instanceof PessoaJuridica && ((PessoaJuridica) reserva.getCliente()).getCnpj().equals(cpfCnpj)) {
                return reserva;
            }
        }
        for (Reserva reserva : listaDeEspera) {
            if (reserva.getCliente() instanceof PessoaFisica && ((PessoaFisica) reserva.getCliente()).getCpf().equals(cpfCnpj)) {
                return reserva;
            } else if (reserva.getCliente() instanceof PessoaJuridica && ((PessoaJuridica) reserva.getCliente()).getCnpj().equals(cpfCnpj)) {
                return reserva;
            }
        }
        return null;
    }

    public boolean cancelarReserva(String cpfCnpj) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getCliente() instanceof PessoaFisica && ((PessoaFisica) reserva.getCliente()).getCpf().equals(cpfCnpj) ||
                reserva.getCliente() instanceof PessoaJuridica && ((PessoaJuridica) reserva.getCliente()).getCnpj().equals(cpfCnpj)) {
                reservas.remove(i); // Remove pelo índice
    
                if (listaDeEspera.size() > 0) {
                    reservas.add(listaDeEspera.remove(0)); // Aqui ainda usa remove, mas é uma operação rápida na primeira posição
                }
                return true;
            }
        }
    
        for (int i = 0; i < listaDeEspera.size(); i++) {
            Reserva reserva = listaDeEspera.get(i);
            if (reserva.getCliente() instanceof PessoaFisica && ((PessoaFisica) reserva.getCliente()).getCpf().equals(cpfCnpj) ||
                reserva.getCliente() instanceof PessoaJuridica && ((PessoaJuridica) reserva.getCliente()).getCnpj().equals(cpfCnpj)) {
                listaDeEspera.remove(i); // Remove pelo índice
                return true;
            }
        }
    
        return false; 
    }

    public String listarReservas() {
        if (reservas.isEmpty()) {
            return "Nenhuma reserva realizada ainda.";
        }
        String lista = "Reservas:\n";
        for (T reserva : reservas) { 
            lista += reserva.toString() + "\n---------------------\n";
        }
        return lista;
    }

    public String listarListaDeEspera() {
        if (listaDeEspera.isEmpty()) {
            return "A lista de espera está vazia.";
        }

        String lista = "Lista de Espera:\n";
        for (int i = 0; i < listaDeEspera.size(); i++) {
            lista += (i + 1) + " - " + listaDeEspera.get(i).toString() + "\n---------------------\n";
        }
        return lista;
    }

    public int getTotalReservas() {
        return reservas.size() + listaDeEspera.size();
    }
}