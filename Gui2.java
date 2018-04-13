package HW8;
import java.awt.*;
import javax.swing.*;

public class Gui2 extends JApplet
{

String  lfName;

@Override
public void init ()
{
    setLookAndFeel();

    JLabel  l1  = new JLabel("Enter your name: ");
    JLabel  l2  = new JLabel("Things to do for a GUI");
    JLabel  l3  = new JLabel(" or ");

    JComboBox comboLayout = new JComboBox();
    comboLayout.setToolTipText("Select a Layout Manager");
    comboLayout.addItem("Flow");
    comboLayout.addItem("Grid");
    comboLayout.addItem("Border");
    comboLayout.addItem("Box");
    comboLayout.addItem("Spring");

    JTextArea   notes = new JTextArea(5, 40);
    JScrollPane scrollNotes = new JScrollPane(notes);

    JButton okButton = new JButton("OK");

    ButtonGroup radioGroup = new ButtonGroup();
    JRadioButton appletRadio;
    JRadioButton frameRadio;

    Container c = getContentPane();

    c.setLayout(new FlowLayout());
    c.setBackground(Color.white);

    c.add(l1);
    c.add(new JTextField(25));
    c.add(l2);

    // radio buttons - very different in Swing

    appletRadio = new JRadioButton("Applet", false);
    frameRadio = new JRadioButton("Frame", false);
    radioGroup.add(appletRadio);
    radioGroup.add(frameRadio);
    c.add(appletRadio);
    c.add(l3);
    c.add(frameRadio);

    c.add(new JCheckBox("Set layout manager"));
    c.add(comboLayout);
    c.add(new JCheckBox("Create components"));
    c.add(new JCheckBox("Get content pane"));
    c.add(new JCheckBox("Add components"));
    c.add(new JCheckBox("Handle component events"));

    c.add(scrollNotes);

    c.add(okButton);

    if (lfName == null)
        lfName = "Default Look and Feel";

    c.add(new JLabel(lfName));

}
public void setLookAndFeel()
{
    int i = 0;
    String  lookAndFeel = getParameter("Look");

    if (lookAndFeel == null)
        return;

    if (lookAndFeel.equalsIgnoreCase("metal"))
        i = 0;
    else if (lookAndFeel.equalsIgnoreCase("motif"))
        i = 1;
    else if (lookAndFeel.equalsIgnoreCase("windows"))
        i = 2;
    else
        return;

    try
    {
        lfName = UIManager.getInstalledLookAndFeels()[i].getClassName();
        System.out.println("Look and Feel is " + lfName + " " + i);
        UIManager.setLookAndFeel(lfName);
        SwingUtilities.updateComponentTreeUI(this);
    }
    catch(Exception e)
    {
        System.out.println("Cannot set look and feel " + lookAndFeel);
    }

}
}

