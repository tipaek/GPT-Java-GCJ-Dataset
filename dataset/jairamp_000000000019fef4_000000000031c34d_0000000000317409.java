import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
7
4 4 SSSS
3 0 SNSS
2 10 NSNNSN
0 1 S
2 7 SSSSSSSS
3 2 SSSW
4 0 NESW
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; ++i) {
            String result = getResult(in);


            System.out.println("Case #" + i + ": " + result);
        }
    }
    private static String getResult(Scanner in){
        int currentX = in.nextInt();
        int currentY = in.nextInt();

        String path = in.nextLine().trim();

        int minTime = Integer.MAX_VALUE;
        boolean found = false;
//        System.out.println("Starting: " + currentX + ", " + currentY);
//        System.out.println("Path: " + path);
        for(int x =1;x <= path.length();x++){
            char c = path.charAt(x - 1);
//            System.out.println("Char: " + c);
            switch(c){
                case 'N':
                    currentY = currentY + 1;
                    break;
                case 'S':
                    currentY = currentY - 1;
                    break;
                case 'E':
                    currentX = currentX + 1;
                    break;
                case 'W':
                    currentX = currentX - 1;
                    break;
            }

            int time = Math.abs(currentX) + Math.abs(currentY);
//            System.out.println((x - 1) + ": " + currentX + ", " + currentY + " - " + time);

            if(time <= (x) && time < minTime){
                minTime = Math.min(minTime,time + ((x) - time));
//                System.out.println("Min time: " + minTime);
                found = true;
            }
        }

        if(found){
            return minTime + "";
        }
        return "IMPOSSIBLE";
    }
}
