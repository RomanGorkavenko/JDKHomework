package ru.gb.jdk.homework.sem2.developer;

import java.util.Arrays;
import java.util.List;

/**
 * Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
 * которые в состоянии писать серверный код, фронтендеры, которые могут программировать экранные формы,
 * и фуллстэк разработчики, совмещающие в себе обе компетенции.
 * Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать
 * все его методы.
 *
 * Дописать третье задание таким образом, чтобы в идентификатор типа Developer записывался объект Frontender,
 * и далее вызывался метод developGUI(), не изменяя существующие интерфейсы, только код основного класса.
 */

public class Main {

    public static void main(String[] args) {
        Developer developerFullStack = new DeveloperFull();
        Developer developerBack = new DeveloperBack();
        Developer developerFront = new DeveloperFront();

        List<Developer> developersBackEnder = Arrays.asList(developerFullStack, developerBack, developerFront);

        for (Developer dev: developersBackEnder) {
            dev.task();
        }

//        developerFullStack.createServer();
//        developerFullStack.createFront();
//
//        developerBack.createServer();
    }

}

interface BackEnder {
    void createServer();
}

interface FrontEnder {
    void createFront();
}

interface FullStack extends BackEnder, FrontEnder {

}

interface Developer {
    void task();
}

class DeveloperFull implements FullStack, Developer {

    @Override
    public void createServer() {
        System.out.println("Сделал сервер");
    }

    @Override
    public void createFront() {
        System.out.println("Покрасил кнопку в красный");
    }

    @Override
    public void task() {
        createFront();
        createServer();
    }
}

class DeveloperBack implements BackEnder, Developer {

    @Override
    public void createServer() {
        System.out.println("Уронил сервер!");
    }

    @Override
    public void task() {
        createServer();
    }
}

class DeveloperFront implements FrontEnder, Developer {

    @Override
    public void createFront() {
        System.out.println("Покрасил кнопку в синий");
    }

    @Override
    public void task() {
        createFront();
    }
}
