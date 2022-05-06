package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class spil {

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
  Button[] alleKnapper;
  boolean player1tur = true;


  public boolean win() {

    //vertikalt
    for (int i = 0; i < alleKnapper.length; i += 3) {
      if (!alleKnapper[i].getLabel().isEmpty() && alleKnapper[i].getLabel().equals(alleKnapper[i + 1].getLabel()) && alleKnapper[i+1].getLabel().equals(alleKnapper[i + 2].getLabel())) {
        return true;
      }
    }
    //horrisontalt
    for (int i = 0; i < 3; i ++) {
      if (!alleKnapper[i].getLabel().isEmpty() && alleKnapper[i].getLabel().equals(alleKnapper[i + 3].getLabel()) && alleKnapper[i+3].getLabel().equals(alleKnapper[i + 6].getLabel())) {
        return true;
      }
    }

    //skrå
    if (!alleKnapper[0].getLabel().isEmpty() && alleKnapper[0].getLabel().equals(alleKnapper[4].getLabel()) && alleKnapper[4].getLabel().equals(alleKnapper[8].getLabel())) {
      return true;
    }

    if (!alleKnapper[2].getLabel().isEmpty() && alleKnapper[2].getLabel().equals(alleKnapper[4].getLabel()) && alleKnapper[4].getLabel().equals(alleKnapper[6].getLabel())) {
      return true;
    }


    return false;
  }

  public spil() {
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
    frame.setPreferredSize(new Dimension(400, 400));
    frame.pack();
    frame.setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    // write your code here
    spil game = new spil();
    game.run();
  }

  public void setTur() {
    this.player1tur = !player1tur;
  }

  public void knapAction(Button button) {
    if (button.getLabel().isEmpty()) {
      if (player1tur) {
        button.setLabel("X");
      } else {
        button.setLabel("0");
      }
      setTur();
      if (win()) {
        JOptionPane.showMessageDialog(frame, "Vi har fundet en vinder!");
      }
    }
  }

  public void tilføjActionTilKnapper() {
    //første række
    x1x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x1x1);
      }
    });
    x1x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x1x2);
      }
    });
    x1x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x1x3);
      }
    });
    //anden række
    x2x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x2x1);
      }
    });
    x2x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x2x2);
      }
    });
    x2x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x2x3);
      }
    });
    // tredje række
    x3x1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x3x1);
      }
    });
    x3x2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x3x2);
      }
    });
    x3x3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        knapAction(x3x3);
      }
    });
  }

  private void run() {
    alleKnapper = new Button[]{x1x1, x1x2, x1x3, x2x1, x2x2, x2x3, x3x1, x3x2, x3x3};
    tilføjActionTilKnapper();


  }
}
