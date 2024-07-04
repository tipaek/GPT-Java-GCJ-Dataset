import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String lin = sc.nextLine();
        for(int cas = 0; cas < t; cas++) {
            String line = sc.nextLine();
            System.out.println("Case " + (cas + 1) + ":" +  " " + solve(line, 0));
        }
    }
    public static String solve(String input, int depth){
        String output = "";
        boolean indep = true;
        String next_dep = "";
        for(int i = 0; i < input.length(); i++){
            int current = Integer.parseInt("" + input.charAt(i));
            if(indep) {
                if (current <= depth) {
                    output = output + depth;
                } else {
                    indep = false;
                    next_dep = "";
                    next_dep = next_dep + current;
                }
            }else{
                if (current <= depth){
                    output = output + "(";
                    output = output + solve(next_dep, depth + 1);
                    output = output + ")";
                    output = output + current;
                    indep = true;
                }else{
                    next_dep = next_dep + current;
                }
            }
        }

        if(!indep){
            output = output + "(";
            output = output + solve(next_dep, depth + 1);
            output = output + ")";
        }
        //System.out.print(output);
        return output;
    }

}
