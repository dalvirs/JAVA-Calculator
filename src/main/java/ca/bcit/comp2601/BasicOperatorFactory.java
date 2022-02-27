package ca.bcit.comp2601;

/** @author Dalvir Chiount*/
public class BasicOperatorFactory
        implements AbstractOperatorFactory
{
    /**
     * @param op: Operator type: +, -, /, *
     * @return: returns instance of operator depending on the type.
     * @throws InvalidOperatorException: if wrong operator is given
     */
    @Override
    public Operator getOperator(String op) throws InvalidOperatorException {
        final Operator operator;

        operator = switch(op)
                {
                    case "+" -> new AdditionalOperator();
                    case "-" -> new SubtractionOperator();
                    case "*" -> new MultiplicationOperator();
                    case "/" -> new DivisionOperator();
                    default -> throw new InvalidOperatorException(op);
                };

        return operator;
    }
}
