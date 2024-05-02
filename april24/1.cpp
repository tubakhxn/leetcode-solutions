class Solution {
public:
    string reversePrefix(string word, char ch) {
        auto firstOcc = word.find(ch); 
        reverse(word.begin(), word.begin() + firstOcc + 1); 
        return word; 
    }
};
