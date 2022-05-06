package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

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
  boolean player1 = true;



  public Game() {
    frame = new JFrame("Kryds og bolle");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //hele mit bræt
    frame.setVisible(true);
    frame.setLayout(new GridLayout(3, 3));
    x1x1 = new Button();
    frame.add(x1x1);
    x1x2 = new Button();
    frame.add(x1x2);
    x1x3 = new Button();
    frame.add(x1x3);
    x2x1 = new Button();
    frame.add(x2x1);
    x2x2 = new Button();
    frame.add(x2x2);
    x2x3 = new Button();
    frame.add(x2x3);
    x3x1 = new Button();
    frame.add(x3x1);
    x3x2 = new Button();
    frame.add(x3x2);
    x3x3 = new Button();
    frame.add(x3x3);
    frame.setPreferredSize(new Dimension(400,400));
    frame.pack();
    frame.setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    // write your code here
    Game game = new Game();
    game.run();
  }

  public void switchTurn (){
    this.player1 = !player1;
  }

  public void setBox (Button button){
    if (button.getLabel().isEmpty()) {
      if (player1) {
        button.setLabel("X");
      } else {
        button.setLabel("0");
      }
      switchTurn();
    }
  }

  public void knapper () {
    //første række
    x1x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x1x1);
      }
    });
    x1x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x1x2);
      }
    });
    x1x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x1x3);
      }
    });
    //anden række
    x2x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x2x1);
      }
    });
    x2x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x2x2);
      }
    });
    x2x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x2x3);
      }
    });
    // tredje række
    x3x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x3x1);
      }
    });
    x3x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x3x2);
      }
    });
    x3x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBox(x3x3);
      }
    });
  }

  private void run() {
  knapper();


  }
}
