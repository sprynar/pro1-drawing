package pro1.swingComponents;

import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final MainFrame parent;
    JSlider rSLider;
    JSlider gSLider;
    JSlider bSLider;
    public OptionsPanel(MainFrame parent) {
        this.parent = parent;
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(400, 0));

        JButton barva = new JButton("Jiná náhodná barva");
        barva.setPreferredSize(new Dimension(400, 50));

        this.add(barva);
        barva.addActionListener((e) -> {
            this.parent.setColor(ColorUtils.randomColor());
            this.parent.showExample();
        });

        this.rSLider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        this.gSLider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        this.bSLider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        this.rSLider.setBackground(Color.RED);
        this.gSLider.setBackground(Color.GREEN);
        this.bSLider.setBackground(Color.BLUE);
        this.rSLider.setSize(400,100);
        this.gSLider.setSize(400,100);
        this.bSLider.setSize(400,100);
        this.rSLider.addChangeListener((e)->{
            this.sliderChange();
        });
        this.gSLider.addChangeListener((e)->{
            this.sliderChange();
        });
        this.bSLider.addChangeListener((e)->{
            this.sliderChange();
        });

        this.add(rSLider);
        this.add(gSLider);
        this.add(bSLider);
    }
    private void sliderChange() {
        int r = rSLider.getValue();
        int g = gSLider.getValue();
        int b = bSLider.getValue();
        Color selectedColor = new Color(r, g, b);
        this.parent.setColor(String.format("#%02x%02x%02x", r, g, b));
        this.parent.showExample();
    }
}
