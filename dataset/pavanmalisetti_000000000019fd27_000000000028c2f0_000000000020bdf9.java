import java.util.*;
import java.io.*;
public class Solution{
    
     public static boolean isOverLapped(int[] a, int[] b){
         return a[1]>b[0];
     }

     public static char get(char x){
         return (x=='J') ? 'C' : 'J';
     }

     public static void main(String []args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        int count = 1;
        while(t-->0){
            int n = sc.nextInt();
            int[][] arr2 = new int[n][2];
            
            Map<int[], Integer> map = new HashMap<>();
            
            for(int i=0; i<n; i++){
                arr2[i][0] = sc.nextInt();
                arr2[i][1] = sc.nextInt();
                
                map.put(arr2[i], i);
            }
            
            
            // int[][] arr2 = arr.clone();
            
            boolean imp = false;
            char g = 'J';
            StringBuilder sb = new StringBuilder();
            
            Stack<int[]> stack1 = new Stack<>();
            Stack<int[]> stack2 = new Stack<>();
            
            Arrays.sort(arr2, new Comparator<int[]>(){
               @Override
               public int compare(int[] x, int[] y){
                   return x[0]-y[0];
               }
            });
            
            
            char[] charArray = new char[n];
            
            for(int i=0; i<n; i++){
                charArray[map.get(arr2[i])] = g;
                
                if(i<n-1 && isOverLapped(arr2[i], arr2[i+1])){
                    if(g=='J'){
                        stack1.push(arr2[i]);
                        g = get(g);
                        
                        if(!stack2.isEmpty() && isOverLapped(stack2.peek(), arr2[i+1])){
                            imp = true;
                            break;
                        }
                        
                    }else{
                        stack2.push(arr2[i]);
                        g = get(g);
                        
                        if(!stack1.isEmpty() && isOverLapped(stack1.peek(), arr2[i+1])){
                            imp = true;
                            break;
                        }
                    }
                }else{
                    if(g=='J'){
                        stack1.push(arr2[i]);
                    }else{
                        stack2.push(arr2[i]);
                    }
                }
            }
            
            
            System.out.println("Case #"+count+":"+" "+(imp ? "IMPOSSIBLE" : new String(charArray)));
            count++;
        }
     }
}