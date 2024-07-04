import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class Solution {
    
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
            int T = Integer.parseInt(br.readLine());
            while(T-- > 0){
                int B = Integer.parseInt(br.readLine());
                for(int i = 0; i < B; i++){
                    String[] arr = new String[B];
                    System.out.println(B);
                    String str = br.readLine();
                    if(str.equals("N")) System.exit(1);
                    else arr[i] = str;
                    StringBuilder sb = new StringBuilder();
                    for(String s: arr) sb.append(s);
                    System.out.println(sb);
                    String response = br.readLine();
                    if(response.equals("N")) System.exit(1);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
}