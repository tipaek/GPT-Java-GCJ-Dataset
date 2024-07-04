import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tr = Integer.parseInt(br.readLine());
        for(int t=1;t<=tr;t++){
            int n = Integer.parseInt(br.readLine());
            StringBuilder[] str = new StringBuilder[n];
            for(int i=0;i<n;i++){
                str[i] = new StringBuilder(br.readLine());
                for(int j=0;j<str[i].length();j++){
                    if(str[i].charAt(j)=='*'){
                        str[i].setCharAt(j, '_');
                    }
                }
            }

            int flag[] = new int[n];
            for(int i=0;i<n;i++){
                flag[i] = 0;
            }
            StringBuilder ans = new StringBuilder();
            boolean possible=true;
            while(possible){
                int r = -1;
                for(int i=0;i<n & possible;i++){
                    if(str[i].charAt(flag[i])!='_'){
                        r = i;
                        break;
                    }
                }
                if(r!=-1){
                    ans.append(str[r].charAt(flag[r]));
                    for(int i=0;i<n && possible;i++){
                        if(str[i].charAt(flag[i])=='_'){
                            continue;
                        }
                        if(str[i].charAt(flag[i])!=ans.charAt(ans.length()-1)){
                            possible=false;
                        }else{
                            flag[i]++;
                        }
                    }
                }else{
                    break;
                }
            }

            for(int i=0;i<n;i++){
                flag[i] = str[i].length()-1;
            }
            StringBuilder last = new StringBuilder();
            while(possible){
                int r = -1;
                for(int i=0;i<n & possible;i++){
                    if(str[i].charAt(flag[i])!='_'){
                        r = i;
                        break;
                    }
                }
                if(r!=-1){
                    last.append(str[r].charAt(flag[r]));
                    for(int i=0;i<n && possible;i++){
                        if(str[i].charAt(flag[i])=='_'){
                            continue;
                        }
                        if(str[i].charAt(flag[i])!=last.charAt(last.length()-1)){
                            possible=false;
                        }else{
                            flag[i]--;
                        }
                    }
                }else{
                    break;
                }
            }

            for(int i=0;i<n;i++){
                Pattern pattern = Pattern.compile("_");
                Matcher m = pattern.matcher(str[i]);
                m.find();
                int start = m.start();
                int end = m.end();
                while(m.find()){
                    end = m.end();
                }
                for(int k=start;k<end;k++){
                    if(str[i].charAt(k)!='_'){
                        ans.append(str[i].charAt(k));
                    }
                }

            }
            if(possible) {
                System.out.println("Case #"+t+": "+ans.append(last.reverse().toString()).toString());
            }else{
                System.out.println("Case #"+t+": *");
            }

        }
    }

}
