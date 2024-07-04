
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] solutions = new String[T];
        for (int i = 0; i < T; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();


            solutions[i] = expogo(x, y);
            // System.out.println(solutions[i]);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String expogo(int x, int y) {

        String res = helper(Math.abs(x), Math.abs(y), "");
        if(res=="IMPOSSIBLE")return res;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.length();i++){
            Character c =res.charAt(i);
            char n=c;
            if(x<0){
                if(c=='W')n='E';
                else if(c=='E')n='W';
            }
            if(y<0){
                if(c=='N')n='S';
                else if(c=='S')n='N';
            }
            sb.append(n);
        }
        return sb.toString();

    }

    private static String helper(int x, int y, String s) {
        if (x < 0 || y < 0) return "IMPOSSIBLE";
        if (x == 0 && y == 0) return s;

        int jump = s.length() + 1;
        int dist = (int) Math.pow(2, jump - 1);
//        System.out.println(x + "," + y + " " + dist + s);

//        if (dist > x || dist> y) return "IMPOSSIBLE";
        if(x==0 && dist >y || y==0 && dist >x ||(x!=0 && y!=0 && (dist>x || dist>y)))
            return "IMPOSSIBLE";
        if (x != 0) {

            if (dist < x) {
                String west = helper(x + dist, y, s + "W");
                if (!west.equals("IMPOSSIBLE")) return west;
            }
            String east = helper(x - dist, y, s + "E");
            if (!east.equals("IMPOSSIBLE")) return east;
        }
        if (y != 0) {
            String north = helper(x, y - dist, s + "N");
            if (!north.equals("IMPOSSIBLE")) return north;

            if (dist < y) {
                String south = helper(x, y + dist, s + "S");
                if (!south.equals("IMPOSSIBLE")) return south;
            }
        }
        return "IMPOSSIBLE";
    }
}
