import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        Playlist<String> lista = new Playlist<>();
        Playlist<Musica> listaMusica = new Playlist<>();

        String menu = "";
        menu += "Cabaret Music ❤ \n" + 
                "╔════╗ ♪\n" + 
                "║██║ ♫\n" + 
                "║ (●) ♫\n" + 
                "╚════╝♪♪♪\n\n1 - Adicionar Música\n2 - Remover\n3 - Buscar \n4 - Exibir\n\n5 - Escolher Música para Tocar\n6 - Tocar Playlist\n7 - Tocar Playlist em Ordem Aleatória\n8 - Listar as Mais Escutadas\n\n9 - Sair";
        int opcao = 0;

        do {
            opcao = parseInt(showInputDialog(menu));
            if (opcao < 1 || opcao > 9) {
                showMessageDialog(null, "Opção inválida");
            } else {
                switch (opcao) {
                    case 1:
                        String titulo = showInputDialog("Qual o título da música?");
                        String artista = showInputDialog("Qual o nome do artista?");
                        int duracao = parseInt(showInputDialog("Qual a duração da música?"));
                        int reproducoes = parseInt(showInputDialog("Quantas reproduções?"));
                        listaMusica.adicionar(new Musica(titulo, artista, duracao, reproducoes));
                        lista.adicionar(titulo);
                        break;
                    case 2:
                        String tituloRemover = showInputDialog("Qual título quer remover?");
                        if (listaMusica.remover(new Musica(tituloRemover, "", 0, 0))) {
                            lista.remover(tituloRemover);
                            showMessageDialog(null, "Música removida com sucesso!");
                        } else {
                            showMessageDialog(null, "Música não encontrada na lista.");
                        }
                        break;
                    case 3:
                        String musica = showInputDialog("Qual o título da música deseja pesquisar?");
                        No<String> aux = lista.buscar(musica);
                        if (aux == null) {
                            showMessageDialog(null, musica + " não foi encontrado");
                        } else {
                            No<Musica> nomeCompleto = listaMusica.buscar(new Musica(musica, "", 0, 0));
                            Musica nomeEncontrado = nomeCompleto.dado;
                            showMessageDialog(null, "Música Encontrada: " + nomeEncontrado);
                        }
                        break;
                    case 4:
                        if (listaMusica.inicio == null) {
                            showMessageDialog(null, "A playlist está vazia.");
                        } else {
                            showMessageDialog(null, listaMusica.exibir());
                        }
                        break;
                    case 5:
                        String tituloMusica = showInputDialog("Qual música deseja tocar?");
                        No<String> auxMusica = lista.buscar(tituloMusica);
                        No<Musica> noMusica = listaMusica.buscar(new Musica(tituloMusica, "", 0, 0));
                        if (auxMusica == null) {
                            showMessageDialog(null, "Música " + tituloMusica + " não encontrada na playlist");
                        } else {
                            new Thread(() -> {
                                try {
                                    FileInputStream fileInputStream = new FileInputStream("Musicas/" + tituloMusica + ".mp3");
                                    Player player = new Player(fileInputStream);
                                    player.play(500);
                                } catch (Exception e) {
                                    // showMessageDialog(null, "Erro ao reproduzir a música: " + e.getMessage());
                                }
                            }).start();
                            Musica musicaEncontrada = noMusica.dado;
                            showMessageDialog(null, "Cabaret Music ❤ \n\nTocando a música: \n" + musicaEncontrada + "\n▶ ▬▬▬▬▬▬▬▬ 🔉");
                        }
                        break;
                    case 6:
                        if (listaMusica.inicio == null) {
                            showMessageDialog(null, "A playlist está vazia.");
                        } else {
                            listaMusica.tocarPlaylist();
                            lista.tocarSoMusica();
                            showMessageDialog(null, "Playlist tocada com sucesso!");
                        }
                        break;
                    case 7:
                        if (listaMusica.inicio == null) {
                            showMessageDialog(null, "A playlist está vazia.");
                        } else {
                            listaMusica.tocarPlaylistAleatoria();
                            showMessageDialog(null, "Playlist tocada aleatoriamente com sucesso!");
                        }
                        break;
                    case 8:
                        listarMaisEscutadas(listaMusica);
                        break;
                    
                    }
            }
        } while (opcao != 9);
    }

    public static void listarMaisEscutadas(Playlist<Musica> playlist) {
        if (playlist == null || playlist.inicio == null) {
            showMessageDialog(null, "A playlist está vazia.");
            return;
        }

        Playlist<Musica> copiaPlaylist = new Playlist<>();
        No<Musica> aux = playlist.inicio;
        while (aux != null) {
            copiaPlaylist.adicionar(aux.dado);
            aux = aux.proximo;
        }

        Playlist<Musica> maisEscutadas = new Playlist<>();
        while (copiaPlaylist.inicio != null) {
            No<Musica> maisTocada = copiaPlaylist.inicio;
            No<Musica> atual = copiaPlaylist.inicio.proximo;

            while (atual != null) {
                if (atual.dado.getReproducoes() > maisTocada.dado.getReproducoes()) {
                    maisTocada = atual;
                }
                atual = atual.proximo;
            }

            maisEscutadas.adicionar(maisTocada.dado);
            copiaPlaylist.remover(maisTocada.dado);
        }

        showMessageDialog(null, maisEscutadas.exibir());
    }
}