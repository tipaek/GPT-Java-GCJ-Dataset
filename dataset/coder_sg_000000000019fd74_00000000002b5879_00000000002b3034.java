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
            String longesString = "notInitialized";
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                String str = br.readLine();
                if(str.length() == 1)
                    str = "";
                else
                    str = str.substring(1);
                if(longesString.equals("notInitialized"))
                    longesString = str;
                else {
                    if(longesString.length() < str.length())
                        longesString = str;
                    else if (longesString.length() == str.length()) {
                        if(!longesString.equals(str)) {
                            flag = false;
                        }
                    }
                }   
                if(!flag)
                    break;
                strs.add(str);
            }
            
            if(flag) {
                for(String str : strs) {
                    if(!longesString.endsWith(str)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                sb.append("Case #"+(i+1)+": "+longesString+"\n");
            else
                sb.append("Case #"+(i+1)+": *\n");
        }
        System.out.println(sb);
    } 
}
