public class Lab2 {
    public static void main(String[] args){
        try {
            int[][] m = new int[][] {
                new int[] { 1, 2 },
                new int[] { 3, 4 }
            };
            multiplyMatrixByC(m, 3);

            print(m);

            System.out.println(getSumBiggestIntInEveryColumn(m));

            print(getAvgValueForEveryRow(m));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void multiplyMatrixByC(int[][] matrix, int c) throws Exception{
        validateMatrix(matrix);

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = matrix[i][k] * c;
            }
        }
    }

    private static int getSumBiggestIntInEveryColumn(int[][] matrix) throws Exception{
        validateMatrix(matrix);
        
        int[] ansArr = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                if(matrix[i][k] > ansArr[k]){
                    ansArr[k] = matrix[i][k];
                }
            }
        }
        
        int ans = 0;
        for(int i : ansArr) {
            ans += i;
        }

        return ans;
    }

    private static int[] getAvgValueForEveryRow(int[][] matrix) throws Exception{
        validateMatrix(matrix);

        int[] ansArr = new int[matrix.length];

        for(int i = 0; i < matrix.length; i++){
            int t = 0;
            for(int k = 0; k < matrix[i].length; k++){
                t += matrix[i][k]; 
            }
            ansArr[i] = t / matrix[0].length;
        }

        return ansArr;
    }

    private static void validateMatrix(int[][] matrix) throws Exception{
        int numRows = matrix.length;
        
        if(numRows == 0){
            throw new Exception("SHOULD NOT BE EMPTY");
        }

        int colRows = matrix[0].length;

        for(int l = 0; l < numRows; l++) {
            if(matrix[l].length != colRows){
                throw new Exception("NOT A MATRIX");
            }
        }
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}