import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {//Rename to Solution
    static Scanner scan;
    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t = 1; t <= T; t++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int ys = 0;
            System.out.print("Case #" + t + ": ");
            boolean xneg = false;
            boolean yneg = false;
            boolean impos = false;
            if(x<0) {
                x *= -1;
                xneg = true;
            }
            if(y<0) {
                y *= -1;
                yneg = true;
            }
            String s = "";
            if((x&1)==1 && (y&1)==1) {
                System.out.print("IMPOSSIBLE");
                impos = true;
            }
            while((x&y&ys)==0 && Integer.bitCount(x^y^ys+1) == 0) {
                ys++;
                y++;
            }
            int i = 0;
            if(impos) continue;
            while((x&1<<i)!=0 || (y&1<<i)!=0 || (ys&1<<i)!=0){
                if((x&1<<i)!=0){
                    if(xneg){
                        System.out.print("W");
                    } else System.out.print("E");
                }
                if((y&1<<i)!=0){
                    if(yneg)
                        System.out.print("S");
                    else System.out.print("N");
                }
                if((ys&1<<i)!=0){
                    if(!yneg)
                        System.out.print("S");
                    else System.out.print("N");
                }
                i++;
            }
            System.out.println();
        }
        scan.close();
    }
}