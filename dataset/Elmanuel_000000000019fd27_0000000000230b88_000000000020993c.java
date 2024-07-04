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
        Map<Integer,Set<Integer>> rows = new HashMap<>();
        Map<Integer,Set<Integer>> cols = new HashMap<>();
        boolean arrB[] = new boolean[N*2];
        for(int i = 0; i < N;i++){
            
            for(int j = 0; j < N;j++){
                int val = read.nextInt();
                if(j == i)k+=val;
                if(!arrB[i] && rows.containsKey(val) && rows.get(val).contains(i)){
                    arrB[i] = true;
                    r++;
                }else if(rows.containsKey(val)){
                    rows.get(val).add(i);
                }else{
                    Set<Integer> hs = new HashSet<>();
                    hs.add(i);
                    rows.put(val,hs);
                }

                if(!arrB[N+j] && cols.containsKey(val) && cols.get(val).contains(j)){
                    arrB[N+j] = true;
                    c++;
                }else if(cols.containsKey(val)){
                    cols.get(val).add(j);
                }else{
                    Set<Integer> hs = new HashSet<>();
                    hs.add(j);
                    cols.put(val,hs);
                }
            }
        }
        return k+" "+r+" "+c;
    }
}