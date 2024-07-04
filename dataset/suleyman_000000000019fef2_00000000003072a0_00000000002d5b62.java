import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        int siz = 32;
        int[] pow2 = new int[siz];
        for(int i=0; i<siz; i++) {
            pow2[i] = (int) Math.pow(2,i);
        }

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int caseNo=1; caseNo<= T; caseNo++) {  // each case

            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int xa = Math.abs(X);
            int ya = Math.abs(Y);
            String res = "";
            int suma = xa+ya;

            if(suma%2==0) {
                res = "IMPOSSIBLE";
            }
            else {
                int lim;
                for(lim=0; lim<siz; lim++) {
                    if(suma<=pow2[lim]) {
                        break;
                    }
                }

                StringBuilder dir = new StringBuilder();

                for(int i=lim-1; i>=0; i--) {

                    //System.out.println("1- X: " + X + " Y: " + Y + " " + dir.toString());

                    if(Math.abs(X) > Math.abs(Y)) { // X's turn
                        if(X > 0) {
                            dir.append("E");
                            X -= pow2[i];
                        } else if(X<0) {
                            dir.append("W");
                            X += pow2[i];
                        }
                    }
                    else {  // Y's turn
                        if(Y > 0) {
                            dir.append("N");
                            Y -= pow2[i];
                        } else if(Y<0) {
                            dir.append("S");
                            Y += pow2[i];
                        }
                    }

                    //System.out.println("1- X: " + X + " Y: " + Y + " " + dir.toString());
                }

                //System.out.println(" suma: " + suma + " lim: " + lim);

                res = dir.reverse().toString();
            }


            System.out.println("Case #" + caseNo + ": " + res);
        }
    }
}
