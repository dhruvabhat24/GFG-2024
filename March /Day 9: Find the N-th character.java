class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        for(int j=0;j<r;j++){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
            sb.append("01");
            else
            sb.append("10");
        }
        s = sb.toString().substring(0,n+1);
    }
    return s.charAt(n);
    }
}
