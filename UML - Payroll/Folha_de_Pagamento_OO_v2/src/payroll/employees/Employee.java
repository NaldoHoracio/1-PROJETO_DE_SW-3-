/**!
 * @className payroll.employees.Employee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package payroll.employees;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Employee {
    Scanner input = new Scanner(System.in);

    // Dados básicos do empregado
    private String name;// Nome
    private String address;// Endereço
    private int idEmployee = 0;// Número de identificação do empregado
    private String typeEmployee;// HOURLY, COMISSION, SALARIED
    private LocalDate dataAdmission;// Data de admissão do empregado
    private LocalDate dateLastPayment;// Data do último pagamento


    // Dados referente ao pagamento
    private String typeOfPayment;// POSTOFFICE, HANDS, DEPOSIT
    private String typeOfAgenda;// WEEKLY, BI-WEEKLY, MONTHLY
    private double salaryMonthly;// Salário mensal

    // Dados referente ao sindicato
    private int isSyndicalist;// Verifica se o empregado faz ou não parte do sindicato (1 - Sim | 0 - Não)
    private int idSyndicalist;// Id do empregado no sindicato
    private double unionFee;// Taxa do sindicato, caso o empregado faça parte
    private double othersFee;// Outras taxas e deduções do salário

    // Configura o nome
    public void setName()
    {
        System.out.println("Digite o nome do emprepgado (Formato: PRIMEIRO_NOME ULTIMO_NOME)");
        this.name = input.nextLine();
    }
    // Retorna o nome
    public String getName()
    {
        return name;
    }

    // Configura o endereço
    public void setAddress()
    {
        System.out.println("Digite o nome do empregado (Formato: Av./Logradouro, Nº da Residência, CEP, Cidade)");
        this.address = input.nextLine();
    }
    // Retorna o endereço
    public String getAddress()
    {
        return address;
    }

    public void setIdEmployee(int idEmployee)
    {
        this.idEmployee = idEmployee;
        System.out.println("ID configurado com sucesso!");
    }
    // Retorna o ID do empregado
    public int getIdEmployee()
    {
        return this.idEmployee;
    }

    // Configurando o typo de empregado
    public void setTypeEmployee(String typeEmp)
    {
        System.out.println("Digite o tipo de empregado (HOURLY | SALARIED | COMMISSION):");
        typeEmp = input.nextLine();
        typeEmp = typeEmp.toUpperCase();
        if(typeEmp.equals("HOURLY") || typeEmp.equals("SALARIED") || typeEmp.equals("COMMISSION"))
        {
            this.typeEmployee = typeEmp;
            System.out.println("Tipo de empregado alterado com sucesso!");
        }else {
            System.out.println("Tipo de empregado não existente!");
        }
    }
    // Retornando o tipo de empregado
    public String getTypeEmployee()
    {
        return typeEmployee;
    }

    // Configurando a data de adminissão do empregado
    public void setDataAdmission(String dataAdmissionEmp)
    {
        System.out.println("Digite a data de admissão do empregado (Formato: dd/mm/yyyy):");
        dataAdmissionEmp = input.nextLine();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataAdmission = LocalDate.parse(dataAdmissionEmp, formatDate);
    }
    // Retorna data da admissão do empregado
    public LocalDate getDataAdmission()
    {
        return dataAdmission;
    }

    // Configura a última data de pagamento
    public void setDateLastPayment(String dateLastPaymentEmp)
    {
        dateLastPaymentEmp = input.nextLine();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateLastPayment = LocalDate.parse(dateLastPaymentEmp, formatDate);
    }
    // Retorna a última data de pagamento
    public LocalDate getDateLastPayment()
    {
        return dateLastPayment;
    }
    // Configurando a forma de pagamento
    public void setTypeOfPayment(String typeOfPaymentEmp)
    {
        System.out.println("Digite o tipo de pagamento (POSTOFFICE | HANDS | DEPOSIT):");
        typeOfPaymentEmp = input.nextLine();
        typeOfPaymentEmp = typeOfPaymentEmp.toUpperCase();
        if(typeOfPaymentEmp.equals("POSTOFFICE") || typeOfPaymentEmp.equals("HANDS") || typeOfPaymentEmp.equals("DEPOSIT"))
        {
            this.typeOfPayment = typeOfPaymentEmp;
            System.out.println("Tipo de pagamento alterado com sucesso!");
        }else {
            System.out.println("Tipo de pagamento não disponível!");
        }
    }
    // Retorna o método de pagamento
    public String getTypeOfPayment()
    {
        return typeOfPayment;
    }

    // Configurando o tipo de Agenda
    public void setTypeOfAgenda(String typeOfAgendaEmp)
    {
        System.out.println("Enter type of payment (WEEKLY | BI-WEEKLY | MONTHLY):");
        typeOfAgendaEmp = input.nextLine();
        typeOfAgendaEmp = typeOfAgendaEmp.toUpperCase();
        if(typeOfAgendaEmp.equals("WEEKLY") || typeOfAgendaEmp.equals("BI-WEEKLY") || typeOfAgendaEmp.equals("MONTHLY"))
        {
            this.typeOfAgenda = typeOfAgendaEmp;
            System.out.println("Agenda de pagamento alterada com sucesso!");
        }else {
            System.out.println("Tipo de pagamento não existe!");
        }
    }

    // Configurando o salário mensal
    public void setSalaryMonthly(double salaryMonthlyEmp)
    {
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
        return salaryMonthly;
    }

    // Retorna o tipo de Agenda
    public String getTypeOfAgenda()
    {
        return typeOfAgenda;
    }

    // Retorna se o empregado é sindicalista ou não
    public int isSyndicalistEmployee()
    {
        System.out.println("É sindicalista? (1 - Sim | 0 - Não):");
        this.isSyndicalist = input.nextInt();
        return (this.isSyndicalist == 1) ? 1:0;
    }

    // Configurando o id do funcionário no sindicato
    public void setIdSyndicalist(int idSyndicalistEmp)
    {
        idSyndicalistEmp = getIdEmployee()*10;
        this.idSyndicalist = idSyndicalistEmp;
    }
    // Retorna o id do funcionário no sindicato
    public int getIdSyndicalist()
    {
        return idSyndicalist;
    }

    // Configurando a taxa fixa paga pelo empregado
    public void setUnionFee(double fee)
    {
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
        return unionFee;
    }

    // Configurando outras taxas
    public void setOthersFee(double othersFeeEmp)
    {
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
        return othersFee;
    }

    // Sobrescrevendo o método toString
    @Override
    public String toString()
    {
        return String.format("Empregado %s" + getName(), " tem ID %d" + getIdEmployee());
    }

    // Método abstrato que retornar o salário total do empregado de acordo com seu tipo
    public abstract double salariedEmployee();
}
