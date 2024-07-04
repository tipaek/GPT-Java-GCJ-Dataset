import java.io.*; 
import java.util.*;
class Solution {

    static int tongKc(int x, int y) {
        int res = 0;
        if (x > 0) res += x;
        else res -= x;
        if (y >0) res += y;
        else res -= y;
        return res;
    }

    public static void main(String[] args)throws Exception 
    { 
      Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    //   Scanner sc = new Scanner(new FileReader(new File("test.txt")));
      
      int n = sc.nextInt();
      for (int index = 1; index <= n; index++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String moves = sc.next();
            int stepRes = -1;

            if (x == 0 && y == 0) {
                stepRes = 0;
            } else {
                for (int i = 0; i < moves.length(); ++i) {
                    char nextMove = moves.charAt(i);
                    switch(nextMove) {
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
    
                    int curKc = tongKc(x, y);
                    if (curKc <= i+1) {
                            stepRes = i+1;
                            break;
                    }
    
                }
            }

            

            
            if (stepRes == -1) {
                System.out.println("Case #" + index + ": IMPOSSIBLE");
            } else {
            System.out.println("Case #" + index + ": " + stepRes);
            }

      }
    }
}