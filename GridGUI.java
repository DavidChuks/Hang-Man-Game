package HW8;
import java.awt.*;  // import the AWT graphic classes
import javax.swing.*;   // import the Swing classes

public class GridGUI extends LayoutGUI
{
@Override
public void addComponents(JFrame theFrame)
{
    JLabel  l1  = new JLabel("Enter your name: ");
    JLabel  l2  = new JLabel("Things to do for a GUI");
    JLabel  l3  = new JLabel(" or ");

    JComboBox<String> comboLayout = new JComboBox<String>();
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

    Container c = theFrame.getContentPane();

    c.setLayout(new GridLayout(5,4));
    c.setBackground(Color.white);

    c.add(l1);
    c.add(new JTextField(25));
    c.add(l2);

    // radio buttons have 2 steps: 1. Logically group them 2. add to the Frame or Panel

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
}
}

