import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());
        for(int i = 1; i <= T; i++){
            int N = Integer.parseInt(in.nextLine());

            String[] patterns = new String[N];
            for(int j = 0; j < N; j++)
                patterns[j] = in.nextLine();

            System.out.println("Case #" + i + ": " + solve(patterns));
        }
    }

    private static String solve(String[] patterns){
        String longest = "";
        for(int i = 0; i < patterns.length; i++){
            patterns[i] = patterns[i].substring(1);
            if(patterns[i].length() > longest.length())
                longest = patterns[i];
        }

        for(int i = 0; i < patterns.length; i++){
            if(longest.indexOf(patterns[i]) != longest.length() - patterns[i].length()){
                return "*";
            }
        }

        return longest;
    }
}