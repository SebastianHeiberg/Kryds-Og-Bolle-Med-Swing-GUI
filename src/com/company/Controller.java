package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

  JFrame frame;
  Button x1x1;
  Button x1x2;
  Button x1x3;
  Button x2x1;
  Button x2x2;
  Button x2x3;
  Button x3x1;
  Button x3x2;
  Button x3x3;
  JSplitPane splitPane;
  JPanel topPanel;
  JPanel buttomPanel;
  Button[] allGameButtons;
  JLabel player1;
  JLabel player2;
  Game thegame;

  public Controller() {
    frame = new JFrame("Kryds og bolle");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    topPanel = new JPanel();
    buttomPanel = new JPanel();
    splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    splitPane.setDividerLocation(50);
    frame.add(splitPane);
    splitPane.setTopComponent(topPanel);
    splitPane.setBottomComponent(buttomPanel);
    frame.setVisible(true);

    //toppen
    player1 = new JLabel();
    player2 = new JLabel();
    topPanel.add(player1);
    topPanel.add(player2);

    //bunden
    buttomPanel.setLayout(new GridLayout(3, 3));
    x1x1 = new Button();
    buttomPanel.add(x1x1);
    x1x2 = new Button();
    buttomPanel.add(x1x2);
    x1x3 = new Button();
    buttomPanel.add(x1x3);
    x2x1 = new Button();
    buttomPanel.add(x2x1);
    x2x2 = new Button();
    buttomPanel.add(x2x2);
    x2x3 = new Button();
    buttomPanel.add(x2x3);
    x3x1 = new Button();
    buttomPanel.add(x3x1);
    x3x2 = new Button();
    buttomPanel.add(x3x2);
    x3x3 = new Button();
    buttomPanel.add(x3x3);

    frame.setPreferredSize(new Dimension(400, 400));
    frame.pack();
    frame.setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    // write your code here
    Controller game = new Controller();
    game.run();
  }

  public void buttonActionToGame(Button button) {
    if (button.getLabel().isEmpty()) {
      button.setLabel(thegame.playertakesTurn());
      if (thegame.win()) {
        JOptionPane.showMessageDialog(frame, "We have a winner!");
        thegame.getCurrentPlayerTurn().increaseWins();
        updateAfterWin();
      }
      thegame.endTurn();
      if (thegame.getRoundCount() == 9){
        JOptionPane.showMessageDialog(frame, "Draw!");
        updateAfterWin();
      }
    }
  }

  private void updateAfterWin() {
    for (Button button : allGameButtons) {
      button.setLabel("");
    }
    thegame.resetStatusBoard();
    thegame.setRoundCount(0);

    player1.setText("Player 1 wins: " + thegame.getPlayer1().getWins());
    player2.setText("Player 2 wins: " + thegame.getPlayer2().getWins());

  }

  public void createActionButtons() {
    //første række
    x1x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(0, 0);
        buttonActionToGame(x1x1);
      }
    });
    x1x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(0, 1);
        buttonActionToGame(x1x2);
      }
    });
    x1x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(0, 2);
        buttonActionToGame(x1x3);
      }
    });
    //anden række
    x2x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(1, 0);
        buttonActionToGame(x2x1);
      }
    });
    x2x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(1, 1);
        buttonActionToGame(x2x2);
      }
    });
    x2x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(1, 2);
        buttonActionToGame(x2x3);
      }
    });
    // tredje række
    x3x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(2, 0);
        buttonActionToGame(x3x1);
      }
    });
    x3x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(2, 1);
        buttonActionToGame(x3x2);
      }
    });
    x3x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thegame.setBoardStatus(2, 2);
        buttonActionToGame(x3x3);
      }
    });
  }

  private void run() {
    allGameButtons = new Button[]{x1x1, x1x2, x1x3, x2x1, x2x2, x2x3, x3x1, x3x2, x3x3};
    createActionButtons();
    thegame = new Game();
    player1.setText("Player 1 wins: " + thegame.getPlayer1().getWins());
    player2.setText("Player 2 wins: " + thegame.getPlayer1().getWins());


  }
}
