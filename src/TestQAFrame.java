
import Database.MillionaireConnection;
import javax.swing.JButton;

public class TestQAFrame extends javax.swing.JFrame {

    private final QuestionLoader loader;

    private Question question;

    public TestQAFrame() {
        initComponents();
        area_question.setEditable(false);
        area_question.setLineWrap(true);

        loader = new QuestionLoader(new MillionaireConnection());

        randomLoad();
        setQuestion(question);
    }

    private void setQuestion(Question question) {
        javax.swing.JButton[] buttons = new javax.swing.JButton[]{
            button_answer1,
            button_answer2,
            button_answer3,
            button_answer4,
            button_answer5,
            button_answer6
        };

        button_next.setEnabled(false);
        button_none.setEnabled(false);

        area_question.setText(question.text);
        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(false);
        }
        for (int i = 0; i < question.size; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setText(question.answers.get(i));
        }
    }

    private void randomLoad() {
        question = loader.getRandom(1).get(0);
    }

    private void answerAndCheck(int pos) {
        javax.swing.JButton[] buttons = new javax.swing.JButton[]{
            button_answer1,
            button_answer2,
            button_answer3,
            button_answer4,
            button_answer5,
            button_answer6
        };
        for (JButton button : buttons) {
            button.setEnabled(false);
        }

        if (pos == question.rightAnswerPos) {
            button_next.setEnabled(true);
        } else {
            button_none.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_answer1 = new javax.swing.JButton();
        button_answer2 = new javax.swing.JButton();
        button_answer3 = new javax.swing.JButton();
        button_answer4 = new javax.swing.JButton();
        button_answer5 = new javax.swing.JButton();
        button_answer6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_question = new javax.swing.JTextArea();
        button_next = new javax.swing.JButton();
        button_none = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_answer1.setText("a1");
        button_answer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_answer1ActionPerformed(evt);
            }
        });

        button_answer2.setText("a2");
        button_answer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_answer2ActionPerformed(evt);
            }
        });

        button_answer3.setText("a3");
        button_answer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_answer3ActionPerformed(evt);
            }
        });

        button_answer4.setText("a4");
        button_answer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_answer4ActionPerformed(evt);
            }
        });

        button_answer5.setText("a5");
        button_answer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_answer5ActionPerformed(evt);
            }
        });

        button_answer6.setText("a6");
        button_answer6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_answer6ActionPerformed(evt);
            }
        });

        area_question.setColumns(20);
        area_question.setRows(5);
        jScrollPane1.setViewportView(area_question);

        button_next.setText("Next");
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });

        button_none.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_noneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_none, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button_answer1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_answer3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_answer5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(button_answer6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                .addComponent(button_answer4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_answer2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_answer1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_answer2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_answer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_answer4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_answer6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_answer5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_none, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_answer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_answer1ActionPerformed
        answerAndCheck(1);
    }//GEN-LAST:event_button_answer1ActionPerformed

    private void button_answer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_answer2ActionPerformed
        answerAndCheck(2);
    }//GEN-LAST:event_button_answer2ActionPerformed

    private void button_answer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_answer3ActionPerformed
        answerAndCheck(3);
    }//GEN-LAST:event_button_answer3ActionPerformed

    private void button_answer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_answer4ActionPerformed
        answerAndCheck(4);
    }//GEN-LAST:event_button_answer4ActionPerformed

    private void button_answer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_answer5ActionPerformed
        answerAndCheck(5);
    }//GEN-LAST:event_button_answer5ActionPerformed

    private void button_answer6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_answer6ActionPerformed
        answerAndCheck(6);
    }//GEN-LAST:event_button_answer6ActionPerformed

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nextActionPerformed
        randomLoad();
        setQuestion(question);
    }//GEN-LAST:event_button_nextActionPerformed

    private void button_noneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_noneActionPerformed
        randomLoad();
        setQuestion(question);
    }//GEN-LAST:event_button_noneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestQAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestQAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestQAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestQAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TestQAFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_question;
    private javax.swing.JButton button_answer1;
    private javax.swing.JButton button_answer2;
    private javax.swing.JButton button_answer3;
    private javax.swing.JButton button_answer4;
    private javax.swing.JButton button_answer5;
    private javax.swing.JButton button_answer6;
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_none;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
