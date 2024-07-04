import java.util.*;

class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++){
            char[] src = sc.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i='0'; i<src[0]; i++) sb.append('(');
            sb.append(src[0]);
            for(int i=1; i<src.length; i++){
                if(src[i]>src[i-1]){
                    for(int j=src[i-1]; j<src[i]; j++) sb.append('(');
                } else if(src[i]<src[i-1]){
                    for(int j=src[i]; j<src[i-1]; j++) sb.append(')');
                }
                sb.append(src[i]);
            }
            for(int i='0'; i<src[src.length-1]; i++) sb.append(')');
            System.out.println("Case #"+t+": "+sb);
        }
    }
}