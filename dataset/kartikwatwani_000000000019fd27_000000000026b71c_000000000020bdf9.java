import java.util.*;
    import java.io.*;
    public class Solution {
      private static boolean isFree(int[] when,int[][] inv){
          boolean result=true;
          for(int t=0;t<inv.length;t++){
            int[] ca=inv[t];
            if(ca[0]!=0 ||ca[1]!=0){
                if((when[0]>=ca[0]&& when[0]<ca[1])
                ||(when[1]>ca[0]&& when[1]<=ca[1])||
                (when[0]==ca[0] && when[1]==ca[1])){
                    result=false;
                    break;
                }
                
            }
          }
          return result;
      }
     public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    }
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
          StringBuilder result=new StringBuilder();
          int[][] acts=new int[N][2];
          int[][] cam=new int[N][2];
          int caml=0;
          int[][] jam=new int[N][2];
          int jaml=0;
          for(int act=0;act<N;act++){
              acts[act]=new int[]{in.nextInt(),in.nextInt()};
          }
        // sortbyColumn(acts,0);
         
          for(int tac=0;tac<N;tac++){
              if(tac<N){
              int[] ca=acts[tac];
              if(isFree(ca,cam)){
                cam[caml]=ca;
                caml++;
                result.append('C');
              }
              else if(isFree(ca,jam)){
                jam[jaml]=ca;
                jaml++;
                result.append('J');
              }
              if(tac==N-1 && caml+jaml==N)break;
              else if(tac==N-1){
                  cam=new int[N][2];
                  caml=0;
                  jam=new int[N][2];
                  jaml=0;
              }
              }
              /**
              else{
                  int[] ca=acts[N-tac];
                if(isFree(ca,jam)){
                jam[jaml]=ca;
                jaml++;
              }  
               else if(isFree(ca,cam)){
                cam[caml]=ca;
                caml++;
              }
               
              }
               **/
          }
          
          System.out.println("Case #" + i + ": " +
          (caml+jaml==N?result.toString():"IMPOSSIBLE"));
        }
      }
    }