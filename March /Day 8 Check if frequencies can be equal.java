class Solution {
    boolean sameFreq(String s) {
        // code here
        Map<Character,Integer> hm=new HashMap<>();
        for(char c:s.toCharArray()) hm.put(c,hm.getOrDefault(c,0)+1);
        int frequencyRequired=hm.get(s.charAt(0)),freqDiffOne=0;
        for(Map.Entry<Character,Integer> m:hm.entrySet()){
            if(Math.abs(frequencyRequired-m.getValue())>1) return false;
            if(Math.abs(frequencyRequired-m.getValue())==1) freqDiffOne++;
            if(freqDiffOne>1) return false;
        }
        return true;
    }
}
