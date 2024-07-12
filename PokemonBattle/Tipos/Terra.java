package Tipos;

public class Terra extends Pokemon {

    private static final String atk1 = "Earthquake";
    private static final String atk2 = "Rock Tomb";
    private static final String atk3 = "Dig";
    private static boolean defender = false;

    public Terra(String codigo, String nome, int saude, Tipo tipo) {
        super(codigo, nome, saude, tipo, atk1, atk2, atk3, defender);
    }

    public void defender() {
        System.out.println(this.getNome() + " está se defendendo!");
        defender = true;
    }

    @Override
    public void curar(Pokemon jogador) {
        setSaude((int) (getSaude() + (getSaude() * 0.2)));
    }

    public int usarAtaque1() {
        System.out.println(this.getNome() + " usou " + atk1 + "!");
        int dano = 80;
        return dano;

    }

    public int usarAtaque2() {
        System.out.println(this.getNome() + " usou " + atk2 + "!");
        int dano = 70;
        return dano;

    }

    public int usarAtaque3() {
        System.out.println(this.getNome() + " usou " + atk3 + "!");
        int dano = 30;
        return dano;
    }

    @Override
    public int calcularDano(Tipo tipoAtaque, Tipo tipoDefensor, int dano, boolean def) {

        double modificadorAtaque = 1.0;
        double modificadorDefesa = 1.0;

        if (tipoAtaque.ataqueCritico(tipoAtaque, tipoDefensor)) {
            modificadorAtaque = 2.0;
        } else if (tipoAtaque.danoReduzido(tipoAtaque, tipoDefensor)) {
            modificadorAtaque = 0.5;
        }

        if (tipoDefensor.ataqueCritico(tipoAtaque, tipoDefensor)) {
            modificadorDefesa = 0.5;
        } else if (tipoDefensor.danoReduzido(tipoAtaque, tipoDefensor)) {
            modificadorDefesa = 2.0;
        }
        if (def == true) {
            return (int) ((modificadorAtaque / 2) * modificadorDefesa * dano);
        } else
            return (int) (modificadorAtaque * modificadorDefesa * dano);
    }

    @Override
    public void atacar(int ataque, Pokemon defensor) {
        switch (ataque) {
            case 1:
                defensor.receberDano(calcularDano(this.getTipo(), defensor.getTipo(), usarAtaque1(), defender));
                defender = false;
                break;
            case 2:
                defensor.receberDano(calcularDano(this.getTipo(), defensor.getTipo(), usarAtaque2(), defender));
                defender = false;
                break;
            case 3:
                defensor.receberDano(calcularDano(Tipo.Normal, defensor.getTipo(), usarAtaque3(), defender));
                defender = false;
            default:
            case 4:
                defender();
                break;
        }
    }

    @Override
    public void receberDano(int dano) {
        if (!defender) {
            this.setSaude(getSaude() - dano);
        } else {
            this.setSaude(getSaude() - (int) (dano * 0.5));
        }

        System.out.println(getNome() + " recebeu " + dano + " pontos de dano!");
    }
}
