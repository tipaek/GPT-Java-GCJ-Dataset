import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int i = 1; i <=t ; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[] movements =in.next().toCharArray();
            String result ="IMPOSSIBLE";
            for (int j = 0; j < movements.length; j++) {

                if(x==0&& y==0){
                    result=""+0;
                }
                switch (movements[j]) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }
                int distance = Math.abs(x)+Math.abs(y);
                if (distance <= j+1){
                    int movmentNeeded =j+1;
                    result ="" +movmentNeeded;
                    break;
                }

            }

            System.out.println("Case #" + i+ ": " + result);
        }


    }
}