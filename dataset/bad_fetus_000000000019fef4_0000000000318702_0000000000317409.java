import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        for (int testCase = 0; testCase < testCount; testCase++) {
            String[] split = sc.nextLine().split("\\s+");
            int xStart = Integer.parseInt(split[0]);
            int yStart = Integer.parseInt(split[1]);
            String moves = split[2];

            int[] catCoord = new int[]{xStart, yStart};
            int result = 0;

            for (int i = 0; i < moves.length(); i++) {
                char move = moves.charAt(i);
                switch (move) {
                    case 'N':
                        catCoord[1]++;
                        break;
                    case 'S':
                        catCoord[1]--;
                        break;
                    case 'E':
                        catCoord[0]++;
                        break;
                    case 'W':
                        catCoord[0]--;
                        break;
                }

                if(catCoord[0] + catCoord[1] <= i){
                    result = i;
                    break;
                }
            }

            if(result != 0) {
                System.out.println("Case #" + (testCase + 1) + ": " + result);
            }else{
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            }
        }
    }
}
