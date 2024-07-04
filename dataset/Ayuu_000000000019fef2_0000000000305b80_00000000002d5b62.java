import java.util.Scanner;
import java.lang.Math;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k = 1; k <= t; k++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String str = "";
            for(int i = 0, j = 0; j < y && i < x; i++,j++) {
            if(x%2==0 && y < 0) {
                str=str+"S";
            }
            else if(x%y==0 && y >0) {
                str=str+"N";
            }
            else if(x%2!=0 && x > 0) {
                str=str+"E";
            }
            else if(x%2!=0 && x < 0) {
                str=str+"W";
            }
            int d = (int)Math.pow(2,i-1);
            x = x-d;
            y = y-d;
            }
            System.out.println("Case "+k+": "+str);
        }
    }
}