import java.util.*;

public class Solution{
    public static void main(String...args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=1;i<=t;i++){
            int r = scan.nextInt();
            int c = scan.nextInt();
            int[][] competitors = new int[r][c];
            for(int j=0;j<r;j++){
                for(int k=0;k<c;k++){
                    competitors[j][k] = scan.nextInt(); 
                }
            }
            System.out.println("Case #"+i+": "+findInterest(r,c,competitors));
        }
        scan.close();
    }
    public static long findInterest(int r, int c, int[][] square) {
        boolean proceed = true;
        long totalInterest = 0;
        int[][] temp = Arrays.copy(square, r);
        while (proceed) {
            long roundInterest = 0;
            boolean isEliminated = false;
            for (int row = 0; row < r; row++) {
                for (int col = 0; col < c; col++) {
                    int competitor = square[row][col];
                    if(competitor == -1){
                        continue;
                    }
                    roundInterest = roundInterest + competitor;
                    double totalPower = 0;
                    double numOfCompetitors = 0;
                    // rows right
                    int factor = 1;
                    while (row + factor < r) {
                        if (square[row + factor][col] != -1) {
                            totalPower = totalPower + square[row + factor][col];
                            numOfCompetitors = numOfCompetitors + 1;
                            break;
                        }
                        factor += 1;
                    }

                    // rows left
                    factor = 1;
                    while (row - factor >= 0) {
                        if (square[row - factor][col] != -1) {
                            totalPower = totalPower + square[row - factor][col];
                            numOfCompetitors = numOfCompetitors + 1;
                            break;
                        }
                        factor += 1;
                    }
                    //col right
                    factor = 1;
                    while (col + factor < c) {
                        if (square[row][col + factor] != -1) {
                            totalPower = totalPower + square[row][col + factor];
                            numOfCompetitors = numOfCompetitors + 1;
                            break;
                        }
                        factor += 1;
                    }

                    //col left
                    factor = 1;
                    while (col - factor >= 0) {
                        if (square[row][col - factor] != -1) {
                            totalPower = totalPower + square[row][col - factor];
                            numOfCompetitors = numOfCompetitors + 1;
                            break;
                        }
                        factor += 1;
                    }

                    // calc average
                    if (numOfCompetitors != 0) {
                        int avg = (int) Math.ceil( totalPower / numOfCompetitors);
                        if (competitor < avg) {
                            temp[row][col] = -1;
                            isEliminated = true;
                        }
                    }
                }
            }
            proceed = isEliminated;
            totalInterest += roundInterest;
            square = temp;
        }
        return totalInterest;
    }
}