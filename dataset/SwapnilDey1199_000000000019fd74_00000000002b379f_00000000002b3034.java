import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int t = sc.nextInt();
        int z = 1;
        while(t-->0){
            int n = sc.nextInt();
            String[]arr = new String[n];
            for(int i = 0;i<n;i++){
                arr[i]=sc.next();
            }
            String temp="";
            for(String s:arr){
                if(s.length()>temp.length()) temp = s;
            }
            //System.out.println(temp);
            boolean possible = true;
            for(String s:arr){
                if(temp.substring(1).indexOf(s.substring(1))<0){
                    possible = false;
                    break;
                }
            }
            if(!possible) sb.append("Case #"+z+": "+"*"+"\n");
            else sb.append("Case #"+z+": "+temp.substring(1)+"\n");
            z++;
        }
        System.out.println(sb);
    }
}