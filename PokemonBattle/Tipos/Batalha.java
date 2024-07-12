package Tipos;

public interface Batalha {

    public void atacar(int ataqueEscolhido, Pokemon defensor);

    public void receberDano(int dano);

    public int calcularDano(Tipo atacante, Tipo defensor, int dano, boolean def);

    public void curar(Pokemon jogador);

}