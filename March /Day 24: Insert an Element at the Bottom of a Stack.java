class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> temp = new Stack<>();
        while(!st.empty()) {
            temp.push(st.peek());
            st.pop();
        }
        
        temp.push(x);
        
        while(!temp.empty()) {
            st.push(temp.peek());
            temp.pop();
        }
        
        return st;
    }
}
