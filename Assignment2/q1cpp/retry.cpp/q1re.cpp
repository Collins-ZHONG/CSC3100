#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<int> findNotes(string line, string index) {      // O(n)
    int len = line.length();
    vector<int> ans;
    for (int i=0; i<len; i=i+2) {       // including spaces, numbers appear at every even index
        if (line[i]=='1') {
            ans.push_back(i/2);
        }
    }
    // if (ans.size()==1 && index==ans) return "";    // 只给了自己，事实证明加上了没什么影响
    
    // // 给了自己又给了别人：导致结果增多         // 加上了也没差
    // if (ans.find(index) != -1) {
    //     int j = ans.find(index);
    //     ans = ans.substr(0, j) + ans.substr(j+1);
    // }
    if (ans.size()==0) {
        ans.push_back(stoi(index));
    }
    return ans;  // if no give anyone, return himself
}
// int main() {        /* test findNotes */    // success
//     cout << findNotes("0 0 0 0 0 0", 1) << endl;
//     return 0;
// }

vector<int> intersect(vector<int> s1, vector<int> s2) {        // O(m)
    vector<int> ans;
    int p1=0, p2=0;
    int n1 = s1.size(), n2 = s2.size();
    while (p1 < n1 && p2 < n2) {
        if (s1[p1] == s2[p2]) {
            ans.push_back(s1[p1]);
            p1++;
            p2++;
        } else if (s1[p1] < s2[p2]) {
            p1++;
        } else {
            p2++;
        }
    }
    return ans;
}
// int main() {        /* test intersect */        // success
//     cout << intersect("12357", "34679") << endl;
//     cout << intersect("12357", "469") << endl;
//     return 0;
// }


// winner 可能是多位数

int main() {
    string s;
    getline(cin, s);
    int n = stoi(s);

    vector<int> winner, notes;
    string line;
    for (int i=0; i<n; i++) {       // ask every one
        getline(cin, line);

        if (i==0) {
            winner = findNotes(line, "0");
            continue;
        }

        notes = findNotes(line, to_string(i));
        winner = intersect(winner, notes);
        if (winner.size() == 0) break;

    }

    // cout << winner << " & " << winner.size() <<  endl;
    if (winner.empty()) {
        // Empty: some one is lack of support
        cout << -1 << endl;
    } else {
        cout << winner[0] << endl;
    }

    return 0;
}