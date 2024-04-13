class Solution {
    static Long reversedBits(Long x) {
        long result = 0;
        int count = 0;
        long lsb = 0;
        
        while(x > 0){
            // Get the LSB from x
            lsb = x & 1L;
            // Shift lsb to right 
            lsb = lsb << (31-count);
            // OR with result
            result |= lsb;
            x = x >> 1;
            count++;
        }
        
        return result;
    }
};
