import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();

        for(int t = 1;t<=tc;++t){
            int n = s.nextInt();
            int S[] = new int[n];
            int E[] = new int[n];
            
            for(int i = 0;i<n;++i){
                S[i] = s.nextInt();
                E[i] = s.nextInt();
            }
            int count  = find(S,E,n);
            if(count > 2){
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
            else{
                char ch = 'C';
                HashMap<Integer,Integer> map = new HashMap<>();
                
                for(int i = 0;i<n;++i){
                    map.put(S[i],E[i]);
                }
                Arrays.sort(S);
                int max = map.get(S[0]);
                String output = "C";
                
                for(int i = 1;i<n;++i){
                    if(S[i] >= max){
                        output+=ch;
                    }
                    else{
                        ch = swap(ch);
                        output+=ch;
                    }
                    if(max < map.get(S[i])){
                        max = map.get(S[i]);
                    }
                }
                System.out.println("Case #"+t+": "+output);
            }
            
        }
    }
    private static char swap(char ch){
        if(ch == 'J'){
            ch = 'C';
        }
        else if(ch == 'C'){
            ch = 'J';
        }
        return ch;
    }
    static int find(int arr[], int dep[], int n) 
    { 
    
       Arrays.sort(arr); 
       Arrays.sort(dep); 
      
       int plat_needed = 1, result = 1; 
       int i = 1, j = 0; 
      
       while (i < n && j < n) 
       { 
          if (arr[i] <= dep[j]) 
          { 
              plat_needed++; 
              i++; 
       
              if (plat_needed > result)  
                  result = plat_needed; 
          } 
       
          else
          { 
              plat_needed--; 
              j++; 
          } 
       } 
       
       return result; 
    } 
}
