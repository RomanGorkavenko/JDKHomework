package ru.gb.jdk.homework.sem5.decision_first;

/**
 * Решение №2.
 * Есть пять философов (потоки), которые могут либо
 * обедать (выполнение кода) либо размышлять
 * (ожидание).
 * Каждый философ должен пообедать три раза. Каждый
 * прием пищи длиться 500 миллисекунд
 * После каждого приема пищи философ должен
 * размышлять
 * Не должно возникнуть общей блокировки
 * Философы не должны есть больше одного раза подряд
 */
public class MainWaitNotify {

    private final Object monitor = new Object();

    public static void main(String[] args) {
        MainWaitNotify waitNotify = new MainWaitNotify();
        for (int i = 0; i < 5; i++) {
            new Thread(waitNotify::action).start();
        }
    }

    public void action() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + " начал обедать раз " + (i + 1));
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + " по обедал раз " + (i + 1));
                    System.out.println(Thread.currentThread().getName() + " начал медитировать раз " + (i + 1));
                    monitor.wait(600L);
                    System.out.println(Thread.currentThread().getName() + " по медитировал раз " + (i + 1));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
