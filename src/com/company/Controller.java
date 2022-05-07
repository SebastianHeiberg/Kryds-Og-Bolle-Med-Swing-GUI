package com.company;

import javax.swing.*;
import java.awt.*;

public class Controller {

  final JFrame frame;
  final Button x0x0;
  final Button x0x1;
  final Button x0x2;
  final Button x1x0;
  final Button x1x1;
  final Button x1x2;
  final Button x2x0;
  final Button x2x1;
  final Button x2x2;
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
    x0x0 = new Button();
    bottomPanel.add(x0x0);
    x0x1 = new Button();
    bottomPanel.add(x0x1);
    x0x2 = new Button();
    bottomPanel.add(x0x2);
    x1x0 = new Button();
    bottomPanel.add(x1x0);
    x1x1 = new Button();
    bottomPanel.add(x1x1);
    x1x2 = new Button();
    bottomPanel.add(x1x2);
    x2x0 = new Button();
    bottomPanel.add(x2x0);
    x2x1 = new Button();
    bottomPanel.add(x2x1);
    x2x2 = new Button();
    bottomPanel.add(x2x2);

    frame.setPreferredSize(new Dimension(400, 400));
    frame.pack();
    frame.setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    // write your code here
    new Controller().run();
  }

  public void buttonsActionInGame(Button button) {

    if (button.getLabel().isEmpty()) { // dont want to override existing labels
      button.setLabel(thisGame.playerTakesTurn());
      if (thisGame.win()) { //if the game is over
        JOptionPane.showMessageDialog(frame, "We have a winner!");
        thisGame.getCurrentPlayerTurn().increaseWins();
        updateAfterWin();
      } else { // Its just time for another turn
        thisGame.endTurn();
      }

      if (thisGame.getRoundCount() == 9){ //no more options
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

    player1.setText("Player 1 wins: " + thisGame.getPlayer1().getWins() + "  | ");
    player2.setText("Player 2 wins: " + thisGame.getPlayer2().getWins());
  }

  public void createActionButtons() {
//    første række
    x0x0.addActionListener(e -> {
      thisGame.setBoardStatus(0, 0);
      buttonsActionInGame(x0x0);
    });
    x0x1.addActionListener(e -> {
      thisGame.setBoardStatus(0, 1);
      buttonsActionInGame(x0x1);
    });
    x0x2.addActionListener(e -> {
      thisGame.setBoardStatus(0, 2);
      buttonsActionInGame(x0x2);
    });
    //anden række
    x1x0.addActionListener(e -> {
      thisGame.setBoardStatus(1, 0);
      buttonsActionInGame(x1x0);
    });
    x1x1.addActionListener(e -> {
      thisGame.setBoardStatus(1, 1);
      buttonsActionInGame(x1x1);
    });
    x1x2.addActionListener(e -> {
      thisGame.setBoardStatus(1, 2);
      buttonsActionInGame(x1x2);
    });
    // tredje række
    x2x0.addActionListener(e -> {
      thisGame.setBoardStatus(2, 0);
      buttonsActionInGame(x2x0);
    });
    x2x1.addActionListener(e -> {
      thisGame.setBoardStatus(2, 1);
      buttonsActionInGame(x2x1);
    });
    x2x2.addActionListener(e -> {
      thisGame.setBoardStatus(2, 2);
      buttonsActionInGame(x2x2);
    });
  }

  private void run() {
    allGameButtons = new Button[]{x0x0, x0x1, x0x2, x1x0, x1x1, x1x2, x2x0, x2x1, x2x2};
    createActionButtons();
    thisGame = new Game();
    player1.setText("Player 1 wins: " + thisGame.getPlayer1().getWins()+ "  | ");
    player2.setText("Player 2 wins: " + thisGame.getPlayer1().getWins());


  }
}
