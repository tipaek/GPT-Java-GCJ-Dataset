import java.util.Scanner;
import java.lang.Math;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            int res = 0, z = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='N') {
                    y=y+1;
                    z = Math.abs(x)+Math.abs(y);
                }
                else if(str.charAt(j)=='E'){
                    x=x+1;
                    z = Math.abs(x)+Math.abs(y);
                }
                else if(str.charAt(j)=='S') {
                    y=y-1;
                    z = Math.abs(x)+Math.abs(y);
                }
                else if(str.charAt(j)=='W'){
                    x=x-1;
                    z = Math.abs(x)+Math.abs(y);
                }
                if(z <= (i+1)) {
                    res = i+1;
                }
            }
            if(res==0) {
                res = -1;
            }
            if(res==-1) {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #"+i+": "+res);
            }
            res=0;
        }
        System.exit(0);
    }
}