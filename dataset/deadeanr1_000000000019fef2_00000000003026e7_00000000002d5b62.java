import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static char a[] ;
    static String response;
    static int steps = 0;
   static boolean solution = false;
    static int x, y;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        boolean g;
        for (int i = 1; i <= t; ++i) {
            a = new char[35];
            solution=false;
            steps=100;
            x=in.nextInt();
            y=in.nextInt();
            System.out.print("Case #" + i + ": ");
            check(0,0,0);
            if(!solution){
                System.out.println("IMPOSSIBLE");
            }

        }


    }

    static boolean  check(int u, int v, int i) {
        if (u == x && y == v) {
            solution = true;
            if(steps>i){
                response=new String(a).substring(0,i);
                steps = i;
            }
        }
        if (solution && steps<=i) {
            return solution;
        }
       int prev=1<<(Math.max(10,i-2));

        if (i > 33 || (Math.abs(v)>=Math.max(prev,Math.abs(y))) ||Math.abs(v-y)>Math.max(prev,Math.abs(y+v))
                || Math.abs(u)>=Math.max(prev,Math.abs(x))|| Math.abs(u-x)>Math.max(prev,Math.abs(x+u))) {
            return false;
        }
        a[i] = 'N';
        check(u, v + (1 << i), i + 1);
        a[i] = 'S';
        check(u, v - (1 << i), i + 1);
        a[i] = 'W';
        check(u - (1 << i), v, i + 1);
        a[i] = 'E';
        check(u + (1 << i), v, i + 1);

        if(i==0 && solution){
            System.out.println(response);
        }
        return false;
    }
}