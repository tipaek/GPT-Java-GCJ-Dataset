import java.util.*;
import java.io.*;
public class Solution {
    static Scanner input=new Scanner(System.in);
    public static void main(String args[]) {
        int test=input.nextInt();
        int bits=input.nextInt();
        for(int t=1;t<=test;t++) {
            if(bits==10) {
                if(!solve_10()) {
                    break;
                }
            }
            else if(bits==20) {
                if(!solve_20()) {
                    break;
                }
            }
        }
    }
    public static boolean solve_10() {
        StringBuilder ans=new StringBuilder("");
        for(int i=1;i<=10;i++) {
            System.out.println(i);
            System.out.flush();
            int bit=input.nextInt();
            ans.append(bit);
        }
        System.out.println(ans);
        System.out.flush();
        char verdict=input.next().charAt(0);
        if(verdict=='N') {
            return false;
        }
        return true;
    }
    public static boolean solve_20() {
        String ans_l="";
        String ans_r="";
        while(!ans_l.equals(ans_r)) {
            for(int i=1;i<=10;i++) {
                System.out.println(i);
                System.out.flush();
                int bit=input.nextInt();
                ans_l+=bit;
            }
            for(int i=11;i<=20;i++) {
                System.out.println(i);
                System.out.flush();
                int bit=input.nextInt();
                ans_r+=bit;
            }
        }
        String str="";
        while(!str.equals(ans_l)) {
            str="";
            for(int i=1;i<=10;i++) {
                System.out.println(i);
                System.out.flush();
                int bit=input.nextInt();
                str+=bit;
            }
        }
        StringBuilder tmp=new StringBuilder(""+ans_r);
        tmp=tmp.reverse();
        ans_r=""+tmp;
        System.out.println(ans_l+ans_r);
        System.out.flush();
        char verdict=input.next().charAt(0);
        if(verdict=='N') {
            return false;
        }
        return true;
    }
//    public static boolean check_negation(StringBuilder s1,StringBuilder s2) {
//        
//    }
}
