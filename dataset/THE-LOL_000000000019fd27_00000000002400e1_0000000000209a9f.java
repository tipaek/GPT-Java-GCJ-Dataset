import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        int testCases = 0;
        String input = "";
        String output = "";
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = in.nextLine();
        for(int t = 0; t < testCases; t++){//testCases
            input = in.nextLine();
            input += "0";
            for(int i = 0; i < Integer.parseInt(String.valueOf(input.charAt(0))); i++){
                output += "(";
            }
            for(int i = 1; i < input.length(); i++){
                int prev = Integer.parseInt(String.valueOf(input.charAt(i - 1)));
                int curr = Integer.parseInt(String.valueOf(input.charAt(i)));
                int pren = prev - curr;
                if(pren > 0){
                    for(int a = 0; a < pren; a++) output += ")";
                }
                else{
                    for(int a = 0; a < Math.abs(pren); a++) output += "(";
                }
                if(i != input.length() - 1) output += input.charAt(i);
            }
            System.out.print("Case #"+(t+1) +": "+output + "\n");
            output = "";
        }
    }
}