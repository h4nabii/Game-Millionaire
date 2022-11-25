package Frames;

import Loader.Question;
import Loader.QuestionLoader;
import Database.MillionaireConnection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;

public class GameFrame extends javax.swing.JFrame {

    private final int QUESTION_SIZE = 10;
    private final List<Question> questions;
    private final MainFrame callFrame;
    private final Timer timer;
    private final JButton[] answerButtons;

    private final double[] rewords = new double[]{
        0,
        0.1,
        0.3,
        1.0,
        2.5,
        10.0,
        50.0,
        100.0,
        200.0,
        400.0,
        1000.0
    };

    private int stage = 0;
    private boolean failure = false;

    public GameFrame(MillionaireConnection connection, String type, MainFrame callFrame) {
        this.callFrame = callFrame;

        initComponents();
        java.awt.Point p = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setLocation(p.x - getWidth() / 2, p.y - getHeight() / 2);

        timer = new Timer();

        answerButtons = new JButton[]{
            button_answer1,
            button_answer2,
            button_answer3,
            button_answer4,
            button_answer5,
            button_answer6
        };

        questions = new QuestionLoader(connection).getRandom(type, QUESTION_SIZE + 1);

        timer.start();

        setLabels();
        setQuestion(questions.get(stage));
    }

    private void setQuestion(Question question) {

        timer.reset();
        timer.resume();

        // unable answer buttons and step buttons
        lockStepButtons();
        for (JButton button : answerButtons) {
            button.setText("");
            button.setEnabled(false);
        }

        // set texts and enable used answer buttons
        area_question.setText(question.text);
        for (int i = 0; i < question.size; i++) {
            answerButtons[i].setEnabled(true);
            answerButtons[i].setText(question.answers.get(i));
        }
    }

    private void setLabels() {
        label_got.setText("Now: " + String.valueOf(rewords[stage]));
        label_next.setText("Next: " + String.valueOf(rewords[stage + 1]));
        label_stage.setText(String.valueOf(stage + 1));
    }

    private void answerAndCheck(int pos) {

        timer.pause();

        lockAnswerButtons();

        // check answer
        if (pos == questions.get(stage).rightAnswerPos) {

            // correct
            stage++;
            setLabels();
            
            area_question.setText(
                    "Correct answer! You have already win " + rewords[stage]
                    + "k money. Now you can choose continue "
                    + "or leave for recent reward");
            button_next.setEnabled(true);
            button_quit.setEnabled(true);

        } else {

            // lose
            failure = true;
            lockBuffButtons();
            
            area_question.setText(
                    "Wrong answer! The correct answer is "
                    + answerButtons[questions.get(stage).rightAnswerPos - 1].getText()
                    + ". It regretful you have to quit and earn no money");
            button_quit.setEnabled(true);
        }
    }

    private void timeOut() {
        
        // time out
        failure = true;
        lockAnswerButtons();
        lockBuffButtons();
        
        area_question.setText(
                "Time out! The correct answer is "
                + answerButtons[questions.get(stage).rightAnswerPos - 1].getText()
                + ". It regretful you have to quit and earn no money");
        
        button_quit.setEnabled(true);
    }

    private void lockAnswerButtons() {
        for (JButton button : answerButtons) {
            button.setEnabled(false);
        }
    }
    
    private void lockBuffButtons() {
        button_addTime.setEnabled(false);
        button_remove.setEnabled(false);
        button_change.setEnabled(false);
    }
    
    private void lockStepButtons() {
        button_next.setEnabled(false);
        button_quit.setEnabled(false);
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
        button_quit = new javax.swing.JButton();
        label_next = new javax.swing.JLabel();
        label_got = new javax.swing.JLabel();
        label_stage = new javax.swing.JLabel();
        timerBar = new javax.swing.JProgressBar();
        button_addTime = new javax.swing.JButton();
        button_remove = new javax.swing.JButton();
        button_change = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        button_answer1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_answer1.setText("a1");
        button_answer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer1Action(evt);
            }
        });

        button_answer2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_answer2.setText("a2");
        button_answer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer2Action(evt);
            }
        });

        button_answer3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_answer3.setText("a3");
        button_answer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer3Action(evt);
            }
        });

        button_answer4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_answer4.setText("a4");
        button_answer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer4Action(evt);
            }
        });

        button_answer5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_answer5.setText("a5");
        button_answer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer5Action(evt);
            }
        });

        button_answer6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_answer6.setText("a6");
        button_answer6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer6Action(evt);
            }
        });

        area_question.setEditable(false);
        area_question.setColumns(20);
        area_question.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        area_question.setLineWrap(true);
        area_question.setRows(5);
        area_question.setWrapStyleWord(true);
        area_question.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        area_question.setFocusable(false);
        area_question.setMargin(new java.awt.Insets(10, 5, 10, 5));
        jScrollPane1.setViewportView(area_question);

        button_next.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_next.setText("Next");
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextAction(evt);
            }
        });

        button_quit.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_quit.setText("Quit");
        button_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitAction(evt);
            }
        });

        label_next.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        label_next.setText("Next");

        label_got.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        label_got.setText("Got");

        label_stage.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        label_stage.setText("Stage");

        button_addTime.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_addTime.setText("Reset timer");
        button_addTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTimeAction(evt);
            }
        });

        button_remove.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_remove.setText("Remove a wrong answer");
        button_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeWrongAction(evt);
            }
        });

        button_change.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        button_change.setText("Change a question");
        button_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAction(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_addTime, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_change, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(timerBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_quit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_answer1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_answer3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_answer5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(button_answer6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(button_answer4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_answer2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_got, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_next, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)
                        .addComponent(label_stage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_got)
                    .addComponent(label_next)
                    .addComponent(label_stage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timerBar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button_addTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_remove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_change, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_answer1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_answer2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_answer3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(button_answer4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_answer6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_answer5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_quit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void answer1Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer1Action
        answerAndCheck(1);
    }//GEN-LAST:event_answer1Action

    private void answer2Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer2Action
        answerAndCheck(2);
    }//GEN-LAST:event_answer2Action

    private void answer3Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer3Action
        answerAndCheck(3);
    }//GEN-LAST:event_answer3Action

    private void answer4Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer4Action
        answerAndCheck(4);
    }//GEN-LAST:event_answer4Action

    private void answer5Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer5Action
        answerAndCheck(5);
    }//GEN-LAST:event_answer5Action

    private void answer6Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer6Action
        answerAndCheck(6);
    }//GEN-LAST:event_answer6Action

    private void nextAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextAction
        if (stage == QUESTION_SIZE - 1) {
            this.setVisible(false);
            callFrame.setVisible(true);
            callFrame.refreshData();
            timer.stop();
        }

        setQuestion(questions.get(stage));
    }//GEN-LAST:event_nextAction

    private void quitAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitAction
        if (failure) {
            this.setVisible(false);
            callFrame.setVisible(true);
            timer.stop();
        } else {
            this.setVisible(false);
            callFrame.setVisible(true);
            callFrame.refreshData();
            timer.stop();
        }
    }//GEN-LAST:event_quitAction

    private void resetTimeAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetTimeAction
        if (timer.running) {
            button_addTime.setEnabled(false);
            timer.reset();
        }
    }//GEN-LAST:event_resetTimeAction

    private void removeWrongAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeWrongAction
        if (timer.running) {
            button_remove.setEnabled(false);
            int right = questions.get(stage).rightAnswerPos - 1;
            int randomWrong = right;
            boolean dupliacted = true;
            while (dupliacted) {
                randomWrong = new Random().nextInt(questions.get(stage).size);
                dupliacted = randomWrong == right;
            }
            answerButtons[randomWrong].setEnabled(false);
        }
    }//GEN-LAST:event_removeWrongAction

    private void changeAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAction
        if (timer.running) {
            button_change.setEnabled(false);
            setQuestion(questions.get(QUESTION_SIZE));
        }
    }//GEN-LAST:event_changeAction

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_question;
    private javax.swing.JButton button_addTime;
    private javax.swing.JButton button_answer1;
    private javax.swing.JButton button_answer2;
    private javax.swing.JButton button_answer3;
    private javax.swing.JButton button_answer4;
    private javax.swing.JButton button_answer5;
    private javax.swing.JButton button_answer6;
    private javax.swing.JButton button_change;
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_quit;
    private javax.swing.JButton button_remove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_got;
    private javax.swing.JLabel label_next;
    private javax.swing.JLabel label_stage;
    private javax.swing.JProgressBar timerBar;
    // End of variables declaration//GEN-END:variables

    private class Timer {

        final int MAX_TIME = 30000;

        int milliseconds = MAX_TIME;
        boolean started = false;
        boolean running = false;
        boolean stoped = false;

        {
            timerBar.setMaximum(MAX_TIME);
        }

        void start() {
            if (started || stoped) {
                return;
            }
            started = true;
            running = true;
            new Thread(() -> {
                try {
                    while (milliseconds > 0 && !stoped) {
                        TimeUnit.MILLISECONDS.sleep(1);
                        if (!running) {
                            continue;
                        }
                        timerBar.setValue(milliseconds);
                        milliseconds--;
                    }
                    timeOut();
                    stoped = true;

                } catch (InterruptedException e) {
                }
            }).start();
        }

        void pause() {
            if (!started || stoped) {
                return;
            }
            running = false;
        }

        void resume() {
            if (!started || stoped) {
                return;
            }
            running = true;
        }

        void stop() {
            if (!started) {
                return;
            }
            stoped = true;
        }

        void reset() {
            milliseconds = MAX_TIME;
        }
    }
}
