class Solution {
    static String longestSubstring(String s, int n) {
        String res = "";
        int i=0, j=0;
        
        while(j < n && i < n) {
            String str = s.substring(i, j+1);
            if(s.substring(j+1, n).indexOf(str) != -1) 
                res = res.length() < (j-i+1) ? str : res;
            else
                i++;
            j++;
        }
        return res == "" ? "-1" : res;
    }
};
