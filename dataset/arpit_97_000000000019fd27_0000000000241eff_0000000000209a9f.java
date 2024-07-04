import java.util.*;
import java.io.*;
import java.lang.*;


class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for(int t=1;t<=test_case;t++){
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(int i=0;i<str.length();i++){
                int a = str.charAt(i)-48;
                if(count == a){
                    sb.append(a);
                }
                else if(count>a){
                    int diff = count-a;
                    while(diff--!=0){
                        sb.append(')');
                    }
                    sb.append(a);
                    count = a;
                }
                else{
                    int diff = a-count;
                    while(diff--!=0){
                        sb.append('(');
                    }
                    sb.append(a);
                    count = a;
                }
            }
            while(count--!=0){
                sb.append(')');
            }
            System.out.println("Case #"+t+": "+sb);
        }
    }
}