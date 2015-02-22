/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * CSCO1530 Assignment 1 Naughty Window
 * Aim: Get acquisition to the JDK + NetBeans programming environment
 *      Learn the structure and format of a Java program by example
 * 
 * Remark: Type class names, variable names, method names, etc. as is 
 *         You should type also all the comment (text in gray)
 * 
 * I declare that the assignment here submitted is original 
 * except for the source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of University policy and
 * regulations on honesty in academic work, and of the disciplinary 
 * guidelines and procedures applicable to breaches of such
 * policy and regulations, as contained in the website.
 * 
 * University Guidelines on Academic Honesty:
 *      http://www.cuhk.edu.hk/policy/academichonesty/
 * Faculty of Engineering Guidelines to Academic Honesty:
 *      http://www.cse.cuhk.edu.hk/csci1530/ENGG_Discipline.pdf
 * 
 * Student Name: Lee Wai Lam Jonathan 
 * Student ID  : 1155017574
 * Date        : 20/01/2015
 * 
 * 
 */
package exercise;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 * NaughtyWindow
 * Java Programming Assignment
 * @author Michael FUNG
 * @since 9 January 2015
 */
public class NaughtyWindow extends JFrame implements ActionListener {

    /**Defines how many clicks to stop*/
    private byte clickCount = 7;
    /** The button object field declaration */
    protected JButton clickMe;
    
    /** CONSTRUCTOR */
    public NaughtyWindow() {
        //set properties of the NaughtyWindow object
        setSize (300, 100);
        setLocation (200, 400);
        setTitle ("Naughty Window");
        int DO_NOTHING_CLOSE = 0;
        setDefaultCloseOperation(DO_NOTHING_CLOSE);
        
        //add a button to the window
        clickMe = new JButton();
        updateClickCount();
        ActionListener clickActionListener = this;
        clickMe.addActionListener(clickActionListener);
        this.add(clickMe);
    }
    
    /**
     * Update and display click count
     * @return true if clickCount reaches 0; false otherwise
     */
    protected final boolean updateClickCount()
    {
        clickMe.setText("Close me with" + clickCount +
                (clickCount>1 ? "clicks..." : "last CLICK!")    );
        return clickCount-- == 0;
    }
    
    /**
     * ActionListener callback method for handling clickMe button click event
     * @param eventObject contains event information
     */
    @Override
    public void actionPerformed (ActionEvent eventObject) {
        //on clickCount reaches 0, ask the System to terminate the program 
        if (updateClickCount())
            System.exit(0);
        // naughty jump!
        Point jump = new Point ((int) (Math.random() * 400),
                                (int) (Math.random() * 400) );
        this.setLocation(jump);
    }

    /**
     * Starting point of the program
     * @param args main method arguments
     */
    public static void main (String[] args) {
        //  create a new NaughtyWindow object
        NaughtyWindow window = new NaughtyWindow();
        window.setVisible(true);
        //  the program DOES NOT end here since a window is opened
    }
}
