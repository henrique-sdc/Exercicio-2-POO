public class SistemaReservas<T> {
    No<T> inicio, fim;

    public void adicionarReserva(T dado) {
        No<T> aux = new No<>(dado);
        if (inicio == null) {
            inicio = aux;
            fim = aux;
        } else {
            fim.proximo = aux;
            aux.anterior = fim;
            fim = aux;
        }
    }

    public boolean cancelarReserva(T dado) {
        No<T> atual = inicio;
        while (atual != null) {
            if (atual.dado.equals(dado)) {
                if (atual == inicio) {
                    inicio = inicio.proximo;
                    if (inicio != null) {
                        inicio.anterior = null;
                    }
                } else if (atual == fim) {
                    fim = fim.anterior;
                    if (fim != null) {
                        fim.proximo = null;
                    }
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public No<T> buscarReserva(T dado) {
        No<T> aux = inicio;
        while (aux != null) {
            if (aux.dado.equals(dado)) {
                return aux;
            }
            aux = aux.proximo;
        }
        return null;
    }

    public String listarReservas() {
        No<T> aux = inicio;
        String msg = "";
        while (aux != null) {
            msg += aux.dado + "\n";
            aux = aux.proximo;
        }
        return msg;
    }

    public String exibir() {
        No<T> aux = inicio;
        String msg = "";
        while (aux != null) {
            msg += aux.dado + "\n";
            aux = aux.proximo;
        }
        return msg;
    }

    public String listarListaDeEspera() {
        No<T> aux = inicio;
        StringBuilder msg = new StringBuilder("Lista de Espera:\n");
        while (aux != null) {
            msg.append(aux.dado).append("\n");
            aux = aux.proximo;
        }
        return msg.toString();
    }
}