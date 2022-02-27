package ca.bcit.comp2601;


import java.util.function.BiFunction;

/** @author D'Arcy Smith */
public interface Operator
        extends BiFunction<Integer, Integer, Integer>
{
    /**
     * @param operandA: First Operand
     * @param operandB: Second Operand
     * @return: Returns the result depending upon the operator
     */
    default Integer perform(final Integer operandA,
                            final Integer operandB)
    {
        return apply(operandA, operandB);
    }
}
