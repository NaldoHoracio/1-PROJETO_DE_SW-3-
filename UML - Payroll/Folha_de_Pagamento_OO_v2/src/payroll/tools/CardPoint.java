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

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardPoint {
    private LocalDate hourIn;// Hora de entrada
    private LocalDate hourOut;// Hora de saída

    public void setHourIn(String hourInEmp)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Submeta o cartão de ponto com a data e a hora de entrada (dd/hh/yyyy hh:mm):");
        hourInEmp = input.nextLine();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.hourIn = LocalDate.parse(hourInEmp, formatDate);
    }
}
