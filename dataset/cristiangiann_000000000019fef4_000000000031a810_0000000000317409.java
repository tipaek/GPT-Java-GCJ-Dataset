import java.util.Scanner;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int counter = 0; counter < n; counter++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String percorso = in.next();
            char[] path = (percorso.toCharArray());

            int totaltime = -1;
            if(x + y == 0){
                totaltime = 0;
            }else {
                for (int i = 0; i < path.length; i++) {
                    if (path[i] == 'S') y--;
                    if (path[i] == 'W') x--;
                    if (path[i] == 'E') x++;
                    if (path[i] == 'N') y++;
                    if (Math.abs(x) + Math.abs(y) <= i + 1) {
                        totaltime = i + 1;
                        break;
                    }
                }
            }

            System.out.print("Case #" + (counter + 1) + ": ");

            if(totaltime != -1) {
                System.out.println(totaltime);
            } else{
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
