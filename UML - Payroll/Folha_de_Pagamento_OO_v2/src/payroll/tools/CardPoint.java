/**!
 * @className payroll.tools.CardPoint.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-26
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package payroll.tools;

import payroll.employees.HourlyEmployee;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CardPoint {
    private double hourIn;// Hora de entrada
    private double hourOut;// Hora de saída

    public void setHourIn(String hourInEmp)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Submeta o cartão de ponto com a data e a hora de entrada (dd/hh/yyyy hh:mm):");
        hourInEmp = input.nextLine();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime hourInLDT = LocalDateTime.parse(hourInEmp, formatterDate);
        this.hourIn = hourInLDT.getHour();
    }

    public double getHourIn()
    {
        return hourIn;
    }

    public void setHourOut(String hourOutEmp)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Submeta o cartão de ponto com a data e a hora de saída (dd/hh/yyyy hh:mm):");
        hourOutEmp = input.nextLine();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime hourOutLDT = LocalDateTime.parse(hourOutEmp, formatterDate);
        this.hourOut = hourOutLDT.getHour();
    }

    public double getHourOut()
    {
        return hourOut;
    }
}
