public class Vestigium {
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int testCases = input.nextLine();
        int matrixSize = 0;
        // matrixMap {matrix1: matrix[][]}
        HashMap<String, int[][]> matrixMap = new HashMap<String, int[][]>(testCases);
        for(int t = 0; t < testCases; t++){
            matrixSize = input.nextLine();
            int[][] matrix = new int[matrixSize][matrixSize];
            for(int r = 0; r < matrixSize; r++){
                String[] row = input.nextLine().split(" ");
                for(int i = 0; i < matrixSize; i++){
                    matrix[r][i] = Integer.parseInt(row[i]);
                }
            }
            matrixMap.put("matrix" + t, matrix);
        }
        input.close();
        output(matrixMap);
    }

    
    static String output(HashMap<String, int[][]> matrixMap){
        int count = 1;
        for(Map.Entry set : matrixMap.entrySet()){
            int[][] transposedMatrix = new int[set.getKey().length][set.getKey().length];
            transposedMatrix = transpose(set.getKey());
            System.out.println("Case #" + count + ": " + solveTrace + " " + sovleDuplicates(set.getKey()) + " " + solveDuplicase(transposedMatrix));
        }
    }
    
    // Case #x: k (R) (C)
    static int solveDuplicates(int[][] matrix){
        int count = 0; 
        for(int i = 0; i < matrix.length; i++){ 
            for(int[] rows : i){
                if(!duplicate(rows)){
                    count+=1;
                }
            }
        }
        return count;
    }

    static boolean duplicate(int[] row){
        Set<Integer> lump = new HashSet<Integer>();
        for(int i : row){
            if(lump.contains(i)){
                return true;
            } else {
                lump.add(i);
            }
        }
        return false;
    }
    
    static int[][] transpose(int[][] matrix){
        int[][] transposedMatrix = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }
    
    static int solveTrace(int[][] matrix){
        int trace = 0;
        for(int i = 0; i < matrix.length; i++){
            trace += matrix[i][i];
        }
        return trace;
    }
}