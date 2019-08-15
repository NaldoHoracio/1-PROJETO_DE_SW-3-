/**!
 * @className employees.HourlyEmployee.java
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

public class HourlyEmployee extends Employee{
    private double wageSalary;// Salário horário

    // Construtor
    public HourlyEmployee(int idEmployeeEmp)
    {
        super.setName();
        super.setAddress();
        super.setIdEmployee(idEmployeeEmp);
        setWageSalary();
        super.setTypeEmployee("HORISTA");
        super.setTypeOfPayment("DEPOSITO");
        super.setTypeOfAgenda("SEMANAL");
        super.setDayWeeklyPay(4);// Dia da semana do pagamento
        super.setDataPay(-1);// Data do pagamento
        this.isSyndicalist = false;
    }

    // Configurando o salário do horista
    public void setWageSalary()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o salário por hora (Exm.: 50,00):");
        double wage = input.nextDouble();
        if(wage <= 0)
        {
            System.out.println("Salário inválido! Digite um valor maior que 0!");
        }else {
            this.wageSalary = wage;
        }
    }

    public double getWageSalary()
    {
        return this.wageSalary;
    }

    // Configurando salário do dia para 0
    public void setSalaryDay()
    {
        double salaryDayEmp = 0.0;
        this.grossSalary = salaryDayEmp;
    }

    // Calculando o salário do dia
    public void setSalaryDay(double hoursWorked)
    {
        if(hoursWorked <= 8)
        {
            this.grossSalary = hoursWorked * this.wageSalary;
        }else{
            this.grossSalary = 8 * this.wageSalary + (hoursWorked - 8) * (1.5 * this.wageSalary);
        }
        System.out.println("Salário do dia: " + this.grossSalary);
    }

    public double getSalaryDay()
    {
        return this.grossSalary;
    }

    // Configurando o salário do empregado
    @Override
    public double setLiquidSalariedEmployee()
    {
        return this.liquidSalary += this.grossSalary - getUnionFee()/4 - getOthersFee()/4;
    }
}
