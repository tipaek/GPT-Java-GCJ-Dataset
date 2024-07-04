
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
          public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();


                int [][] mat = new int [n][n];
                for(int i1 =0 ;i1 < n; i1++){
                    for(int j =0 ; j< n;j++){
                        mat[i1][j]= in.nextInt();
                    }
                }

                int rowMax =0;
                int colMax =0;
                int trace =0;
                Map<Integer,Integer> rowMap = null;
                for(int i1 =0 ;i1 < n; i1++){
                    rowMap = new HashMap<>();
                    for(int j =0 ; j< n;j++){
                        int x = mat[i1][j];
                        int y =1;
                        if(rowMap.containsKey(x)){
                           y =  rowMap.get(x)+1;
                        }
                        rowMap.put(x,y);

                        rowMax = Math.max(rowMax,y);

                        if(i1 ==j){
                            trace+= x;
                        }

                    }
                }
                for(int i1 =0 ;i1 < n; i1++){
                    rowMap = new HashMap<>();
                    for(int j =0 ; j< n;j++){
                        int x = mat[j][i1];
                        int y =1;
                        if(rowMap.containsKey(x)){
                            y =  rowMap.get(x)+1;
                        }
                        rowMap.put(x,y);

                        colMax = Math.max(colMax,y);



                    }
                }
                System.out.println("Case #" + i + ": "+ trace+ " "+(rowMax==1?0:rowMax)+" "+(colMax==1?0:colMax));
            }
        }
    }