package pro1.drawingModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polyline implements Drawable {
    private List<Point> points = new ArrayList<>();
    private int thickness = 10;
    private boolean isRed = true;

    public void addPoint(Point p) { points.add(p); }
    public void zpet() { if (!points.isEmpty()) points.removeLast();}
    public void reset() { points.clear(); }
    public void setThickness(int t) { this.thickness = t; }
    public void setRed(boolean red) { this.isRed = red; }

    @Override
    public void draw(Graphics2D g) {
        if (points.size() > 1) {
            g.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            if (isRed) g.setColor(Color.RED);
            else g.setColor(Color.GRAY);

            for (int i = 0; i < points.size() - 1; i++) {
                Point p1 = points.get(i);
                Point p2 = points.get(i + 1);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
}
