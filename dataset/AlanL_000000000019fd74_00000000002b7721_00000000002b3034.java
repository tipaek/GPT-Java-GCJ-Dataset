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

    /**
     * @param args the command line arguments
     */
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int z = 1; z<=t; z++){
            System.out.print("Case #"+z+": ");
            int n = readInt(), max = -1; String arr[] = new String[n];
            ArrayList<String>adj = new ArrayList<>();
            for(int i = 0; i<n; i++){
                String line = readLine();
                arr[i] = line;
                if(line.length()>max){
                    adj.clear();
                    max = line.length();
                    adj.add(line);
                }
                else if(line.length()==max)adj.add(line);
            }
            boolean flag1 = false;
            for(int i = 0; i<adj.size(); i++){
                boolean flag = true;
                String mainWord = adj.get(i).replaceAll("\\*", "");
                for(int j = 0; j<arr.length; j++){
                    String val = arr[j].replaceAll("\\*", "");
                    if(arr[j].charAt(0)=='*'){
                        if(mainWord.endsWith(val)){
                            continue;
                        }
                        else flag = false;
                    }
                    else if(arr[j].charAt(arr[j].length()-1)=='*'){
                        if(mainWord.startsWith(val)){
                            continue;
                        }
                        else flag = false;
                    }
                    else if(arr[j].indexOf("\\*")>0&&arr[j].indexOf("\\*")<arr[j].length()){
                        String[]split = arr[j].split("\\*");
                        String cur = ""; int index = -1;
                        for(int k = 1; k<adj.get(i).length(); k++){
                            cur+=adj.get(i).charAt(k);
                            if(cur.equals(split[0])){
                                index = k;
                                break;
                            }
                        }
                        if(index==-1){
                            flag = false;
                            break;
                        }
                        cur = "";
                        for(int k = index+1; k<adj.get(i).length(); k++){
                            cur+=adj.get(i).charAt(k);
                            if(cur.equals(split[1])){
                                break;
                            }
                        }
                    }
                    if(flag)continue;
                    break;
                }
                if(flag){
                    System.out.println(mainWord);
                    flag1 = true;
                    break;
                }
            }
            if(!flag1)System.out.println("*");
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
