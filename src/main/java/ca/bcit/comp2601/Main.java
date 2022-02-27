package ca.bcit.comp2601;

import javax.swing.*;

/** @author D'Arcy Smith, Dalvir Chiount*/
public class Main
{
    /**
     * Main class to run the program
     */
    public static void main(final String[] argv)
    {
        SwingUtilities.invokeLater(
                () ->
                {
                    final CalculatorFrame frame;

                    frame = CalculatorFrame.getInstance();
                    frame.init(0.25f, 0.5f);
                    frame.setVisible(true);
                });
    }
}
