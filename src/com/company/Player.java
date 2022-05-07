package com.company;

public class Player {
  private int wins;

  public Player (){
    this.wins = 0;
  }

  public void increaseWins(){
    this.wins ++;
  }

  public int getWins() {
    return wins;
  }
}
