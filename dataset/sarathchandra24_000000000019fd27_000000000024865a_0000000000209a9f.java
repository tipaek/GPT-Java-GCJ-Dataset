import java.io.*;
import java.util.Scanner;

public class Solution {
    private static final boolean DEBUG = true;
    private static int opened;
    private static String sol;
    public static void main(String[] args) throws FileNotFoundException {
//        InputStream is = DEBUG ? new FileInputStream("C:\\Users\\Sarat\\IdeaProjects\\hashcode\\src\\codejam\\input.in") : System.in;
//        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
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
    private static void makeSolution(int num){
        while (num>opened)
            addpar();

        while (num<opened)
                rmpar();
        sol+=Integer.toString(num);
    }
    private static void addpar(){
        sol=sol+"(";
        opened++;
    }
    private static void rmpar(){
        sol=sol+")";
        opened--;
    }
}
