package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBox implements ActionListener {

  private Game thisGame;

  public ChangeBox (Game thisGame) {
    this.thisGame = thisGame;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Button button = (Button) e.getSource();
    if (button.getLabel().isEmpty()) {
      button.setLabel(thisGame.playerTakesTurn());
      if (thisGame.win()) {
  //      JOptionPane.showMessageDialog(frame, "We have a winner!");
        thisGame.getCurrentPlayerTurn().increaseWins();
   //     updateAfterWin();
        System.out.println("this won by norm!");

      }
      thisGame.endTurn();
      if (thisGame.getRoundCount() == 10){
      //  JOptionPane.showMessageDialog(frame, "Draw!");
  //      updateAfterWin();
        System.out.println("round == 10");
      }
    }
  }

  }
