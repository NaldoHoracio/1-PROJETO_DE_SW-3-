import java.util.Scanner;

public class MaximumFinder
{
    public void determineMaximum()
    {
        // Cria o Scanner para entrada via janela de comando
        Scanner var1 = new Scanner(System.in);

        // Mensagem na janela de comando
        System.out.print("Enter three floating-point values separated by spaces: ");
        // Lendo os 3 valores
        double var2 = var1.nextDouble();
        double var3 = var1.nextDouble();
        double var4 = var1.nextDouble();

        // Determina o valor máximo
        //double result = this.maximum(var2, var3, var4);
        double result = maximum(var2, var3, var4);

        // Exibe o valor máximo
        System.out.println("Maximum is: " + result);
    }

    public double maximum(double x, double y, double z)
    {
        double maximumValue = x;// Supõe x como maior valor inicial

        if(y > maximumValue)
        {
            maximumValue = y;
        }
        else if(z > maximumValue)
        {
            maximumValue = z;
        }

        return maximumValue;
    }// Fim do método máximum
}// Fim da classe MaximumFinder

