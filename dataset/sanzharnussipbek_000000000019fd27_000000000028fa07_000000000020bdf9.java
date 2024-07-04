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

    private String getOutput(int[][] matrix){
        int num = matrix.length;
        String result = "JC";
        char[] name = new char[]{'J', 'C'};
        int nameCounter = 0;

        if(matrix.length != 2) {
            int[][][] parents = new int[2][(int) Math.ceil(matrix.length)][2];
            parents[0][0] = matrix[0];
            parents[1][0] = matrix[1];

            int[] counter = new int[2];
            counter[0] = 1;
            counter[1] = 1;

            for (int i = 2; i < num; i++) {
                int start = matrix[i][0];
                int end = matrix[i][1];

                int pStart = parents[nameCounter][counter[nameCounter] - 1][0];
                int pEnd = parents[nameCounter][counter[nameCounter] - 1][1];

                if (start < pEnd) {
                    if (start < pStart && end < pStart) {
                        parents[nameCounter][counter[nameCounter]] = matrix[i];
                        counter[nameCounter]++;
                        result += name[nameCounter];
                        nameCounter ^= 1;
                    } else {
                        nameCounter ^= 1;
                        pStart = parents[nameCounter][counter[nameCounter] - 1][0];
                        pEnd = parents[nameCounter][counter[nameCounter] - 1][1];
                        if (start < pEnd) {
                            if (start < pStart && end < pStart) {
                                parents[nameCounter][counter[nameCounter]] = matrix[i];
                                counter[nameCounter]++;
                                result += name[nameCounter];
                                nameCounter ^= 1;
                            } else
                                return "IMPOSSIBLE";
                        }else{
                            parents[nameCounter][counter[nameCounter]] = matrix[i];
                            counter[nameCounter]++;
                            result += name[nameCounter];
                            nameCounter ^= 1;
                        }
                    }

                } else {
                    parents[nameCounter][counter[nameCounter]] = matrix[i];
                    counter[nameCounter]++;
                    result += name[nameCounter];
                    nameCounter ^= 1;
                }
            }
        }

        return result;
    }
}
