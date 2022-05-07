package com.company;

import javax.swing.*;
import java.awt.*;

public class Controller {

  final JFrame frame;
  final Button x1x1;
  final Button x1x2;
  final Button x1x3;
  final Button x2x1;
  final Button x2x2;
  final Button x2x3;
  final Button x3x1;
  final Button x3x2;
  final Button x3x3;
  final JSplitPane splitPane;
  final JPanel topPanel;
  final JPanel bottomPanel;
  Button[] allGameButtons;
  final JLabel player1;
  final JLabel player2;
  Game thisGame;

  public Controller() {
    frame = new JFrame("Kryds og bolle");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    topPanel = new JPanel();
    bottomPanel = new JPanel();
    splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    splitPane.setDividerLocation(50);
    frame.add(splitPane);
    splitPane.setTopComponent(topPanel);
    splitPane.setBottomComponent(bottomPanel);
    frame.setVisible(true);

    //toppen
    player1 = new JLabel();
    player2 = new JLabel();
    topPanel.add(player1);
    topPanel.add(player2);

    //bunden
    bottomPanel.setLayout(new GridLayout(3, 3));
    x1x1 = new Button();
    bottomPanel.add(x1x1);
    x1x2 = new Button();
    bottomPanel.add(x1x2);
    x1x3 = new Button();
    bottomPanel.add(x1x3);
    x2x1 = new Button();
    bottomPanel.add(x2x1);
    x2x2 = new Button();
    bottomPanel.add(x2x2);
    x2x3 = new Button();
    bottomPanel.add(x2x3);
    x3x1 = new Button();
    bottomPanel.add(x3x1);
    x3x2 = new Button();
    bottomPanel.add(x3x2);
    x3x3 = new Button();
    bottomPanel.add(x3x3);

    frame.setPreferredSize(new Dimension(400, 400));
    frame.pack();
    frame.setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    // write your code here
    new Controller().run();
  }

  public void buttonActionToGame(Button button) {
    if (button.getLabel().isEmpty()) {
      button.setLabel(thisGame.playerTakesTurn());
      if (thisGame.win()) {
        JOptionPane.showMessageDialog(frame, "We have a winner!");
        thisGame.getCurrentPlayerTurn().increaseWins();
        updateAfterWin();
      }
      thisGame.endTurn();
      if (thisGame.getRoundCount() == 10){
        JOptionPane.showMessageDialog(frame, "Draw!");
        updateAfterWin();
      }
    }
  }

  private void updateAfterWin() {
    for (Button button : allGameButtons) {
      button.setLabel("");
    }

    thisGame.updateAfterGame();
    player1.setText("Player 1 wins: " + thisGame.getPlayer1().getWins());
    player2.setText("Player 2 wins: " + thisGame.getPlayer2().getWins());
  }

  public void createActionButtons() {
    //første række
    x1x1.addActionListener(e -> {
      thisGame.setBoardStatus(0, 0);
      buttonActionToGame(x1x1);
    });
    x1x2.addActionListener(e -> {
      thisGame.setBoardStatus(0, 1);
      buttonActionToGame(x1x2);
    });
    x1x3.addActionListener(e -> {
      thisGame.setBoardStatus(0, 2);
      buttonActionToGame(x1x3);
    });
    //anden række
    x2x1.addActionListener(e -> {
      thisGame.setBoardStatus(1, 0);
      buttonActionToGame(x2x1);
    });
    x2x2.addActionListener(e -> {
      thisGame.setBoardStatus(1, 1);
      buttonActionToGame(x2x2);
    });
    x2x3.addActionListener(e -> {
      thisGame.setBoardStatus(1, 2);
      buttonActionToGame(x2x3);
    });
    // tredje række
    x3x1.addActionListener(e -> {
      thisGame.setBoardStatus(2, 0);
      buttonActionToGame(x3x1);
    });
    x3x2.addActionListener(e -> {
      thisGame.setBoardStatus(2, 1);
      buttonActionToGame(x3x2);
    });
    x3x3.addActionListener(e -> {
      thisGame.setBoardStatus(2, 2);
      buttonActionToGame(x3x3);
    });
  }

  private void run() {
    allGameButtons = new Button[]{x1x1, x1x2, x1x3, x2x1, x2x2, x2x3, x3x1, x3x2, x3x3};
    createActionButtons();
    thisGame = new Game();
    player1.setText("Player 1 wins: " + thisGame.getPlayer1().getWins());
    player2.setText("Player 2 wins: " + thisGame.getPlayer1().getWins());


  }
}
