package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBox implements ActionListener {

  private boolean playerTurn;
  private Button button;

  public ChangeBox (boolean playerTurn, Button button) {
    this.playerTurn = playerTurn;
    this.button = button;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (playerTurn) {
      this.button.setLabel("X");
    } else {
      this.button.setLabel("0");
    }

  }
}
