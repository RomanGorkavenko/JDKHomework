package ru.gb.jdk.homework.sem2.server;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * было описано окно сервера приложения, содержащее две кнопки (старт и стоп) и текстовое поле журнала.
 * Необходимо вынести логику работы сервера
 * в класс ChatServer, а в обработчиках кнопок оставить только логику нажатия кнопки и
 * журналирования сообщений от сервера.
 * Для достижения цели необходимо описать интерфейс «слушатель сервера», с методом
 * «получить сообщение», вызывать его с одной стороны, и реализовать с другой.
 *
 * Создать интерфейсы ServerSocketThreadListener и SocketThreadListener, содержащие методы,
 * соответствующие событиям сервера и клиента чата. Реализовать созданные интерфейсы простым логированием.
 * Со стороны клиента – только SocketThreadListener,
 * со стороны сервера – оба интерфейса.
 */

public class ChatServer implements ServerSocketThreadListener, SocketThreadListener {
    private final IServerListener serverListener;

    private final SocketThreadListener socketListener;

    private final ServerWindow serverWindow = new ServerWindow(this);

    private Logger logger = Logger.getLogger(ChatServer.class.getName());

    public ChatServer() {
        this.serverListener = serverWindow;
        this.socketListener = serverWindow;
    }

    @Override
    public void start() {
        String message = "Server started\n";
        serverListener.onMessageReceived(message);
        socketListener.action("btnStart");
        logger.log(Level.INFO, message);
    }

    @Override
    public void stop() {
        String message = "Server stopped\n";
        serverListener.onMessageReceived(message);
        socketListener.action("btnStop");
        logger.log(Level.INFO, message);
    }

    @Override
    public void action(String message) {
        logger.log(Level.INFO, "Дана команда " + message + " серверу");
    }
}
