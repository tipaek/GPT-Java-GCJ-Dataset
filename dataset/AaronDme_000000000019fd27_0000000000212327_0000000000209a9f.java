import java.io.*;
public class Solution{
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(input.readLine());
        for(int i = 1; i <= t; i++){
           String s = input.readLine();
           int openBrackets = 0;
           System.out.print("Case #" + i + ": ");
           for(int j = 0; j < s.length(); j++){
                int x = s.charAt(j) - '0';
                while(x > openBrackets){
                    System.out.print('(');
                    openBrackets++;
                }
                while(x < openBrackets){
                    System.out.print(')');
                    openBrackets--;
                }
                System.out.print(x);
           }
           while(openBrackets > 0){
               System.out.print(')');
               openBrackets--;
           }
           System.out.println("");
        }
    }
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
}