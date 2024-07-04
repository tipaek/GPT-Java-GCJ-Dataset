import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int numTests = sc.nextInt();

	    for(int t = 1; t <= numTests; t++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] floor = new int[r][c];

            long result = 0;
            int[] countInCol = new int[c];
            int[] countInRow = new int[r];

            long curSum = 0;

            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    floor[i][j] = sc.nextInt();
                    curSum += floor[i][j];
                    countInRow[i]++;
                    countInCol[j]++;
                }
            }

            boolean proceed = true;
            while(proceed){
                ArrayList<String> eliminated = new ArrayList<>();
                proceed = false;
                result += curSum;

                for(int i = 0; i < r; i++){
                    for(int j = 0; j < c; j++){
                        if(floor[i][j] != -1){
                            // check if compass neighbour exists
                            if(true){
                                int countNeighbour = 0;
                                int sumNeighbourSkill = 0;
                                for(int k = i-1; k >= 0; k--){
                                    if(floor[k][j] != -1){
                                        countNeighbour++;
                                        sumNeighbourSkill += floor[k][j];
                                        break;
                                    }
                                }
                                for(int k = i+1; k < r; k++){
                                    if(floor[k][j] != -1){
                                        countNeighbour++;
                                        sumNeighbourSkill += floor[k][j];
                                        break;
                                    }
                                }
                                for(int k = j-1; k >= 0; k--){
                                    if(floor[i][k] != -1){
                                        countNeighbour++;
                                        sumNeighbourSkill += floor[i][k];
                                        break;
                                    }
                                }
                                for(int k = j+1; k < c; k++){
                                    if(floor[i][k] != -1){
                                        countNeighbour++;
                                        sumNeighbourSkill += floor[i][k];
                                        break;
                                    }
                                }

                                if(floor[i][j] < ((double) sumNeighbourSkill / (double) countNeighbour)){
                                    eliminated.add(i + "_" + j);
                                    proceed = true;
                                }
                            }
                        }
                    }
                }

                for(String s : eliminated){
                    String[] q = s.split("_");
                    int row = Integer.parseInt(q[0]);
                    int col = Integer.parseInt(q[1]);
                    curSum -= floor[row][col];
                    floor[row][col] = -1;
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}
