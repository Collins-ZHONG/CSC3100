#include <iostream>
#include <string>
using namespace std;

int main() {
    int n;
    string n_s;
    getline(cin, n_s);
    n = n_s[0]-'0';
    int winner;

    string line;
    int pos;
    // int i=0;
    // while (cin) {
    for (int i=0; i<n; i++) {
        getline(cin, line);     
        // cin >> line;
        // obtain a line of "0 0 1 0"
        // where numbers are at indices 0,2,4,...
        // i/2 shows the true input
        pos = line.find('1');

        // cout << line << " & " << pos << " & " << i << endl;

        if (pos == -1) {    // the winner is this line
            if (i == 0) {         // initial condition
                winner = 0;
                // cout << "The winner should be " << 0 << endl;

            } else if (i != winner) {   // if no 1, winner should be itself. If not, no winner
            // } else if (winner != -1 && i != winner) {
                // no winner
                winner = -1;
                break;
            }

        } else {                    // if find 1, winner should be pos/2
            if (i == 0) {       // initial condition
                winner = pos/2;       
                // cout << "The Winner should be " << pos/2 << endl;

            } else if (pos/2 != winner) {   
                // no winner
                winner = -1;
                break;
            } 
            if (pos/2 == i) {   // contain the condition of pos/2 == winner
            // cannot give himself
                // cout << "give himself" << endl;
                winner = -1;
                break;
            }
        }

        // 如果他自己给了他自己
        // cout << winner << endl;
    }
    
    cout << winner << endl;

    return 0;
}