package paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventanas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JButton btnNewButton_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventanas frame = new Ventanas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ventanas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        btnNewButton_1 = new JButton("Click Aqui");
        contentPane.add(btnNewButton_1);

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                btnNewButton_1.setEnabled(false);
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        Ventanas2 frame = new Ventanas2(Ventanas.this);
                        frame.setVisible(true);
                       
                    }
                });
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                btnNewButton_1.setEnabled(true); 
            }
        });
    }
}
