import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests =  in.nextInt();

        for(int test = 1; test <= tests; test++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            StringBuilder answer = new StringBuilder();
            int distance = Math.abs(X) + Math.abs(Y);
            int temp = 0;
            int i = 1;
            int steps = 0;

            while(distance > temp) {
                temp += Math.pow(2, i - 1);
                i++;
                steps++;
            }

            boolean found = false;

            for(int step = steps - 1; step >= 0; step--) {
                int jump = (int) Math.pow(2, step);
                int[] X_directions = {-jump, 0, jump, 0};
                int[] Y_directions = {0, jump, 0, -jump};
                int current_distance = Integer.MAX_VALUE;
                int finalX = 0;
                int finalY = 0;
                String finalDir = "";
                for(int j = 0; j < 4; j++) {
                    int newX = X + X_directions[j];
                    int newY = Y + Y_directions[j];

                    if(step == 0 && newX == 0 && newY == 0) {
                        if(j == 0) {
                            finalDir = "E";
                        } else if(j == 1){
                            finalDir = "S";
                        } else if(j == 2) {
                            finalDir = "W";
                        } else {
                            finalDir = "N";
                        }
                        found = true;
                        break;
                    }

                    int new_distance = Math.abs(newX) + Math.abs(newY);
                    if(new_distance < current_distance) {
                        current_distance = new_distance;
                        finalX = newX;
                        finalY = newY;
                        if(j == 0) {
                            finalDir = "E";
                        } else if(j == 1){
                            finalDir = "S";
                        } else if(j == 2) {
                            finalDir = "W";
                        } else {
                            finalDir = "N";
                        }
                    }
                }
                X = finalX;
                Y = finalY;
                answer.append(finalDir);
            }

            System.out.println("Case #" + test + ": " + (found ? answer.reverse() : "IMPOSSIBLE"));
        }
    }
}