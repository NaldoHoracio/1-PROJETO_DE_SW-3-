/**!
 * @className employees.Employee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package employees;

import java.util.Scanner;

public abstract class Employee {

    // Dados básicos do empregado
    private String name;// Nome
    private String publicPlace;// Logradouro
    private String numHouse;// Número da residência
    private String cepPlace;
    private String city;
    private String country;
    private int    idEmployee = 0;// Número de identificação do empregado
    private String typeEmployee;// HORISTA, COMISSIONADO, ASSALARIADO


    // Dados referente ao pagamento
    private String typeOfPayment;// CORREIOS, EM MAOS, DEPOSITO
    private String typeOfAgenda;// SEMANAL, BISSEMANAL, MENSAL
    private int dataPay;// Data do pagamento do funcionário
    private int dayWeeklyPay;// Dia da semana do pagamento
    protected double salaryMonthly;// Salário mensal
    protected double liquidSalary = 0;// Salário líquido

    // Dados referente ao sindicato
    protected boolean isSyndicalist = false;// Verifica se o empregado faz ou não parte do sindicato (1 - Sim | 0 - Não)
    private int idSyndicalist = -1;// Id do empregado no sindicato
    private double unionFee = 0;// Taxa do sindicato, caso o empregado faça parte
    private double othersFee = 0;// Outras taxas e deduções do salário

    // Configura o nome
    public void setName()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do empregado (PrimeiroNome UltimoNome):");
        this.name = input.nextLine();
    }
    // Retorna o nome
    public String getName()
    {
        return this.name;
    }

    // Configura o endereço
    public void setAddress()
    {
        Scanner input = new Scanner(System.in);
        /*System.out.println("Digite o logradouro do Empregado (Avenida, Loteamento, Bloco...):");
        this.publicPlace = input.nextLine();*/

        System.out.println("Digite o número da residência:");
        this.numHouse = input.nextLine();

        /*System.out.println("Digite o CEP: (XXX)");
        this.cepPlace = input.nextLine();

        System.out.println("Digite a cidade:");
        this.city = input.nextLine();

        System.out.println("Digite o estado:");
        this.country = input.nextLine();*/
    }

    // Retorna a situação sindical
    public boolean getIsSyndicalist()
    {
        return this.isSyndicalist;
    }

    // configura o ID do empregado
    public void setIdEmployee(int idEmployee)
    {
        this.idEmployee = idEmployee;
    }

    // Retorna o ID do empregado
    public int getIdEmployee()
    {
        return this.idEmployee;
    }

    // Configurando o typo de empregado
    public void setTypeEmployee(String typeEmp)
    {
        this.typeEmployee = typeEmp;
    }
    // Retornando o tipo de empregado
    public String getTypeEmployee()
    {
        return this.typeEmployee;
    }

    // Configurando a forma de pagamento
    public void setTypeOfPayment(String typeOfPaymentEmp)
    {
        this.typeOfPayment = typeOfPaymentEmp;
    }

    // Retorna o método de pagamento
    public String getTypeOfPayment()
    {
        return this.typeOfPayment;
    }

    // Configurando o tipo de Agenda
    public void setTypeOfAgenda(String typeOfAgendaEmp)
    {
        this.typeOfAgenda = typeOfAgendaEmp;
    }

    // Retorna o tipo de agenda
    public String getTypeOfAgenda()
    {
        return this.typeOfAgenda;
    }

    // Configurando a data do pagamento
    public void setDataPay(int dataPayEmp)
    {
        this.dataPay = dataPayEmp;
    }

    // Retorna a data do pagamento
    public int getDataPay()
    {
        return this.dataPay;
    }

    // Configurando o dia da semana do pagamento
    public void setDayWeeklyPay(int dayWeeklyPay)
    {
        this.dayWeeklyPay = dayWeeklyPay;
    }

    // Retornando o dia da semana do pagamento
    public int getDayWeeklyPay()
    {
        return this.dayWeeklyPay;
    }

    // Configurando o salário mensal
    public void setSalaryMonthly()
    {
        double salaryMonthlyEmp;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o salário mensal:");
        salaryMonthlyEmp = input.nextDouble();
        if(salaryMonthlyEmp < 0)
        {
            System.out.println("ERROR! Salário inválido! Valor menor que 0!");
        }else{
            this.salaryMonthly = salaryMonthlyEmp;
        }
    }

    // Retorna o salário mensal
    public double getSalaryMonthly()
    {
        return this.salaryMonthly;
    }

    // Configurando a sindicalização do empregado
    public void setMembershipEmployee(int idEmp)
    {
        Scanner input = new Scanner(System.in);

        if(this.isSyndicalist == true)// Se ele é vinculado, desvinculamos
        {
            System.out.println("Situação atual do empregado junto ao sindicato: FILIADO");
            this.isSyndicalist = false;
            this.idSyndicalist = -1;
            this.unionFee = 0;
            this.othersFee = 0;
            System.out.println("Situação do empregado junto ao sindicato alterada: NAO FILIADO");
        }else{
            System.out.println("Situação atual do empregado junto ao sindicato: NÃO FILIADO");
            this.isSyndicalist = true;
            setIdSyndicalist(idEmp);
            setUnionFee(idEmp);
            setOthersFee();
            System.out.println("Situação do empregado junto ao sindicato alterada: FILIADO");
        }
    }

    public boolean isSyndicalist() {
        return this.isSyndicalist;
    }

    // Configurando o id do funcionário no sindicato
    public void setIdSyndicalist(int idEmp)
    {
        idEmp = this.idEmployee*10;
        this.idSyndicalist = idEmp;
    }

    public void setIdSyndicalist()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o novo número do sindicato:");
        int newIdSynd = input.nextInt();
        this.idSyndicalist = newIdSynd;
    }

    // Retorna o id do funcionário no sindicato
    public int getIdSyndicalist()
    {
        return this.idSyndicalist;
    }

    // Configurando a taxa fixa paga pelo empregado
    public void setUnionFee(int idEmp)
    {
        double fee;
        Scanner input = new Scanner(System.in);
        System.out.println("Dite a taxa do Sindicato:");
        fee = input.nextDouble();
        if(fee < 0)
        {
            System.out.println("Valor menor que 0!");
        }else{
            this.unionFee = fee;
        }
    }

    // Retorna a taxa do sindicato paga pelo empregado, caso o mesmo faça para do Sindicato
    public double getUnionFee()
    {
        return this.unionFee;
    }

    // Configurando outras taxas
    public void setOthersFee()
    {
        double othersFeeEmp;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor total das outras taxas do Sindicato:");
        othersFeeEmp = input.nextDouble();
        if(othersFeeEmp < 0)
        {
            System.out.println("Valor menor que 0!");
        }else{
            this.othersFee = othersFeeEmp;
        }
    }

    // Retorna outras taxas descontadas do salário do empregado
    public double getOthersFee()
    {
        return this.othersFee;
    }

    // Sobrescrevendo o método toString
    @Override
    public String toString()
    {
        return "ID:" + getIdEmployee() + " --- " + "Nome: " + getName() + " --- Tipo: " + getTypeEmployee() +
                " --- ID Sind: " +getIdSyndicalist() + "\n";
    }

    public double setLiquidSalariedEmployee(double liquidSalaryEmp)
    {
        return this.liquidSalary = liquidSalaryEmp;
    }

    // Método abstrato que retornar o salário total do empregado de acordo com seu tipo
    public abstract double setLiquidSalariedEmployee();


}
