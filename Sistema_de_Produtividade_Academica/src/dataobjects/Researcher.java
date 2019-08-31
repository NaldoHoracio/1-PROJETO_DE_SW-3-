package dataobjects;

import tools.Project;
import tools.Publication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Researcher {
    private String name;
    private String email;
    private ArrayList<Project> projects = new ArrayList<Project>();// Armazena os projetos
    private ArrayList<Publication> publications = new ArrayList<Publication>();// Armazena as publicações

    public void setNome(String nameReasearcher) {
        this.name = nameReasearcher;
    }

    public String getNome() {
        return this.name;
    }

    public void setEmail(String emailResearcher) {
        this.email = emailResearcher;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean isTeacher(){
        return false;
    }

    // Método abstrado
    public boolean isMaxProjects()
    {
        return false;
    }

    public int numberOfProjects() {
        return this.projects.size();
    }

    public void addResearcher() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do pesquisador:");
        this.setNome(input.nextLine());
        System.out.println("Digite o email do pesquisador:");
        this.setEmail(input.nextLine());
        System.out.println("Pesquisador cadastrado com sucesso!\n");
    }

    // Associar projeto
    public void connectProject(Project project) {
        this.projects.add(project);
    }

    // Associar publicação
    public void connectPublication(Publication publication) {
        this.publications.add(publication);
    }

    public void collaborator() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        System.out.println("Nome do colaborador: " + this.name);
        System.out.println("Email do colaborador: " + this.email);
        System.out.println("Projetos do colaborador: ");
        Collections.sort(this.projects);

        System.out.println("  Concluídos: ");
        for(Project projectCon : this.projects) {
            if(projectCon.getStatus().equals("Concluído"))
                System.out.println("	Título: "  + projectCon.getTitle());
            System.out.println("	  Status atual: " + projectCon.getStatus());
            System.out.println("	  Data de início: " + dateFormat.format(projectCon.getDataStartProject()));
            System.out.println("	  Data de término: " + dateFormat.format(projectCon.getDataEndProject()));
        }

        System.out.println("  Em andamento: ");
        for(Project projectsCont : this.projects) {
            if(projectsCont.getStatus().equals("Em Andamento"))
                System.out.println("	Título: "  + projectsCont.getTitle());
            System.out.println("	  Status atual: " + projectsCont.getStatus());
            System.out.println("	  Data de início: " + dateFormat.format(projectsCont.getDataStartProject()));
            System.out.println("	  Data de término: " + dateFormat.format(projectsCont.getDataEndProject()));
        }
        System.out.println("Publicações na qual o colaborador foi autor: ");
        Collections.sort(this.publications);
        for(Publication publicationCont : this.publications) {
            System.out.println("	Título: "  + publicationCont.getTitle());
            System.out.println("	  Ano de publicação: " + publicationCont.getYearPublicationConference());
            System.out.println("	  Conferência: " + publicationCont.getConference());
        }
    }
}
