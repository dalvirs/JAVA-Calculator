package ca.bcit.comp2601;

/** @author Dalvir Chiount*/
public abstract class AbstractOperator
            implements Operator {
    public AbstractOperator() {
    }

    /**
     * @param a: First Operand
     * @param b: Second Operand
     * @return: Return result based on the operator
     */
    @Override
    public Integer apply (final Integer a, final Integer b) {
        {
            final Integer result;

            if (a == null) {
                throw new IllegalArgumentException("operand cannot be null");
            }

            if (b == null) {
                throw new IllegalArgumentException("operand cannot be null");
            }

            result = doApply(a, b);

            return result;
        }
    }

    protected abstract Integer doApply(Integer operandA,
                                        Integer operandB);

}
