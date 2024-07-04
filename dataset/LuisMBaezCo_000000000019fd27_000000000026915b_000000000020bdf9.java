import java.io.*;
import java.util.*;

public class Solution {

    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);
    
    public static String solve(ArrayList<ArrayList<Data>> start,
                              ArrayList<ArrayList<Data>> end, int n) {
        if(n==0) return "";
        
        StringBuilder output=new StringBuilder();
        
        boolean[][] task = new boolean[n][2];
        
        boolean J=false, C=false;
        
        ArrayList<Data> curr1, curr2;
        
        for(int i = 0; i <= 24*60; ++i) {
            curr1 = start.get(i);
            curr2 = end.get(i);
            
            
            if(curr2.size() != 0) {
                if(curr2.size()==2) {
                    J=false;C=false;
                } else if(curr2.size()==1) {
                    if(task[curr2.get(0).index][0]==true)J=false;
                    else if(task[curr2.get(0).index][1]==true)C=false;
                } if(curr2.size() > 2) return "IMPOSSIBLE";
            }
            
            if(curr1.size() != 0) {
                if(curr1.size() == 0) continue;
                
                if((J||C) && curr1.size() > 1) return "IMPOSSIBLE";
                else if(curr1.size() > 2) return "IMPOSSIBLE";
                else if((J&&C) && curr1.size()>0) return "IMPOSSIBLE";
                
                if((!J||!C)&& curr1.size()==1) {
                    if(!J) {
                        J = true;
                        task[curr1.get(0).index][0] = true;
                        output.append('J');
                    } else if(!C) {
                        C = true;
                        task[curr1.get(0).index][1] = true;
                        output.append('C');
                    } else return "IMPOSSIBLE";
                } else if((!J&&!C) && curr1.size() == 2) {
                    J=true;
                    C=true;
                    task[curr1.get(0).index][0] = true;
                    task[curr1.get(1).index][1] = true;
                    output.append('J');
                    output.append('C');
                }
            }
        }
        
        return output.toString();
    }
    
    public static void main(String[] args) {
        
        int T = in.nextInt();
        
        int n, x, y;
        for(int t=1;t<=T; ++t) {
            n = in.nextInt();
            
            
            ArrayList<ArrayList<Data>> start = new ArrayList<>(60*24);
            ArrayList<ArrayList<Data>> end = new ArrayList<>(60*24);
            
            for(int i = 0; i <= 60*24; ++i) {
                start.add(new ArrayList<>());
                end.add(new ArrayList<>());
            }
            
            ArrayList<Data> tmp;
            for(int i = 0; i < n; ++i) {
                x = in.nextInt();
                y = in.nextInt();
                
                tmp = start.get(x);
                tmp.add(new Data(x, y, i));
                start.set(x, tmp);
                
                tmp = end.get(y);
                tmp.add(new Data(x, y, i));
                end.set(y, tmp);
            }
            
            
            out.println("Case #"+t+": "+solve(start, end, n));
        }
    }
    
    static class Data {
        int start;
        int end;
        int index;
        
        public Data(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}