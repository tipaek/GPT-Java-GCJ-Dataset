import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        int[] validMoves = new int[31];
        for(int i= 0; i<validMoves.length; i++){
            validMoves[i] = (int) Math.pow(2,i);
        }
        test:
        for (int testCase = 0; testCase < testCount; testCase++) {
            String[] split = sc.nextLine().split("\\s+");
            int xGoal = Integer.parseInt(split[0]);
            int yGoal = Integer.parseInt(split[1]);

            if (xGoal % 2 == 1 && yGoal % 2 == 1) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                boolean xNegative = false;
                boolean yNegative = false;
                if (xGoal < 0) {
                    xNegative = true;
                    xGoal *= -1;
                }

                if (yGoal < 0) {
                    yNegative = true;
                    yGoal *= -1;
                }

                boolean[] bits = new boolean[31];
                for (int i = 30; i >= 0; i--) {
                    bits[i] = (xGoal & (1 << i)) != 0;
                }
                int xPos = 0;
                int yPos = 0;
                int[] moves = new int[31];
                int maxVal = 0;

                for (int i = 0; i < moves.length; i++) {
                    if (bits[i]) {
                        maxVal = i;
                        if (xNegative) {
                            moves[i] = 1; //W
                        } else {
                            moves[i] = 2; //E
                        }
                    }
                }

                int total = 0;
                for (int i = 0; i < moves.length; i++) {
                    if (moves[i] == 0) {
                        if (i < maxVal) {
                            total += validMoves[i];
                        } else if (total >= yGoal) {
                            break;
                        } else {
                            total += validMoves[i];
                            maxVal = i;
                        }
                    }
                }

                for(int i = maxVal; i>= 0; i--){
                    if(moves[i] == 0){
                        if(yPos <= yGoal){
                            yPos +=  validMoves[i];
                            if(yNegative){
                                moves[i] = 3; //S
                            }else{
                                moves[i] = 4; //N
                            }
                        }else{
                            yPos -= validMoves[i];
                            if(yNegative){
                                moves[i] = 4; //S
                            }else{
                                moves[i] = 3; //N
                            }
                        }
                    }
                }

                if(yPos == yGoal){
                    StringBuilder solution = new StringBuilder();
                    print: for(int i = 0; i<moves.length; i++){
                        switch(moves[i]){
                            case 0:
                                break print;
                            case 1:
                                solution.append('W');
                                break;
                            case 2:
                                solution.append('E');
                                break;
                            case 3:
                                solution.append('S');
                                break;
                            case 4:
                                solution.append('N');
                                break;
                        }
                    }
                    System.out.println("Case #" + (testCase + 1) + ": " + solution);
                }else{
                    System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
                }
            }
        }
        sc.close();
    }
}
