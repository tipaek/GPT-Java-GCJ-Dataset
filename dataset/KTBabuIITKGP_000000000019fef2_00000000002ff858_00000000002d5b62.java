
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t=1; t<=T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int X1 = Math.abs(X);
            int Y1 = Math.abs(Y);

            int Z = X1 + Y1;
            int max_bit = (int) (Math.log(Z)/Math.log(2));
            int ref = (int) Math.pow(2, max_bit+1) - 1;

            StringBuilder ans = new StringBuilder();
            if ((ref-Z)%2 != 0) {
                ans.append("IMPOSSIBLE");
            }else {
                int diff = (Z^ref)/2;
                int X2, Y2;
                if (X1<Y1) {
                    X2 = process(X1, diff);
                    Y2 = diff-X2;
                }else {
                    Y2 = process(Y1, diff);
                    X2 = diff-Y2;
                }
                X1 = X1+X2;
                Y1 = Y1+Y2;
                char east = (X < 0)? 'W':'E';
                char west = (X < 0)? 'E':'W';
                char north = (Y < 0)? 'S':'N';
                char south = (Y < 0)? 'N':'S';

                for (int i=0; i<=max_bit; i++) {
                    if ((X1&(int)Math.pow(2, i))!=0){
                        ans.append(east);
                    }else if ((X2&(int)Math.pow(2, i))!=0) {
                        ans.append(west);
                    }else if ((Y1&(int)Math.pow(2, i))!=0) {
                        ans.append(north);
                    }else if ((Y2&(int)Math.pow(2, i))!=0) {
                        ans.append(south);
                    }
                }
            }
            System.out.println("Case #"+t+": "+ans);
        }
    }

    private static int process(int x1, int diff) {
        int x2 = 0;
        while ((x1&diff) != 0) {
            x2 = x2+getLastUp(x1&diff);
            x1 = x1+x2;
        }
        return x2;
    }

    private static int getLastUp(int X) {
        int count = 0;
        while (X%2!=0) {
            X=X/2;
            count++;
        }
        return (int)Math.pow(1, count);
    }
}
