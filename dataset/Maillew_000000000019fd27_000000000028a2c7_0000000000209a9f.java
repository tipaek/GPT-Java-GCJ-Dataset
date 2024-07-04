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
public class Solution{
     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
   static StringTokenizer st;

   

    public static void main(String[] args) throws IOException {
        int t = readInt();
        
        for (int z = 1; z<=t; z++){
            String s = " " + readLine();
            String ans = "";
            ArrayList<String> list = new ArrayList<>();
            int len = 1;
            
            for (int i =1; i<s.length(); i++){
                
                
                if (s.charAt(i)==s.charAt(i-1)){
                    len++;
                }
                
                else if (s.charAt(i)!= s.charAt(i-1)){
                    String ad = "";
                    
                    for (int j =0; j<len;j ++){
                        ad+=s.charAt(i-1);
                    }
                    list.add(ad);
                    len = 1;
                }
            }
            String ad ="";
            for (int i =0; i<len; i++){
                ad+=s.charAt(s.length()-1);
            }
            list.add(ad);
            list.remove(0);
            
            for (int i =0; i<list.size(); i++){
                int n = (int) list.get(i).charAt(0)-48;
                String b1 = "";
                String b2 ="";
                for (int j =0; j<n; j++){
                    b1+="(";
                    b2+=")";
                }
                ans+=b1;
                ans+=list.get(i);
                ans+=b2;
                
            }
            System.out.println("Case #" + z +": " + ans);
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
