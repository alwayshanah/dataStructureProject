package postfixnotation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Casta
 */
public class PostfixNotation {
    private JTextField infixInputField;
    private JTextField valueAField, valueBField, valueCField, valueDField, valueEField;
    private JLabel postfixLabel, resultLabel;
    private JPanel postfixPanel, resultPanel;

    public PostfixNotation() {

        JFrame frame = new JFrame("Infix to Postfix Calculator");
        frame.setSize(800, 600);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10)); 

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel infixLabel = new JLabel("Enter Infix Expression:");
        mainPanel.add(infixLabel, gbc);

        gbc.gridx = 1;
        infixInputField = new JTextField(15);  
        mainPanel.add(infixInputField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Enter value for A:"), gbc);
        gbc.gridx = 1;
        valueAField = new JTextField(10);
        mainPanel.add(valueAField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Enter value for B:"), gbc);
        gbc.gridx = 1;
        valueBField = new JTextField(10);
        mainPanel.add(valueBField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Enter value for C:"), gbc);
        gbc.gridx = 1;
        valueCField = new JTextField(10);
        mainPanel.add(valueCField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Enter value for D:"), gbc);
        gbc.gridx = 1;
        valueDField = new JTextField(10);
        mainPanel.add(valueDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(new JLabel("Enter value for E:"), gbc);
        gbc.gridx = 1;
        valueEField = new JTextField(10);
        mainPanel.add(valueEField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        postfixPanel = new JPanel();
        postfixPanel.setBackground(new Color(255,165,0));
        postfixLabel = new JLabel("Postfix Notation: ");
        postfixPanel.add(postfixLabel);
        mainPanel.add(postfixPanel, gbc);

        gbc.gridy = 7;
        resultPanel = new JPanel();
        resultPanel.setBackground(new Color(255, 225, 0));
        resultLabel = new JLabel("Generated Result: ");
        resultPanel.add(resultLabel);
        mainPanel.add(resultPanel, gbc);

        gbc.gridy = 8;
        gbc.gridwidth = 1;
        JButton convertButton = new JButton("Convert to Postfix");
        mainPanel.add(convertButton, gbc);

        gbc.gridx = 1;
        JButton calculateButton = new JButton("Calculate Result");
        mainPanel.add(calculateButton, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String infixExpression = infixInputField.getText().replaceAll("\\s+", "");
                String postfixExpression = infixToPostfix(infixExpression);
                postfixLabel.setText("Postfix Notation: " + postfixExpression);
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String infixExpression = infixInputField.getText().replaceAll("\\s+", "");
                    String postfixExpression = infixToPostfix(infixExpression);
                    HashMap<Character, Integer> values = new HashMap<>();
                    values.put('A', Integer.parseInt(valueAField.getText()));
                    values.put('B', Integer.parseInt(valueBField.getText()));
                    values.put('C', Integer.parseInt(valueCField.getText()));
                    values.put('D', Integer.parseInt(valueDField.getText()));
                    values.put('E', Integer.parseInt(valueEField.getText()));

                    int result = evaluatePostfix(postfixExpression, values);
                    resultLabel.setText("Generated Result: " + result);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid inputs.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    private static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = Character.toUpperCase(expression.charAt(i));

            if (Character.isLetter(c)) {
                result.append(c).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString().trim();
    }

    private static int evaluatePostfix(String postfix, HashMap<Character, Integer> values) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isLetter(c)) {
                stack.push(values.get(c));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        new PostfixNotation();
    }
}
