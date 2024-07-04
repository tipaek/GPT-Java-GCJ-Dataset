import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            String line = input.readLine();
            StringBuilder s = new StringBuilder();
            
            int x = Integer.parseInt(Character.toString(line.charAt(0)));
            for(int a = 0; a<x; a++) s.append("(");
            s.append(x);
            if(line.length() == 1){
                for(int a = 0; a<x; a++) s.append(")");
            }
            for(int i = 1; i<line.length(); i++){
                int current = Integer.parseInt(Character.toString(line.charAt(i)));
                int prev = Integer.parseInt(Character.toString(line.charAt(i-1)));
                
                if(current<prev){
                    for(int j = 0; j<prev-current; j++){
                        s.append(")");
                    }
                    s.append(current);
                }
                else if(current>prev){
                    for(int j = 0; j<current-prev; j++){
                        s.append("(");
                    }
                    s.append(current);
                }
                else s.append(current);
                if(i == line.length()-1){
                    for(int j = 0; j<current; j++){
                        s.append(")");
                    }
                }
            }
            output.println("Case #" + (t+1) + ": " + s.toString());
        }
        output.flush();
        output.close();
    }
}