package sgpaeh;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Laboratory
{
    private ArrayList<Project> projects = new ArrayList<Project>();
    private ArrayList<Researcher> researchers = new ArrayList<Researcher>();
    private ArrayList<Publication> publications = new ArrayList<Publication>();

    public void addCollaborator()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEscolha o tipo de colaborador que deseja adicionar ao sistema\n");
        System.out.println("1 - Pesquisador\n" +
                "2 - Graduando\n" +
                "3 - Mestrando\n" +
                "4 - Doutorando\n" +
                "5 - Professor\n");

        try {
            int choice = input.nextInt();
            input.nextLine();
            Researcher newElement = null;

            if(choice == 1)
            {
                newElement = new Researcher();
                System.out.println("Pesquisador alocado com sucesso!");
            }
            else if(choice == 2)
            {
                newElement = new GraduationStudent();
                System.out.println("Estudante de graduação alocado com sucesso!");
            }
            else if(choice == 3)
            {
                newElement = new MastersDegreeStudent();
                System.out.println("Estudante de mestrado alocado com sucesso!");
            }
            else if(choice == 4)
            {
                newElement = new PhdStudent();
                System.out.println("Estudante de doutorado alocado com sucesso!");
            }
            else if(choice == 5)
            {
                newElement = new Teacher();
                System.out.println("Professor alocado com sucesso!");
            }else {
                System.out.println("\nOpção inválida! Voltando ao menu inicial...\n");
            }

            if (newElement != null) {
                newElement.addResearcher();
                researchers.add(newElement);
            }
        } catch (InputMismatchException e) {
            System.err.println("\nERRO! A entrada não é um número inteiro!");
            input.nextLine();
        }
    }

    public void addProject() {
        Project newProject = new Project();
        boolean valid = newProject.addProject(researchers);
        if (valid)
            projects.add(newProject);
    }

    public void putCollaboratorProject()
    {
        Scanner input = new Scanner(System.in);
        if (!isProjectsEmpty() && !isResearcherEmpty())
        {
            System.out.println("\nEscolha o projeto no qual o colaborador será associado:");
            Main.printProjects(projects);
            try {
                int choice = input.nextInt();
                Project chosenProject = projects.get(choice);
                if (chosenProject.getStatus().equals("Em Elaboração"))
                {
                    System.out.println("\nEscolha o colaborador a ser associado:");
                    Main.printParticipants(researchers);
                    choice = input.nextInt();
                    if (!chosenProject.isResearcherAdd(researchers.get(choice)) && !researchers.get(choice).isMaxProjects())
                    {
                        chosenProject.addResearcher(researchers.get(choice));
                        researchers.get(choice).connectProject(chosenProject);
                        System.out.println("\nColaborador associado ao projeto com sucesso!");
                    } else {
                        System.out.println("\nEste pesquisador já faz parte do projeto!");
                    }
                } else {
                    System.out.println("\nEste projeto não pode mais receber colaboradores!");
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println("\nERRO! A posição do array não existe!");
            } catch (InputMismatchException e) {
                System.err.println("ERRO! Entrada não é um número inteiro!");
                input.nextLine();
            }
        } else {
            System.out.println("\nNão existem projetos e/ou colaboradores cadastrados!");
        }
    }

    public void changeStatusLab()
    {
        Scanner input = new Scanner(System.in);
        if (!isProjectsEmpty())
        {
            System.out.println("\nEscolha o projeto ao qual deseja alterar o status:");
            Main.printProjects(projects);
            try {
                int chosen = input.nextInt();
                Project escolhido = projects.get(chosen);
                escolhido.changeStatusProject();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("\nERRO! ERRO! A posição do array não existe!");
            } catch (InputMismatchException e) {
                System.err.println("ERRO! Entrada não é um número inteiro!");
                input.nextLine();
            }
        } else {
            System.out.println("\nNão existem projetos cadastrados!");
        }
    }

    public void includeInfoProjects()
    {
        Scanner input = new Scanner(System.in);

        if (!isProjectsEmpty())
        {
            System.out.println("\nEscolha o projeto no qual deseja incluir informações:");
            Main.printProjects(projects);
            try {
                int chosen = input.nextInt();
                input.nextLine();
                Project chosenProject = projects.get(chosen);
                if (chosenProject.getStatus().equals("Em Andamento"))
                    chosenProject.incluirPublicacoes(publications);
                else
                    System.out.println("\nEste projeto não pode receber novas publicações no momento!");
            } catch (IndexOutOfBoundsException e) {
                System.err.println("\nERRO! ERRO! A posição do array não existe!");
            } catch (InputMismatchException e) {
                System.err.println("\nERRO! Entrada não é um número inteiro!");
                input.nextLine();
            }
        } else {
            System.out.println("\nNão existem colaboradores cadastrados!");
        }
    }

    public void inquiryCollaborator()
    {
        Scanner input = new Scanner(System.in);

        if (!isResearcherEmpty())
        {
            System.out.println("\nEscolha o colaborador ao qual deseja consultar:");
            Main.printParticipants(researchers);
            try {
                int chosen = input.nextInt();
                input.nextLine();
                Researcher chosenResearcher = researchers.get(chosen);
                chosenResearcher.collaborator();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("\nERRO! A posição do array não existe!");
            } catch (InputMismatchException e) {
                System.err.println("\nERRO! Entrada não é um número inteiro!");
                input.nextLine();
            }
        } else {
            System.out.println("\nNão existem colaboradores cadastrados!");
        }
    }

    public void inquiryProject()
    {
        Scanner input = new Scanner(System.in);
        if (!isProjectsEmpty())
        {
            System.out.println("\nEscolha o projeto ao qual deseja consultar:");
            Main.printProjects(projects);
            try {
                int chosen = input.nextInt();
                input.nextLine();
                Project chosenProject = projects.get(chosen);
                chosenProject.projectInfo();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("\nERRO! A posição do array não existe!");
            } catch (InputMismatchException e) {
                System.err.println("\nERRO! Entrada não é um número inteiro!");
                input.nextLine();
            }
        } else {
            System.out.println("\nNão existem projetos cadastrados!");
        }
    }

    public void reportLab()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Número de colaboradores cadastrados: " + researchers.size());
        System.out.println("Total de projetos cadastrados: " + projects.size());
        int progress = 0, elaboration = 0, completed = 0;
        for (Project projectCount : projects)
        {
            if (projectCount.getStatus().equals("Em Andamento"))
            {
                progress++;
            }
            else if (projectCount.getStatus().equals("Em Elaboração"))
                elaboration++;
            else
                completed++;
        }
        System.out.println("Projetos em elaboração: " + elaboration);
        System.out.println("Projetos em andamento: " + progress);
        System.out.println("Projetos concluídos: " + completed);
        System.out.println("Número de publicações cadastradas: " + publications.size());
    }

    public boolean isProjectsEmpty() {
        return this.projects.isEmpty();
    }

    public boolean isResearcherEmpty() {
        return this.researchers.isEmpty();
    }
}
