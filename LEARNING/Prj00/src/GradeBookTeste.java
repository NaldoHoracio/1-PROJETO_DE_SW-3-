import java.awt.datatransfer.SystemFlavorMap;
import java.io.PrintStream;
import java.util.Scanner; //Incluindo o método Scanner

public class GradeBookTeste
{
    public static void main(String[] args)
    {
        // Cria Scanner para obter entrada a partir da janela de comando
        //Scanner input = new Scanner(System.in);
        GradeBook gradeBook1 = new GradeBook("Engenharia de Computação", "Tiago Cordeiro");
        GradeBook gradeBook2 = new GradeBook("Física", "Wagner Ferreira");

        // Exibe o valor inicial de courseName para cada GradeBook
        System.out.printf("gradeBook1 course name is %s\n", gradeBook1.getCourseName());
        System.out.printf("Instructor of course gradeBook1 is %s.\n", gradeBook1.getInstructorName());
        System.out.printf("gradeBook2 course name is %s\n", gradeBook2.getCourseName());
        System.out.printf("Instructor of course gradeBook1 is %s.\n",gradeBook2.getInstructorName());

    }// fim de main
}// Fim da classe GradeBookTeste
