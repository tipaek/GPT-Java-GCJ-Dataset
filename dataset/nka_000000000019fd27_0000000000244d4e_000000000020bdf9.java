import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int x = 1;
        while (T > 0) {
            int n = sc.nextInt();
            boolean[] cTime=new boolean[1441];
            boolean[] jTime=new boolean[1441];
            int sC = -1;
            int eC = -1;
            int sJ = -1;
            int eJ = -1;
            String output = "";
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                if (eC<=s || sC>=e) {
                    output += "C";
                    sC = s;
                    eC = e;
                } else if (eJ<=s || sJ>=s) {
                    output += "J";
                    sJ = s;
                    eJ = e;
                }
            }
            if (output.length() > 2 || (output.length()==2 && output.charAt(0)==output.charAt(1))) {
                System.out.println("Case #" + x + ": " + output);
            } else {
                System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
            }
            T--;
            x++;
        }
    }

}
