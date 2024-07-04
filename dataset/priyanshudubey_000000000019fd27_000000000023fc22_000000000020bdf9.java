import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[] ) throws Exception {
       Scanner sc = new Scanner(System.in);
       int tc = sc.nextInt();
       for(int t = 1;t <= tc;t++){
        int n = sc.nextInt();
        List<task> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            int x,y;
            x = sc.nextInt();y = sc.nextInt();
            list.add(new task(x, y,i));
        }

        Collections.sort(list,(a,b) -> (a.b == b.b)? a.e - b.e : a.b - b.b );
        char[] dec = new char[n];
        int c = list.get(0).e,j = -1;
        dec[list.get(0).ind] = 'C';
        boolean poss = true;

        for(int i = 1;i < n;i++){
            if(list.get(i).b >= c){
                dec[list.get(i).ind] = 'C';
                c = list.get(i).e;
            }else{
                if(j == -1){
                    dec[list.get(i).ind] = 'J';
                    j = list.get(i).e;
                }else if(j <= list.get(i).b){
                    dec[list.get(i).ind] = 'J';
                    j = list.get(i).e;
                }else{
                    poss = false;
                }
            }
        }
        String ans;

        if(poss){
            ans = new String(dec);
        }else{
            ans = "IMPOSSIBLE";
        }
        System.out.println("Case #" + t + ": " + ans);
       }
    }
}
class task{
    int b,e;
    int ind;
    task(int x,int y,int i){b = x;e = y;ind = i;}
}