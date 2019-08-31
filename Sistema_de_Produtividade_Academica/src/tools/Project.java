package tools;

import dataobjects.Researcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Project {
    private String title; // Armazena o título do projeto
    private Date dataStartProject; // Armazenam a data de início do projeto
    private Date dataEndProject; // Armazenam a data de término do projeto
    private String fundingAgency; // Armazena o nome da agência
    private double fundingValue; // Armazena o valor que foi financiado nos
    private String objective; // Armazena o objetivo do projeto
    private String description; // Armazena a descrição do projeto
    private Researcher guidness; // Armazena o professor orientador do projeto
    private ArrayList<Researcher> participants = new ArrayList<Researcher>(); // Participantes do projeto

    private String status; // Armazena o status atual do projeto
    private ArrayList<Publication> publicacoes = new ArrayList<Publication>(); // Armazena as publicaões

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String titleIn) {
        this.title = titleIn;
    }

    public String getFundingAgency() {
        return this.fundingAgency;
    }

    public void setFundingAgency(String fundingAgencyIn) {
        this.fundingAgency = fundingAgencyIn;
    }

    public double getFundingValue() {
        return this.fundingValue;
    }

    public void setFundingValue(double fundingValueIn) {
        this.fundingValue = fundingValueIn;
    }

    public String getObjective() {
        return this.objective;
    }

    public void setObjective(String objectiveIn) {
        this.objective = objectiveIn;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String descriptionIn) {
        this.description = descriptionIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataStartProject(Date dataStartProjectIn) {
        this.dataStartProject = dataStartProjectIn;
    }

    public Date getDataStartProject() {
        return this.dataStartProject;
    }

    public void setDataEndProject(Date dataEndProjectIn) {
        this.dataEndProject = dataEndProjectIn;
    }

    public Date getDataEndProject() {
        return this.dataEndProject;
    }

    public void addResearcher(Researcher researcherIn) {
        this.participants.add(researcherIn);
    }

    public boolean isResearcherAdd(Researcher researcherIn) {
        return this.participants.contains(researcherIn);
    }

    public boolean addProject(ArrayList<Researcher> researchers) {
        Scanner input = new Scanner(System.in);
        if (researchers.isEmpty() || !isRegisteredTeacher(researchers))
        {
            System.out.println("\nÉ necessário existirem colaboradores cadastrados para a criação do projeto!");
            return false;
        } else {
            boolean valid = false;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            System.out.println("\nDigite o título do projeto:");
            this.setTitle(input.nextLine());
            System.out.println("\nDigite o nome da agência financiadora:");
            this.setFundingAgency(input.nextLine());
            System.out.println("\nDigite o valor financiado no projeto (Ex: 50000,00):");
            do {
                try {
                    this.setFundingValue(input.nextDouble());
                    valid = true;
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("\nValor inválido! Tente novamente...");
                }
            } while (!valid);
            valid = false;
            System.out.println("\nQual o objetivo do projeto?");
            this.setObjective(input.nextLine());
            System.out.println("\nDescreva o projeto de pesquisa:");
            this.setDescription(input.nextLine());
            System.out.println("\nDigite a data de início do projeto (dd/mm/yyyy):");
            do {
                try {
                    Date data = formato.parse(input.nextLine());
                    this.setDataStartProject(data);
                    valid = true;
                } catch (ParseException e) {
                    System.err.println("Data inválida, tente novamente!");
                }
            } while (!valid);
            valid = false;
            System.out.println("\nDigite a data de término do projeto (dd/mm/yyyy):");
            do {
                try {
                    Date data = formato.parse(input.nextLine());
                    if (data.after(this.dataStartProject)) {
                        this.setDataEndProject(data);
                        valid = true;
                    } else
                        System.out.println("\nData anterior à data de início!");
                } catch (ParseException e) {
                    System.err.println("\nData inválida, tente novamente!");
                }
            } while (!valid);
            valid = false;
            do {
                System.out.println("\nEscolha um professor para orientar o projeto:\n");
                Main.printTeacher(researchers);
                try{
                    int choice = input.nextInt();
                    if (researchers.get(choice).isTeacher() == true) {
                        this.guidness = researchers.get(choice);
                        researchers.get(choice).connectProject(this);
                        this.setStatus("Em Elaboração");
                        System.out.println("\nProjeto cadastrado com sucesso!");
                        valid = true;
                    } else
                        System.out.println("\nEste pesquisador não é um professor!");
                } catch (InputMismatchException e) {
                    System.err.println("\nFormato de entrada não é um número inteiro!");
                    input.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("\nPosição do Array Inexistente!");
                }
            } while (valid == false);
            return true;
        }

    }

    public void changeStatusProject() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nO status atual do projeto é "
                + this.getStatus() +
                ". Deseja alterar?" +
                "\n1 - Sim\n2 - Não");
        try {
            int choice = input.nextInt();

            if (choice == 1)
            {
                if (this.getStatus().equals("Em Elaboração")) {
                    if (this.participants.isEmpty())
                        System.out.println("\nProjeto não possui participantes ainda!");
                    else {
                        this.setStatus("Em Andamento");
                        System.out.println("\nStatus alterado de 'Em Elaboração' para 'Em Andamento'");
                    }
                } else if (this.getStatus().equals("Em Andamento")) {
                    if (this.publicacoes.isEmpty())
                        System.out.println(
                                "\nO status desse projeto não pode ser alterado para concluído pois não possui publicações associadas!");
                    else {
                        this.setStatus("Concluído");
                        System.out.println("\nStatus alterado de 'Em Andamento' para 'Concluído'!");
                    }
                } else
                    System.out.println("\nProjeto já foi concluído!");
            }
        } catch (InputMismatchException e) {
            System.err.println("\nFormato de entrada não é um número inteiro!");
            input.nextLine();
        }
    }

    public static boolean isRegisteredTeacher(ArrayList<Researcher> participant) {
        boolean is = false;
        for (Researcher pesq : participant) {
            if (pesq.isTeacher())
                is = true;
        }
        return is;
    }

    void projectInfo() {

    }

    @Override
    public int compare2Projects(Project projects) {

    }
}
