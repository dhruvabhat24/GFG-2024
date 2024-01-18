#User function Template for python3

class Solution:
    def kTop(self, arr, N, K):
        a_to_pos = dict()
        top_freqs = []
        turn_top_K_freqs = []
        for a in arr:
            if a not in a_to_pos:
                i = len(top_freqs)
                a_freq = [-1, a]
                top_freqs.append(a_freq)
            else:
                i = a_to_pos[a]
                top_freqs[i][0] -= 1
                a_freq = top_freqs[i]
            while i > 0 and top_freqs[i - 1] > a_freq:
                pre_a = top_freqs[i - 1][1]
                a_to_pos[pre_a] = i
                top_freqs[i] = top_freqs[i - 1]
                i -= 1
            a_to_pos[a] = i
            top_freqs[i] = a_freq
            turn = []
            for j in range(min(K, len(top_freqs))):
                top_a = top_freqs[j][1]
                ### WORKARAOUND ###
                # Fix for invalid tests/judge code
                if top_a == 0:
                    break
                ### END OF WORKAROUND ###
                turn.append(top_a)
            turn_top_K_freqs.append(turn)
        return turn_top_K_freqs

#{ 
 # Driver Code Starts


t=int(input())
for _ in range(0,t):
    n,k=list(map(int,input().split()))
    a=list(map(int,input().split()))
    ob = Solution()
    ans=ob.kTop(a,n,k)
    for line in ans:
        print(*line)



# } Driver Code Ends
