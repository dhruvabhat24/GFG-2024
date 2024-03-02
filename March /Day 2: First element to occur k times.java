class Solution
{
    public int firstElementKTime(int n, int k, int[] a) { 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : a){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i) >= k)return i;
        }
        return -1;
    } 
}
