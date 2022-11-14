package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow {
    private JFrame frame;

    public GameWindow(GamePainter gamePainter) {

        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePainter);

        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(950, 740));
        frame.setSize(950, 740);

        frame.setTitle("2D Demo");
        frame.setBackground(Color.black);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
//        frame.setAlwaysOnTop(true);


    }

}