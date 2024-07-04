import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        new Solution().runApp(args);
    }

    private void runApp(String[] args) {
        Scanner in = new Scanner(System.in);

        int caseNum = Integer.parseInt(in.nextLine());
        String[] output = new String[caseNum];

        for(int i = 0; i < caseNum; i++){
            int size = Integer.parseInt(in.nextLine());
            int[][] matrix = new int[size][2];

            for(int r = 0; r < size; r++) {
                for (int c = 0; c < 2; c++) {
                    matrix[r][c] = in.nextInt();
                }
                String dummy = in.nextLine();
            }
            output[i] = getOutput(matrix);
        }

        for(int i = 0; i < output.length; i++){
            System.out.println("Case #" + (i+1) + ": " + output[i]);
        }
    }

    private boolean canDo(int start, int end, int[][]parent){
        int counter = 0;
        for(int i = 0; i < parent.length; i++){
            int pStart = parent[i][0];
            int pEnd = parent[i][1];
            if((start < pStart && end <= pStart) || (start >= pEnd && end >= pEnd))
                counter++;
        }
        return counter == parent.length;
    }

    private String getOutput(int[][] matrix){
        int num = matrix.length;
        String result = "JC";
        char[] name = new char[]{'J', 'C'};
        int nameCounter = 0;

        if(matrix.length == 2) {
            if(matrix[0][1] == matrix[1][0])
                return "JJ";
            else
                return "JC";
        }
        else{
            int[][][] parents = new int[2][(int) Math.ceil(matrix.length)][2];
            parents[0][0] = matrix[0];
            parents[1][0] = matrix[1];

            int[] counter = new int[2];
            counter[0] = 1;
            counter[1] = 1;

            for (int i = 2; i < num; i++) {
                int start = matrix[i][0];
                int end = matrix[i][1];

                if(canDo(start, end, parents[nameCounter])) {
                    parents[nameCounter][counter[nameCounter]] = matrix[i];
                    counter[nameCounter]++;
                    result += name[nameCounter];
                    nameCounter ^= 1;
                }else if(canDo(start, end, parents[nameCounter^1])){
                    nameCounter ^= 1;
                    parents[nameCounter][counter[nameCounter]] = matrix[i];
                    counter[nameCounter]++;
                    result += name[nameCounter];
                }else{
                    return "IMPOSSIBLE";
                }
            }
        }

        return result;
    }
}