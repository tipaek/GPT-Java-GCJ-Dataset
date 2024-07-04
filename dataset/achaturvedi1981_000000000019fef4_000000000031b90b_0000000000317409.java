import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i=0; i<T; i++){
            String data[] = scanner.nextLine().split(" ");
            int X = Integer.parseInt(data[0]);
            int Y = Integer.parseInt(data[1]);
            String M = data[2];
            int time = catchTheCat(X, Y, M);
            if(time > 0) {
                System.out.println("Case #" + (i + 1) + ": " + time);
            } else {
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static int catchTheCat(int x, int y, String m) {
        for(int i = 0; i<m.length(); i++){
            char c = m.charAt(i);
            switch (c){
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
            }
            if(Math.abs(x) + Math.abs(y)<=i+1){
                return i+1;
            }
        }
        return -1;
    }
}
