# Manipulação de JSON
*by Aline Assunção `[Jornada Tech]`*

## Capítulo 2 - Java + JSON + Testes Unitários

**ManipulaJson** é uma biblioteca criada para a manipulação e gerenciamento de dados no formato JSON. Este projeto visa facilitar operações comuns em arquivos JSON por meio de funcionalidades que abrangem:

- **CRUD:** Criação, leitura, atualização e deleção de registros.
- **Comparação:** Verificação de diferenças e semelhanças entre diferentes estruturas ou versões de JSON.
- **Busca:** Localização rápida de informações específicas dentro dos dados, seja por chave ou por valor.

## Funcionalidades

- **Criar:** Permite a inserção de novos registros ou itens em arquivos JSON.
- **Ler:** Oferece métodos para extrair e visualizar todo o conteúdo ou dados específicos de um JSON.
- **Atualizar:** Permite alterar valores ou estruturas existentes, facilitando a manutenção e evolução dos dados.
- **Deletar:** Inclui a funcionalidade para remover registros indesejados ou obsoletos do arquivo JSON.
- **Comparação de JSONs:** Facilita a identificação de diferenças entre duas versões de um arquivo JSON ou entre duas estruturas, auxiliando na verificação de alterações ou na sincronização de dados.
- **Busca por Chave/Valor:** Oferece métodos para localizar elementos dentro do JSON com base em chaves ou valores específicos, tornando a filtragem de informações mais eficiente em grandes volumes de dados.

## Instalação

### Pré-requisitos

- **Java JDK 8 ou superior**
- **Maven** (caso o projeto use dependências gerenciadas)
- **IDE para Java** (como Eclipse, IntelliJ IDEA ou VS Code com extensões para Java)

### Passos de Instalação

1. Clone o repositório:
   ```
   git clone https://github.com/alineAssuncao/manipulaJson.git
   cd manipulaSQL
   ```
2. Compile o projeto:
   ```
   javac -d bin src/*.java
   ```
3. Execute o programa:
   ```
   java -cp bin main
   ```

## Uso

### Exemplo de Integração
Abaixo, um exemplo de como usar a biblioteca para manipulação de JSON:
```
import com.alineAssuncao.manipulaJson.ManipuladorJson;

public class ExemploUso {
    public static void main(String[] args) {
        ManipuladorJson manipulador = new ManipuladorJson();

        // Leitura de arquivo JSON
        String dados = manipulador.ler("dados.json");

        // Criação de novo registro
        String novoRegistro = "{ \"id\": 1, \"nome\": \"Exemplo\", \"valor\": 100 }";
        dados = manipulador.criar(dados, novoRegistro);

        // Atualização de registro existente
        String registroAtualizado = "{ \"id\": 1, \"nome\": \"Exemplo Atualizado\", \"valor\": 150 }";
        dados = manipulador.atualizar(dados, registroAtualizado);

        // Exclusão de registro
        dados = manipulador.deletar(dados, "id", 1);

        // Busca de registro
        String resultadoBusca = manipulador.buscar(dados, "nome", "Exemplo Atualizado");
        System.out.println("Resultado da busca: " + resultadoBusca);

        // Comparação entre dois JSONs
        String dadosAntigos = manipulador.ler("dados_anterior.json");
        String diferencas = manipulador.comparar(dadosAntigos, dados);
        System.out.println("Diferenças encontradas: " + diferencas);
    }
}
```

Nota: Adapte os nomes das classes, métodos e pacotes conforme a estrutura real do projeto.

## Estrutura do Projeto

O projeto segue uma estrutura modular e organizada, facilitando a manutenção e escalabilidade. Abaixo está uma visão geral dos diretórios e arquivos principais:
```
manipulaJson/
│
├── src/
│   ├── CampoComposto.java       # Classe complementar para criar um campo composto por outro JSON
│   ├── CompareJson.java         # Implementa a leitura e comparação de 2 JSONs diferentes (fileOrig.json e fileNew.json)
│   ├── DadosJson.java           # implementa os Construtores, Getters e Setters do JSOn
│   ├── JsonManipulation.java    # Implementa as operações CRUD
│   ├── SliceJson.java           # Implementa a busca de um JSON dentro de um array de JSON, com tratamento de erro caso seja um objeto (arrayJson.json)
│   └── Main.java                # Ponto de entrada para testes
│
├── resources/
│   ├── arrayJson.json           # Arquivo com array de Json utilizado para os testes de busca de JSON
│   ├── fileNew.json             # Arquivo utilizado nos testes de comparação de JSONs
│   ├── fileOrig.json            # Arquivo utilizado nos testes de comparação de JSONs
│   ├── temp.json                # Arquivo utilizado para CRUD da aplicação
│
├── README.md                    # Documentação do projeto
└── pom.xml                      # Configuração do Maven (se aplicável)
```


## Boas Práticas Utilizadas

O código é desenvolvido com base em padrões de qualidade e boas práticas de programação:

### 1. **Princípios SOLID**
   - **Responsabilidade única:** Cada classe e método realiza uma única tarefa bem definida.
   - **Aberto para extensão, fechado para modificação:** O design permite adicionar novas funcionalidades sem alterar o código existente.

### 2. **Segurança e Validação**
   - Validação de entrada para garantir que dados JSON são bem formados antes de realizar qualquer operação.
   - Tratamento adequado de exceções para evitar falhas inesperadas (ex.: `try-catch` em operações de E/S).

### 3. **Testes Unitários**
   - Cada funcionalidade é coberta por testes unitários robustos para garantir que o código está funcionando corretamente e detectar regressões.

### 4. **Documentação**
   - Comentários claros e concisos explicando a lógica do código e o propósito de cada método.

### 5. **Modularidade**
   - Estrutura modular para facilitar a reutilização e o entendimento do código.

### 6. **Compatibilidade**
   - Garantia de compatibilidade com múltiplas versões do Java, configurando corretamente o Maven (`pom.xml`) para gerenciar dependências.

## Contribuição
Contribuições são sempre bem-vindas! Para ajudar no desenvolvimento:
- Faça um fork deste repositório.
- Crie uma branch para as alterações:
  ```
  git checkout -b nova-melhoria
  ```
- Realize os commits com as modificações realizadas.
- Abra um Pull Request detalhando as melhorias.

## Licença
Este projeto está licenciado sob a MIT License.,

## Contato
Caso tenha dúvidas, sugestões ou identifique problemas, abra uma issue neste repositório ou entre em contato diretamente.





