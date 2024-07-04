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
            Map<Integer, edge>mp = new HashMap<>();
            for(int i = 0; i<n; i++){
                arr[i][0] = readInt(); arr[i][1] = readInt();
                mp.put(i, new edge(arr[i][0], arr[i][1]));
            }
            Arrays.sort(arr, new Comparator<Integer[]>(){
                @Override
                public int compare(Integer[]arr1, Integer[]arr2){
                    return arr1[0].compareTo(arr2[0]);
                }
            });
            System.out.print("Case #"+z+": ");
            ArrayList<edge>a = new ArrayList<>(), b = new ArrayList<>();
            boolean flag1 = true;
            for(int i = 0; i<n; i++){
                boolean flag = true;
                for(int j = 0; j<a.size(); j++){
                    edge e = a.get(j);
                    if(arr[i][0]<e.y&&arr[i][0]>=e.x||arr[i][1]>e.x&&arr[i][1]<=e.y){
                        flag = false;
                        break;
                    }
                }
                if(flag)a.add(new edge(arr[i][0], arr[i][1]));
                else{
                    flag = true;
                    for(int j = 0; j<b.size(); j++){
                        edge e = b.get(j);
                        if(arr[i][0]<e.y&&arr[i][0]>=e.x||arr[i][1]>e.x&&arr[i][1]<=e.y){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag){
                        flag1 = false;
                        break;
                    }
                    else b.add(new edge(arr[i][0], arr[i][1]));
                }
            }
            if(!flag1)System.out.println("IMPOSSIBLE");
            else{
                ArrayList<edge>list = new ArrayList<>();
                for(int i = 0; i<n; i++){
                    boolean val = true;
                    edge e = mp.get(i);
                    for(int j = 0; j<list.size(); j++){
                        edge cur = list.get(j);
                        if(cur.x==e.x&&cur.y==e.y){
                            val = false;
                            break;
                        }
                    }
                    list.add(e);
                    if(val){
                        val = false;
                        for(int j = 0; j<a.size(); j++){
                            edge cur = a.get(j);
                            if(cur.x==e.x&&cur.y==e.y){
                                System.out.print("C");
                                val = true;
                                break;
                            }
                        }
                    }
                    if(!val)System.out.print("J");
                }
                System.out.println();
            }
        }
    }
    static class edge{
        int x, y;
        edge(int x0, int y0){
            x = x0;
            y = y0;
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
}

