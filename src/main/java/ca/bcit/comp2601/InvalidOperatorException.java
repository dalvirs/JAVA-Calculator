package ca.bcit.comp2601;

/** @author D'Arcy Smith */
public class InvalidOperatorException extends Exception
{
    /**
     * @param name: message to show when program throws error
     */
    public InvalidOperatorException(final String name)
    {
        super(name);
    }
}