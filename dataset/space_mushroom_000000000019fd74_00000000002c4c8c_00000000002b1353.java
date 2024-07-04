import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String solve(int n){
        StringBuilder stringBuilder = new StringBuilder("\n");
        for(int i=0; i< Math.min(499, n); i++){
            stringBuilder.append(i+1).append(" ").append(i+1).append("\n");
        }
        if(n==500)
            stringBuilder.append(500).append(" ").append(500).append("\n");
        if(n==501)
            stringBuilder.append(500).append(" ").append(499).append("\n");
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();
            System.out.println("Case #" + (i + 1) + ": " + solve(n));
        }
    }
}