package paquete;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Botones extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Botones frame = new Botones();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Botones() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton Boton1 = new JButton("1");
        contentPane.add(Boton1);

        JButton Boton2 = new JButton("2");
        contentPane.add(Boton2);

        JButton Boton3 = new JButton("3");
        contentPane.add(Boton3);

        JButton Salir = new JButton("salir");
        contentPane.add(Salir);

        Boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("Número 1");
            }
        });
        Boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("Número 2");
            }
        });
        Boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("Número 3");
            }
        });
        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_1) {
                    setTitle("Número 1");
                } else if (keyCode == KeyEvent.VK_2) {
                    setTitle("Número 2");
                } else if (keyCode == KeyEvent.VK_3) {
                    setTitle("Número 3");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        setFocusable(true);
        requestFocus();
    }
}
