package ca.bcit.comp2601;

/**
 * Class with singleton design pattern.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** @author D'Arcy Smith, Dalvir Chiount*/
public class CalculatorFrame
    extends JFrame
{
    private static final CalculatorFrame instance = new CalculatorFrame();
    private final Calculator calculator;
    private JTextField answerLabel;
    private String firstNumber;
    private String operator;

    /**
     * method to access the instance of CalculatoFrame class.
     * @return
     */
    public static CalculatorFrame getInstance() {
        return instance;
    }

    /**
     * private constructor of the class
     */
    private CalculatorFrame()
    {
        this("Calculator");
    }

    /**
     *
     * @param name: name for the calculator
     */
    private CalculatorFrame(final String name)
    {
        this(name,
             new Calculator());
    }

    /**
     *
     * @param name: name for the claculator
     * @param calc: instance of the Calculator class
     */
    private CalculatorFrame(final String     name,
                           final Calculator calc)
    {
        super(name);

        calculator = calc;
    }

    /**
     *
     * @param widthPercent: Width of the calculator in percentage to the screen size.
     * @param heightPercent: Height of the calculator in percentage to the screen size.
     */
    public void init(final float widthPercent,
                     final float heightPercent)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        position(widthPercent, heightPercent);
        setLayout(new BorderLayout());
        createAnswerArea();
        createButtonArea();
    }

    /**
     * @param widthPercent: Width of the calculator in percentage to the screen size.
     * @param heightPercent: Height of the calculator in percentage to the screen size.
     */
    private void position(final float widthPercent,
                          final float heightPercent)
    {
        final Dimension screenSize;
        final int       width;
        final int       height;
        final int       x;
        final int       y;

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width      = (int)(screenSize.width * widthPercent);
        height     = (int)(screenSize.height * heightPercent);
        x          = (screenSize.width - width) / 2;
        y          = (screenSize.height - height) / 2;
        setBounds(x, y, width, height);
    }

    /**
     * Method to create Text box for answer area.
     */
    private void createAnswerArea()
    {
        answerLabel = new JTextField("0");
        add(answerLabel, BorderLayout.NORTH);
    }

    /**
     * Method to create buttons of the calculator
     */
    private void createButtonArea()
    {
        final JPanel buttonPanel;

        buttonPanel = new JPanel(new GridLayout(5, 3, 1, 1));
        add(buttonPanel, BorderLayout.CENTER);

        for(int i = 0; i < 10; i++)
            {
                final String buttonName;

                buttonName = Integer.toString(i);
                createAndAddButton(buttonPanel,
                        buttonName,
                        this::addNumber);
            }

            createAndAddButton(buttonPanel, "+", this::selectOperator);
            createAndAddButton(buttonPanel, "-", this::selectOperator);
            createAndAddButton(buttonPanel, "*", this::selectOperator);
            createAndAddButton(buttonPanel, "/", this::selectOperator);
            createAndAddButton(buttonPanel, "^", this::selectOperator);
            createAndAddButton(buttonPanel, "=", this::calculate);

    }

    /**
     * @param container: conatiner for button panel
     * @param label: Label of the button
     * @param listener: ActionListner for the buttons
     * @return: Returns Jbutton
     */
    private JButton createAndAddButton(final Container      container,
                                       final String         label,
                                       final ActionListener listener)
    {
        final JButton button;

        button = new JButton(label);
        container.add(button);

        if(listener != null)
        {
            button.addActionListener(listener);
        }

        return button;
    }

    /**
     * Method to create 1 to 9 buttons
     */
    private void addNumber(final ActionEvent event)
    {
        final String currentValueStr;
        final String newDigitStr;
        final String newValue;

        currentValueStr = answerLabel.getText();
        newDigitStr     = event.getActionCommand();

        if(currentValueStr.equals("0"))
        {
            newValue = newDigitStr;
        }
        else
        {
            newValue = currentValueStr + newDigitStr;
        }

        answerLabel.setText(newValue);
    }

    /**
     * Method to select operator
     */
    private void selectOperator(final ActionEvent event)
    {
        firstNumber = answerLabel.getText();
        operator    = event.getActionCommand();
        answerLabel.setText("0");
    }

    /**
     * Method to get result
     */
    private void calculate(final ActionEvent event)
    {
        final String secondNumber;

        secondNumber = answerLabel.getText();

        try
        {
            final int    value;
            final String newAnswer;

            value = calculator.calculate("Extended",
                                         Integer.parseInt(firstNumber),
                                         operator,
                                         Integer.parseInt(secondNumber));
            operator  = null;
            newAnswer = Integer.toString(value);
            answerLabel.setText(newAnswer);
            firstNumber = newAnswer;
        }
        catch(final InvalidOperatorException ex)
        {
            System.err.println("Bad operator");
            System.exit(1);
        }
    }
}
