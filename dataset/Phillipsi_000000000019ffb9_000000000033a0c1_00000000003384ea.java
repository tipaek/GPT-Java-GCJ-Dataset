import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try{
        
		      //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for(int i = 1; i<=t; i++){
                st = new StringTokenizer(br.readLine());
                long l = Long.parseLong(st.nextToken());
                long r = Long.parseLong(st.nextToken());
                long currentPancakes = 1;
                while(currentPancakes <= l || currentPancakes <= r){
                  if(l >= r){
                     l-=currentPancakes;
                  }else{
                     r-=currentPancakes;
                  }
                  currentPancakes++;
                }
                System.out.println("Case #" + i + ": " + (currentPancakes-1) + " " + l + " " + r); 
            }
        }catch(IOException e){
            return;
        }
    }
    
}