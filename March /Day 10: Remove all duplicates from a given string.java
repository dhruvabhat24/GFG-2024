class Solution {
    String removeDuplicates(String str) {
        Set<Character> st = new HashSet<Character>();
        String s ="";
        for(int i=0;i<str.length();i++) {
            if(! st.contains(str.charAt(i))){
                s+= str.charAt(i);
                st.add(str.charAt(i));
            }
        }
        return s;
    }
}
