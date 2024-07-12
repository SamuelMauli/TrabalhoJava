# TrabalhoJava

Projeto Pokemon Battle Descrição Este projeto foi desenvolvido pelos alunos Luiz Athar, Luiz Gabriel, Pedro e Samuel. O objetivo é criar um jogo de batalha de Pokémons utilizando a linguagem de programação Java. O projeto inclui funcionalidades como listar, escolher e sortear Pokémons, além de permitir batalhas entre os Pokémons selecionados.

Estrutura do Projeto O projeto está organizado em diferentes classes e pacotes para manter a modularidade e facilitar a manutenção do código.

Pacote Tipos Contém todas as classes relacionadas aos diferentes tipos de Pokémon e suas características:

Enum Tipo: Define todos os tipos de Pokémon e as relações de ataque crítico e dano crítico entre os tipos. Classe Pokemon: Classe abstrata que define a estrutura básica de um Pokémon, incluindo atributos como código, nome, saúde, tipo e ataques. Subclasses de Pokemon: Cada tipo específico de Pokémon herda da classe Pokemon. Classe Main A classe principal que inicia o jogo e exibe o menu inicial para o usuário.

Classe OperacoesPokemons Contém métodos para manipular a lista de Pokémons, como preencher a lista a partir de um arquivo, mostrar Pokémons por tipo, listar todos os Pokémons, sortear um Pokémon e escolher um Pokémon por ID.

Classe Interface Responsável pela interação com o usuário, exibindo menus e processando as escolhas do usuário. Inclui métodos para iniciar o jogo, exibir menus, iniciar batalhas e curar Pokémons.

Funcionalidades Listar todos os Pokémons: Exibe todos os Pokémons disponíveis na lista. Escolher Pokémon por Tipo: Permite ao usuário escolher um Pokémon baseado no tipo. Sortear Pokémon: Sorteia um Pokémon aleatoriamente para o usuário. Iniciar Batalha: Inicia uma batalha entre o Pokémon do jogador e um Pokémon sorteado. Curar Pokémon: Cura o Pokémon do jogador, restaurando sua saúde.

Exemplos de Uso Ao iniciar o jogo, o usuário verá um menu com as seguintes opções:

Novo Jogo: Permite iniciar um novo jogo. Carregar Jogo: Carrega um jogo salvo anteriormente (atualmente não implementado). No menu de novo jogo, o usuário pode escolher um Pokémon manualmente ou optar por um sorteio aleatório. Após selecionar o Pokémon, o usuário pode iniciar uma batalha, curar o Pokémon ou sair do jogo.

Projeto Pokemon Battle Descrição Este projeto foi desenvolvido pelos alunos Luiz, Luiz Gabriel, Pedro e Samuel. O objetivo é criar um jogo de batalha de Pokémons utilizando a linguagem de programação Java. O projeto inclui funcionalidades como listar, escolher e sortear Pokémons, além de permitir batalhas entre os Pokémons selecionados.

Estrutura do Projeto O projeto está organizado em diferentes classes e pacotes para manter a modularidade e facilitar a manutenção do código.

Pacote Tipos Contém todas as classes relacionadas aos diferentes tipos de Pokémon e suas características:

Enum Tipo: Define todos os tipos de Pokémon e as relações de ataque crítico e dano crítico entre os tipos. Classe Pokemon: Classe abstrata que define a estrutura básica de um Pokémon, incluindo atributos como código, nome, saúde, tipo e ataques. Subclasses de Pokemon: Cada tipo específico de Pokémon herda da classe Pokemon. Classe Main A classe principal que inicia o jogo e exibe o menu inicial para o usuário.

Classe OperacoesPokemons Contém métodos para manipular a lista de Pokémons, como preencher a lista a partir de um arquivo, mostrar Pokémons por tipo, listar todos os Pokémons, sortear um Pokémon e escolher um Pokémon por ID.

Classe Interface Responsável pela interação com o usuário, exibindo menus e processando as escolhas do usuário. Inclui métodos para iniciar o jogo, exibir menus, iniciar batalhas e curar Pokémons.

Funcionalidades Listar todos os Pokémons: Exibe todos os Pokémons disponíveis na lista. Escolher Pokémon por Tipo: Permite ao usuário escolher um Pokémon baseado no tipo. Sortear Pokémon: Sorteia um Pokémon aleatoriamente para o usuário. Iniciar Batalha: Inicia uma batalha entre o Pokémon do jogador e um Pokémon sorteado. Curar Pokémon: Cura o Pokémon do jogador, restaurando sua saúde. Como Executar Compilar o Projeto: Compile todas as classes Java utilizando um compilador Java. Executar o Jogo: Execute a classe Main para iniciar o jogo. bash Copiar código javac Main.java java Main Estrutura dos Arquivos pokemons.txt: Arquivo de texto contendo informações dos Pokémons. Cada linha do arquivo deve seguir o formato: bash Copiar código id, nome, saude, tipo batalha.txt: Arquivo utilizado para salvar o estado das batalhas. Exemplos de Uso Ao iniciar o jogo, o usuário verá um menu com as seguintes opções:

Novo Jogo: Permite iniciar um novo jogo. Carregar Jogo: Carrega um jogo salvo anteriormente (atualmente não implementado). No menu de novo jogo, o usuário pode escolher um Pokémon manualmente ou optar por um sorteio aleatório. Após selecionar o Pokémon, o usuário pode iniciar uma batalha, curar o Pokémon ou sair do jogo.

Autores Luiz Athar Luiz Gabriel Pedro Samuel
