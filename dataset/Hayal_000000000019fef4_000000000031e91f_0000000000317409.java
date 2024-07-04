
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tt=scan.nextInt();
        for (int t = 0; t < tt ; t++) {
int x = scan.nextInt();
int y = scan.nextInt();
char[] path = scan.nextLine().trim().toCharArray();
int stepsLeft = path.length-x;
int stepsDone = x;
            for (int i = 0; i < x ; i++) {
                if(path[i]=='N')
                    y++;
                else
                    y--;
            }
            for (int i = x; i <path.length; i++) {
                if(y==0)
                    break;
                if(path[i]=='N'||y==1)
                    y--;
                else
                    y-=2;
                x++;

            }
            if(y==0)
            System.out.println("Case #" + (t + 1) + ": "+x);
            else
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
        }
    }
}
