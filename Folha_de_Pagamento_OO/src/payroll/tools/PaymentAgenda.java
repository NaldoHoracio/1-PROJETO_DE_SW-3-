/**!
 * @className tools.PaymentAgenda.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-26
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package payroll.tools;

import payroll.employees.CommissionEmployee;
import payroll.employees.Employee;
import payroll.employees.HourlyEmployee;
import payroll.employees.SalariedEmployee;

import java.util.ArrayList;

public class PaymentAgenda {
    private int[] dayWeekly = new int[5];// Agenda semanal - guarda o dia da semana
    private int[] dayBiweekly = new int[5];// Agenda bissemanal - guarda o dia da semana
    private int[] dayMonthly = new int[28];// Agenda mensal

    public static void payWeekly(ArrayList<Employee> employees, int weeklyDay)
    {
        for (int i = 0; i < employees.size(); ++i)
        {
            if(employees.get(i).getTypeOfAgenda().equals("SEMANAL") && employees.get(i).getDayWeeklyPay() == weeklyDay)
            {
                System.out.println("ID: " + employees.get(i).getIdEmployee() +
                        " | Nome: " + employees.get(i).getName() +
                        " | Salário: R$ " + ((HourlyEmployee )employees.get(i)).setLiquidSalariedEmployee() +
                        " | Método: " + employees.get(i).getTypeOfPayment() + "\n");
                ((HourlyEmployee )employees.get(i)).setSalaryDay();
                employees.get(i).setLiquidSalariedEmployee(0);
            }
        }
    }

    public static void payBiweekly(ArrayList<Employee> employees, int weeklyDay)
    {
        for (int i = 0; i < employees.size(); ++i)
        {
            if(employees.get(i).getTypeOfAgenda().equals("BISSEMANAL") && employees.get(i).getDayWeeklyPay() == weeklyDay)
            {
                System.out.println("ID: " + employees.get(i).getIdEmployee() +
                        " | Nome: " + employees.get(i).getName() +
                        " | Salário: R$ " +((CommissionEmployee)employees.get(i)).setLiquidSalariedEmployee() +
                        " | Método: " + employees.get(i).getTypeOfPayment() + "\n");
                employees.get(i).setLiquidSalariedEmployee(0);
            }
        }
    }

    public static void payMonthly(ArrayList<Employee> employees, int dataPay)
    {
        for (int i = 0; i < employees.size(); ++i)
        {
            if(employees.get(i).getTypeOfAgenda().equals("MENSAL") && employees.get(i).getDataPay() == dataPay)
            {
                System.out.println("ID: " + employees.get(i).getIdEmployee() +
                        " | Nome: " + employees.get(i).getName() +
                        " | Salário: R$ " +((SalariedEmployee)employees.get(i)).setLiquidSalariedEmployee() +
                        " | Método: " + employees.get(i).getTypeOfPayment() + "\n");
                employees.get(i).setLiquidSalariedEmployee(0);
            }
        }
    }
}
