/**
 * Created by katalysatorn on 18/5/17.
 */

package RPNCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import RPNCalculator.*;

/**
 * This class contains the GUI
 */
public class GUI extends JFrame
{
    JPanel area;
    JTextField field;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JMenuItem aboutmenuItem;
    final String[] buttonNames = {
            "1", "2", "3", "_",
            "4", "5", "6", " + ",
            "7", "8", "9", " -",
            " * ", "0", " / ", "EXE"
    };

    /**
     * This class listens for each button press and does the correct thing depending on what button
     */
    class buttonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("EXE"))
            {
                try {
                    field.setText(RPN.DoWork(field.getText()).toString());
                } catch (Exception err)
                {

                }
            }
            else if (e.getActionCommand().equals("_"))
            {
                field.setText(field.getText() + " ");
            }
            else
            {
                field.setText(field.getText() + e.getActionCommand());
            }
        }
    }

    /**
     * This class listens for the menu buttons and returns the appropriate subwindow
     */
    class MenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("About"))
            {
                JOptionPane.showMessageDialog(menuItem, "This is a basic RPN Calculator\n\nVersion 0.1");
            }
        }
    }
    public GUI()
    {
        this.getContentPane().setLayout(new BorderLayout());
        this.setTitle("RPN Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("Extras");
        menuBar.add(menu);

        aboutmenuItem = new JMenuItem("About");
        aboutmenuItem.addActionListener(new MenuListener());
        menu.add(aboutmenuItem);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(4,4));

        for (int i = 0; i < buttonNames.length; i++)
        {
            JButton button = new JButton(buttonNames[i]);
            button.addActionListener(new buttonListener());
            buttons.add(button);
        }

        add(buttons, "Center");

        field = new JTextField();
        add(field, "North");

        this.pack();
        this.toFront();
        this.setVisible(true);
    }
}