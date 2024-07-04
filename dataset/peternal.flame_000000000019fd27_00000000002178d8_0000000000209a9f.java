import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i<=t; i++){
            String solution = "";
            int depth = 0;
            //while((ch = System.in.read() - '0')>=0){
            String input = in.next();
            char[] inputChars = input.toCharArray();
            for(char c: inputChars){
                int ch = c - '0';
                while(depth<ch){
                    solution+="(";
                    depth++;
                }
                while(depth>ch){
                    solution+=")";
                    depth--;
                }
                solution+=c;
            }
            while(depth>0){
                solution+=")";
                depth--;
            }
            System.out.println("Case #" + i + ": " + solution);
        }

    }
}
