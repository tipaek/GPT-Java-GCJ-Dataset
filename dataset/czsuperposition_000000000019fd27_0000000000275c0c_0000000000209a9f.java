import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answer = new String[T];
        for(int i=0;i<T;i++)
        {
            String S = scanner.next();
            String temp = "";
            for(int j=0;j<S.length();j++)
                temp = temp + String.join("", Collections.nCopies(Integer.parseInt(S.substring(j,j+1)), "("))
                        + Integer.parseInt(S.substring(j,j+1))
                        + String.join("", Collections.nCopies(Integer.parseInt(S.substring(j,j+1)), ")"));
            temp = temp.replace(")(", "");
            answer[i] = temp;
        }
        for(int i=0;i<T;i++)
            System.out.println("Case #" + (i+1) + ": " + answer[i]);
    }
}