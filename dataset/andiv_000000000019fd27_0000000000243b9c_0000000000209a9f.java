import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();

        boolean wasPrevNextLine = false;

        for (int i = 1; i <= totalTests; i++) {
            if(!wasPrevNextLine) scanner.nextLine();
            String  str = scanner.nextLine();
            wasPrevNextLine = true;
            String result = solve(str);
            System.out.println("Case #"+i+": " + result);
        }

    }


    public static String solve(String str){
        StringBuilder result = new StringBuilder();
        int open = 0;
        for(char ch : str.toCharArray()){
            int num = ch - '0';
            if(num == open){
                result.append(ch);
            }
            else if(num > open){
                int diff = num-open;
                for(int i=0; i<diff; i++){
                    result.append('(');
                    open++;
                }
                result.append(ch);
            }
            else{
                int diff = open - num;
                for(int i=0; i < diff; i++){
                    result.append(')');
                    open --;
                }
                result.append(ch);
            }
        }
        while(open > 0){
            result.append(')');
            open --;
        }
        return result.toString();
    }

}
