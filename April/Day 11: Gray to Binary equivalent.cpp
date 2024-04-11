class Solution{
    public:
    // function to convert a given Gray equivalent n to Binary equivalent.
     int grayToBinary(int n){
        bitset<32> bin(n);
        for(int i=30;i>=0;i--){
            bin[i]=bin[i]^bin[i+1];
        }
        return bin.to_ulong();
    }
};
