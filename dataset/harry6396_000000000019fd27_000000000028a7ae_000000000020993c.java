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
                    
                    // to check for Rows
                    if(traceRow[i] == 0){
                        if(map.get(ip) == null){
                            map.put(ip, 1);
                        }else{
                    	    traceRow[i] = 1;
                            row++;
                        }
                    }
                    
                    // to check for Columns
                    if(traceColumn[j] == 0){
                        if(map1.get(j) == null){
                            map1.put(j,new ArrayList<Integer>(n));
                            map1.get(j).add(ip);
                        }else if(map1.get(j).contains(new Integer(ip))){
                            traceColumn[j] = 1;
                            column++;
                        }
                        else{
                            map1.get(j).add(ip);
                        }
                    }
                    
                    // diagonal trace
                    if(i == j){
                        sum+=ip;
                    }
                }
            }
        System.out.println(sum + " " + row + " " +  column);   
        }
    }
}