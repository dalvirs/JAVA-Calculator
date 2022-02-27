package ca.bcit.comp2601;

/** @author Dalvir Chiount*/
public class ExponentOperator extends AbstractOperator
{
    /**
     * @param a: First Operand
     * @param b: Second Operand
     * @return: Returns First operand to the power second operand
     */
    @Override
    public Integer doApply (final Integer a, final Integer b)
    {
        return (int) Math.pow(a, b);
    }
}
