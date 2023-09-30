package Gublins;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Principal extends JFrame {
    private JTextArea textArea;
    private JPanel contentPane;
    private String currentInput = "";

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor de la ventana principal
    public Principal() {
        // Configurar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 600);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Configurar el área de texto
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 24)); 
        JScrollPane scrollPane = new JScrollPane(textArea); 
        contentPane.add(scrollPane, BorderLayout.NORTH);

        // Configurar el panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));             

        // Agregar botones numéricos y de operación al panel
        for (int i = 1; i <= 9; i++) {
            addButton(buttonPanel, Integer.toString(i));
        }
        addButton(buttonPanel, "0");
        addButton(buttonPanel, "+");
        addButton(buttonPanel, "-");
        addButton(buttonPanel, "*");
        addButton(buttonPanel, "/");
        addButton(buttonPanel, "=");

        contentPane.add(buttonPanel, BorderLayout.CENTER);

        // Agregar botón "Salir"
        JButton Salir = new JButton("Salir");
        contentPane.add(Salir, BorderLayout.SOUTH);

        // Manejar la acción del botón "Salir"
        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Agregar KeyListener para capturar las teclas presionadas
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                currentInput += keyChar;
                textArea.setText(currentInput);
            }
        });

        setFocusable(true);
        requestFocus();
    }

    // Método para agregar botones al panel
    private void addButton(JPanel panel, String label) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                String buttonText = clickedButton.getText();
                if (buttonText.equals("=")) {
                    calculateResult();
                } else {
                    currentInput += buttonText;
                    textArea.setText(currentInput);
                }
            }
        });
        panel.add(button);
    }

    // Método para calcular el resultado de la expresión ingresada
    private void calculateResult() {
        try {
            // Filtrar caracteres no válidos y evaluar la expresión
            String input = currentInput.replaceAll("[^0-9+\\-*/.]", "");
            double result = eval(input);
            textArea.setText(Double.toString(result));
            currentInput = Double.toString(result);
        } catch (Exception e) {
            textArea.setText("Error: Entrada inválida");
            currentInput = "";
        }
    }

    // Método para evaluar una expresión matemática dada
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            double parseNumber() {
                int startPos = pos;
                while (Character.isDigit(ch) || ch == '.') {
                    nextChar();
                }
                String numberStr = str.substring(startPos, pos);
                return Double.parseDouble(numberStr);
            }

            double parseExpression() {
                double left = parseTerm();
                while (ch == '+' || ch == '-') {
                    char op = str.charAt(pos);
                    nextChar();
                    double right = parseTerm();
                    if (op == '+') {
                        left += right;
                    } else {
                        left -= right;
                    }
                }
                return left;
            }

            double parseTerm() {
                double left = parseFactor();
                while (ch == '*' || ch == '/') {
                    char op = str.charAt(pos);
                    nextChar();
                    double right = parseFactor();
                    if (op == '*') {
                        left *= right;
                    } else {
                        left /= right;
                    }
                }
                return left;
            }

            double parseFactor() {
                double result;
                if (ch == '(') {
                    nextChar();
                    result = parseExpression();
                    if (ch == ')') {
                        nextChar();
                    }
                } else {
                    result = parseNumber();
                }
                return result;
            }

            double parse() {
                nextChar();
                return parseExpression();
            }
        }.parse();
    }
}
