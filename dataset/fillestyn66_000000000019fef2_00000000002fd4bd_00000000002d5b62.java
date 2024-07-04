import java.util.*;
import java.io.*;

public class Solution {

    private static String[] upDown = new String[]{"S", "N"};
    private static String[] leftRight = new String[]{"W", "E"};

    private static boolean isPowerOfTwo(int number){
        return number > 0 && ((number & (number - 1)) == 0);
    }

    private static String getResult(int x, int y){
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        if(isPowerOfTwo(x + y)){
            return "IMPOSSIBLE";
        }
        boolean isLinearRule = x == 0 || y == 0;
        if(Math.abs(absX - absY) != 1 && !isLinearRule){
            return "IMPOSSIBLE";
        }

        StringBuilder stringBuilder = new StringBuilder(1000);
        int divisionTotal = absX + absY - 1;

        if ( x == 0 ){
            String upDown = (y > 0) ? "S" : "N";
            while (divisionTotal >= 1){
                stringBuilder.append(upDown);
                divisionTotal /= 2;
            }

        } else if (y == 0) {
            String leftRight = (x > 0) ? "E" : "W";
            while (divisionTotal >= 1){
                stringBuilder.append(leftRight);
                divisionTotal /= 2;
            }

        }else {
            int udCounter = y > 0 ? 0 : 1;
            int lrCounter = x > 0 ? 1 : 0;

            boolean shiftUp = absY > absX;

            while (divisionTotal >= 1){
                if(shiftUp){
                    shiftUp = false;
                    stringBuilder.append(upDown[udCounter % 2]);
                    udCounter++;
                }else{
                    shiftUp = true;
                    stringBuilder.append(leftRight[lrCounter % 2]);
                    lrCounter++;
                }

                divisionTotal /= 2;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String result = getResult(in.nextInt(), in.nextInt());
            System.out.println("Case #" + i + ": " + result);
        }
    }
}