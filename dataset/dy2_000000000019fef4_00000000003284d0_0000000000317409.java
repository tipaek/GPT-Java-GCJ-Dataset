import java.util.*;
        import java.io.*;
        import java.lang.Math;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); //
            int m = in.nextInt();
            String k = in.nextLine();

            boolean isImpossible = true;
            int idx = 0;
            for(int j=0; j<k.length(); j++){
                switch(k.charAt(j)){
                    case 'S':
                        m--;
                        break;
                    case 'N':
                        m++;
                        break;
                    case 'W':
                        n--;
                        break;
                    case 'E':
                        n++;
                        break;
                }

                if((Math.abs(n) + Math.abs(m)) <= j){
                    idx = j;
                    isImpossible = false;
                    break;
                }

            }
            if(isImpossible){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + i + ": " + (idx));
            }
        }
    }
}