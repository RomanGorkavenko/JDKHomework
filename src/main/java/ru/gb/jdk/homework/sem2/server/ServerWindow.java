package ru.gb.jdk.homework.sem2.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Окно сервера.
 */
public class ServerWindow extends JFrame implements IServerListener, SocketThreadListener {
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_POSX = 400;
    private static final int WINDOW_POSY = 300;

    Logger logger = Logger.getLogger(ServerWindow.class.getName());

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea logTextArea = new JTextArea();
    private final JPanel top = new JPanel(new GridLayout(1, 2));
    private boolean isServerWorker  = false;

    private final SocketThreadListener socketListener;
    private final ServerSocketThreadListener serverListener;

    public ServerWindow(ChatServer chatServer) {
        this.socketListener = chatServer;
        this.serverListener = chatServer;

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorker = false;
                socketListener.action("stop");
                serverListener.stop();
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorker = true;
                socketListener.action("start");
                serverListener.start();
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

        JScrollPane scrollPane = new JScrollPane(logTextArea);

        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void onMessageReceived(String message) {
        if (isServerWorker) {
            logTextArea.append(message);
        } else {
            logTextArea.append(message);
        }
    }

    @Override
    public void action(String message) {
        logger.log(Level.INFO, "Нажата кнопка " + message);
    }
}
