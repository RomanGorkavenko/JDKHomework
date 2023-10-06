package ru.gb.jdk.homework.sem1.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Окно клиента.
 */
public class ChatClient extends JFrame {
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_POS_X = 700;
    private static final int WINDOW_POS_Y = 200;

    private final JPanel panSet = new JPanel(new GridLayout(2, 3));
    private final JTextField loginField = new JTextField("login");
    private final JTextField passField = new JTextField("pass");
    private final JTextField ipField = new JTextField("ip");
    private final JTextField portField = new JTextField("port");
    private final JButton btnConnect = new JButton("Connect");
    private final JPanel panMid = new JPanel(new BorderLayout());
    private final JTextArea fieldChat = new JTextArea();
    private final JList<String> listUsers = new JList<>();
    private final JScrollPane scrollPane = new JScrollPane(fieldChat);
    private final JPanel panChat = new JPanel(new BorderLayout());
    private final JTextField fieldMessage = new JTextField("Message");
    private final JButton btnSend = new JButton("Send");

    /**
     * Приватный конструктор.
     * Тут происходит вся инициализация.
     */
    private ChatClient() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Client");
        setResizable(false);

        panSet.add(loginField);
        panSet.add(passField);
        panSet.add(ipField);
        panSet.add(portField);
        panSet.add(btnConnect);
        add(panSet, BorderLayout.NORTH);

        fieldChat.setEditable(false);
        String[] users = {"Dima", "Katya", "Sasha", "Vasya", "Ignat"};
        listUsers.setListData(users);

        panMid.add(scrollPane, BorderLayout.CENTER);
        panMid.add(listUsers, BorderLayout.EAST);
        add(panMid);

        panChat.add(fieldMessage, BorderLayout.CENTER);
        panChat.add(btnSend, BorderLayout.EAST);
        add(panChat, BorderLayout.SOUTH);

        action();

        setVisible(true);
    }

    /**
     * Метод описывает действия кнопок.
     * При нажатии на ENTER отправляем сообщение.
     * При нажатии на кнопку SEND отправляем сообщение.
     * При закрытии окна сохраняется история чата в файл.
     * При нажатии на кнопку CONNECT загружается история чата.
     */
    private void action() {
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldChat.append(String.format("%s\n", fieldMessage.getText()));
            }
        });

        fieldMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    fieldChat.append(String.format("%s\n", fieldMessage.getText()));
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
                    fieldChat.write(writer);
                }catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });

        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        fieldChat.append(line + "\n");
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}
