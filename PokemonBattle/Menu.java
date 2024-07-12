import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Tipos.Pokemon;
import Tipos.Tipo;

public class Menu {

    public Scanner scanner = new Scanner(System.in);

    OperacoesPokemons opArq = new OperacoesPokemons();

    Random rand = new Random();
    int contadorVitoria = 0;

    private String progressoSalvo;
    private String LogBatalha = "Arquivos\\historicoBatalha.txt";
    

    public static String primeiraLetraMaius(String tipo) {
        return tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
    }
    File arquivo = new File("Arquivos\\batalha.txt");

    public void iniciar() {
        imprimirCabecalho();
        exibirMenuInicial();
    }

    public void imprimirCabecalho() {
        System.out.println("  ____        _        _ _             _____      _                              ");
        System.out.println(" |  _ \\      | |      | | |           |  __ \\    | |                             ");
        System.out.println(" | |_) | __ _| |_ __ _| | |__   __ _  | |__) |__ | | _____ _ __ ___   ___  _ __  ");
        System.out.println(" |  _ < / _` | __/ _` | | '_ \\ / _` | |  ___/ _ \\| |/ / _ \\ '_ ` _ \\ / _ \\| '_ \\ ");
        System.out.println(" | |_) | (_| | |_ (_| | | | | | (_| | | |  | (_) |   <  __/ | | | | | (_) | | | |");
        System.out.println(" |____/ \\__,_|\\__\\__,_|_|_| |_|\\__,_| |_|   \\___/|_|\\_\\___|_| |_| |_|\\___/|_| |_|");
        System.out.println("                                                                                 ");
        System.out.println("                                                                                 ");
    }

    public void exibirMenuInicial() {

        opArq.preencherLista();

        String menu1 = "+-------------------+-------------------+\n" +
               "| 01. Novo Jogo     | 02. Carregar Jogo |\n" +
               "+-------------------+-------------------+\n";

        System.out.println(menu1);


        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                menuNovoJogo();
                break;
            case 2:
                menuCarregarJogo();
                break;
            default:
                System.out.println("Opcao invalida.");
                exibirMenuInicial();
                break;
        }
    }

    public void menuNovoJogo() {
            String menu2 = "+---------------------------+-----------------------------+\n" +
               "| 01. Escolha um Pokemon    | 02. Escolha Aleatoriamente  |\n" +
               "+---------------------------+-----------------------------+\n";

            System.out.println(menu2);


        int opcao = scanner.nextInt();
        scanner.nextLine();
        Pokemon jogador = null;

        switch (opcao) {
            case 1:
                while (true) {
                    String tabela = "+---------+---------+---------+---------+---------+---------+---------+---------+\n"
                            +
                            "| Fogo    | Agua    | Planta  | Eletrico| Terra   | Pedra   | Gelo    | Lutador |\n" +
                            "+---------+---------+---------+---------+---------+---------+---------+---------+\n" +
                            "| Voador  | Psiquico| Veneno  | Inseto  | Fantasma| Dragao  | Aco     | Fada    |\n" +
                            "+---------+---------+---------+---------+---------+---------+---------+---------+";

                    System.out.println(tabela);
                    System.out.println("Escolha o tipo do seu pokemon:");
                    // for(int i=0;i<)
                    String tipo = scanner.nextLine();
                    String tipoFormatado = primeiraLetraMaius(tipo);
                    try {
                        Tipo tipoEscolhido = Tipo.valueOf(tipoFormatado);
                        opArq.mostrarPokemonsPorTipo(tipoEscolhido);
                        System.out.println("Digite o codigo do Pokemon que deseja");
                        String id = scanner.nextLine().toUpperCase();
                        jogador = opArq.escolherPokemon(id);
                        break;

                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo de pokemon invalido.");
                    }
                }
                break;
            case 2:
                jogador = opArq.sortearPokemon();
                break;
            default:
                System.out.println("Opção invalida.");
                menuNovoJogo();
                break;
        }
        //Salvar nome do jogo
        System.out.println("Digite o nome do seu jogo para salvar: "); 
        progressoSalvo = scanner.nextLine();

        iniciarBatalha(jogador);
    }

    public void menuCarregarJogo() {
        File arquivoJogo = new File(LogBatalha);
            String menu3 = "+------------------------+------------+\n" +
               "| 01. Exibir Jogos Salvos | 02. Retornar |\n" +
               "+------------------------+------------+\n";

            System.out.println(menu3);


        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
            if (arquivoJogo.exists()) {
                if (arquivoJogo.exists()) {
                    try (Scanner leitor = new Scanner(arquivoJogo)) {
                        Map<String, String> jogosSalvos = new LinkedHashMap<>();
                        while (leitor.hasNextLine()) {
                            String linha = leitor.nextLine();
                            String[] partes = linha.split(":");
                            if (partes.length > 1) {
                                jogosSalvos.put(partes[0], linha); // Sobrescreve entradas com o mesmo nome
                            }
                        }
                        System.out.println("Jogos Salvos:");
                        List<String> nomesJogos = new ArrayList<>(jogosSalvos.keySet());
                        for (int i = 0; i < nomesJogos.size(); i++) {
                            System.out.println(i + ": " + nomesJogos.get(i));
                        }
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Digite o número do jogo salvo que deseja carregar:");
                        int escolha = scanner.nextInt();
                        scanner.nextLine();
        
                        if (escolha >= 0 && escolha < nomesJogos.size()) {
                            String nomeEscolhido = nomesJogos.get(escolha);
                            String linhaSelecionada = jogosSalvos.get(nomeEscolhido);
                            System.out.println("Carregando jogo: " + linhaSelecionada);
                            // Aqui você pode adicionar a lógica para carregar o jogo salvo com base na linha selecionada
                        } else {
                            System.out.println("Escolha inválida.");
                            menuCarregarJogo();
                        }
                } catch (IOException e) {
                    System.out.println("Erro ao abrir o arquivo de jogo salvo.");
                }
            } else {
                System.out.println("Nenhum jogo salvo encontrado.");
                exibirMenuInicial();
            }
                break;
        }
            case 2:
                exibirMenuInicial();
                break;
            default:
                System.out.println("Opção inválida.");
                menuCarregarJogo();
                break;
        }
    }

    public void exibirTelaPrincipal(Pokemon jogador) {
            String menu4 = "+--------------------+--------------------+---------+\n" +
               "| 01. Nova Batalha   | 02. Curar Pokémon  | 03. Sair |\n" +
               "+--------------------+--------------------+---------+\n";

            System.out.println(menu4);


        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                iniciarBatalha(jogador);
                break;
            case 2:
                curarPokemon(jogador);
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                exibirTelaPrincipal(jogador);
                break;
        }

    }

    public void exibirTelaPrincipalofCura(Pokemon jogador) {
            String menu5 = "+-------------------+---------+\n" +
               "| 01. Nova Batalha  | 02. Sair |\n" +
               "+-------------------+---------+\n";

            System.out.println(menu5);


        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                iniciarBatalha(jogador);
                break;
            case 2:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                exibirTelaPrincipalofCura(jogador);
                break;
        }

    }

    public void iniciarBatalha(Pokemon jogador) {

        String vencedor;
        Pokemon computador = null;
        computador = opArq.sortearPokemon();
        
        while ((jogador.getSaude() > 0) && (computador.getSaude() > 0)) {

        String mensagemBatalha = "+-------------------------------------------+\n" +
                         "| Começando a " + (contadorVitoria + 1) + "º batalha! |\n" +
                         "+-------------------------------------------+\n";
        System.out.println(mensagemBatalha);

        System.out.println(jogador.getNome()+" |Vida: "+jogador.getSaude()+" | X | Vida: "+computador.getSaude()+"| " + computador.getNome()) ;

        String ataques = "+---------------------+---------------------+\n" +
                 "| 1: " + jogador.getAtaqueUm() + " | 2: " + jogador.getAtaqueDois() + " |\n" +
                 "+---------------------+---------------------+\n" +
                 "| 3: " + jogador.getAtaqueTres() + " | 4: Defender         |\n" +
                 "+---------------------+---------------------+\n";
        System.out.println("\nAtaques\n" + ataques);

        System.out.println("Escolha uma opção: ");


            Scanner opcao = new Scanner(System.in);
            int ataqueEscolhido = opcao.nextInt();

            jogador.atacar(ataqueEscolhido, computador);
            if (computador.getSaude() <= 0) {
                computador.setSaude(0);
                System.out.println("Vida do pokemon adversário: " + computador.getSaude());
                break;
            }

            System.out.println("Vida do pokemon adversário: " + computador.getSaude());

            int min = 1;
            int max = 3;
            int opcaoComp = rand.nextInt(max - min) + min;

            System.out.println("Vez do pokemon adversário");
            computador.atacar(opcaoComp, jogador);

            if (jogador.getSaude() <= 0) {
                jogador.setSaude(0);
            }

            System.out.println("\nVocê foi atacado\nVida do seu pokemon: " + jogador.getSaude());

        }

        if (jogador.getSaude() > 0) {
            System.out.println("Você Venceu!!!\nVida do seu pokemon: " + jogador.getSaude());
            vencedor = jogador.getNome();
            contadorVitoria++;
        } else {
            System.out.println("Você perdeu!\nTotal de vitórias: " + contadorVitoria + "\nFIM JOGO");
            vencedor = computador.getNome();
        }
        try (BufferedWriter saida = new BufferedWriter(new FileWriter(LogBatalha, true));) {
            saida.write( progressoSalvo +": Pokemon jogador: " + jogador.getNome() + ", Pokemon computador: " + computador.getNome()
                    + ", Vencedor: " + vencedor + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao guardar histórico da batalha no arquivo");
        }

        if (vencedor == jogador.getNome()) {
            exibirTelaPrincipal(jogador);
        }
        // Fazero "log" com o nome do pokemon do jogador, nome do pokemon do computador
        // e vencedor da batalha
    }

    public void curarPokemon(Pokemon jogador) {

        jogador.curar(jogador);

        System.out.println("quu..__");
        System.out.println(" $$$b  `---.__                                 ");
        System.out.println("  \"$b        `--.                          ___.---uuudP              ");
        System.out.println("   `$$b           `.__.------.__     __.---'      $$$$\"              .");
        System.out.println("     \"$b          -'            `-.-'            $$$\"              .'");
        System.out.println("       \".                                       d$\"             _.'  |");
        System.out.println("         `.   /                              ...\"             .'     |");
        System.out.println("           `./                           ..::-'            _.'       |");
        System.out.println("            /                         .:::-'            .-'         .'");
        System.out.println("           :                          ::''\\          _.'            | ");
        System.out.println("          .' .-.             .-.           `.      .'               | ");
        System.out.println("          : /'$$|           .@\"$\\           `.   .'              _.-' ");
        System.out.println("         .'|$u$$|          |$$,$$|           |  <            _.-'     ");
        System.out.println("         | `:$$:'          :$$$$$:           `.  `.       .-'         ");
        System.out.println("         :                  `\"--'             |    `-.     \\          ");
        System.out.println("        :##.       ==             .###.       `.      `.    `\\        ");
        System.out.println("        |##:                      :###:        |        >     >       ");
        System.out.println("        |#'     `..'`..'          `###'        x:      /     /        ");
        System.out.println("         \\                                   xXX|     /    ./         ");
        System.out.println("          \\                                xXXX'|    /   ./           ");
        System.out.println("          /`-.                                  `.  /   /             ");
        System.out.println("         :    `-  ...........,                   | /  .'              ");
        System.out.println("         |         ``:::::::'       .            |<    `.             ");
        System.out.println("         |             ```          |           x| \\ `.:``.           ");
        System.out.println("         |                         .'    /'   xXX|  `:`M`M':.         ");
        System.out.println("         |    |                    ;    /:' xXXX'|  -'MMMMM:'         ");
        System.out.println("         `.  .'                   :    /:'       |-'MMMM.-'           ");
        System.out.println("          |  |                   .'   /'        .'MMM.-'              ");
        System.out.println("          `'`'                   :  ,'          |MMM<                 ");
        System.out.println("            |                     `'            |tbap\\                ");
        System.out.println("             \\                                  :MM.-'                ");
        System.out.println("              \\                 |              .''                    ");
        System.out.println("               \\.               `.            /                       ");
        System.out.println("                /     .:::::::.. :           /                        ");
        System.out.println("               |     .:::::::::::`.         /                         ");
        System.out.println("               |   .:::------------\\       /                          ");
        System.out.println("              /   .''               >::'  /                           ");
        System.out.println("              `',:                 :    .'                            ");
        System.out.println("                                   `:.:'                               ");
        System.out.println();
        System.out.println("Parabéns! " + jogador.getNome() + " foi curado.");
        System.out.println("Vida atual: " + jogador.getSaude());
        exibirTelaPrincipalofCura(jogador);
    }

}
