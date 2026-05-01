class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        if (cols == 0) return false;

        for (int row = 0; row < rows; row++) {
            // Check if target could be in this row
            if (target >= matrix[row][0] && target <= matrix[row][cols - 1]) {
                // Binary search in this row
                int start = 0;
                int end = cols - 1;

                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    int midValue = matrix[row][mid];

                    if (target == midValue) {
                        return true;
                    } else if (target < midValue) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }

                // If not found in this row, no need to check further
                return false;
            }
        }

        return false;
    }
}
