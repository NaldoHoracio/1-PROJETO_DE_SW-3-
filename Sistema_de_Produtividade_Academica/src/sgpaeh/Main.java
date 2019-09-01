package sgpaeh;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Laboratory laboratory = new Laboratory();
        int option = -1;
        Scanner input = new Scanner(System.in);

        do {
            managementMenu();
            try{
                option = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.err.println("ERRO! Entrada não é um inteiro! " +
                        "Por favor, entre com um número inteiro.");
                input.nextLine();
            }

            if(option == 0)
            {
                System.out.println("Saindo do Sistema! " +
                        "Obrigado por utilizar o Sistema de Gerenciamento de Produtividade Acadêmica EH!");
            }
            else if(option == 1)
            {
                System.out.println("Cadastrar novo colaborador!");
                laboratory.addCollaborator();
            }
            else if(option == 2)
            {
                System.out.println("Adicionar novo projeto de pesquisa!");
                laboratory.addProject();
            }
            else if(option == 3)
            {
                System.out.println("Alterar status de um projeto de pesquisa!");
                laboratory.changeStatusLab();
            }
            else if(option == 4)
            {
                System.out.println("Incluir informações sobre a produção acadêmica (publicações e/ou orientações)!");
                laboratory.includeInfoProjects();
            }
            else if (option == 5)
            {
                System.out.println("Consultar colaborador!");
                laboratory.inquiryCollaborator();
            }
            else if(option == 6)
            {
                System.out.println("Consultar projeto de pesquisa!");
                laboratory.inquiryProject();
            }
            else if(option == 7)
            {
                System.out.println("Relatório da produção acadêmica (publicações e/ou orientações)!");
                laboratory.reportLab();
            }
            else if(option == 8)
            {
                System.out.println("Alocar participante em um projeto de pesquisa!");
                laboratory.putCollaboratorProject();
            }else {
                System.out.println("Opção inválida! " +
                        "Tente novamente digitanto um inteiro correspondente a uma opção válida! [0-8]");
            }

        }while (option != 0);
        input.close();
    }

    public static void managementMenu()
    {
        System.out.println("\nBem-vindo ao Sistema de Gerenciamento de Produtividade Acadêmcia EH!\n");
        System.out.println("Escolha uma opção para usar o sistema [0-8]:\n");
        System.out.println("0 - Sair do Sistema!");
        System.out.println("1 - Cadastrar novo colaborador!");
        System.out.println("2 - Adicionar novo projeto de pesquisa!");
        System.out.println("3 - Alterar status de um projeto de pesquisa!");
        System.out.println("4 - Incluir informações sobre a produção acadêmica (publicações e/ou orientações)!");
        System.out.println("5 - Consultar colaborador!");
        System.out.println("6 - Consultar projeto de pesquisa!");
        System.out.println("7 - Relatório da produção acadêmcia (publicações e/ou orientações)!");
        System.out.println("8 - Alocar participante em um projeto de pesquisa!");
    }

    public static void printParticipants(ArrayList<Researcher> collaborator)
    {
        int i = 0;
        for(Researcher collaboratorCount : collaborator)
        {
            System.out.println("Índice: " + i + " --- " + collaboratorCount.getName() +
                    ": " + collaboratorCount.getEmail() + "(email)");
            i++;
        }
    }

    public static void printTeacher(ArrayList<Researcher> collaborator)
    {
        int i = 0;
        for(Researcher teacherCount : collaborator)
        {
            if(teacherCount.isTeacher())
            {
                System.out.println("Índice: " + i + " --- " + teacherCount.getName() +
                        ": " + teacherCount.getEmail() + "(email)");
            }
            i++;
        }
    }

    public static void printProjects(ArrayList<Project> projectsIn)
    {
        int i = 0;
        for(Project projectCount : projectsIn){
            System.out.println("Índice: " + i + " --- " + projectCount.getTitle() +
                    " --- " + projectCount.getStatus() + " --- " + projectCount.getDataStartProject());
            i++;
        }
    }
}
