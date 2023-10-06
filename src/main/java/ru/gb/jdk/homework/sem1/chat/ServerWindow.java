package ru.gb.jdk.homework.sem1.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Окно сервера.
 */
public class ServerWindow extends JFrame{
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_POSX = 400;
    private static final int WINDOW_POSY = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JPanel top = new JPanel(new GridLayout(1, 2));
    private boolean isServerWorker;

    private ServerWindow() {
        isServerWorker = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorker = false;
                log.append("Server stopped: " + isServerWorker + "\n");
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorker = true;
                log.append("Server started: " + isServerWorker + "\n");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Chat Server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(2, 1));

        top.add(btnStart);
        top.add(btnStop);

        add(top);

        JScrollPane scrollPane = new JScrollPane(log);

        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerWindow();
    }
}
