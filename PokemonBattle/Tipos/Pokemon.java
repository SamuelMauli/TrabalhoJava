package Tipos;

public abstract class Pokemon implements Batalha {

    private final String codigo;
    private final String nome;
    private int saude;
    private final Tipo tipo;
    private String ataqueUm;
    private String ataqueDois;
    private String ataqueTres;
    private boolean Defense;

    public Pokemon(String codigo, String nome, int saude, Tipo tipo, String ataqueUm, String ataqueDois,
            String ataqueTres, boolean Defense) {
        this.codigo = codigo;
        this.nome = nome;
        this.saude = saude;
        this.tipo = tipo;
        this.ataqueUm = ataqueUm;
        this.ataqueDois = ataqueDois;
        this.ataqueTres = ataqueTres;
        this.Defense = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public abstract int usarAtaque1();

    public abstract int usarAtaque2();

    public abstract int usarAtaque3();

    public abstract int calcularDano(Tipo tipoAtacante, Tipo tipoDefensor, int dano, boolean def);

    public abstract void atacar(int ataqueEscolhido, Pokemon defensor);

    public abstract void receberDano(int dano);

    public abstract void curar(Pokemon jogador);

    public String getAtaqueUm() {
        return ataqueUm;
    }

    public String getAtaqueDois() {
        return ataqueDois;
    }

    public String getAtaqueTres() {
        return ataqueTres;
    }

    @Override
    public String toString() {
        String info = String.format("Codigo: %s\nNome: %s\nSaude: %d", codigo, nome, saude);
        String border = "+-------------------+";
        StringBuilder box = new StringBuilder();

        box.append(border).append("\n");
        for (String line : info.split("\n")) {
            box.append(String.format("| %-17s |\n", line));
        }
        box.append(border);

        return box.toString();
    }

}
