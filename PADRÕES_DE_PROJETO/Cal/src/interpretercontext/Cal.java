package interpretercontext;
import java.util.Scanner;

public class Cal
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        double a, b = 0.0;

        System.out.print("Enter the first number \n");
        a = in.nextDouble();
        System.out.print("And enter second  \n");
        b = in.nextDouble();

        System.out.print("Choose the operation  " +
                "\n1.Addition" +
                "\n2.Subtraction" +
                "\n3.Multiplication" +
                "\n4.Division" +
                "\n5.Power" +
                "\n#Please enter the number of operation \n");
        double somethin = in.nextDouble();
        double add = 1;
        double sub = 2;
        double mult = 3;
        double div = 4 ;
        double pow = 5;

        if (somethin == add)
        {
            Operate addition = new Addition(new Number(a), new Number(b));
            System.out.println(addition.interpreterContext());
        }
        else if (somethin == sub)
        {
            Operate subtraction = new Subtraction(new Number(a), new Number(b));
            System.out.println(subtraction.interpreterContext());
        }
        else if (somethin == mult)
        {
            Operate multiplication = new Multiplication(new Number(a), new Number(b));
            System.out.println(multiplication.interpreterContext());
        }
        else if (somethin == div)
        {
            Operate division = new Division(new Number(a), new Number(b));
            System.out.println(division.interpreterContext());
        }
        else if (somethin == pow)
        {
            System.out.println("Enhance A or B?" + "\n1.A" +"\n2.B");
            double enhance = in.nextDouble();
            double first = 1;
            double second = 2;
            if (enhance == first)
            {
                Operate result_pow = new Power(new Number(a), new Number(b));
                System.out.println(result_pow.interpreterContext());
            }
            else if (enhance == second)
            {
                Operate result_pow = new Power(new Number(b), new Number(a));
                System.out.println(result_pow.interpreterContext());
            }
        }
    }
}
