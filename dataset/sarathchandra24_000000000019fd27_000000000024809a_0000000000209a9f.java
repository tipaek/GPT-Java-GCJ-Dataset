import java.io.*;
import java.util.Scanner;

class Solution {
    public static int opened;
    public static String sol;
    public static void main(String[] args)  {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int cases = scanner.nextInt();
            for (int cas = 0; cas < cases; cas++) {
                opened=0;
                sol="";
                String s = scanner.next();
                for (int i = 0; i < s.length(); i++) {
                    makeSolution(Integer.parseInt(Character.toString(s.charAt(i))));
                }
                while (opened>0)
                    rmpar();
                System.out.println(sol);
            }
        }
    }
    public static void makeSolution(int num){
        while (num>opened)
            addpar();

        while (num<opened)
                rmpar();
        sol+=Integer.toString(num);
    }
    public static void addpar(){
        sol=sol+"(";
        opened++;
    }
    public static void rmpar(){
        sol=sol+")";
        opened--;
    }
}
