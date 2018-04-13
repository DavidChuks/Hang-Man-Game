/**
 * 
 */
package HW8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import HW4.SecretString;

/**
 * 
 * @author David Chukwuma
 * Andrew ID: dchukwue
*  On my honor, as a Carnegie-Mellon Rwanda student, I have neither
*  given nor received unauthorized assistance on this work.

 */
public class HangmanGUI extends LayoutGUI implements StringHandler
{
    private int tries=0;
    private int wins=0;
    private int losses=0;
    private ArrayList<SingleUseButton>letters;
    private HangedMan hangingMan= new HangedMan(400, 200);
    private String filename="";
    private PhraseList phrasel;
    private JSecretString secretS;

    private JLabel label2 = new JLabel("Guess what I say!");
    private JButton playButton = new JButton("PLAY");
    private JLabel labelforWins = new JLabel("Wins: " + wins);
    private JLabel labelforLosses = new JLabel("Losses: " + wins);
    private JLabel labelforTries = new JLabel("Tries: " + wins);

    private boolean hasGameEnded=false;

    public HangmanGUI()
    {
        
    }
    
    public HangmanGUI(String filename_)
    {
        filename=filename_;
        phrasel = new PhraseList(filename);
        secretS= new JSecretString(phrasel.getRandomPhrase());
    }
   

    @Override
    public void processString(String text)
    {
       tries++;
       labelforTries.setText("Tries: "+tries);
       
       if (secretS.revealLetters(text)==0)
       {
            label2.setText("Lol! nope " + text + " is not correct!");
           hangingMan.addBodyPart();
       }
       else 
       {
           label2.setText("Yass, "+text+" is correct!");
       }
       if (hangingMan.isHanged()) 
       {
           label2.setText("Uh uh, you hung the poor lad");
           for (SingleUseButton letter : letters)
           {
              letter.setEnabled(false);
           }
           
           playButton.setEnabled(true);
           hasGameEnded=true;
           losses++;
           labelforLosses.setText("Losses: "+losses);
          
           
       }
       else if(secretS.hasWordBeenrevealed()) 
       {
           label2.setText("Awesome, you saved the poor lad");
           for (SingleUseButton letter : letters)
           {
              letter.setEnabled(false);
           }
           
           playButton.setEnabled(true);
           hasGameEnded=true;
           wins++;
           labelforWins.setText("Wins: "+wins);
           
       }

        //secretS.setText(secretS.getDisplayedPhrase());
        hangingMan.repaint();

      
 
        
    }

    @Override
    public void addComponents(JFrame theFrame)
    {     

        theFrame.setTitle("Dave's Hangman Game [Homework 8]");
        Container c = theFrame.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);

        JPanel buttonGrid = new JPanel(new GridLayout(4, 7));
        JPanel midGrid = new JPanel(new BorderLayout(20, 20));
        JPanel topGrid = new JPanel(new FlowLayout());

        midGrid.setBackground(Color.WHITE);
        topGrid.setBackground(Color.WHITE);

        topGrid.add(labelforTries);
        topGrid.add(labelforLosses);
        topGrid.add(labelforWins);

        midGrid.add(hangingMan, BorderLayout.NORTH);
        midGrid.add(secretS, BorderLayout.CENTER);
        midGrid.add(label2, BorderLayout.SOUTH);

        // label1.setText(secretS.getDisplayedPhrase());
        // c.add(secretS);
        // c.add(label2);

        letters = SingleUseButton.getLetterButtons(this);
        c.add(topGrid);
        c.add(midGrid);
        for (SingleUseButton letter : letters)
        {
            buttonGrid.add(letter);
            // c.add(letter);
        }
        buttonGrid.add(playButton);
        c.add(buttonGrid);
        //c.add(playButton);

        
            playButton.setEnabled(false);
        
        
        playButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                resetGame();
            }

        });
              
    }
    
    public void resetGame()
    {
        secretS.setDisplayedPhrase(phrasel.getRandomPhrase());
        
        hangingMan.reset();
        hasGameEnded=false;
        
        for (SingleUseButton letter : letters)
        {
           letter.setEnabled(true);
            //c.add(letter);
        }
        playButton.setEnabled(false);
        label2.setText("Guess what I say!");
        tries=0;
        labelforTries.setText("Tries: "+tries);
        
    }

}
