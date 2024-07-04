import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Set<String> strs = new HashSet<String>();
            String longestString = "notInitialized";
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                String str = br.readLine();
                if(str.length() > 1)
                    str = str.substring(1);
                else
                    str = "";
                if(longestString.equals("notInitialized"))
                    longestString = str;
                if(longestString.length() < str.length())
                    longestString = str;
                else if (longestString.length() == str.length() && !longestString.equals(str)) {
                    flag = false;
                    break;
                }
                strs.add(str);
            }
            if(flag) {
                for(String str : strs) {
                    if(!longestString.endsWith(str)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                sb.append("Case #"+(i+1)+": "+longestString+"\n");
            else
                sb.append("Case #"+(i+1)+": *\n");
        }
        System.out.print(sb);
    } 
}
