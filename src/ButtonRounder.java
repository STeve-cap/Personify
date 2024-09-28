import java.lang.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.Font;



// Custom JButton with rounded corners
class ButtonRounder extends JButton {

    public ButtonRounder(String label) {
        super(label);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        if (getModel().isArmed()) {
            g2.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            g2.setColor(getBackground().brighter());
        } else {
            g2.setColor(getBackground());
        }

        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());

        // Draw the rounded border
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
        }
        return shape.contains(x, y);
    }

    private Shape shape;
}
