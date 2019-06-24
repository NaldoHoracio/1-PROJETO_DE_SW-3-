/**!
 * @className payroll.employees.HourlyEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2018
 *
 */
package payroll.employees;

public class HourlyEmployee extends Employee {
    private double wageSalary;// Salário horário
    private double hoursWorked;// Horas trabalhadas
    private double salaryDay;// Salario do dia (incluindo as horas extras)

    // Configurando o salário do horista
    public void setWageSalary(double wage)
    {
        if(wage <= 0)
        {
            System.out.println("Salaried invalid! Enter to value > 0!");
        }else {
            this.wageSalary = wage;
        }
    }

    // Retornando o salário horário
    public double getWageSalary()
    {
        return wageSalary;
    }

    // Configurando o número de horas trabalhadas
    public void setHoursWorked(double hours)
    {

        if(hours < 0.0 || hours > 24.00)
        {
            System.out.println("Invalid hour! Enter to number valid! (Hour > 0 OR Hour <= 24.00");
        }
        this.hoursWorked = hours;
    }

    // Retornando o número de horas trabalhadas
    public double getHoursWorked()
    {
        return hoursWorked;
    }

    // Calculando o salário do dia
    public void setSalaryDay(double salaryD)
    {
        if(getHoursWorked() <= 8)
        {
            salaryD = getHoursWorked()*getWageSalary();
        }else{
            salaryD = 8 * getWageSalary() + (8 - getHoursWorked()) * (1.5 * getWageSalary());
        }
        this.salaryDay = salaryD;
    }

    // Retornando o salário do dia
    public double getSalaryDay()
    {
        return salaryDay;
    }

    // Configurando o salário do empregado
    public void set

    @Override
    public double salariedEmployee() {
        return 0;
    }
}
