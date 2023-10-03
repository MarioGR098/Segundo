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
import javax.swing.border.EmptyBorder;

public class Calculadora extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String entrada = "";
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculadora frame = new Calculadora();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Calculadora() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 600);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 24));
        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.NORTH);

        JPanel botones = new JPanel(new GridLayout(5, 4)); 
        JButton Boton1 = new JButton("1");
        JButton Boton2 = new JButton("2");
        JButton Boton3 = new JButton("3");
        JButton Boton4 = new JButton("4");
        JButton Boton5 = new JButton("5");
        JButton Boton6 = new JButton("6");
        JButton Boton7 = new JButton("7");
        JButton Boton8 = new JButton("8");
        JButton Boton9 = new JButton("9");
        JButton Boton0 = new JButton("0"); 
        JButton Botonmenos = new JButton("-");
        JButton Botonmas = new JButton("+");
        JButton Botonpor = new JButton("*");
        JButton Botonentre = new JButton("/");
        JButton Botonigual = new JButton("=");
        JButton BotonC = new JButton("C");

        contentPane.add(botones, BorderLayout.CENTER);
        botones.add(Boton1);
        botones.add(Boton2);
        botones.add(Boton3);
        botones.add(Boton4);
        botones.add(Boton5);
        botones.add(Boton6);
        botones.add(Boton7);
        botones.add(Boton8);
        botones.add(Boton9);
        botones.add(Boton0);
        botones.add(Botonmenos);
        botones.add(Botonmas);
        botones.add(Botonpor);
        botones.add(Botonentre);
        botones.add(Botonigual);
        botones.add(BotonC);

       
        ActionListener numeroActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                String buttonText = clickedButton.getText();
                entrada += buttonText;
                textArea.setText(entrada);
            }
        };

        Boton1.addActionListener(numeroActionListener);
        Boton2.addActionListener(numeroActionListener);
        Boton3.addActionListener(numeroActionListener);
        Boton4.addActionListener(numeroActionListener);
        Boton5.addActionListener(numeroActionListener);
        Boton6.addActionListener(numeroActionListener);
        Boton7.addActionListener(numeroActionListener);
        Boton8.addActionListener(numeroActionListener);
        Boton9.addActionListener(numeroActionListener);
        Boton0.addActionListener(numeroActionListener); 

       
        ActionListener operadorActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                String buttonText = clickedButton.getText();
                entrada += " " + buttonText + " ";
                textArea.setText(entrada);
            }
        };

        Botonmenos.addActionListener(operadorActionListener);
        Botonmas.addActionListener(operadorActionListener);
        Botonpor.addActionListener(operadorActionListener);
        Botonentre.addActionListener(operadorActionListener);

        Botonigual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] partes = entrada.split(" ");
                    double resultado = Double.parseDouble(partes[0]);
                    for (int i = 1; i < partes.length; i += 2) {
                        String operador = partes[i];
                        double operando = Double.parseDouble(partes[i + 1]);
                        if (operador.equals("+")) {
                            resultado += operando;
                        } else if (operador.equals("-")) {
                            resultado -= operando;
                        } else if (operador.equals("*")) {
                            resultado *= operando;
                        } else if (operador.equals("/")) {
                            resultado /= operando;
                        }
                    }
                    entrada = Double.toString(resultado);
                    textArea.setText(entrada);
                } catch (Exception ex) {
                    entrada = "Error";
                    textArea.setText(entrada);
                }
            }
        });

        BotonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                entrada = "";
                textArea.setText(entrada);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                entrada += keyChar;
                textArea.setText(entrada);
            }
        });

        setFocusable(true);
        requestFocus();
    }
}

