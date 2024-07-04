import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0; ++i<=t; ) {
            String s = in.nextLine();
            System.out.print("Case #"+i+": ");
            printOut(s);
            System.out.println();
        }
    }

    private static void printOut(String str) {
        int s = 0, d = 0;
        StringBuilder sb = new StringBuilder();
        String[] ints = str.split("");
        for(String st : ints){
            int i = Integer.parseInt(st);
            if(i != s){
                if (i > s && i > 0) {
                    d = i-s;
                    for(int j=0; j<d; j++){
                        sb.append("(");
                        s++;
                    }
                }
                if(i < s && i > 0) {
                    d = s-i;
                    for(int j = 0; j<d; j++) {
                        sb.append(")");
                        s--;
                    }
                }
                if (i == 0) {
                    for(int j=0; j<s; j++) {
                        sb.append(")");
                        s--;
                    }
                }
                sb.append(i);
            } else {
                sb.append(st);
            }
        }
        for(int i=0; i<s; i++)
            sb.append(")");
        System.out.print(sb.toString());
    }
}
