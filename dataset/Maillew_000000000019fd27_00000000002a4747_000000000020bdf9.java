/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author billy
 */
class Pair { 
    int x; 
    int y; 
  
    // Constructor 
public Pair(int x, int y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
} 
  
// class to define user defined conparator 
class Compare { 
  
    static void compare(Pair array[]) 
    { 
        // sorts pair based on first element
        Arrays.sort(array, new Comparator<Pair>() { 
            @Override public int compare(Pair p1, Pair p2){ 
                return p1.x - p2.x; 
            } 
        }
        ); 
        
        
    } 
    static class cmp implements Comparator<Pair>{
            public int compare(Pair a,Pair b){
                return a.y-b.y;
            }
}
} 

public class Solution {
     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
   static StringTokenizer st;

   

    public static void main(String[] args) throws IOException {
        
        int t = readInt();
        int time = 24*60+1;
        for (int z =1; z<=t; z++){
            int n = readInt();
            Pair start[] = new Pair[n];
            Pair start2[] = new Pair[n];
            
            int fail = 0;
            int[] psa = new int[time];
            int[] a = new int[time];      
            
            
            String ans ="";
            
            for (int i =0; i<n; i++){
                int x = readInt();
                int y = readInt();
                start[i] = (new Pair(x,y));
                start2[i] = (new Pair(x, y));
                psa[x]++;
                psa[y]--;
            }
            a[0] = psa[0];
            
            for (int i =1; i<time; i++){
                a[i] = a[i-1] +psa[i];
                if (a[i]>2){
                    fail=1;
                    break;
                }
            }
            
            if (fail ==1){
                ans = "IMPOSSIBLE";
            }
            
            else{
                Compare.compare(start2);
                int J =0;
                int C =0;//checks if theyre taken
                int[] b = new int[time];
                int index = 0;
                for (int i =0; i<time; i++){
                    if (index>=n){
                        break;
                    }
                    if (b[i] == -1) {
                        J--;
                    }

                    if (b[i] == -3) {
                        C--;
                    }
                    if (b[i] == -4){
                        J--;
                        C--;
                    }
                    
                    if (i == start2[index].x){
                        
                        if (C==0){
                            if (b[i] <0){
                                b[i]=3;
                            }
                            else{
                                b[i] += 3;
                            }
                            b[start2[index].y] -=3;
                            C++;
                            index++;
                        }
                        else if (J ==0){
                            if (b[i] <0) {
                                b[i] =1;
                            }
                            else{
                                b[i]+=1;
                            }
                            b[start2[index].y] -= 1;
                            J++;
                            index++;
                        }
                       i--;  
                    }
                }
                
                
                
                for (int i =0; i<n; i++){
                    int task = start[i].x;
                    if(b[task] == 4){
                        ans+="JC";
                        b[task] -=4;
                    }
                    if (b[task] >=3){
                        ans+="C";
                        b[task] -=3;
                    }
                    if (b[task] ==1){
                        ans+="J";
                        b[task] -=1;
                    }
                }
            }
            
            System.out.println("Case #" + z + ": " + ans);
        }
    }






   static String read () throws IOException {
       while (st == null || !st.hasMoreTokens())
           st = new StringTokenizer(br.readLine().trim());
       return st.nextToken();
   }
   static long readLong () throws IOException {
       return Long.parseLong(read());
   }
   static int readInt () throws IOException {
       return Integer.parseInt(read());
   }
   static double readDouble () throws IOException {
       return Double.parseDouble(read());
   }
   static char readChar () throws IOException {
       return read().charAt(0);
   }
   static String readLine () throws IOException {
       return br.readLine().trim();
   }
    
}
