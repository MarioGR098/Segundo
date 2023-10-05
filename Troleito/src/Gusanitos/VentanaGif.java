package Gusanitos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaGif extends JFrame {

    private static final long serialVersionUID = 1L;
    private String[] gifs;
    private int currentIndex;

    public VentanaGif(String[] gifs, int index) {
        this.gifs = gifs;
        this.currentIndex = index;

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(450, 300);

        // Generar coordenadas aleatorias para la ventana
        Random rand = new Random();
        int x = rand.nextInt(800); 
        int y = rand.nextInt(600); 
        setLocation(x, y);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Reproducir música al abrir la ventana
                reproducirMusica("/resources/musica.wav");
                mostrarNuevaVentana();
            }
        });

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource(gifs[currentIndex])));
        contentPane.add(lblNewLabel);
    }

    private void mostrarNuevaVentana() {
        currentIndex = (currentIndex + 1) % gifs.length;
        VentanaGif nuevaVentana = new VentanaGif(gifs, currentIndex);
        nuevaVentana.setVisible(true);
    }

    private void reproducirMusica(String rutaMusica) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResource(rutaMusica)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


