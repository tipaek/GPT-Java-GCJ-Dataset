import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution{
    public static void main(String [] args){
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        int act = 1;
        while(act <= cases){
            int N = read.nextInt();
            System.out.println("Case #"+(act)+": "+solveVestigium(N,read));
            act++;
        }
    }

    public static String solveVestigium(int N,Scanner read){
        int k = 0,r = 0, c = 0;
        Map<Integer,Map<Integer,Integer>> rows = new HashMap<>();
        Map<Integer,Map<Integer,Integer>> cols = new HashMap<>();
        for(int i = 0; i < N;i++){
            boolean repeated = false, repeatedc = false;
            for(int j = 0; j < N;j++){
                int val = read.nextInt();
                if(j == i)k+=val;
                //Analizing rows
                if(!repeated && rows.containsKey(i) && rows.get(i).containsKey(val)){
                    if(rows.get(i).get(val) == 1){
                        r++;
                        rows.get(i).replace(val,2);
                    }
                    repeated = true;
                }
                if(rows.containsKey(i) && !rows.get(i).containsKey(val)){
                    rows.get(i).put(val,1);
                }else{
                    Map<Integer,Integer> s = new HashMap<>();
                    s.put(val,1);
                    rows.put(i,s);
                }

                //Analizing cols
                if(!repeatedc && cols.containsKey(j) && cols.get(j).containsKey(val)){
                    if(cols.get(j).get(val) == 1 && c < N){
                        c++;
                        cols.get(j).replace(val,2);
                    }
                    repeatedc = true;
                }
                if(cols.containsKey(j) && !cols.get(j).containsKey(val)){
                    cols.get(j).put(val,1);
                }else{
                    Map<Integer,Integer> s = new HashMap<>();
                    s.put(val,1);
                    cols.put(j,s);
                }
            }
            if(repeated && r < N)r++;
            if(repeatedc && c < N)c++;
        }
        return k+" "+r+" "+c;
    }
}