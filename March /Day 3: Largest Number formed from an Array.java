class Solution {
    String printLargest(int n, String[] arr) {
        StringBuilder res = new StringBuilder();
        Arrays.sort(arr, (a, b)->{
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        for(String x : arr){
            res.append(x);
        }
        return res.toString();
    }
}
