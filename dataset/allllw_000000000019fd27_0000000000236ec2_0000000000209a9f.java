import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = Integer.parseInt(in.next());
        int count = 0;
        List<String> result = new ArrayList<>();
        while(count < num){
            result.add(calculate(in.next()));
            count++;
        }

        for(int i = 0; i < result.size(); i++){
            System.out.println("Case #" + (i + 1) + ": " + result.get(i));
        }
        return;
    }

    private static String calculate(String str){
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for(int i = 0; i < str.length(); i++){
            int now = str.charAt(i) - '0';
            if(now > left){
                while(left < now) {
                    sb.append('(');
                    left++;
                }
            }
            if(i < str.length() - 1){
                sb.append(str.charAt(i));
                for(int j = 0; j < str.charAt(i) - str.charAt(i + 1); j++){
                    sb.append(')');
                    left--;
                }
            }
            else{
                sb.append(str.charAt(str.length() - 1));
            }
        }
        while(left > 0){
            sb.append(')');
            left--;
        }
        return sb.toString();
    }
}
