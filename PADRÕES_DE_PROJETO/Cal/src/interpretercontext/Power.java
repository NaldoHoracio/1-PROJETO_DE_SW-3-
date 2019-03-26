package interpretercontext;

public class Power implements Operate
{
    private Operate left;
    private Operate right;

    public Power(Operate left, Operate right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpreterContext()
    {
        return this.left.interpreterContext() *  this.left.interpreterContext();
    }
}

