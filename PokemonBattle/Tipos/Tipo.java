package Tipos;

public enum Tipo {
  Fogo,
  Agua,
  Planta,
  Eletrico,
  Terra,
  Pedra,
  Gelo,
  Lutador,
  Voador,
  Psiquico,
  Veneno,
  Inseto,
  Fantasma,
  Dragao,
  Aco,
  Fada,
  Normal,
  Noturno;

  public boolean ataqueCritico(Tipo atk, Tipo def) {

    switch (atk) {
      case Fogo:
        return def == Planta || def == Gelo || def == Inseto || def == Aco;
      case Agua:
        return def == Fogo || def == Pedra || def == Terra;
      case Planta:
        return def == Agua || def == Pedra || def == Terra;
      case Eletrico:
        return def == Agua || def == Voador;
      case Terra:
        return def == Fogo || def == Eletrico || def == Veneno || def == Pedra || def == Aco;
      case Pedra:
        return def == Fogo || def == Gelo || def == Voador || def == Inseto;
      case Gelo:
        return def == Planta || def == Terra || def == Dragao || def == Voador;
      case Lutador:
        return def == Normal || def == Gelo || def == Pedra || def == Aco || def == Noturno;
      case Voador:
        return def == Planta || def == Lutador || def == Inseto;
      case Psiquico:
        return def == Lutador || def == Veneno;
      case Veneno:
        return def == Planta || def == Fada;
      case Inseto:
        return def == Planta || def == Psiquico || def == Noturno;
      case Fantasma:
        return def == Psiquico || def == Fantasma;
      case Dragao:
        return def == Dragao;
      case Aco:
        return def == Gelo || def == Pedra || def == Fada;
      case Fada:
        return def == Lutador || def == Dragao || def == Noturno;
      case Noturno:
        return def == Psiquico || def == Fantasma;
      case Normal:
        return false;
      default:
        return false;
    }
  }

  public boolean danoReduzido(Tipo atk, Tipo def) {

    switch (atk) {
      case Fogo:
        return def == Agua || def == Pedra || def == Terra;
      case Agua:
        return def == Eletrico || def == Planta;
      case Planta:
        return def == Fogo || def == Gelo || def == Voador || def == Inseto || def == Veneno;
      case Eletrico:
        return def == Terra;
      case Terra:
        return def == Agua || def == Gelo || def == Planta;
      case Pedra:
        return def == Agua || def == Planta || def == Lutador || def == Terra || def == Aco;
      case Gelo:
        return def == Fogo || def == Lutador || def == Pedra || def == Aco;
      case Lutador:
        return def == Voador || def == Psiquico || def == Fada;
      case Voador:
        return def == Eletrico || def == Gelo || def == Pedra;
      case Psiquico:
        return def == Inseto || def == Fantasma || def == Noturno;
      case Veneno:
        return def == Terra || def == Psiquico;
      case Inseto:
        return def == Fogo || def == Voador || def == Pedra;
      case Fantasma:
        return def == Fantasma || def == Noturno;
      case Dragao:
        return def == Gelo || def == Dragao || def == Fada;
      case Aco:
        return def == Fogo || def == Lutador || def == Terra;
      case Fada:
        return def == Veneno || def == Aco;
      case Noturno:
        return def == Lutador || def == Inseto || def == Fada;
      case Normal:
        return def == Lutador;
      default:
        return false;
    }
  }
}
