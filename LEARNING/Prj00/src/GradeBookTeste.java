import java.util.Scanner; //Incluindo o método Scanner

public class GradeBookTeste
{
    public static void main(String[] args)
    {
        // Cria Scanner para obter entrada a partir da janela de comando
        Scanner input = new Scanner(System.in);

        // Cria um objeto GradeBook e o atribui a myGradeBook
        GradeBook myGradeBook = new GradeBook();

        // prompt para entrada do nome do curso
        System.out.println("Please enter the course name:\n");
        String nameOfCourse = input.nextLine();// Lê uma linha de texto
        System.out.println();// Gera a saida de uma linha em branco

        myGradeBook.displayMessage(nameOfCourse);// Passa nameOfCourse como argumento
    }// fim de main
}// Fim da classe GradeBookTeste
