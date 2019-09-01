package sgpaeh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Project implements Comparable<Project>
{
    private String title; // Armazena o título do projeto
    private Date dataStartProject; // Armazenam a data de início do projeto
    private Date dataEndProject; // Armazenam a data de término do projeto
    private String fundingAgency; // Armazena o nome da agência
    private double fundingValue; // Armazena o valor que foi financiado nos
    private String objective; // Armazena o objetivo do projeto
    private String description; // Armazena a descrição do projeto
    private Researcher leader; // Armazena o professor orientador do projeto
    private ArrayList<Researcher> participants = new ArrayList<Researcher>(); // Participantes do projeto

    private String status; // Armazena o status atual do projeto
    private ArrayList<Publication> publications = new ArrayList<Publication>(); // Armazena as publicações

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String titleIn) {
        this.title = titleIn;
    }

    public void setFundingAgency(String fundingAgencyIn) {
        this.fundingAgency = fundingAgencyIn;
    }

    public void setFundingValue(double fundingValueIn) {
        this.fundingValue = fundingValueIn;
    }

    public void setObjective(String objectiveIn) {
        this.objective = objectiveIn;
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

    public boolean addProject(ArrayList<Researcher> researchers)
    {
        Scanner input = new Scanner(System.in);
        if (researchers.isEmpty() || !isRegisteredTeacher(researchers))
        {
            System.out.println("\nÉ necessário existirem colaboradores cadastrados para a criação do projeto!");
            return false;
        } else {
            boolean valid = false;
            SimpleDateFormat dataFormate = new SimpleDateFormat("dd/MM/yyyy");
            dataFormate.setLenient(false);
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
            System.out.println("\nDigite a data de início do projeto (DD/MM/YYYY):");
            do {
                try {
                    Date data = dataFormate.parse(input.nextLine());
                    this.setDataStartProject(data);
                    valid = true;
                } catch (ParseException e) {
                    System.err.println("Data inválida, tente novamente!");
                }
            } while (!valid);
            valid = false;
            System.out.println("\nDigite a data de término do projeto (DD/MM/YYYY):");
            do {
                try {
                    Date data = dataFormate.parse(input.nextLine());
                    if (data.after(this.dataStartProject)) {
                        this.setDataEndProject(data);
                        valid = true;
                    } else
                        System.out.println("\nData anterior à data de início!");
                } catch (ParseException e) {
                    System.err.println("\nERRO! Data inválida! Tente novamente!");
                }
            } while (!valid);
            valid = false;
            do {
                System.out.println("\nEscolha um professor para orientar o projeto:\n");
                Main.printTeacher(researchers);
                try{
                    int choice = input.nextInt();
                    if (researchers.get(choice).isTeacher() == true) {
                        this.leader = researchers.get(choice);
                        researchers.get(choice).connectProject(this);
                        this.setStatus("Em Elaboração");
                        System.out.println("\nProjeto cadastrado com sucesso!");
                        valid = true;
                    } else
                        System.out.println("\nEste pesquisador não é um professor!");
                } catch (InputMismatchException e) {
                    System.err.println("\nERRO! Formato de entrada não é um número inteiro!");
                    input.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("\nERRO! A posição do array não existe!");
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
                if (this.getStatus().equals("Em Elaboração"))
                {
                    if (this.participants.isEmpty())
                    {
                        System.out.println("\nProjeto não possui participantes ainda!");
                    }
                    else {
                        this.setStatus("Em Andamento");
                        System.out.println("\nStatus alterado de 'Em Elaboração' para 'Em Andamento'");
                    }
                }
                else if (this.getStatus().equals("Em Andamento"))
                {
                    if (this.publications.isEmpty())
                    {
                        System.out.println("\nO status desse projeto não pode ser alterado para concluído, " +
                                "pois não possui publicações associadas!");
                    }
                    else {
                        this.setStatus("Concluído");
                        System.out.println("\nStatus alterado de 'Em Andamento' para 'Concluído'!");
                    }
                } else
                    System.out.println("\nProjeto já foi concluído!");
            }
        } catch (InputMismatchException e)
        {
            System.err.println("\nFormato de entrada não é um número inteiro!");
            input.nextLine();
        }
    }

    public void incluirPublicacoes(ArrayList<Publication> generalPublications)
    {
        Scanner input = new Scanner(System.in);
        Publication publicationIn = new Publication();
        publicationIn.setAssociatedProject(this.getTitle());

        System.out.println("\nDigite o título da publicação:");
        publicationIn.setTitleConference(input.nextLine());

        System.out.println("\nDigite o nome da conferência onde foi divulgada a publicação:");
        publicationIn.setConference(input.nextLine());

        System.out.println("\nDigite o ano de publicação:");
        publicationIn.setYearPublicationConference(input.nextInt());

        System.out.println("\nQDigite o professor orientador da publicação");
        Main.printTeacher(this.participants);

        try {
            int choice = input.nextInt();
            boolean valid = false;
            while (!valid) {
                if (this.participants.get(choice).isTeacher()) {
                    publicationIn.addAuthors(this.participants.get(choice));
                    this.participants.get(choice).connectPublication(publicationIn);
                    Teacher teacherIn = (Teacher) this.participants.get(choice);
                    teacherIn.addGuidance(publicationIn.getTitle());
                    valid = true;
                } else
                    System.out.println("\nEste colaborador não é professor!");
            }
            boolean finalizing = false;
            while (!finalizing) {
                System.out.println("\nAdicione o(s) autor(es) da publicação:");
                Main.printParticipants(this.participants);

                choice = input.nextInt();
                if (!this.participants.get(choice).isTeacher() && !publicationIn.isAssociatedAuthor(this.participants.get(choice)))
                {
                    publicationIn.addAuthors(this.participants.get(choice));
                    this.participants.get(choice).connectPublication(publicationIn);
                    System.out.println("\nAutor adicionado!");
                } else {
                    System.out.println("\nEste autor já foi adicionado!");
                }
                System.out.println("\nDeseja adicionar outro autor?\n1 - Sim\n2 - Não");
                choice = input.nextInt();
            }
            if (choice == 2)
                finalizing = true;
        } catch (InputMismatchException e) {
            System.err.println("\nERRO! Entrada não é um número inteiro!");
            input.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nERRO! A posição do array nao existe!");
        }
        this.publications.add(publicationIn);
        generalPublications.add(publicationIn);
        System.out.println("\nPublicação adicionada com sucesso!");
    }

    public static boolean isRegisteredTeacher(ArrayList<Researcher> participant)
    {
        boolean is = false;
        for (Researcher researcherCount : participant)
        {
            if (researcherCount.isTeacher())  is = true;
        }
        return is;
    }

    public void projectInfo()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        System.out.println("Título do projeto: " + this.title);
        System.out.println("Objetivo do projeto: " + this.objective);
        System.out.println("Descrição do projeto: " + this.description);
        System.out.println("Agência financiadora do projeto: " + this.fundingAgency);
        System.out.println("Valor financiado no projeto: R$" + this.fundingValue);
        System.out.println("Data de início do projeto: " + dateFormat.format(this.dataStartProject));
        System.out.println("Data de término do projeto: " + dateFormat.format(this.dataEndProject));
        System.out.println("Status atual do projeto: " + this.status);
        System.out.println("Colaboradores participantes do projeto: ");
        for (Researcher participantCont : this.participants)
        {
            if (!participantCont.isTeacher())
                System.out.println("	" + participantCont.getName());
        }
        System.out.println("Professor orientador do projeto: " + this.leader.getName());
        System.out.println("Publicações associadas ao projeto: ");
        Collections.sort(publications);
        for (Publication publicationCount : this.publications) {
            System.out.println("Título da publicação: " + publicationCount.getTitle());
            System.out.println("Ano de publicação: " + publicationCount.getYearPublicationConference());
            System.out.println("Conferência: " + publicationCount.getConference());
        }
    }

    @Override
    public int compareTo(Project projects)
    {
        if (this.dataEndProject.after(projects.dataEndProject))
        {
            return -1;
        }
        else if (this.dataEndProject.before(projects.dataEndProject))
        {
            return 1;
        }else{
            return 0;
        }
    }
}
