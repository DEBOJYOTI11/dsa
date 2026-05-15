class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length, n = matrix[0].length;

        int left = 0;
        int right = m * n - 1 ;

        while(left <= right) {

            int mid = (left + right) / 2;

            int i = mid / n;
            int j = mid % n;

            System.out.println(matrix[i][j]);
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){

                right = mid - 1 ;
            }else{
                left = mid + 1;
            }

        }
        return false;
    }
}
