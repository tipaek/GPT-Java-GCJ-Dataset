import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
          Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
        List<String> result = new ArrayList<>();


// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            
          int N = in.nextInt();
          int[][] grid = new int[N][N];
          int  k = 0,r=0,c =0;
          
          for(int x = 0; x < N ; x++){
              for(int y=0; y < N ; y++){
                  
                  
                  grid[x][y] = in.nextInt();
                  if(x == y){ 
                      k += grid[x][y];
                  
                  }
                  
              }
              
              
          }
          
          
           for(int x = 0; x < N ; x++){
               
               HashMap<Integer,String> rows = new HashMap<>();
               
              for(int y=0; y < N ; y++){
                  
                  
                  
                  
                  
                  if(rows.containsKey(grid[x][y])){
                     r++;
                     break;
                      
                  }else{
                      rows.put(grid[x][y],x+""+y);
                  }
                   
              }
              
              
          }
           
           
            for(int x = 0; x < N ; x++){
               
               HashMap<Integer,String> columns = new HashMap<>();
               
              for(int y=0; y < N ; y++){
               
                  
                  if(columns.containsKey(grid[y][x])){
                     c++;
                     break;
                      
                  }else{
                      columns.put(grid[y][x],y+""+x);
                  }
                   
              }
              
              
          }
            
            
            result.add("Case #" + i + ": "+k+" "+r+" "+c);
          
          
          
        }
        
        
        
        for(int i = 0; i < t; i++){
            
            System.out.println(result.get(i));
            
        }
      }
    }