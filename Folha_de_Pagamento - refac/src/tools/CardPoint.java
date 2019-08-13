/**!
 * @className employees.CardPoint.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package tools;

import employees.HourlyEmployee;

import java.util.Scanner;


public class CardPoint {

    public static void setCardPoint(HourlyEmployee empHourly)
    {
        Scanner input = new Scanner(System.in);
        double hours, hoursIn, hoursOut;
        System.out.println("Digite a hora de entrada (Formato de 24h - HH):");
        hoursIn = input.nextInt();
        System.out.println("Digite a hora de saida: (Formato de 24h - HH):");
        hoursOut = input.nextInt();
        if(hoursIn > hoursOut)
        {
            System.out.println("Hora de entrada maior que a hora de saída!");
        }else{
            hours = hoursOut - hoursIn;
            if(hours > 24)
            {
                System.out.println("Impossível! O funcionário trabalhou mais que 24h no dia!");
            }else{
                System.out.println("Horas trabalhadas: " + hours);
                empHourly.setSalaryDay(hours);
                System.out.println("Cartão de ponto inserido com sucesso!");
            }
        }
    }
}
