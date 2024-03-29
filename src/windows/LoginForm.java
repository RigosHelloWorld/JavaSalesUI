package windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import server.Database;

public class LoginForm extends JFrame {

    private JTextField tfEmail;
    private JPasswordField pfPassword;

    /*************** Components ***************/
    private JLabel lbLoginForm;
    private JLabel lbEmail;
    private JLabel lbPassword;

    private JButton btnLogin;
    private JButton btnCancel;

    private JPanel formPanel;
    private JPanel buttonsPanel;

    public void init() {

        createComponents();
        createFormPanel();
        createButtonListeners();
        createButtonPanel();
        createFrame();


    }

    private void createComponents() {
        lbLoginForm = new JLabel("Login Form: ");
        lbEmail = new JLabel("Emal: ");
        lbPassword = new JLabel("Password: ");

        tfEmail = new JTextField();
        pfPassword = new JPasswordField();

        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");

        formPanel = new JPanel();

    }

    private void createFormPanel() {
        /*************** Form Panel ***************/

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
    }

    private void createButtonPanel(){
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnCancel);
    }

    private void createFrame(){
        /*************** Initialise the frame ***************/
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        // setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createButtonListeners() {
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (Database.validateUser(tfEmail.getText(), new String(pfPassword.getPassword()))) {
                    dispose();
                    Inventory in = new Inventory();
                    //JOptionPane.showMessageDialog(LoginForm.this, "Succes", "title", JOptionPane.PLAIN_MESSAGE);
                    
                } else
                    JOptionPane.showMessageDialog(LoginForm.this, "Incorrect Email or Password", "Error",
                            JOptionPane.ERROR_MESSAGE);

            }
        });

        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * Deletes the Jframe if this is the only Jframe the the Jvm is closed
                 */
                dispose();
            }

        });
    }



}
