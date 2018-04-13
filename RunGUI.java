package HW8;
import java.io.*;
import java.awt.*;  // import the AWT graphic classes
import javax.swing.*;   // import the Swing classes

public class RunGUI
{
public static void main(String args[]) throws IOException
{
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    String str;
    final LayoutGUI gui;

    // Prompt the User for the GUI to run.

    System.out.println("Select Your GUI");
    System.out.println("Enter 1 to run the FlowGui.");
    System.out.println("Enter 2 to run the GridGui.");
    System.out.println("Enter 3 to run the BorderGui.");
    System.out.println();
    System.out.print("Enter your selection: ");

    str = keyboard.readLine();

    if (str.equals("1"))
        gui = new FlowGUI();
    else if (str.equals("2"))
        gui = new GridGUI();
    else if (str.equals("3"))
        gui = new BorderGUI();
    else
        gui = null;

    if (gui == null)
    {
        System.err.println("*** Exiting program: Invalid selection");
        System.exit(12);
    }

    // Note: this is an anonymous inner-class that extends the Runnable class
    //       and overrides the run() method.

    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        @Override
        public void run()
        {
            createAndShowGUI(gui);
        }
    });
}

private static void createAndShowGUI(LayoutGUI gui)
{
    // Create a JFrame and get its content pane

    JFrame      theFrame = new JFrame(gui.getClass().getName() + " Application");
    Container   c = theFrame.getContentPane();

    // Instantiate the GUI, which is a JPanel

    gui.addComponents(theFrame);

    // Set the size of the frame and exit behavior

    theFrame.setPreferredSize(new Dimension(500, 400));
    theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add the GUI to the frame

    c.add(gui);

    // show the frame

    theFrame.pack();
    theFrame.setVisible(true);
}
}

