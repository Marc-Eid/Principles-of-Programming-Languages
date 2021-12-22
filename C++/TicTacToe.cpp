
#include <iostream>
#include <string>
#include "Board.h"

using namespace std;



int main() {



    Board game1; //initialize board object.

    for (int i = 0 ; i < Board::getBoardSize()/2 ; i++) { //repeats the game at most 9 times.

        game1.printBoard(); //print the board.

        while (!game1.entryPlayerX()) //keep asking if entry is invalid.
            continue;


        if (game1.checkWinner()) { //checks if there are 3 consecutive x's or o's in the board
            game1.printBoard();
            cout << ("player x won"); //player x wins because the checkWinner funtion checks after x plays.
            exit(0);; //if x wins we exit
        }


        game1.printBoard(); //after each play we reprint the board with the inputs

        //here we repeat the same code but for the second player.
        while (!game1.entryPlayerO()) //keep asking if entry is invalid.
            continue;


        if (game1.checkWinner()) {
            game1.printBoard();
            cout << ("player o won");
            exit(0);
        }

    }

    //the loop made 8 entries in total, so player one gets one more.
    game1.printBoard(); //print the board.

    while (!game1.entryPlayerX()) //keep asking if entry is invalid.
        continue;


    if (game1.checkWinner()) { //checks if there are 3 consecutive x's or o's in the board
        game1.printBoard();
        cout << ("player x won"); //player x wins because the checkWinner funtion checks after x plays.
        exit(0);; //if x wins we exit
    }

    //if no player wins print tie.
    cout << ("It's a tie!!");
    return 0;
}

