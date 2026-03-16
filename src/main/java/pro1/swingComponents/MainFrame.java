package pro1.swingComponents;

import pro1.Main;
import pro1.drawingModel.*;
import pro1.drawingModel.Rectangle;
import pro1.utils.ColorUtils;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    DisplayPanel displayPanel;
    private int x;
    private int y;
    private String color = ColorUtils.randomColor();

    public MainFrame() {
        this.setTitle("Petrův úžasný projekt");
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        OptionsPanel options = new OptionsPanel(this);
        this.add(options, BorderLayout.WEST);

        this.displayPanel.addMouseListener(new MouseAdapter() {

            @Override
            //lambda výraz
            public void mousePressed(MouseEvent e) {
                MainFrame.this.x = e.getX();
                MainFrame.this.y = e.getY();
                MainFrame.this.color = ColorUtils.randomColor();
                MainFrame.this.showExample();
            }
        });
    }
    public void showExample(){
        MainFrame.this.displayPanel.setDrawable(MainFrame.this.example());
    }
    public void setColor(String color){
        this.color = color;
    }
    private Drawable example() {
        // var d1 = new Ellipse(0, 0, 150, 250, color);
        var d2 = new Text(0, 0, color);
        var d3 = new Line(0, 0,170,170,3, color);
        return new Group(new Drawable[]{d2, d3}, this.x, y, 40, 1, 1);
    }
}