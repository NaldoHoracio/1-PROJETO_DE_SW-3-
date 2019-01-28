
public class GradeBook
{
    private String courseName;// Nome do curso para esse GradeBooks
    private String instructorName;// Nome do instrutor para o curso

    // O contrutor inicializa courseName com o argumento String
    public GradeBook(String name, String name2)
    {
        courseName = name;// Inicializa courseName
        instructorName = name2;// Inicializa instructorName
    }

    // Método para armazenar o nome do curso
    public void setCourseName(String name, String name2)
    {
        courseName = name;// Guarda o nome do curso
        instructorName = name2;// Guarda o nome do instrutor
    }

    // Método para recuperar o nome do curso
    public String getCourseName()
    {
        return courseName;
    }// fim do método getCourseName

    // Método para recuperar o nome do instrutor do curso
    public String getInstructorName()
    {
        return instructorName;
    }

    // exibe uma mensagem de boas vindas para o usuário de GradeBook
    public void displayMessage()
    {
        // chama getCourseName para obter o nome do curso que esse GradeBook representa
        System.out.printf("Welcome to the GradeBook %s.\n", getCourseName());
        System.out.printf("The instructor is %s.\n", getInstructorName());
    }// fim do método displayMessage
}// Fim da classe GradeBook
