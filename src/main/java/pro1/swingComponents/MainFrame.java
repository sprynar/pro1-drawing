package pro1.swingComponents;

import pro1.drawingModel.Polyline;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    DisplayPanel displayPanel;
    private Polyline polyline = new Polyline(); // Nahrazuje staré proměnné stavu

    public MainFrame() {
        java.util.Collections.list(UIManager.getDefaults().keys()).forEach(key -> { if (UIManager.get(key) instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, new javax.swing.plaf.FontUIResource(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 20))); });
        this.setTitle("Petrův úžasný projekt"); // Původní titulek
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.displayPanel.setDrawable(polyline);
        this.add(this.displayPanel, BorderLayout.CENTER);

        OptionsPanel options = new OptionsPanel(this);
        this.add(options, BorderLayout.WEST);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                polyline.addPoint(e.getPoint());
                displayPanel.repaint();
            }
        });
    }

    public void setThickness(int thickness) {
        polyline.setThickness(thickness);
        displayPanel.repaint();
    }

    public void setRed(boolean isRed) {
        polyline.setRed(isRed);
        displayPanel.repaint();
    }

    public void undo() {
        polyline.zpet();
        displayPanel.repaint();
    }

    public void reset() {
        polyline.reset();
        displayPanel.repaint();
    }
}