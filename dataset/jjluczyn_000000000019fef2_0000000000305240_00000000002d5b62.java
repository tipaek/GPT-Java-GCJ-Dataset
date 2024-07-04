import java.io.*;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Solution {

    public static void main(String[] args) throws IOException{

        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tests = sc.nextInt();
        for (int test = 0; test < tests; test++) {
            long X = sc.nextLong();
            long Y = sc.nextLong();
//            for (int XX = -100; XX < 101; XX++) {
//                for (int YY = -100; YY < 101; YY++) {
//                    long X = XX;
//                    long Y = YY;
                    pw.printf("Case #%d: ",test+1);
                    boolean Xneg = X < 0;
                    boolean Yneg = Y < 0;
                    X = Math.abs(X);
                    Y = Math.abs(Y);
                    if (X%2 + Y%2 != 1){
                        pw.println ("IMPOSSIBLE");
                        continue;
                    }
                    long Xc2 = ((((Long.highestOneBit(X)<<2))-1)^X)+1;
                    long Yc2 = ((((Long.highestOneBit(Y)<<2))-1)^Y)+1;
        //            pw.println("0"+Long.toBinaryString(X)+" "+Long.toBinaryString(Xc2));
        //            pw.println("0"+Long.toBinaryString(Y)+" "+Long.toBinaryString(Yc2));
        //            pw.println();
                    boolean solved = false;
                    int minLen = 100;
                    char[] sol = new char[100];
                    if((X&Y) == 0 && ((Long.highestOneBit(X|Y)<<1)-1)==X+Y){
                        solved = true;
                        int len = Math.max(Long.toBinaryString(X).length(),Long.toBinaryString(Y).length());
                        if (len<minLen) {
                            minLen = len;
                            sol = new char[100];
                            String sx = new StringBuilder(Long.toBinaryString(X)).reverse().toString();
                            for (int i = 0; i < sx.length(); i++) {
                                if (sx.charAt(i) == '1') {
                                    if (Xneg) {
                                        sol[i] = 'W';
                                    } else {
                                        sol[i] = 'E';
                                    }
                                }
                            }
                            String sy = new StringBuilder(Long.toBinaryString(Y)).reverse().toString();
                            for (int i = 0; i < sy.length(); i++) {
                                if (sy.charAt(i) == '1') {
                                    if (Yneg) {
                                        sol[i] = 'S';
                                    } else {
                                        sol[i] = 'N';
                                    }
                                }
                            }
                        }
                    }
                    if ((X&Yc2) == 0 && Yc2 !=0){
                        long Yc2aux = Yc2;
                        while (Yc2aux<X && (X&Yc2aux)==0 && (((Long.highestOneBit(X|Yc2aux)<<1)-1)!=X+Yc2aux)){
                            Yc2aux = Long.highestOneBit(Yc2aux)<<1 | Yc2aux;
                        }
                        if (((X&Yc2aux) == 0) && ((Long.highestOneBit(X|Yc2aux)<<1)-1)==X+Yc2aux){
                            solved = true;
                            int len = Math.max(Long.toBinaryString(X).length(),Long.toBinaryString(Yc2aux).length());
                            if (len<minLen) {
                                minLen = len;
                                sol = new char[100];
                                String sx = new StringBuilder(Long.toBinaryString(X)).reverse().toString();
                                for (int i = 0; i < sx.length(); i++) {
                                    if (sx.charAt(i) == '1') {
                                        if (Xneg) {
                                            sol[i] = 'W';
                                        } else {
                                            sol[i] = 'E';
                                        }
                                    }
                                }
                                String sYc2aux = new StringBuilder(Long.toBinaryString(Yc2aux)).reverse().toString();
                                for (int i = 0; i < sYc2aux.length() - 1; i++) {
                                    if (sYc2aux.charAt(i)=='1'){
                                        if (Yneg){
                                            sol[i] = 'N';
                                        } else {
                                            sol[i] = 'S';
                                        }
                                    }
                                }
                                if (Yneg && sYc2aux.charAt( sYc2aux.length() - 1)=='1'){
                                    sol[ sYc2aux.length() - 1] = 'S';
                                } else {
                                    sol[ sYc2aux.length() - 1] = 'N';
                                }
                            }
                        }
                    }
                    if ((Xc2&Y) == 0 && Xc2 !=0){
                        long Xc2aux = Xc2;
                        while (Xc2aux<Y && (Y&Xc2aux)==0 && (((Long.highestOneBit(Y|Xc2aux)<<1)-1)!=Y+Xc2aux)){
                            Xc2aux = Long.highestOneBit(Xc2aux)<<1 | Xc2aux;
                        }
                        if (((Y&Xc2aux) == 0) && ((Long.highestOneBit(Y|Xc2aux)<<1)-1)==Y+Xc2aux){
                            solved = true;
                            int len = Math.max(Long.toBinaryString(Y).length(),Long.toBinaryString(Xc2aux).length());
                            if (len<minLen) {
                                minLen = len;
                                sol = new char[100];
                                String sy = new StringBuilder(Long.toBinaryString(Y)).reverse().toString();
                                for (int i = 0; i < sy.length(); i++) {
                                    if (sy.charAt(i) == '1') {
                                        if (Yneg) {
                                            sol[i] = 'S';
                                        } else {
                                            sol[i] = 'N';
                                        }
                                    }
                                }
                                String sXc2aux = new StringBuilder(Long.toBinaryString(Xc2aux)).reverse().toString();
                                for (int i = 0; i < sXc2aux.length() - 1; i++) {
                                    if (sXc2aux.charAt(i)=='1'){
                                        if (Xneg){
                                            sol[i] = 'E';
                                        } else {
                                            sol[i] = 'W';
                                        }
                                    }
                                }
                                if (Xneg && sXc2aux.charAt( sXc2aux.length() - 1)=='1'){
                                    sol[ sXc2aux.length() - 1] = 'W';
                                } else {
                                    sol[ sXc2aux.length() - 1] = 'E';
                                }
                            }
                        }
                    }
                    if ((Xc2&Yc2) == 0){

                    }


                    if (solved) {
                        String solve = "";
                        for (int i = 0; i < minLen; i++) {
                            solve = sol[i] + solve;
                        }
                        pw.println(new StringBuilder(solve).reverse().toString());
                    } else {
                        pw.println ("IMPOSSIBLE");
                    }
                    pw.flush();

//                }
//            }
        }
        pw.flush();
    }

}