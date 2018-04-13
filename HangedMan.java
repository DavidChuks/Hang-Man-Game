package HW8;
import java.awt.*;  // import the AWT graphic classes
import javax.swing.*;   // import the Swing classes

/**
  *
  * This class represents a graphical drawing of a Hanged Man. 
  *
  * Note: it does NOT represetnd good, re-useable class design.
  *
  *  @author Cathy Bishop 
  *
  */

public class HangedMan extends JComponent
{

// Note: if numShown >= numBodyParts, the man is considered "hung"

private int numShown = 0;           // the current number of body parts to show
private final int numBodyParts = 6; // the max number of body parts to show.

public HangedMan(int width, int height)
{
    Dimension size = new Dimension(width, height);
    setSize(size);
    setPreferredSize(size);
}

public void reset()
{
    numShown = 0;
    repaint();
}

public boolean isHanged()
{
    if (numShown >= numBodyParts)
        return true;
    return false;

}
public void addBodyPart()
{
    numShown++;
}

@Override
public void paintComponent(Graphics g)
{
    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();
    int centerX = width / 2;
    int centerY = height / 2;

    int gallowsWidth = 10;
    int bodyOffset = gallowsWidth + 10;
    int headWidth = 50;
    int bodyWidth = 10;
    int bodyLength = 75;
    int armLength = 30;
    int legLength = 50;
    Color backgroundColor;

    int limbY;

    g.setColor(Color.BLACK);

    // Draw the Gallows first

    g.fillRect(width/4, 0, gallowsWidth, height);
    g.fillRect(width/4, 0, width/4, gallowsWidth);
    g.fillRect(centerX - 5, 0, 10, bodyOffset);

    // now draw the body parts

    if (numShown > 0)
    {
        g.fillOval(centerX - headWidth/2, bodyOffset, headWidth, headWidth);
        if (isHanged())
            g.setColor(Color.RED);
        else
            g.setColor(getBackground());
        g.fillOval(centerX - headWidth/2 + 3, bodyOffset + 3, headWidth - 6, headWidth - 6);
        g.setColor(Color.BLACK);
    }

    if (numShown > 1)
        g.fillRect(centerX - bodyWidth/2, headWidth + bodyOffset, bodyWidth, bodyLength);

    // Draw Legs 

    limbY = headWidth + bodyOffset + bodyLength - 5;
    if (numShown > 2)
        drawWideLine(g, 3, centerX, limbY, centerX - legLength, limbY + legLength);

    if (numShown > 3)
        drawWideLine(g, 3, centerX, limbY, centerX + legLength, limbY + legLength);

    // Draw Arms

    limbY = headWidth + bodyOffset + bodyLength/3;
    if (numShown > 4)
        drawWideLine(g, 3, centerX, limbY, centerX - armLength/2, limbY - armLength/2);

    if (numShown > 5)
        drawWideLine(g, 3, centerX, limbY, centerX + armLength/2, limbY - armLength/2);
}
private void drawWideLine(Graphics g, int width, int x1, int y1, int x2, int y2)
{
    double slope = ((double)(y2 - y1)) / ((double)(x2 - x1));
    Polygon poly;

    if (slope < 0)
    {
        int xvals[] = {x1 - width, x1 + width, x2 + width, x2 - width};
        int yvals[] = {y1 - width, y1 + width, y2 + width, y2 - width};
        poly = new Polygon(xvals, yvals, 4);
    }
    else
    {
        int xvals[] = {x1 - width, x1 + width, x2 + width, x2 - width};
        int yvals[] = {y1 + width, y1 - width, y2 - width, y2 + width};
        poly = new Polygon(xvals, yvals, 4);
    }


    Graphics2D g2 = (Graphics2D) g;
    g2.fillPolygon(poly);
}
}
