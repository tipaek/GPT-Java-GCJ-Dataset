/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author alanl
 */
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int z = 1; z<=t; z++){
            int n = readInt();
            Integer[][]arr = new Integer[n][2];
            for(int i = 0; i<n; i++){
                arr[i][0] = readInt(); arr[i][1] = readInt();
            }
            String ans = "";
            int cur = 0, a[] = new int[1441], b[] = new int[1441];
            boolean first = true, second = true, flag = true;
            for(int i = 0; i<n; i++){
                boolean c = true;
                if(cur==0){
                    for(int j = arr[i][0]; j<arr[i][1]; j++){
                        if(a[j]!=0){
                            c = false;
                            break;
                        }
                    }
                    if(!c){
                        first = false;
                        if(second){
                            cur = 1;
                            i--;
                        }
                        else{flag = false; break;}
                    }
                    else{
                        for(int j = arr[i][0]; j<arr[i][1]; j++){
                            a[j] = 1;
                        }
                        first = true;
                        second = true;
                        ans+="C";
                    }
                }
                else{
                    for(int j = arr[i][0]; j<arr[i][1]; j++){
                        if(b[j]!=0){
                            c = false;
                            break;
                        }
                    }
                    if(!c){
                        second = false;
                        if(first){
                            cur = 0;
                            i--;
                        }
                        else{flag = false; break;}
                    }
                    else{
                        for(int j = arr[i][0]; j<arr[i][1]; j++){
                            b[j] = 1;
                        }
                        first = true;
                        second = true;
                        ans+="J";
                    }
                }
            }
            if(!flag)System.out.println("Case #"+z+": IMPOSSIBLE");
            else System.out.println("Case #"+z+": "+ans);
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(input.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readChar () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return input.readLine().trim();
    }
    //System.out.println(Arrays.toString(e.getStackTrace()));
}

