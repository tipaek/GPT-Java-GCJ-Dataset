import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static boolean checkIfMatches(String str, String pattern){
        if(str.length() == 0 || pattern.length() == 0){
            if(str.length() == 0 && pattern.length() == 0)
                return true;
            if(pattern.length() == 0){
                return false;
            }
            if(pattern.charAt(0) == '*')
                return checkIfMatches(str, pattern.substring(1));
            return false;
        }

        char c1 = str.charAt(0);
        char c2 = pattern.charAt(0);

        if(c2 != '*'){
            if(c1 != c2)
                return false;
            return checkIfMatches(str.substring(1), pattern.substring(1));
        }

        return checkIfMatches(str, pattern.substring(1)) || checkIfMatches(str.substring(1), pattern);
    }

    private static String solve(List<String> list){
        int max = -1;
        String maxString = "";
        for (int i=0; i<list.size(); i++){
            if(list.get(i).length() > max){
                max = list.get(i).length();
                maxString = list.get(i);
            }
        }

        maxString = maxString.substring(1);

        boolean flag = true;
        for (int i=0; i<list.size(); i++){
            flag = flag && checkIfMatches(maxString, list.get(i));
        }
        return (flag) ? maxString : "*";
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();
            input.nextLine();
            List<String> list = new ArrayList<>();
            for(int j=0; j<n; j++){
                list.add(input.nextLine());
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(list));
        }
    }
}