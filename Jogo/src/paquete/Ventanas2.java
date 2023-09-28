package paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventanas2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Ventanas parentVentana;

    public Ventanas2(Ventanas parent) {
        this.parentVentana = parent; 
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnNewButton_2 = new JButton("volver");
        contentPane.add(btnNewButton_2);

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                parentVentana.btnNewButton_1.setEnabled(true);
            }
        });
    }
}
