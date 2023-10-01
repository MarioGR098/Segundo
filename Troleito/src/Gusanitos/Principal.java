package Gusanitos;

import java.awt.EventQueue;

public class Principal {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String[] gifs = { "/resources/flip.gif", "/resources/meditate.gif", "/resources/tenor.gif" , "/resources/dance.gif" , "/resources/dream.gif", "/resources/fumon.gif", "/resources/funny.gif", "/resources/jaja.gif", "/resources/jefe.gif"     };
                    VentanaGif frame = new VentanaGif(gifs, 0);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


