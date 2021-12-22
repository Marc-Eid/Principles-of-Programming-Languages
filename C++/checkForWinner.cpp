//
// Created by marki on 2021-12-22.
//

#include <iostream>
#include <string>
#include <ctype.h>
#include <sstream>

using namespace std;


int checkWinner(string tic[]) { //this function serves to check if there are any 3 consecutive letters in the rows, columns, or diagonally.

    if (tic[0] == (tic[1]) && tic[0] == (tic[2]))
        return true;
    else if (tic[3] == (tic[4]) && tic[3] == (tic[5]))
        return true;
    else if (tic[6] == (tic[7]) && tic[6] == (tic[8]))
        return true;
    else if (tic[0] == (tic[3]) && tic[0] == (tic[6]))
        return true;
    else if (tic[1] == (tic[4]) && tic[1] == (tic[7]))
        return true;
    else if (tic[2] == (tic[5]) && tic[2] == (tic[8]))
        return true;
    else if (tic[0] == (tic[4]) && tic[0] == (tic[8]))
        return true;
    else if (tic[2] == (tic[4]) && tic[2] == (tic[6]))
        return true;
    else
        return false;
}