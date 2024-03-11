class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int r1 = 0,c1 = 0,c2 = (n*n)-1,count = 0;
        int r2 = c2/n;
        while(r1<n && c1<(n*n) && r2>=0 && c2>=0)
        {
            if(mat1[r1][c1%n]+mat2[r2][c2%n]==x){
                count++;
                c1++;
                r1 = c1/n;
                c2--;
                r2=c2/n;
            }
            else if(mat1[r1][c1%n]+mat2[r2][c2%n]<x){
                c1++;
                r1 = c1/n;
            }else{
                c2--;
                r2=c2/n;
            }
        }
        return count;
    }
}
