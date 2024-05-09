import java.util.Objects;

public class Musica extends Object {
    String titulo;
    String artista;
    int duracao;
    int reproducoes;

    public Musica(String titulo, String artista, int duracao, int reproducoes) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.reproducoes = reproducoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setReproducoes(int reproducoes) {
        this.reproducoes = reproducoes;
    }

    @Override
    public String toString() {
        return "-- Título: " + titulo + " | Artista: " + artista + " | Duração: " + duracao + " | Reproduções: " + reproducoes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Musica musica = (Musica) obj;
        return Objects.equals(titulo, musica.titulo);
    }
}