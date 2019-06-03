#include <iostream>
#include <stdio.h>
#include <vector>
#include <string> 
#include <boost/algorithm/string.hpp>

using namespace std;

double TwoStack(vector<char> s) {
    vector<char> operators;
    vector<double> values;
    char op;
    double temp;
    double v1, v2, v3;

    for(int i = 0; i<s.size(); i++) {

        if(s[i] == '(') {
        }
        else if(s[i] == '+' || s[i] == '*') {
            operators.push_back(s[i]);
        }
        else if(s[i] == ')') {
            op = operators[operators.size()-1];
            operators.pop_back();
            if(op == '+') {
                v1 = values[values.size() -1];
                values.pop_back();
                v2 = values[values.size() -1];
                values.pop_back();
                values.push_back(v1 + v2);
            }
            else if(op == '*') {
                v1 = values[values.size() -1];
                values.pop_back();
                v2 = values[values.size() -1];
                values.pop_back();
                values.push_back(v1 * v2);
            };
        }
        else {
            temp = (double)s[i];
            values.push_back(temp);
        };
    };
    v3 = values[values.size() - 1];
    values.pop_back();
    return v3;
};

vector<char> split(string s) {
    vector<char> ans;
    char temp;

    for(int i = 0; i<s.length(); i++) {
        temp = s[i];
        ans.push_back(temp);
    };

    return ans;
};
int main() {
    string s = "(1+((2+3)*(4*5)))";
    char z = '9';
    string v(1,z);
    cout<<v<<endl;
    vector<char> answer = split(s);
    double res = TwoStack(answer);
    cout<<res<<endl;
};