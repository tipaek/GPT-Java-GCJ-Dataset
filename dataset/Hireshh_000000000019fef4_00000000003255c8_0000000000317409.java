
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        nextTest:
        for (int i = 1; i <= t; i++) {
            String inp = in.nextLine();
            String arr[] = inp.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            String path = arr[2];
            int hx = 0;
            int hy = 0;
            int ccy = y;
            int ccx = x;
            char prevChar = path.charAt(0);
            int cost = 0;
            boolean firstXMet=false;
            catpath:
            for (int j = 0; j < path.length(); j++) {
                char cc = path.charAt(j);
               // boolean opp = oppChar(prevChar, cc);
                if (cc == 'N') {
                    ccy++;
                } else if (cc == 'S') {
                    ccy--;
                } else if(cc=='E'){
                    ccx++;
                }else if(cc=='W'){
                    ccx--;
                }
                if (hx == ccx && hy == ccy) {
                    System.out.println("Case #" + i + ": " + (cost+1));
                    continue nextTest;
                }
                if(!firstXMet){
                    hx++;
                    cost++;
                    if(hx==ccx){
                        firstXMet=true;
                        if (hx == ccx && hy == ccy) {
                            System.out.println("Case #" + i + ": " + (cost));
                            continue nextTest;
                        }
                        continue catpath;
                    }
                }
                if (hx == ccx && hy == ccy) {
                    System.out.println("Case #" + i + ": " + (cost));
                    continue nextTest;
                }
                if(firstXMet) {

                    if (ccy > hy) {
                        hy++;
                        cost++;
                    }

                    if (hx == ccx && hy == ccy) {
                        System.out.println("Case #" + i + ": " + (cost));
                        continue nextTest;
                    }

                    if (ccy < hy) {
                        hy--;
                        cost++;
                    }
                    if (hx == ccx && hy == ccy) {
                        System.out.println("Case #" + i + ": " + (cost));
                        continue nextTest;
                    }
                }
            }
            System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }


    public static boolean oppChar(char pc, char cc) {
        if (cc == 'N') {
            return pc == 'S';
        }
        if (cc == 'S') {
            return pc == 'N';
        }
        if (cc == 'E') {
            return pc == 'W';
        }
        if (cc == 'W') {
            return pc == 'E';
        }
        return false;
    }
}
