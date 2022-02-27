package ca.bcit.comp2601;

/** @author D'Arcy Smith, Dalvir Chiount*/
public class Calculator
{
    /**
     * @param calculatorType: type of the calculator. Basic calculator or extended operator.
     * @param operandA: First number to be calculated.
     * @param operatorString: operator. +, -, /, *, ^
     * @param operandB: Second number
     * @return: Returns result depends upon the operator.
     * @throws InvalidOperatorException: If wrong string is given as operator or calculator type.
     */
    public Integer calculate(final String calculatorType,
                             final Integer operandA,
                             final String  operatorString,
                             final Integer operandB)
            throws InvalidOperatorException
    {
        final Operator operator;
        final Integer  result;
        final AbstractOperatorFactory op;


        if(operandA == null)
        {
            throw new IllegalArgumentException("operandA cannot be null");
        }

        if(operandB == null)
        {
            throw new IllegalArgumentException("operandB cannot be null");
        }

        if(operatorString == null)
        {
            throw new IllegalArgumentException("operatorString cannot be null");
        }

        if (calculatorType.equalsIgnoreCase("Basic"))
        {
            op = new BasicOperatorFactory();
        }
        else if (calculatorType.equalsIgnoreCase("Extended"))
        {
            op = new ExtendedOperatorFactory();
        }

        else
        {
            throw new IllegalArgumentException("Invalid Operator Factory");
        }
        operator = op.getOperator(operatorString);
        result   = operator.perform(operandA, operandB);

        return result;
    }
}
