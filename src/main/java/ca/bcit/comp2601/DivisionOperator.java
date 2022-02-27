package ca.bcit.comp2601;

/** @author D'Arcy Smith, Dalvir Chiount*/
public class DivisionOperator extends AbstractOperator
{
    /**
     * @param a: First Operand
     * @param b: Second Operand
     * @return: Return first operand / second operand
     */
    @Override
    public Integer doApply (final Integer a, final Integer b)
    {
        return a / b;
    }
}

