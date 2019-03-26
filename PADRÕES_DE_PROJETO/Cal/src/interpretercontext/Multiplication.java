package interpretercontext;

public class Multiplication implements Operate {
    private Operate left;
    private Operate right;


    public Multiplication(Operate left, Operate right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpreterContext()
    {
        return this.left.interpreterContext() * this.right.interpreterContext();
    }
}

