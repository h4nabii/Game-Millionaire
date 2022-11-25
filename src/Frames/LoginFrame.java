package Frames;

import Database.MillionaireConnection;

/**
 * The layout of this frmae is mostly gemerated by NetBeans
 */
public class LoginFrame extends javax.swing.JFrame {

    private final MillionaireConnection connection;

    /**
     * Creates new form LoginFrame
     *
     * @param connection Millionaire DB connection instance
     */
    public LoginFrame(MillionaireConnection connection) {
        this.connection = connection;

        initComponents();
        java.awt.Point p = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setLocation(p.x - getWidth() / 2, p.y - getHeight() / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_username = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        field_username = new javax.swing.JTextField();
        field_password = new javax.swing.JPasswordField();
        button_login = new javax.swing.JButton();
        button_register = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_msg = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login / Register");
        setResizable(false);

        label_username.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        label_username.setText("Username: ");

        label_password.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        label_password.setText("Password: ");

        field_username.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        field_password.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        button_login.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_login.setText("Login");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginAction(evt);
            }
        });

        button_register.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_register.setText("Register");
        button_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerAction(evt);
            }
        });

        area_msg.setEditable(false);
        area_msg.setColumns(20);
        area_msg.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        area_msg.setLineWrap(true);
        area_msg.setRows(3);
        area_msg.setTabSize(4);
        jScrollPane1.setViewportView(area_msg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(button_register, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_username, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(label_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_username, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(field_password)))
                    .addComponent(jScrollPane1))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_username)
                    .addComponent(field_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_password)
                    .addComponent(field_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_register, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAction
        String username = field_username.getText();
        char[] pass = field_password.getPassword();
        String password = new String(pass, 0, pass.length);

        if (!username.equals("") && connection.login(username, password)) {
            area_msg.setText(
                    "Login successfully!\n"
                    + "Welcome, " + username);
            closeAndStartGame(username);

        } else {
            area_msg.setText(
                    "Please check your infotmations then try again.\n"
                    + "If you do not have an account, "
                    + "please register one");

        }
    }//GEN-LAST:event_loginAction

    private void registerAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerAction
        String username = field_username.getText();
        char[] pass = field_password.getPassword();
        String password = new String(pass, 0, pass.length);

        if (!username.equals("") && connection.register(username, password)) {
            area_msg.setText("Register successfully! Welcome, " + username);
            closeAndStartGame(username);

        } else {
            area_msg.setText(
                    "Username exsits!\n"
                    + "Please change your username then try again.\n");
        }
    }//GEN-LAST:event_registerAction

    private void closeAndStartGame(String username) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                java.util.concurrent.TimeUnit.SECONDS.sleep(1);
                setVisible(false);
                new MainFrame(connection, username).setVisible(true);
                dispose();

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        });
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_msg;
    private javax.swing.JButton button_login;
    private javax.swing.JButton button_register;
    private javax.swing.JPasswordField field_password;
    private javax.swing.JTextField field_username;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_username;
    // End of variables declaration//GEN-END:variables
}
