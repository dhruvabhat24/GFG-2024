class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
        HashSet<Integer> set = new HashSet<>();
        for(int i :head1)
            set.add(i);
        int count =0;
        
        for(int j:head2){
            if(set.contains(x-j))
                count++;
        }
        return count;
    }
}
