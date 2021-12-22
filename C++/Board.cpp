//
// Created by marki on 2021-12-22.
//

#include "Board.h"
#include <iostream>
#include <string>




    bool Board::isNumber(string s) //this private helper function serves to check whether the passed string is numeric or not.
    {
        for (int i = 0; i < s.length(); i++)
            if (isdigit(s[i]) == false)
                return false;
        return true;
    }



    int Board::getBoardSize() { //getter method that returns the static member boarSize.
        return boardSize;
    }

    void Board::printBoard() { //this function serves to print the board.

        int count = 1; //this variable serves to insert new line after 3 prints.

        for (int i = 0; i < 9; i++) {
            cout << " " << game[i] << " ";
            if (count > 0 && count % 3 == 0) {
                cout << "\n";
                cout << ("---+---+---\n");
            } else
                cout << ("|");
            count++;
        }

    }

    bool Board::entryPlayerX() { //returns true and registers the players move if successful, false otherwise. (for player Y)

        int choice;
        cout << ("where do you want to put the X? ");
        string inputValidator;
        cin >> inputValidator;
        if (isNumber(inputValidator)) //checks if the input is numeric
        {
            choice = stoi(inputValidator); //if input is numeric its stored in choice
            if (choice > 0 && choice < 10) //checks whether the enrty is between 1 and 9, inclusively
            {
                if (game[choice - 1] == 'x' || game[choice - 1] == 'o') { //checks whether the spot is already occupied.
                    cout << "try again, already chosen\n";
                    return false;
                } else {
                    game[choice - 1] = 'x';
                    return true;
                }
            }
            cout << "try again(1-9)\n";
            return false;
        }
        cout << "enter a number (1-9)\n";
        return false;
    }

    bool Board::entryPlayerO() { //returns true and registers the players move if successful, false otherwise. (for player O)

        int choice;
        cout << ("where do you want to put the O? ");
        string inputValidator;
        cin >> inputValidator;
        if (isNumber(inputValidator)) //checks if the input is numeric
        {
            choice = stoi(inputValidator); //if input is numeric its stored in choice
            if (choice > 0 && choice < 10) {
                if (game[choice - 1] == 'x' || game[choice - 1] == 'o') {
                    cout << "try again, already chosen\n";
                    return false;
                } else {
                    game[choice - 1] = 'o';
                    return true;
                }
            }
            cout << "try again(1-9)\n";
            return false;
        }
        cout << "enter a number (1-9)\n";
        return false;
    }

    int Board::checkWinner() { //this function serves to check if there are any 3 consecutive letters in the rows, columns, or diagonally.

        for (int i = 0; i < boardSize; i += 3) { //check rows
            if (game[i] == game[i + 1] && game[i] == game[i + 2])
                return true;
        }

        for (int i = 0; i < boardSize / 3; i++) { //check columns
            if (game[i] == game[i + 3] && game[i] == game[i + 6])
                return true;
        }
        if (game[0] == game[4] && game[0] == game[8]) //check diagonals
            return true;

        if (game[2] == game[4] && game[2] == game[6]) //check diagonals
            return true;


        return false;
    }

