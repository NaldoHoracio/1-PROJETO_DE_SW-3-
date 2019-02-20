import java.util.Scanner;

class Agenda{

    public int[] diaS = new int[5]; // Caso a agenda seja semanal, guarda o dia da semana que ser� realizado o pagamento
    public int[] diaB = new int[5]; // Caso a agenda seja bi-semanal, guarda o dia da semana que ser� realizado o pagamento
    public int[] data = new int[28]; // Caso a agenda seja mensal, guarda a data do pagamento (caso seja 28, o �ltimo dia do m�s � considerado)

}

class Empregado {

    public String nome, endereco, metodo; // Guardam o nome, endere�o e m�todo de pagamento escolhido pelo funcion�rio
    public int numeroCadastro; // Guarda o n�mero de cadastro do funcion�rio
    public char tipo; // Guarda o tipo do funcion�rio: A - Assalariado, H - Horista, C - Comissionado
    public char sindicalista; // Guarda a informa��o se o funcion�rio � do sindicato ou n�o: S - Sim, N - N�o
    public double salarioHora; // Guarda o sal�rio a ser pago por hora para funcion�rios horistas
    public double salarioFixo; // Guarda o sal�rio fixo a ser pago para funcion�rios assalariados
    public double percentual; // Guarda o percentual sobre as vendas a ser pago para funcion�rios comissionados
    public double salario; // Guarda o sal�rio total a ser pago de cada funcion�rio
    public double taxaFixa, adicionais; // Guarda a taxa sindical do empregado e as taxas adicionais que possam ser cobradas
    public long numeroSindicato; // Guarda a ID do funcion�rio no sindicato
    public char agendaTipo; // Guarda o tipo de agenda de pagamento do funcion�rio: S - Semanal, M - Mensal, B - Bi-semanal
    public int agendaData; // Caso a agenda seja mensal, esta vari�vel guarda o dia do pagamento do funcion�rio
    public int agendaDia; // Caso a agenda seja semanal, esta vari�vel guarda o dia da semana do pagamento

}

public class FolhadePagamento {

    public Scanner entrada = new Scanner(System.in);

    public static void menu() { // Exibe o menu de op��es do sistema

        System.out.println("\nBem-vindo ao sistema de cadastros de funcion�rios da Wolves & Villagers!");
        System.out.println("\nPor favor, escolha uma op��o para iniciar:");
        System.out.println("\n1 - Adicionar um funcion�rio");
        System.out.println("2 - Remover um funcion�rio");
        System.out.println("3 - Lan�ar um cart�o de ponto");
        System.out.println("4 - Lan�ar um resultado venda");
        System.out.println("5 - Lan�ar uma taxa de servi�o");
        System.out.println("6 - Alterar detalhes de um empregado j� cadastrado");
        System.out.println("7 - Rodar a folha de pagamento para hoje");
        System.out.println("8 - Undo / Redo");
        System.out.println("9 - Criar nova Agenda de Pagamento");
        System.out.println("10 - Alterar dia de pagamento de um funcion�rio");
        System.out.println("11 - Ver lista de funcion�rios cadastrados");
        System.out.println("\nCaso tenha conclu�do as atividades, clique em 0 para sair.");

    }

    public static void imprimeFuncionarios(Empregado[] empregados){

        for(int i = 0; i < 20; i++){
            if (empregados[i] != null){
                System.out.println("ID: " + empregados[i].numeroCadastro + "\nFunion�rio: " + empregados[i].nome + "\n");
            }
        }
    }

    public static void backup (Empregado atual, Empregado recup){

        recup.nome = atual.nome;
        recup.endereco = atual.endereco;
        recup.metodo = atual.metodo;
        recup.salarioFixo = atual.salarioFixo;
        recup.numeroCadastro = atual.numeroCadastro;
        recup.salarioHora = atual.salarioHora;
        recup.adicionais = atual.adicionais;
        recup.agendaData = atual.agendaData;
        recup.agendaTipo = atual.agendaTipo;
        recup.sindicalista = atual.sindicalista;
        recup.numeroSindicato = atual.numeroSindicato;
        recup.percentual = atual.percentual;
        recup.salario = atual.salario;
        recup.tipo = atual.tipo;
        recup.agendaDia = atual.agendaDia;
        recup.taxaFixa = atual.taxaFixa;

    }

    public static void cadastrado(Empregado empregado) { // Imprime na tela os dados do empregado cadastrado

        System.out.println("\nFuncion�rio cadastrado com sucesso!");

        System.out.printf("\nN�mero de cadastro: %d\n", empregado.numeroCadastro);
        System.out.println("Nome: " + empregado.nome);
        System.out.println("Endere�o: " + empregado.endereco);

        System.out.print("Tipo: ");
        if (empregado.tipo == 'C') {
            System.out.println("Comissionado");
            System.out.printf("Valor a ser pago quinzenalmente: %.2f\n", empregado.salarioFixo / 2);
            System.out.println("Percentual de comiss�o sobre as vendas: " + empregado.percentual + "%");
        } else if (empregado.tipo == 'A') {
            System.out.println("Assalariado");
            System.out.printf("Valor a ser pago mensalmente: %.2f\n", empregado.salarioFixo);
        } else if (empregado.tipo == 'H') {
            System.out.println("Horista");
            System.out.printf("Valor a ser pago por hora: %.2f\n", empregado.salarioHora);
        }
        System.out.println("M�todo de pagamento escolhido: " + empregado.metodo);

        if(empregado.sindicalista == 'S'){
            System.out.println("Faz parte do sindicato");
            System.out.println("ID no sindicato: " + empregado.numeroSindicato);
        } else {
            System.out.println("N�o faz parte do sindicato\n");
        }

    }

    public static boolean ultimoDiaDoMes (int ano, int mes, int dia){ // Informa se o dia � o �ltimo do m�s

        if ((dia == 31) && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)){
            return true;
        } else if ((dia == 30) && (mes == 4 || mes == 6 || mes == 9 || mes == 11)){
            return true;
        } else if ((dia == 28) && (mes == 2) && (ano % 4 != 0)){
            return true;
        } else if ((dia == 29) && (mes == 2) && (ano % 4 == 0)){
            return true;
        }

        return false;

    }

    public static void pagarMensal(Empregado[] empregados, int data){ // Informa os funcion�rios assalariados que devem ser pagos

        for (int i = 0; i < 20; i++){

            if (empregados[i] != null && empregados[i].agendaTipo == 'M' && empregados[i].agendaData == data){
                empregados[i].salario += empregados[i].salarioFixo - (empregados[i].taxaFixa + empregados[i].adicionais);
                System.out.printf("O funcion�rio %s receber� R$ %.2f no m�todo: %s\n", empregados[i].nome, empregados[i].salario, empregados[i].metodo);
                empregados[i].salario = 0;
                empregados[i].adicionais = 0;
            }
        }
    }

    public static void pagarSemanal(Empregado[] empregados, int diaSemana){ // Informa os funcion�rios horistas que devem ser pagos

        for(int i = 0; i < 20; i++){
            if (empregados[i] != null && empregados[i].agendaTipo == 'S' && empregados[i].agendaDia == diaSemana){
                empregados[i].salario += (empregados[i].salarioFixo/4) - (empregados[i].taxaFixa + empregados[i].adicionais)/4;
                System.out.printf("O funcion�rio %s receber� R$ %.2f no m�todo: %s\n", empregados[i].nome, empregados[i].salario, empregados[i].metodo);
                empregados[i].salario = 0;
                empregados[i].adicionais = 0;
            }
        }
    }

    public static void pagarBisemanal(Empregado[] empregados, int diaSemana){

        for(int i = 0; i < 20; i++){
            if(empregados[i] != null && empregados[i].agendaTipo == 'B' && empregados[i].agendaDia == diaSemana){
                empregados[i].salario += (empregados[i].salarioFixo/2) - (empregados[i].adicionais + empregados[i].taxaFixa)/2;
                System.out.printf("O funcion�rio %s receber� R$ %.2f no m�todo: %s\n", empregados[i].nome, empregados[i].salario, empregados[i].metodo);
                empregados[i].salario = 0;
                empregados[i].adicionais = 0;
            }
        }
    }

    public static int adicionar(Scanner entrada, Empregado[] empregados) throws Exception { // Adiciona um novo empregado ao sistema

        int atual = 0;
        while (empregados[atual] != null) {
            atual++;
        }
        empregados[atual] = new Empregado();
        empregados[20] = null;

        System.out.println("\nPor favor, digite o nome do empregado a ser cadastrado:");
        empregados[atual].nome = entrada.nextLine();

        System.out.println("\nPor favor, digite o endere�o do empregado:");
        empregados[atual].endereco = entrada.nextLine();

        System.out.println("\nPor favor, escolha o tipo de pagamento do empregado:");
        System.out.println("\nH - Horista");
        System.out.println("A - Assalariado");
        System.out.println("C - Comissionado");
        empregados[atual].tipo = (char) System.in.read();

        System.out.print("\nPor favor, digite o sal�rio a ser pago ao empregado ");
        if (empregados[atual].tipo == 'H') {
            System.out.println("por hora:");
            empregados[atual].salarioHora = entrada.nextDouble();
            empregados[atual].agendaDia = 4;
            empregados[atual].agendaData = -1;
            empregados[atual].agendaTipo = 'S';
            empregados[atual].percentual = 0;
            empregados[atual].salarioFixo = 0;
        } else {
            System.out.println("por m�s:");
            empregados[atual].salarioFixo = entrada.nextDouble();
            if (empregados[atual].tipo == 'C') {
                System.out.println("Por favor, digite o percentual de comiss�o a ser pago ao empregado: (ex: 20)");
                empregados[atual].percentual = entrada.nextDouble();
                empregados[atual].agendaDia = 4;
                empregados[atual].agendaData = -1;
                empregados[atual].agendaTipo = 'B';
                empregados[atual].salarioHora = 0;
            } else {
                empregados[atual].percentual = 0;
                empregados[atual].agendaDia = -1;
                empregados[atual].agendaData = 27;
                empregados[atual].agendaTipo = 'M';
                empregados[atual].salarioHora = 0;
            }
        }

        System.out.println("\nPor favor, informe a forma de pagamento desejada pelo empregado:");
        System.out.println("Op��es: Cheque pelos correios, Dep�sito banc�rio, Cheque em m�os");
        entrada.nextLine();
        empregados[atual].metodo = entrada.nextLine();
        empregados[atual].numeroCadastro = atual + 1;

        System.out.println("\nO funcion�rio faz parte do sindicato?");
        System.out.println("S - Sim ou N - N�o");
        empregados[atual].sindicalista = (char) System.in.read();
        if(empregados[atual].sindicalista == 'S'){
            System.out.println("\nQual o n�mero de identifica��o do funcion�rio no sindicato? (6 d�gitos)");
            empregados[atual].numeroSindicato = entrada.nextLong();
            System.out.println("\nQual o valor da taxa do sal�rio destinada ao sindicato? (em R$)");
            empregados[atual].taxaFixa = entrada.nextDouble();
        } else {
            empregados[atual].numeroSindicato = 0;
            empregados[atual].taxaFixa = 0;
        }
        empregados[atual].adicionais = 0;
        empregados[atual].salario = 0;

        cadastrado(empregados[atual]);
        return atual;

    }

    public static void remover(Scanner entrada, Empregado[] empregados){ // Remove um empregado do sistema

        System.out.println("\nPor favor, digite o n�mero de cadastro do empregado a ser removido:\n");
        imprimeFuncionarios(empregados);
        int cadastro = entrada.nextInt() - 1;
        entrada.nextLine();

        if (empregados[cadastro] == null) {
            System.out.println("Empregado n�o cadastrado!");
        } else {
            System.out.println("Deseja remover " + empregados[cadastro].nome + "? (Sim/N�o)");
            String resposta = entrada.nextLine();
            if (resposta.equals("Sim")) {
                empregados[20] = new Empregado();
                backup(empregados[cadastro], empregados[20]);
                empregados[cadastro] = null;
                System.out.println("Empregado removido com sucesso!");
            }
        }

    }

    public static void ponto(Scanner entrada, Empregado[] empregados){ // Lan�a o cart�o de ponto a um empregado

        System.out.println("Digite o n�mero de cadastro do empregado:\n");
        imprimeFuncionarios(empregados);
        int cadastro = entrada.nextInt() - 1;

        if (empregados[cadastro] == null) {
            System.out.println("Empregado n�o cadastrado!");
        } else if (empregados[cadastro].tipo == 'H') {
            System.out.println("Digite o n�mero de horas:");
            double horas = entrada.nextDouble();
            empregados[20] = new Empregado();
            backup(empregados[cadastro], empregados[20]);
            if (horas > 8) {
                empregados[cadastro].salario += (((horas - 8) * empregados[cadastro].salarioHora * 1.5) + (8 * empregados[cadastro].salarioHora));
            } else {
                empregados[cadastro].salario += (horas * empregados[cadastro].salarioHora);
            }
            System.out.println("Cart�o de ponto lan�ado com sucesso!");
        } else {
            System.out.println("Empregado n�o � horista!");
        }

    }

    public static void venda(Scanner entrada, Empregado[] empregados){ // Lan�a o resultado da venda de um empregado

        System.out.println("Digite o n�mero de cadastro do empregado:\n");
        imprimeFuncionarios(empregados);
        int cadastro = entrada.nextInt() - 1;

        if(empregados[cadastro] == null){
            System.out.println("Empregado n�o cadastrado!");
        } else if (empregados[cadastro] != null && empregados[cadastro].tipo == 'C') {
            System.out.println("Digite o resultado da venda:");
            empregados[20] = new Empregado();
            backup(empregados[cadastro], empregados[20]);
            empregados[cadastro].salario += entrada.nextDouble() * (empregados[cadastro].percentual/100);
            System.out.println("Resultado lan�ado com sucesso!");
        } else {
            System.out.println("Empregado n�o � comissionado!");
        }

    }

    public static void alteracoes(Scanner entrada, Empregado[] empregados) throws Exception { // Altera dados de um funcion�rio

        System.out.println("Digite o n�mero de cadastro do empregado:\n");
        imprimeFuncionarios(empregados);
        int cadastro = entrada.nextInt() - 1;

        if (empregados[cadastro] == null) {
            System.out.println("Empregado n�o cadastrado!");
        } else {
            empregados[20] = new Empregado();
            backup(empregados[cadastro], empregados[20]);
            System.out.println("Deseja alterar o nome do funcion�rio: " + empregados[cadastro].nome + "? (Sim/N�o)");
            entrada.nextLine();
            String resposta = entrada.nextLine();
            if (resposta.equals("Sim")) {
                System.out.println("Digite o nome do funcion�rio:");
                empregados[cadastro].nome = entrada.nextLine();
            }

            System.out.println("Deseja alterar o endere�o do funcion�rio: " + empregados[cadastro].endereco + "?  (Sim/N�o)");
            resposta = entrada.nextLine();
            if (resposta.equals("Sim")) {
                System.out.println("Digite o endere�o do funcion�rio:");
                empregados[cadastro].endereco = entrada.nextLine();
            }

            System.out.println("Deseja alterar o tipo de pagamento do funcion�rio: " + empregados[cadastro].tipo + "?  (Sim/N�o)");
            resposta = entrada.nextLine();
            if (resposta.equals("Sim")) {
                System.out.println("Digite o tipo de pagamento do funcion�rio:");
                System.out.println("\nH - Horista");
                System.out.println("A - Assalariado");
                System.out.println("C - Comissionados");
                empregados[cadastro].tipo = (char) System.in.read();
                System.out.print("\nPor favor, digite o sal�rio a ser pago ao empregado ");
                if (empregados[cadastro].tipo == 'H') {
                    System.out.println("por hora:");
                    empregados[cadastro].salarioHora = entrada.nextDouble();
                    empregados[cadastro].agendaDia = 4;
                    empregados[cadastro].agendaData = -1;
                    empregados[cadastro].agendaTipo = 'S';
                    empregados[cadastro].percentual = 0;
                    empregados[cadastro].salarioFixo = 0;
                } else {
                    System.out.println("por m�s:");
                    empregados[cadastro].salarioFixo = entrada.nextDouble();
                    if (empregados[cadastro].tipo == 'C') {
                        System.out.println("Por favor, digite o percentual de comiss�o a ser pago ao empregado:");
                        empregados[cadastro].percentual = entrada.nextDouble();
                        empregados[cadastro].agendaDia = 4;
                        empregados[cadastro].agendaData = -1;
                        empregados[cadastro].agendaTipo = 'B';
                        empregados[cadastro].salarioHora = 0;
                    } else {
                        empregados[cadastro].percentual = 0;
                        empregados[cadastro].agendaDia = -1;
                        empregados[cadastro].agendaData = 27;
                        empregados[cadastro].agendaTipo = 'M';
                        empregados[cadastro].salarioHora = 0;
                    }
                }
            }
            entrada.nextLine();
            System.out.println("Deseja alterar a participa��o do funcion�rio no sindicato: " + empregados[cadastro].sindicalista + "?  (Sim/N�o)");
            resposta = entrada.nextLine();
            if (resposta.equals("Sim")) {
                System.out.println("\nO funcion�rio faz parte do sindicato?");
                System.out.println("S - Sim ou N - N�o");
                empregados[cadastro].sindicalista = (char) System.in.read();
                if(empregados[cadastro].sindicalista == 'S'){
                    System.out.println("\nQual o n�mero de identifica��o do funcion�rio no sindicato? (6 D�gitos)");
                    empregados[cadastro].numeroSindicato = entrada.nextLong();
                    System.out.println("\nQual o valor da taxa do sal�rio destinada ao sindicato? (em R$)");
                    empregados[cadastro].taxaFixa = entrada.nextDouble();
                    entrada.nextLine();
                } else {
                    empregados[cadastro].taxaFixa = 0;
                    empregados[cadastro].numeroSindicato = 0;
                }
            }

            System.out.println("Deseja alterar a forma de pagamento do funcion�rio: " + empregados[cadastro].metodo + "?  (Sim/N�o)");
            resposta = entrada.nextLine();
            if (resposta.equals("Sim")) {
                System.out.println("\nPor favor, informe a forma de pagamento desejada pelo empregado:");
                System.out.println("Op��es: Cheque pelos correios, Dep�sito banc�rio, Cheque em m�os");
                empregados[cadastro].metodo = entrada.nextLine();
            }
        }
        System.out.println("Dados alterados com sucesso!");
    }

    public static void taxa(Scanner entrada, Empregado[] empregados){ // Registra uma taxa cobrada pelo sindicato a um funcion�rio

        System.out.println("Digite o n�mero de cadastro do empregado:\n");
        imprimeFuncionarios(empregados);
        int cadastro = entrada.nextInt() - 1;

        if(empregados[cadastro] == null){
            System.out.println("Empregado n�o cadastrado!");
        } else if (empregados[cadastro].sindicalista == 'S'){
            empregados[20] = new Empregado();
            backup(empregados[cadastro], empregados[20]);
            System.out.println("Digite a taxa a ser deduzida do pagamento do funcion�rio:");
            empregados[cadastro].adicionais += entrada.nextDouble();
            System.out.println("Taxa registrada com sucesso!");
        } else {
            System.out.println("Empregado n�o faz parte do sindicato!");
        }

    }

    public static void folha(Scanner entrada, Empregado[] empregados){ // Roda a folha de pagamento para determinado dia informado

        System.out.println("Por favor, informe o ano atual");
        int ano = entrada.nextInt();
        System.out.println("Por favor, informe o m�s atual:");
        int mes = entrada.nextInt();
        System.out.println("Por favor, informe a data atual:");
        int data = entrada.nextInt();
        System.out.println("Por favor, informe o dia da semana atual:");
        System.out.println("1 - Segunda-feira\n2 - Ter�a-feira\n3 - Quarta-feira\n4 - Quinta-feira\n5 - Sexta-feira");
        int dia = entrada.nextInt();

        boolean ultimo = ultimoDiaDoMes(ano, mes, data);
        int dataPag;

        if(ultimo == true){
            dataPag = 28;
        } else {
            dataPag = data;
        }
        pagarMensal(empregados,dataPag - 1);
        pagarSemanal(empregados, dia - 1);
        if((data > 7 && data < 15) || (data > 21 && data < 29)){
            pagarBisemanal(empregados, dia - 1);
        }
    }

    public static void undoRedo(Scanner entrada, Empregado[] empregados, int ultimo, int ultimoAdd){
        System.out.println("O que deseja fazer?\n1 - Undo\n2 - Redo");
        int opcao = entrada.nextInt();
        if (ultimo == 0){
            System.out.println("Nenhuma opera��o realizada at� o momento!");
            return;
        }
        switch(opcao){
            case 1:
                if(ultimo == 1){
                    empregados[20] = new Empregado();
                    backup(empregados[ultimoAdd], empregados[20]);
                    empregados[ultimoAdd] = null;
                    System.out.println("Undo realizado com sucesso!");
                } else if (ultimo == 2){
                    int indice = empregados[20].numeroCadastro - 1;
                    empregados[indice] = new Empregado();
                    backup(empregados[20], empregados[indice]);
                    System.out.println("Undo realizado com sucesso!");
                } else {
                    int indice = empregados[20].numeroCadastro - 1;
                    Empregado troca = new Empregado();
                    backup(empregados[indice], troca);
                    backup(empregados[20], empregados[indice]);
                    backup(troca, empregados[20]);
                    System.out.println("Undo realizado com sucesso!");
                }
                break;
            case 2:
                int indice = empregados[20].numeroCadastro - 1;
                if (ultimo == 2){
                    empregados[indice] = null;
                } else if (ultimo == 1){
                    empregados[indice] = new Empregado();
                    backup(empregados[20], empregados[indice]);
                } else {
                    Empregado troca = new Empregado();
                    backup(empregados[indice], troca);
                    backup(empregados[20], empregados[indice]);
                    System.out.println("Redo realizado com sucesso!");
                }
                break;
        }
    }

    public static void novaAgenda(Scanner entrada, Agenda agenda) throws Exception { // Cria uma nova agenda de pagamento

        System.out.println("Qual o tipo de agenda que deseja adicionar?");
        System.out.println("B - Bi-semanal, S - Semanal, M - Mensal");
        char opcao = (char) System.in.read();
        int escolha;

        if (opcao == 'M'){
            System.out.println("Digite o dia de pagamento que deseja adicionar na agenda (de 1 a 28)");
            escolha = entrada.nextInt() - 1;
            if (agenda.data[escolha] == 1){
                System.out.println("Agenda de pagamento j� cadastrada!");
            } else {
                agenda.data[escolha] = 1;
                System.out.println("Agenda de pagamento cadastrada com sucesso!");
            }
        } else if (opcao == 'B'){
            System.out.println("Digite o dia da semana em que ser� realizado o pagamento:\n");
            System.out.println("1 - Segunda-feira\n2 - Ter�a-feira\n3 - Quarta-feira\n4 - Quinta-feira\n5 - Sexta-feira");
            escolha = entrada.nextInt() - 1;
            if (agenda.diaB[escolha] == 1){
                System.out.println("Agenda de pagamento j� cadastrada!");
            } else {
                agenda.diaB[escolha] = 1;
                System.out.println("Agenda de pagamento cadastrada com sucesso!");
            }
        } else if (opcao == 'S'){
            System.out.println("Digite o dia da semana em que ser� realizado o pagamento:\n");
            System.out.println("1 - Segunda-feira\n2 - Ter�a-feira\n3 - Quarta-feira\n4 - Quinta-feira\n5 - Sexta-feira");
            escolha = entrada.nextInt() - 1;
            if (agenda.diaS[escolha] == 1){
                System.out.println("Agenda de pagamento j� cadastrada!");
            } else {
                agenda.diaS[escolha] = 1;
                System.out.println("Agenda de pagamento cadastrada com sucesso!");
            }
        } else {
            System.out.println("Op��o inv�lida!");
        }

    }

    public static void alterarPagamento(Scanner entrada, Agenda agenda, Empregado[] empregados) throws Exception{

        System.out.println("Por favor, digite o n�mero de cadastro do empregado:\n");
        imprimeFuncionarios(empregados);
        int cadastro = entrada.nextInt() - 1;
        if (empregados[cadastro] == null){
            System.out.println("Empregado n�o cadastrado!");
        } else {
            System.out.println("Qual tipo de agenda o funcion�rio far� parte?");
            System.out.println("B - Bi-semanal, S - Semanal, M - Mensal");
            char tipo = (char) System.in.read();
            if (tipo == 'B'){
                System.out.println("Em qual dia da semana o funcion�rio ser� pago?");
                System.out.println("1 - Segunda-feira\n2 - Ter�a-feira\n3 - Quarta-feira\n4 - Quinta-feira\n5 - Sexta-feira");
                int escolha = entrada.nextInt() - 1;
                if(agenda.diaB[escolha] == 1){
                    empregados[cadastro].agendaDia = escolha;
                    empregados[cadastro].agendaTipo = 'B';
                    empregados[cadastro].agendaData = -1;
                    System.out.println("Alterado com sucesso!");
                } else {
                    System.out.println("Agenda de pagamento escolhida n�o est� dispon�vel!");
                }
            } else if (tipo == 'S') {
                System.out.println("Em qual dia da semana o funcion�rio ser� pago?");
                System.out.println("1 - Segunda-feira\n2 - Ter�a-feira\n3 - Quarta-feira\n4 - Quinta-feira\n5 - Sexta-feira");
                int escolha = entrada.nextInt() - 1;
                if (agenda.diaS[escolha] == 1){
                    empregados[cadastro].agendaDia = escolha;
                    empregados[cadastro].agendaTipo = 'S';
                    empregados[cadastro].agendaData = -1;
                    System.out.println("Alterado com sucesso!");
                } else {
                    System.out.println("Agenda de pagamento escolhida n�o est� dispon�vel!");
                }
            } else if (tipo == 'M') {
                System.out.println("Em qual dia do m�s o funcion�rio ser� pago (De 1 a 28)?");
                int escolha = entrada.nextInt() - 1;
                if (agenda.data[escolha] == 1){
                    empregados[cadastro].agendaData = escolha;
                    empregados[cadastro].agendaTipo = 'M';
                    empregados[cadastro].agendaDia = -1;
                    System.out.println("Alterado com sucesso!");
                } else {
                    System.out.println("Agenda de pagamento escolhida n�o est� dispon�vel!");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        Empregado[] empregados = new Empregado[21];
        empregados[20] = new Empregado();
        Agenda agenda = new Agenda();
        int opcao;
        int ultimo = 0, ultimoAdd = -1;

        for(int i = 0; i < 28; i++){
            agenda.data[i] = 0;
            if (i < 5){
                agenda.diaS[i] = 0;
                agenda.diaB[i] = 0;
            }
        }

        agenda.data[27] = 1;
        agenda.diaS[4] = 1;
        agenda.diaB[4] = 1;

        do{
            menu();
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    ultimoAdd = adicionar(entrada, empregados);
                    break;

                case 2:
                    remover(entrada, empregados);
                    break;

                case 3:
                    ponto(entrada, empregados);
                    break;

                case 4:
                    venda(entrada, empregados);
                    break;

                case 5:
                    taxa(entrada, empregados);
                    break;

                case 6:
                    alteracoes(entrada, empregados);
                    break;

                case 7:
                    folha(entrada, empregados);
                    break;

                case 8:
                    undoRedo(entrada, empregados, ultimo, ultimoAdd);
                    break;

                case 9:
                    novaAgenda(entrada, agenda);
                    break;

                case 10:
                    alterarPagamento(entrada, agenda, empregados);
                    break;

                case 11:
                    imprimeFuncionarios(empregados);
                    break;

                case 0:
                    System.out.println("Obrigado por utilizar a  Wolves & Villagers Sistema de Cadastros!");
                    break;

                default:
                    System.out.println("Op��o Inv�lida!");
                    break;

            }
            if (opcao >= 1 && opcao <= 6)ultimo = opcao;
        } while (opcao != 0);

        entrada.close();
    }
}