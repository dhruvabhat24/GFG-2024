class Solution {
  public:
    string findSum(string str1, string str2)
    {
        if (str1.length() > str2.length())
            swap(str1, str2);
        string str = "";
        int n1 = str1.length(), n2 = str2.length();
        reverse(str1.begin(), str1.end());
        reverse(str2.begin(), str2.end());
        int carry = 0;
        for (int i=0; i<n1; i++)
        {
            int sum = ((str1[i]-'0')+(str2[i]-'0')+carry);
            str.push_back(sum%10 + '0');
     
            carry = sum/10;
        }
        for (int i=n1; i<n2; i++)
        {
            int sum = ((str2[i]-'0')+carry);
            str.push_back(sum%10 + '0');
            carry = sum/10;
        }
        if (carry)
            str.push_back(carry+'0');
        reverse(str.begin(), str.end());
        return str;
    }
    bool isAdditiveSequence(string s) {
        int n = s.size();
        string num1 = "";
        for (int i = 0; i < n / 2; i++)
        {
            num1 += s[i];
            string num2 = "";
            for (int j = i + 1; j < n - 1; j++)
            {
                num2 += s[j];
                string prev2 = num1, prev1 = num2;
                string sum = findSum(prev1, prev2);
                string num = "";
                int k = j + 1;
                while (k < n)
                {
                    num += s[k];
                    if (num == sum)
                    {
                        prev2 = prev1;
                        prev1 = num;
                        sum = findSum(prev1, prev2);
                        num = "";
                    }
                    k++;
                }
                if (k == n && num == "")
                    return 1;
            }
        }
        return 0;
    }
};
