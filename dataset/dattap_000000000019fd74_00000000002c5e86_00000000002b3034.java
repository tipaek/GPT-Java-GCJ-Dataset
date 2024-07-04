import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
    forloop:    for (int ii = 1; ii <= t; ii++) {

            int N = Integer.parseInt(s.nextLine());
            String[] P = new String[N];
            String[] Q = new String[N];
            for(int i=0; i < N; i++){
                P[i] = s.nextLine();
                Q[i] = P[i];
            }
            String sL = "";
            int f1 = 0;
            int f2 = 0;

            for(int i=0; i < N; i++) {

                if (P[i].charAt(0) == '*') {
                    if (sL.equals("") && i==0) {
                        sL = P[i].substring(1);
                        f1=1;
                    }
                    else {

                        if (sL.indexOf(P[i].substring(1)) >= 0) {

                            sL = sL;
                            //f1 = 1;
                            f2 = 1;
                            //System.out.println("sL = " + sL);
                        } else {
                            if (P[i].substring(1).indexOf(sL) >= 0) {
//                                sL = P[i].substring(1);
                                if (P[i].substring(1).lastIndexOf(sL) >= 0 && (P[i].substring(P[i].lastIndexOf(sL)+1).equals(sL) )){
                                    sL = P[i].substring(1);
                                }
                                else {
                                    sL = "";
                                }
                                f2 = 1;
                               // System.out.println("sL1 = " + sL);
                            }
                            else{
//                                String t1="";
//                                P[i] = P[i].substring(1);
//                                for (int j = 0; j < Math.min(P[i].length(), sL.length()); j++) {
//
//                                    if (sL.charAt(j) == P[i].charAt(j)) {
//                                        t1 = t1 + sL.charAt(j);
//                                        //System.out.println("t1 = " + t1);
//                                    }
//
//                                }
//                                sL = t1;
                                //System.out.println("sL2 = " + sL);
                                sL="";
                            }


                        }


                    }
                }
            }
//            if (f1==1 && f2 == 0 && N  > 1){
//                sL = "";
//            }
            int c = 0;
//            for(int i=0; i < N; i++){
//                if (Q[i].indexOf(sL) == 1){
//                    c++;
//                }
//            }
//            if (c == N){
//                System.out.println("Case #" + ii + ": "  + "*" + sL);
//                continue forloop;
//            }
            if (sL.equals("")){
                System.out.println("Case #" + ii + ": "  + "*");
            }
            else{
                System.out.println("Case #" + ii + ": "  + sL);
            }

        }
    }
}
