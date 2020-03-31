package com.cyc2018.sort;

#include <vector>
#include <iostream>
#include<string>
using namespace std;
void generate(int n, int l, int r,string str, vector<string>& res) {
    if (n == 0 || l > r || l < 0 || r <0)
        return;
    if (l == 0 && r == 0) {
        res.push_back(str);
        return;
    }
    if (l <= r && l != 0) 
        generate(n, l-1, r, str+ '(', res);
    if (l < r) 
        generate(n, l , r-1, str + ')', res);
    return;
}
int main() {
    int n;
    cin >> n;
    vector <string> vec;
    string str;
    generate(n, n, n,str,  vec);
    for (int i = 0; i < vec.size() - 1; i++){
        cout << vec[i];
        cout << ',';
    }
    cout << vec[vec.size() - 1];
    return 0;
}
1