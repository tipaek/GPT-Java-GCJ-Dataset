import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for(int testNum = 0; testNum < tests; testNum++){
            String input = scan.next();
            List<Integer> s = new ArrayList<Integer>();
            String output = "";
            var test2 = input.length();
            for(int i = 0; i < input.length(); i++){
                int temp = Integer.parseInt(input.substring(i, i+1));
                s.add(temp);
            }
            int depth = 0;
            for(int i = 0; i < input.length(); i++){
                int test = s.get(i);
                if(depth < s.get(i)){
                    for(int j = 0; j < s.get(i)-depth; j++){
                        output = output.concat("(");
                    }
                }else{
                    for(int j = 0; j < depth-s.get(i); j++){
                        output = output.concat(")");
                    } 
                }
                depth = s.get(i);
                String temp = Integer.toString(s.get(i));
                output = output.concat(Integer.toString(s.get(i)));
            }
            for(int j = 0; j < depth; j++){
                output = output.concat(")");
            }
            System.out.println("Case #"+(testNum+1)+": "+output);
       }
    }
}