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
        String longest = Arrays.stream(patterns).max(Comparator.comparingInt(String::length)).get().substring(1);

        for(String pat : patterns){
            pat = pat.substring(1);

            if(longest.lastIndexOf(pat) != longest.length() - pat.length()){
                return "*";
            }
        }

        return longest;
    }
}