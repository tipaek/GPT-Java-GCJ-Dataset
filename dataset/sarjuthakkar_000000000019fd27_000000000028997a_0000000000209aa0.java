import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int max = in.nextInt();
            int trace = in.nextInt();
            boolean possibility = false;
            int sum = 0;
            int traceNumber = 0;
            for(int j = 1; j<= max; j++) {
                sum += j;
                possibility = (max * j == trace);
                if(possibility){
                    traceNumber = j;
                    break;
                }
            }
            if(!possibility){
                    if(sum == trace && max % 2 != 0) {
                        possibility = true;
                    } else {
                        System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                    }
            }
            if(possibility) {
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                if(traceNumber > 0) {
                    for(int row = 0; row < max; row++){
                        for(int column = 0; column < max; column++){
                            int numberToPrint = traceNumber + row - column;
                            while(numberToPrint > max || numberToPrint < 1){
                                if(numberToPrint > max) {
                                    numberToPrint -= max;
                                }
                                else if(numberToPrint < 1) {
                                    numberToPrint += max;
                                }
                            }
                            System.out.print(numberToPrint + " ");
                        }
                        System.out.print("\n");
                    }
                } else {
                    for(int row = max - 1; row >= 0; row--){
                        for(int column = 0; column < max; column++){
                            int traceOpp = max / 2 + 1;
                            int numberToPrint = traceOpp + row - column;
                            while(numberToPrint > max || numberToPrint < 1) {
                                if(numberToPrint > max) {
                                    numberToPrint -= max;
                                }
                                else if(numberToPrint < 1) {
                                    numberToPrint += max;
                                }
                            }
                            System.out.print(numberToPrint + " ");
                        }
                        System.out.print("\n");
                    }
                }
            }
        }
    }
}