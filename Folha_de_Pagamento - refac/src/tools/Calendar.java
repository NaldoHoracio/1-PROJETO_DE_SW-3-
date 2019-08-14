/**!
 * @className tools.Calendar.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package tools;

public class Calendar {

    public static boolean lastDayMonth (int year, int month, int day){

        if ((day == 31) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
        {
            return true;
        }
        else if ((day == 30) && (month == 4 || month == 6 || month == 9 || month == 11))
        {
            return true;
        }
        else if ((day == 28) && (month == 2) && (year % 4 != 0))// Verifca se é BISSEXTO
        {
            return true;
        }
        else if ((day == 29) && (year == 2) && (year % 4 == 0))// VERIFICA SE É BISSEXTO
        {
            return true;
        }
        return false;
    }
}
