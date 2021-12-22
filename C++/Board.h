//
// Created by marki on 2021-12-22.
//

#ifndef UNTITLED1_BOARD_H
#define UNTITLED1_BOARD_H


#include <iostream>
#include <string>

using namespace std;

class Board {

    char game[9] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; // create and initialize the array
    const static int boardSize = 9; //to avoid using "magic numbers"


    bool isNumber(string s); //this private helper function serves to check whether the passed string is numeric or not.


public:

    static int getBoardSize(); //getter method that returns the static member boarSize.

    void printBoard(); //this function serves to print the board.

    bool entryPlayerX();  //returns true and registers the players move if successful, false otherwise. (for player Y)

    bool entryPlayerO(); //returns true and registers the players move if successful, false otherwise. (for player O)

    int checkWinner(); //this function serves to check if there are any 3 consecutive letters in the rows, columns, or diagonally.

};

#endif //UNTITLED1_BOARD_H
