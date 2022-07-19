Analisador Sinático- Linguagem LA

O projeto foi desenvolvido utilizando as mesmas ferramentas apresentadas pelo professor em suas videos-aulas (Java + Maven)
O sistema operacional utilizado foi o Windows 10
A versão do ANTLR utilizada foi a 4.7.2, e a instalação foi feita pelo Maven, seguindo as instruções contidas em:
https://github.com/dlucredio/cursocompiladores/blob/master/exemplosCodigo/Compiladores.T%C3%B3pico02.An%C3%A1lise%20L%C3%A9xica.roteiro.md


---- Compilação ----

Para compilar o projeto, utilize o Apache NetBeans IDE 11.2 ou superior.
É necessário que durante a instalação do NetBeans selecione a opção de instalar o plugin do Apache Maven
Agora basta abrir o projeto e apertar F11 (Build Project) ou clicar com o botão direito no ícone do projeto (la-sintatico) e selecionar a opção build

---- Execução ----

Para executar o programa, basta utilizar o Prompt de Comando do Windows na pasta target do projeto e executar o seguinte comando:

java -jar la-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar programa.txt saida.txt

programa.txt é o arquivo que contém o programa escrito na linguagem LA
