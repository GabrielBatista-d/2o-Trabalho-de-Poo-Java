package atv2;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Atv2 {
/*permita ao usuário criar o arquivo com as respostas de todos os aluno de uma
disciplina. O nome do arquivo será o nome da disciplina. O usuário é livre para inserir
quantos alunos ele queira. O usuário pode criar mais de uma disciplina.
    
- permita ao usuário gerar o resultado de uma disciplina. Seu programa deve permitir ao
usuário escolher a disciplina e então informar a localização do arquivo contendo o
gabarito oficial da prova (apenas uma linha com as 10 respostas corretas) da disciplina
escolhida. Em seguida, deve produzir como resposta dois outros arquivos: um contendo
a lista dos alunos e seus respectivos pontos (número de acertos) ordenadas por ordem
alfabética, e outro contendo as mesmas informações, porém ordenado por ordem
decrescente de notas (quantidade de acertos) e mostrando ao final a média da turma.
Caso o aluno tenha marcado todas as questões com V ou F, o aluno receberá 0. Permita
ao usuário visualizar esses dados na tela.*/
    public static void main(String[] args){
        
        try{
            int sair = 0;
            while(sair == 0){
                Scanner digita = new Scanner(System.in);
                System.out.println("Digite o nome da disciplina: ");
                String disciplina = digita.nextLine();
                FileOutputStream   arquivo = new FileOutputStream(disciplina+".txt");
                PrintWriter        pr      = new PrintWriter(arquivo);
                
                int i = 0;
                int a = 1;
                String aluno;
                int totAlunos;
                int p = 0;
                Scanner gab = new Scanner(System.in);
                System.out.println("Crie o gabarito para a disciplina ("+disciplina+")");
                String Gabarito = gab.nextLine();
                    
                FileOutputStream gabarito = new FileOutputStream("Gabarito_da_disciplina_"+disciplina);
                PrintWriter      gr       = new PrintWriter(gabarito);
                    
                gr.println(Gabarito);
                
                gr.close();
                gabarito.close();
                
                System.out.println("Quantos alunos você deseja adicionar à disciplina ("+disciplina+") ?");
                totAlunos = digita.nextInt();
                
                while(i<totAlunos){
                    Scanner teclado = new Scanner(System.in);
                    System.out.println("Digite as respostas e o nome do "+a+"o aluno: ");
                    aluno = teclado.nextLine();
                    pr.println(aluno);
                    a++;
                    i++;
                }
            
                pr.close();
                arquivo.close();
                System.out.println("===============================");
                System.out.println("Deseja criar outra disciplina ?");
                System.out.println("Digite 0 para SIM: ");
                System.out.println("Digite 1 para NÃO: ");
                System.out.println("===============================");
                sair = digita.nextInt();
            }

        }
        catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo");
        }
    
    }
}
