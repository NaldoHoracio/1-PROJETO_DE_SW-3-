/**!
 * @className HourlyEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2018
 *
 */

public class HourlyEmployee extends Employee {
    private double wageSalary;// Salário horário
    private double hoursWorked;// Horas trabalhadas

    // Configurando o salário do horista
    public double setWageSalary(double wage)
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
    public double setHoursWorked(double hours)
    {
        if(hours < 0.0 || hours > 24.00)
        {
            System.out.println("Invalid hour! Enter to number valid! (Hour > 0 OR Hour <= 24.00");
        }else{
            this.hoursWorked = hours;
        }
    }

    // Retornando o número de horas trabalhadas
    public double getHoursWorked()
    {
        return hoursWorked;
    }


}
