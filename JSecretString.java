/**
 * 
 */
package HW8;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * 
 * @author David Chukwuma & David Mawazo Andrew ID: dchukwue 
 * On my honor, as a Carnegie-Mellon Rwanda student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 */
public class JSecretString extends JLabel
{
    private String phrase = new String("");
    private String displayedPhrase = new String("");
    private String secretString;

    public JSecretString()
    {

        setPhrase("Java is Great!");
        setDisplayedPhrase();
        this.setText(displayedPhrase);
    }

    public JSecretString(String phrase)
    {

        setPhrase(phrase);
        setDisplayedPhrase();
        this.setText(displayedPhrase);
        this.setFont((new Font("Courier New", Font.ITALIC, 18)));
       
    }

    private String getPhrase()
    {
        return phrase;
    }

    private void setPhrase(String phrase_)
    {
        phrase = phrase_;
    }

    private String getDisplayedPhrase()
    {
        return secretString;
    }

    public void setDisplayedPhrase()
    {
        secretString = makeDisplayString(phrase);
    }
    
    public void setDisplayedPhrase(String phrase_)
    {
        phrase=phrase_;
        secretString = makeDisplayString(phrase);
        this.setText(displayedPhrase);
    }

    public String makeDisplayString(String phrase)
    {
        displayedPhrase = phrase.replaceAll("[A-Za-z]", "_");

        return displayedPhrase;
    }

    public int revealLetters(String str)
    {
        str = str.toLowerCase();
        phrase = phrase.toLowerCase();
        int length = str.length();
        char letter = 'x';
        int temp = 0;

        for (int i = 0; i < length; i++)
        {
            letter = str.charAt(i);

            for (int j = 0; j < phrase.length(); j++)
            {

                if (phrase.charAt(j) == letter)
                {
                    secretString = secretString.substring(0, j) + letter
                            + secretString.substring(j + 1, phrase.length());
                    temp++;

                }

            }
            // this.setText("There are " + temp + "\"" + letter + "\"s");
            // System.out.println("There are " + temp + "\"" + letter + "\"s");
        }
        this.setText(getDisplayedPhrase());
        return temp;

    }

    public Boolean hasWordBeenrevealed()
    {
        Boolean status = false;
        int count = 0;

        String letter = "_";

        for (int j = 0; j < secretString.length(); j++)
        {
            if (secretString.substring(j, j + 1).equals(letter))
            {
                count++;
                break;

            }

        }

        if (count == 0)
        {
            status = true;
        }

        return status;
    }

    @Override
    public String toString()
    {
        return displayedPhrase;
    }

}
