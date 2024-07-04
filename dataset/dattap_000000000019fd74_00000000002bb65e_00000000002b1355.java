import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for (int ii = 1; ii <= t; ii++) {

            int N = Integer.parseInt(s.nextLine());
            String[] P = new String[N];
            for(int i=0; i < N; i++){
                P[i] = s.nextLine();
            }
            String sL = "";
            int f1 = 0;
            int f2 = 0;
            for(int i=0; i < N; i++) {

                if (P[i].charAt(0) == '*') {
                    if (sL.equals("")) {
                        sL = P[i].substring(1);
                        f1=1;
                    }
                    else {
                        if (sL.indexOf(P[i]) >= 0) {
                            sL = P[i].substring(1);
                            //f1 = 1;
                            f2 = 1;
                        } else {
                            if (P[i].indexOf(sL) >= 0) {
                                sL = P[i].substring(1);
                               f2 = 1;
                            }


                        }
                        //System.out.println("sL = " + sL);

                    }
                }
            }
            if (f1==1 && f2 == 0 && N  > 1){
                sL = "";
            }
                if (sL.equals("")){
                    System.out.println("*");
                }
                else{
                    System.out.println(sL);
                }

        }
    }
}
