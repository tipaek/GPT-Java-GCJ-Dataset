import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dbatchunag
 */

public class Solution {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] inputArray;

        input = br.readLine();
        final int T = Integer.parseInt(input);
        for (int t=1; t<=T; t++) {
            input = br.readLine();
            inputArray = input.split(" ");
            int X = Integer.parseInt(inputArray[0]);
            int Y = Integer.parseInt(inputArray[1]);
            final String M = inputArray[2];
            final int length = M.length();
            int ans = -1;
            for (int i=0; i<length; i++) {
                int x=0;
                int y=0;
                switch (M.charAt(i)) {
                    case 'S' : y-=1; break;
                    case 'N' : y+=1; break;
                    case 'E' : x+=1; break;
                    case 'W' : x-=1; break;
                }
                X+=x;
                Y+=y;
//                System.out.println("X: " + X + ", Y: " + Y);
                if (Math.abs(X) + Math.abs(Y) <= i+1) {
                    ans = i+1;
                    break;
                }
            }

            System.out.println(String.format("Case #%d: %s", t, ans==-1? "IMPOSSIBLE" : ans));
        }
    }
}



