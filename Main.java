public class Main {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica("Alek", "123.456.789-00");
        PessoaJuridica pj = new PessoaJuridica("Empresa Alekinho Ltda", "98.765.432/0001-00");
        Reserva reservaPF = new Reserva(pf, true);
        Reserva reservaPJ = new Reserva(pj, false);

        System.out.println(reservaPF);
        System.out.println("---------------------");
        System.out.println(reservaPJ);
    }
}