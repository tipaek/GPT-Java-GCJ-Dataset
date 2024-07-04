import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class Solution1 {
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));   
            int t = Integer.parseInt(br.readLine());
            int num = 1;
            while(t-- > 0){
                String str = br.readLine();
                StringBuilder sb = new StringBuilder();
                int open = Integer.parseInt(String.valueOf(str.charAt(0)));
                sb.append(returnOpen(open));sb.append(String.valueOf(str.charAt(0)));
                int prev = Integer.parseInt(String.valueOf(str.charAt(0)));
                for(int i = 1; i < str.length(); i++){
                    String ch = String.valueOf(str.charAt(i));
                    int val = Integer.parseInt(ch);
                    int diff = val-prev; prev = val;
                    if(diff > 0){
                        sb.append(returnOpen(diff)); sb.append(ch); open += diff;
                    }
                    else if(diff < 0){
                        sb.append(returnClose(Math.abs(diff))); sb.append(ch); open -= Math.abs(diff) ;
                    }
                    else{
                        sb.append(ch);
                    }
                }
                if(open > 0) sb.append(returnClose(open));
                System.out.println("Case #"+num+": "+sb);num++;
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static StringBuilder returnOpen(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append("(");
        }
        return sb;
    }
    public static StringBuilder returnClose(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(")");
        }
        return sb;
    }
   
}