package HW8;
import java.awt.*;  // import the AWT graphic classes
import javax.swing.*;   // import the Swing classes

public class BorderGUI extends LayoutGUI
{
@Override
public void addComponents(JFrame theFrame)
{
    JButton okButton = new JButton("South Button");

    theFrame.getContentPane().setLayout(new BorderLayout());

    theFrame.getContentPane().add(new JLabel("North"), BorderLayout.NORTH);
    theFrame.getContentPane().add(new JButton("North Button"), BorderLayout.NORTH);
    theFrame.getContentPane().add(new JLabel("West"), BorderLayout.WEST);
    theFrame.getContentPane().add(new JLabel("East"), BorderLayout.EAST);
    theFrame.getContentPane().add(new JLabel("Center"), BorderLayout.CENTER);

    theFrame.getContentPane().add(okButton, BorderLayout.SOUTH);
}
}

