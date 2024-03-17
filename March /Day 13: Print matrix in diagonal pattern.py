class Solution:
    def matrixDiagonally(self, mat):
        n = len(mat)
        i, j = 0, 0
        diagonal_pattern = []
        # The top left half with the major diagonal
        for ij_sum in range(n):
            itr = range(ij_sum + 1)
            if ij_sum % 2 == 0:
                itr = reversed(itr)
            for i in itr:
                diagonal_pattern.append(mat[i][ij_sum - i])
        # The bottom right half
        for ij_sum in range(n, 2 * (n - 1) + 1):
            itr = range(ij_sum - (n - 1), n)
            if ij_sum % 2 == 0:
                itr = reversed(itr)
            for i in itr:
                diagonal_pattern.append(mat[i][ij_sum - i])
        return diagonal_pattern
