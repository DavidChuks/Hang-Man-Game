package HW8;
import java.util.*;

import java.awt.event.*;
import javax.swing.*;

/**
  *
  * This class represents a button that can be clicked only once
  * and when clicked, will provide the label on the button to the
  * StringHandler object (called callback) passed into the constructor.
  *
  *  @author Cathy Bishop 
  *
  */

public class SingleUseButton extends JButton
{
public SingleUseButton(String text, StringHandler callback)
{
	SingleClickListener eventListener;

	// Use text as the label

	setText(text);

	// Create the listener and add it to the button

	eventListener = new SingleClickListener(callback);
	addActionListener(eventListener);
}

public static ArrayList<SingleUseButton> getLetterButtons(StringHandler callback)
{
    ArrayList<SingleUseButton> buttons = new ArrayList<SingleUseButton>();

    for (char letter = 'A'; letter <= 'Z'; letter++)
        buttons.add(new SingleUseButton(Character.toString(letter), callback));

    return buttons;
}

// SingleClickListener is an inner class - meaning it is inside another class and not 
// intended to be re-used.

class	SingleClickListener implements ActionListener
{
private StringHandler	_callback;

public	SingleClickListener(StringHandler callback)
{
	_callback = callback;
}

@Override
public void actionPerformed(ActionEvent e)
{
    // Note: Why all the casting? Just to show you something interesting ...
    //       See if you can figure it out (optional).

    JComponent button = (JComponent) e.getSource();

    button.setEnabled(false);
	_callback.processString(((JButton)button).getText());
}

}
}
