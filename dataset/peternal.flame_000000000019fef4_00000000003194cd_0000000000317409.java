import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int tt = 1; tt<= t; tt++){
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            int currDist = 0;
            boolean imp = true;
            for(int i = 0; i<m.length(); i++){
                switch (m.charAt(i)) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                currDist = Math.abs(x) + Math.abs(y);
                if (currDist<=i+1){
                    currDist = i+1;
                    imp = false;
                    break;
                }

            }
            if(imp){
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            }else{
                System.out.println("Case #" + tt + ": "+currDist);
            }

        }
    }

}