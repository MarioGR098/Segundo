package paquete;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdivinaElNumero extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblMensaje;
    private JLabel lblPista;
    private int numeroAleatorio;
    private int intentos;
	private static final long serialVersionUID = 1L;
	private JButton btnAdivinar;
	private JButton btnReiniciar;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdivinaElNumero frame = new AdivinaElNumero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdivinaElNumero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		textField = new JTextField();
		 textField.setBounds(20, 60, 100, 20);
	        contentPane.add(textField);
	        textField.setColumns(10);
	        
	        btnReiniciar = new JButton("Reiniciar");
	         btnAdivinar = new JButton("Adivinar");
	        btnAdivinar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	         
	                adivinarNumero();
	            }
	        });
	        
	        
	  
	        btnAdivinar.setBounds(140, 60, 90, 20);
	        contentPane.add(btnAdivinar);

	        lblPista = new JLabel("");
	        lblPista.setBounds(20, 100, 350, 20);
	        contentPane.add(lblPista);
	        
	        
	        Random random= new Random();
	       numeroAleatorio = random.nextInt(100)+1;
	         intentos = 0;
	         }
	        
	        public void adivinarNumero() {
	        	
	       String suposicionTexto = textField.getText();
	            try {
	                int suposicion = Integer.parseInt(suposicionTexto);
	                intentos++;
if(intentos == 7) {
	 lblPista.setText("Fallaste el limite era de: " + intentos + " intentos.");
	 btnAdivinar.setEnabled(false);
	 contentPane.add(btnReiniciar);
     btnReiniciar.setEnabled(true);
	 btnReiniciar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             btnReiniciar.setEnabled(false);
             btnAdivinar.setEnabled(true);
       	  Random random= new Random();
    	  numeroAleatorio = random.nextInt(100)+1;
          intentos = 0;
         }
     });

      

}else {
	                if (suposicion < numeroAleatorio) {
	                    lblPista.setText("El número es mayor. Sigue intentando.LLevas "+ intentos+ " intentos");
	                    
	                } else if (suposicion > numeroAleatorio) {
	                    lblPista.setText("El número es menor. Sigue intentando.LLevas "+ intentos+ " intentos");
	                    
	                } else {
	                    lblPista.setText("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
	                }
	            }} catch (NumberFormatException e) {
	                lblPista.setText("Por favor, ingresa un número válido.");
	            }
	}
	        }

