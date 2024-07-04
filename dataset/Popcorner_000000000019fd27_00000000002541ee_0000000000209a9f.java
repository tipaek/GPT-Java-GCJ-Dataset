import java.util.*;
import java.io.*;

public class Solution{
    
    public static String nest(String input){
        String ans = "";
        int parCount = 0;

        for(int i = 0; i < input.length(); i++){
            while(parCount < ((int)input.charAt(i) - 48)){
                ans += "(";
                parCount++;
            }

            while(parCount > ((int)input.charAt(i) - 48)){
                ans += ")";
                parCount--;
            }

            ans += (int)input.charAt(i) - 48;
        }

        while(parCount > 0){
            ans += ")";
            parCount--;
        }

        return ans;
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tc = 0;

        if(input.hasNextLine())
            tc = Integer.parseInt(input.nextLine());

        for(int i = 0; i < tc; i++){
            String inp = input.nextLine();
            
            System.out.println("Case #" + (i + 1) + ": " + nest(inp));
        }
        input.close();
    }
}