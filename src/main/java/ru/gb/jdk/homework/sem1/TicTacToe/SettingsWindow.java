package ru.gb.jdk.homework.sem1.TicTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 290;
    private static final int WINDOW_WIDTH = 350;
    private int mode = 0;
    private int sizeX = 0;
    private int sizeY = 0;
    private int winLength = 0;

    private static final String DESCRIPTION_SLIDER = "Установленный размер поля: ";
    private static final String DESCRIPTION_SLIDER_LENGTH = "Установленная длина: ";

    private static final int MIN_VALUE_SLIDER = 3;
    private static final int MAX_VALUE_SLIDER = 10;
    private static final int DEFAULT_VALUE_SLIDER = 3;

    private static final int VALUE_GRID_ROWS = 13;
    private static final int VALUE_GRID_COLS = 1;


    public SettingsWindow(GameWindow gameWindow) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        setTitle("Settings");

        setLayout(new GridLayout(VALUE_GRID_ROWS,VALUE_GRID_COLS));

        JRadioButton pve = getjRadioButton();

        Map<String, JSlider> result = slidersCollection();

        buttonStartGame(gameWindow, pve, result);
    }

    private void buttonStartGame(GameWindow gameWindow, JRadioButton pve, Map<String, JSlider> result) {
        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pve.isSelected()) {
                    mode = 1;
                }
                sizeX = result.get("sizeX").getValue();
                sizeY = result.get("sizeY").getValue();
                if (result.get("winLength").getValue() == DEFAULT_VALUE_SLIDER) {
                    winLength = result.get("sizeX").getValue();
                } else {
                    winLength = result.get("winLength").getValue();
                }

                gameWindow.startNewGame(mode, sizeX, sizeY, winLength);
                setVisible(false);
            }
        });

        add(btnStart);
    }

    private JRadioButton getjRadioButton() {
        add(new JLabel("Выберите режим игры"));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton pvp = new JRadioButton("Человек против человека");
        JRadioButton pve = new JRadioButton("Человек против компьютера");

        buttonGroup.add(pvp);
        buttonGroup.add(pve);

        add(pvp);
        add(pve);
        return pve;
    }

    private Map<String, JSlider> slidersCollection() {
        Map<String, JSlider> result = new HashMap<>();

        JLabel labelX = new JLabel("Выберите размеры поля по X");
        add(labelX);
        JLabel labelCurrentX = new JLabel(DESCRIPTION_SLIDER);
        add(labelCurrentX);

        JSlider sliderX = new JSlider(MIN_VALUE_SLIDER, MAX_VALUE_SLIDER, DEFAULT_VALUE_SLIDER);
        sliderX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelCurrentX.setText(DESCRIPTION_SLIDER + sliderX.getValue());
            }
        });

        add(sliderX);

        JLabel labelY = new JLabel("Выберите размеры поля по Y");
        add(labelY);
        JLabel labelCurrentY = new JLabel(DESCRIPTION_SLIDER);
        add(labelCurrentY);

        JSlider sliderY = new JSlider(MIN_VALUE_SLIDER, MAX_VALUE_SLIDER, DEFAULT_VALUE_SLIDER);
        sliderY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelCurrentY.setText(DESCRIPTION_SLIDER + sliderY.getValue());
            }
        });

        add(sliderY);

        JLabel labelLength = new JLabel("Выберите длину для победы");
        add(labelLength);
        JLabel labelCurrentLength = new JLabel(DESCRIPTION_SLIDER_LENGTH);
        add(labelCurrentLength);

        JSlider sliderLength = new JSlider(MIN_VALUE_SLIDER, MAX_VALUE_SLIDER, DEFAULT_VALUE_SLIDER);
        sliderLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelCurrentLength.setText(DESCRIPTION_SLIDER_LENGTH + sliderLength.getValue());
            }
        });

        add(sliderLength);

        result.put("sizeX", sliderX);
        result.put("sizeY", sliderY);
        result.put("winLength", sliderLength);

        return result;
    }
}
