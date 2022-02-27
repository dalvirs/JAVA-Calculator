package ca.bcit.comp2601;

/** @author D'Arcy Smith, Dalvir Chiount*/
public class AdditionalOperator extends AbstractOperator
{
    /**
     * @param a: First Operand
     * @param b: Second Operand
     * @return: Return addition of two operands
     */
    @Override
    public Integer doApply (final Integer a, final Integer b)
    {
        return a + b;
    }
}

