import java.util.*;
import java.io.*;

class Solution{
   public static void main(String args[])throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int counter = 1;
            while(counter <= T){
               st = new StringTokenizer(br.readLine());
               String S = st.nextToken();
               HashMap<Integer,Integer> posO = new HashMap<>();
               HashMap<Integer,Integer> posC = new HashMap<>();
               char [] SS = S.toCharArray();
               int nums = SS.length, min = 58;
               int index = 0, sI = 0;
               while(nums != 0){
                  nums = 0;
                  index = 0;
                  sI = 0;
                  while(index < SS.length){
                     if(SS[index] == 48 && sI != index){
                        posO.put(sI,posO.getOrDefault(sI,0)+ (min-48));
                        posC.put(index,posC.getOrDefault(index,0)+ (min-48));
                        update(sI,index,SS,min);
                        min = 60;
                        sI = index+1;
                     }else if(SS[index] != 48) {
                        min = Math.min(min,SS[index]);
                        nums++;
                     }else
                        sI = index+1;
                     index++;
                  }
                  
                  if(min != 60){
                     posO.put(sI,posO.getOrDefault(sI,0)+ (min-48));
                     posC.put(index,posC.getOrDefault(index,0)+ (min-48));
                     update(sI,index,SS,min);
                     min = 60;
                  }
               }
               
               StringBuilder sb = new StringBuilder();
               for(int i = 0; i < S.length(); i++){
                  if(posC.containsKey(i)){
                     putClose(sb,posC.get(i));
                  }
                  if(posO.containsKey(i)){
                     putOpen(sb,posO.get(i));
                  }
                  sb.append(S.charAt(i));
               }
               
               if(posC.containsKey(S.length())){
                    putClose(sb,posC.get(S.length()));
               }


               bw.write("Case #"+counter+": "+sb.toString()+ "\n");
               bw.flush();
               counter++;
            }
            
            bw.close();
            br.close();
    }
    
    public static void update(int i, int j, char [] SS, int min){
      for(int k = i; k < j; k++){
         SS[k] -= (min-48);
      }
    }
    
    
    public static void putOpen(StringBuilder sb, int n){
    
      for(int i = 0; i < n; i++){
         sb.append('(');
      }
    }
    
     public static void putClose(StringBuilder sb, int n){
      for(int i = 0; i < n; i++){
         sb.append(')');
      }
    }
  }
      
