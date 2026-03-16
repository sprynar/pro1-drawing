package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final MainFrame parent;

    public OptionsPanel(MainFrame parent) {
        this.parent = parent;
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(250, 0));

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        this.add(new JLabel("Tloušťka čáry:"));
        JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 1, 20, 10);
        thicknessSlider.setPreferredSize(new Dimension(200, 50));
        thicknessSlider.setBackground(Color.LIGHT_GRAY);
        thicknessSlider.addChangeListener(e -> this.parent.setThickness(thicknessSlider.getValue()));
        this.add(thicknessSlider);

        JCheckBox colorCheckBox = new JCheckBox("Aktivní", true);
        colorCheckBox.setBackground(Color.LIGHT_GRAY);
        colorCheckBox.setPreferredSize(new Dimension(200, 30));
        colorCheckBox.addActionListener(e -> this.parent.setRed(colorCheckBox.isSelected()));
        this.add(colorCheckBox);

        JButton btnUndo = new JButton("Zpět");
        btnUndo.setPreferredSize(new Dimension(200, 40));
        btnUndo.addActionListener(e -> this.parent.undo());
        this.add(btnUndo);

        JButton btnReset = new JButton("Reset");
        btnReset.setPreferredSize(new Dimension(200, 40));
        btnReset.addActionListener(e -> this.parent.reset());
        this.add(btnReset);
    }
}