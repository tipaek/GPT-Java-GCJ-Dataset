import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int row = 0, column = 0, sum = 0;
            int []traceColumn = new int[n];
            int []traceRow = new int[n];
            HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<Integer, ArrayList<Integer>>();
            for(int i = 0; i<n;i++){
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                for(int j=0;j<n;j++){
                    int ip = sc.nextInt();
                    if(map.get(ip) == null){
                        map.put(ip, 1);
                    }else if(traceRow[i] == 0){
                    	traceRow[i]++;
                        row++;
                    }
                    if(map1.get(j) == null){
                        map1.put(j,new ArrayList<Integer>(n));
                        map1.get(j).add(ip);
                    }else if(map1.get(j).contains(ip) && traceColumn[j] == 0){
                        traceColumn[j] = 1;
                        column++;
                    }
                    else{
                        map1.get(j).add(ip);
                    }
                    if(i == j){
                        sum+=ip;
                    }
                }
            }
        System.out.println(sum + " " + row + " " +  column);   
        }
    }
}