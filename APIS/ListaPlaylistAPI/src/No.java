public class No<T> {
    T dado;
    No<T> proximo, anterior;

    public No(T dado) {
        this.dado = dado;
    }
}