import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> result = new ArrayList<>();
        int total = sc.nextInt();sc.nextLine();
        for (int i = 1; i <= total; ++i) {
            String input = sc.nextLine();
            String line = "";
            int count = 0;
            for (int j = 0; j < input.length(); j++) {
                int x = Integer.parseInt(String.valueOf(input.charAt(j)));
                while (x != count) {
                    if (count > x) {
                        line = line + ")";count--;
                    } else {
                        line = line + "(";count++;
                    }
                }
                line = line+ input.charAt(j);
            }
            while (count!=0){
                line=line+")";count--;
            }
            result.add("Case #"+i+": "+line);
        }
        for (String temp : result) {
            System.out.println(temp);
        }
    }
}