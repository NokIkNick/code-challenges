package com.wintherdev.numbers.alarmclock;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class AlarmClock extends JFrame {
    
    private float time;

    public AlarmClock(){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth() / 3;
        int height = (int) screenSize.getHeight() / 3;
        setSize(width, height);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setSize( width / 2, height / 2);
        mainPanel.setBackground(new Color(200));
        
        
        
        
        

        add(mainPanel);
        setLayout(null);
        setVisible(true);

    }
}
