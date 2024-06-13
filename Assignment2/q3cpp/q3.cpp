#include <iostream>
#include <stack>

using namespace std;

// string smallestNumber(string number, int m) {
void smallestNumber(string number, int m) {
    stack<char> s1;
    
    for (char c: number) {                  // dealing data
        while (!s1.empty() && m>0 && s1.top() > c) {  // if new number larger than top --> not descend anymore
            s1.pop();
            m--;
        }
        s1.push(c);
    }

    // Keep on deleting numbers if not enough number deleted after appending all the string
    while (m>0) {
        s1.pop();
        m--;
    }

    // output part
    string ans;
    while (!s1.empty()) {
        ans = s1.top() + ans;
        s1.pop();
    }

    // dealing with the heading zeros
    // int count = 0;
    // cout << ans << endl;
    // for (char c1: ans) {
    //     // cout << (c1=='0') << endl;
    //     // cout << "count is "<< count << endl;
    //     if (c1=='0') {
    //         count++;
    //     } else {
    //         break;
    //     }
    // }
    // ans = ans.erase(0,count);   // erase at last

    // return ans.length() == 0 ? "0" : ans;

    bool headZero = true;
    if (ans.length()==0) {
        cout << 0;
        return;
    }
    for (char c1: ans) {
        if (c1=='0' && headZero) {
            continue;
        } else if (headZero) {      // c1 != 0
            headZero = false;
            cout << c1;
        } else {
            cout << c1;
        }
    }
}


int main() {
    string number;
    int m;
    /* Test case 1 */
    // number = "1942056387";
    // m = 5;

    /* Test case 2 */
    // number = "100000";
    // m = 2;

    cin >> number >> m;

    // cout << smallestNumber(number, m);
    smallestNumber(number, m);

    return 0;
}
