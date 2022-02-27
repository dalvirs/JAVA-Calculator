package ca.bcit.comp2601;

/** @author Dalvir Chiount*/
public interface AbstractOperatorFactory
{
    Operator getOperator(String op) throws InvalidOperatorException;
}
