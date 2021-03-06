package com.company;

public class Game {

  private final Player player1;
  private final Player player2;
  private Player currentPlayerTurn;
  private final int[][] boardStatus;
  private int roundCount;
  private int currentPlayerValue; //brugt i board-status, player1 = 1 og player2 = 2

  public Game() {
    this.player1 = new Player();
    this.player2 = new Player();
    this.currentPlayerTurn = player1;
    this.boardStatus = new int[3][3];
    this.roundCount = 0;
    this.currentPlayerValue = 1;
  }

  public String playerTakesTurn() {
    String buttonText;

    if (currentPlayerTurn == player1) {
      buttonText = "X";
    } else {
      buttonText = "O";
    }

    return buttonText;
  }

  public void endTurn() {
    switchCurrentPlayerTurn();
    increaseRound();
  }

  private void switchCurrentPlayerTurn() {
    if (currentPlayerTurn == player1) {
      currentPlayerTurn = player2;
      currentPlayerValue = 2;
    } else {
      currentPlayerTurn = player1;
      currentPlayerValue = 1;
    }
  }

  private void increaseRound() {
    this.roundCount++;
  }

  public void setBoardStatus(int row, int column) {
    boardStatus[row][column] = currentPlayerValue;
  }

  public boolean win() {

    int firstNumber;
    int secondNumber;
    int thirdNumber;

    //vertical
    for (int i = 0; i < 3; i++) {
      firstNumber = boardStatus[0][i];
      secondNumber = boardStatus[1][i];
      thirdNumber = boardStatus[2][i];

      if (firstNumber != 0 && firstNumber == secondNumber && secondNumber == thirdNumber) {
        return true;
      }
    }

    //horizontal
    for (int i = 0; i < 3; i++) {
      firstNumber = boardStatus[i][0];
      secondNumber = boardStatus[i][1];
      thirdNumber = boardStatus[i][2];

      if (firstNumber != 0 && firstNumber == secondNumber && secondNumber == thirdNumber) {
        return true;
      }
    }

    //skrå
    if (boardStatus[0][0] != 0 && boardStatus[0][0] == boardStatus[1][1] && boardStatus[1][1] == boardStatus[2][2]) {
      return true;
    }

    return boardStatus[0][2] != 0 && boardStatus[0][2] == boardStatus[1][1] && boardStatus[1][1] == boardStatus[2][0];
  }

  public void resetStatusBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        boardStatus[i][j] = 0;
      }
    }
  }

  public Player getPlayer1() {
    return player1;
  }

  public Player getPlayer2() {
    return player2;
  }

  public Player getCurrentPlayerTurn() {
    return currentPlayerTurn;
  }

  public int getRoundCount() {
    return roundCount;
  }

  public void updateAfterGame() {
    resetStatusBoard();
    this.roundCount = 0;
    this.currentPlayerTurn = player1;

  }

}
