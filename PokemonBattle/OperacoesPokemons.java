import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Tipos.*;

public class OperacoesPokemons {

    private List<Pokemon> pokedex = new ArrayList<>();

    String informacoesPokemons = "Arquivos\\pokemons.txt";

    public void preencherLista() {
        try (BufferedReader br = new BufferedReader(new FileReader(informacoesPokemons))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] infoPokemon = line.split(", ");
                String id = infoPokemon[0];
                String nome = infoPokemon[1];
                int saude = Integer.parseInt(infoPokemon[2]);
                Tipo tipo = Tipo.valueOf(infoPokemon[3]);

                switch (tipo) {
                    case Aco:
                        pokedex.add(new Aco(id, nome, saude, tipo));
                        break;
                    case Agua:
                        pokedex.add(new Agua(id, nome, saude, tipo));
                        break;
                    case Dragao:
                        pokedex.add(new Dragao(id, nome, saude, tipo));
                        break;
                    case Eletrico:
                        pokedex.add(new Eletrico(id, nome, saude, tipo));
                        break;
                    case Fada:
                        pokedex.add(new Fada(id, nome, saude, tipo));
                        break;
                    case Fantasma:
                        pokedex.add(new Fantasma(id, nome, saude, tipo));
                        break;
                    case Fogo:
                        pokedex.add(new Fogo(id, nome, saude, tipo));
                        break;
                    case Gelo:
                        pokedex.add(new Gelo(id, nome, saude, tipo));
                        break;
                    case Lutador:
                        pokedex.add(new Lutador(id, nome, saude, tipo));
                        break;
                    case Normal:
                        pokedex.add(new Normal(id, nome, saude, tipo));
                        break;
                    case Noturno:
                        pokedex.add(new Noturno(id, nome, saude, tipo));
                        break;
                    case Planta:
                        pokedex.add(new Planta(id, nome, saude, tipo));
                        break;
                    case Psiquico:
                        pokedex.add(new Psiquico(id, nome, saude, tipo));
                        break;
                    case Pedra:
                        pokedex.add(new Pedra(id, nome, saude, tipo));
                        break;
                    case Terra:
                        pokedex.add(new Terra(id, nome, saude, tipo));
                        break;
                    case Veneno:
                        pokedex.add(new Veneno(id, nome, saude, tipo));
                        break;
                    case Voador:
                        pokedex.add(new Voador(id, nome, saude, tipo));
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na leitura do arquivo!");
        }
    }

    public void mostrarPokemonsPorTipo(Tipo tipoEscolhido) {
        for (Pokemon pokemon : pokedex) {
            if (pokemon.getTipo() == tipoEscolhido) {
                System.out.println(pokemon);
            }
        }
    }

public Pokemon sortearPokemon() {
        Random rand = new Random();
        Pokemon pokemonSorteado = pokedex.get(rand.nextInt(pokedex.size()));

        System.out.println("+-------------------------+-----------------------+");
        System.out.println("| Pokémon sorteado        |                       |");
        System.out.println("+-------------------------+-----------------------+");
        System.out.println("| Nome: " + pokemonSorteado.getNome());
        System.out.println("| Vida: " + pokemonSorteado.getSaude());
        System.out.println("| Tipo: " + pokemonSorteado.getTipo());
        System.out.println("+-------------------------+-----------------------+");

        return pokemonSorteado;
    }

    public Pokemon escolherPokemon(String id) {
        Pokemon escolhido = null;
        for (Pokemon pokemon : pokedex) {
            if (id.equals(pokemon.getCodigo())) {
                escolhido = pokemon;

                System.out.println("+-------------------------+-----------------------+");
                System.out.println("| Pokémon escolhido       |                       |");
                System.out.println("+-------------------------+-----------------------+");
                System.out.println("| Nome: " + pokemon.getNome());
                System.out.println("| Vida: " + pokemon.getSaude());
                System.out.println("| Tipo: " + pokemon.getTipo());
                System.out.println("+-------------------------+-----------------------+");

                break;
            }
        }
        return escolhido;
    }
}
