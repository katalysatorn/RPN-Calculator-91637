/**
 * Contains the main GUI information
 * 
 * @author katalysatorn, Blair Burton <blair.burton@outlook.com>
 * @since 1.0
 */
package RPNCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the GUI
 */
public class GUI extends JFrame {
    // Create serialVersionUID
    private static final long serialVersionUID = 1L;

    JTextField field;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem, aboutmenuItem;

    // Array containing the items for the buttons
    final String[] buttonNames = {
        "1", "2", "3", "⟵",
        "4", "5", "6", "+",
        "7", "8", "9", "-",
        "^", "0", "EXE", "*",
        "C", "Space", ".", "/"
    };

    /**
     * This class listens for each button press and does the correct thing depending on what button
     */
    class buttonListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (e.getActionCommand().equals("EXE")) {
                try {
                    field.setText(RPN.DoWork(field.getText()));
                } catch (Exception err) {
                    new GUI();
                }
            }
            else if (e.getActionCommand().equals("C")) {
                field.setText("");
            }
            else if (e.getActionCommand().equals("Space")) {
                field.setText(field.getText() + " ");
            }
            else if (e.getActionCommand().equals("⟵")) {
                field.setText(field.getText().replaceFirst(".$",""));
            }
            else {
                field.setText(field.getText() + e.getActionCommand());
            }
        }
    }

    /**
     * This class listens for the menu buttons and returns the appropriate subwindow
     */
    class MenuListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (e.getActionCommand().equals("About")) {
                JOptionPane.showMessageDialog(
                    menuItem,
                    "This is a basic RPN Calculator\n" +
                    "If you input nothing or get an error in the RPN, it will start a new GUI.\n" +
                    "This is intended behaviour; \"It's not a bug, its a feature.\"\n\n" +
                    "Version 0.3"
                );
            }
        }
    }

    public GUI () {
        this.getContentPane().setLayout(new BorderLayout());

        this.setTitle("RPN Calculator AS91637");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("Extras");
        menuBar.add(menu);

        aboutmenuItem = new JMenuItem("About");
        aboutmenuItem.addActionListener(new MenuListener());
        menu.add(aboutmenuItem);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(5,4));

        // Set the buttons to the correct place
        for (int i = 0; i < buttonNames.length; i++) {
            JButton button = new JButton(buttonNames[i]);
            button.addActionListener(new buttonListener());
            buttons.add(button);
        }

        add(buttons, "Center");

        field = new JTextField();
        field.setEditable(false);
        add(field, "North");

        this.pack();
        this.toFront();
        this.setVisible(true);
    }
}
