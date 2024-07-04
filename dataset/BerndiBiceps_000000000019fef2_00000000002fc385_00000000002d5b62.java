import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();


        for (int i = 0; i < tests; i++){
            int x = in.nextInt();
            int y = in.nextInt();

            StringBuilder pat = new StringBuilder();

            if (jump(x, y, pat)){
                System.out.print(String.format("Case #%d: ", i+1));
                System.out.println(pat);
            } else{
                System.out.print(String.format("Case #%d: ", i+1));
                System.out.println("IMPOSSIBLE");
            }
        }

    }

    static boolean jump(int x, int y, StringBuilder pat){
        if (x == 0 && y == 1){
            pat.append("N");
            return true;//S
        } else if(x == 0 && y == -1){
            pat.append("S");
            return true;//N
        } else if(y == 0 && x == 1){
            pat.append("E");
            return true;//W
        } else if(y == 0 && x == -1){
            pat.append("W");
            return true;//E
        } else {
            if ((x + y) % 2 == 0){
                return false;
            }
            else if (x % 2 != 0){
                if ((y/2)%2 == 0){
                    if (((x+1)/2)%2 != 0){
                        pat.append("W");
                        return jump((x+1)/2, y/2, pat);
                    } else {
                        pat.append("E");
                        return jump((x-1)/2, y/2, pat);
                    }
                } else {
                    if (((x+1)/2)%2 == 0){
                        pat.append("W");
                        return jump((x+1)/2, y/2, pat);
                    } else {
                        pat.append("E");
                        return jump((x-1)/2, y/2, pat);
                    }
                }

            } else {
                if ((x / 2) % 2 == 0) {
                    if (((y + 1) / 2) % 2 != 0) {
                        pat.append("S");
                        return jump(x / 2, (y + 1) / 2, pat);
                    } else {
                        pat.append("N");
                        return jump(x / 2, (y - 1) / 2, pat);
                    }
                } else {
                    if (((y + 1) / 2) % 2 == 0) {
                        pat.append("S");
                        return jump(x / 2, (y + 1) / 2, pat);
                    } else {
                        pat.append("N");
                        return jump(x / 2, (y - 1) / 2, pat);
                    }
                }
            }

        }
    }
}