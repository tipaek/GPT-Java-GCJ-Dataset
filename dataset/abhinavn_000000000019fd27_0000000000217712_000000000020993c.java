import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int trace;
        int numRows;
        int numCols;
        int T = in.nextInt();
        for (int i=1; i<=T; i++){
            int N = in.nextInt();
            int[][] array = new int[N+1][N+1];
            HashMap<Integer, HashMap<Integer,Integer>> map1 = new HashMap<Integer, HashMap<Integer,Integer>>();
            HashMap<Integer, HashMap<Integer,Integer>> map2 = new HashMap<Integer, HashMap<Integer,Integer>>();
            HashMap<Integer, Integer> map3 = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> map4 = new HashMap<Integer, Integer>();
            trace = 0;
            numRows = 0;

            numCols = 0;

//            System.out.println(i);
//            System.out.println(N);
            for(int r = 0; r < N; r++)
            {
            //	System.out.println(i);
            	for(int c = 0; c < N; c++)
            	{
            		
                	int n = in.nextInt();
            		array[r][c] = n;
            		if(map1.containsKey(r))
            		{
            			if(map1.get(r).containsKey(array[r][c]))
            			{	
            				if(!map3.containsKey(r))
            				{
            					numRows++;
            					map3.put(r, 1);
            				}
            			}
            			else
            			{
            				map1.get(r).put(array[r][c], 1);
            			}
            			
            		}
            		else
            		{
            			HashMap<Integer, Integer> neww = new HashMap<Integer, Integer>();
            			map1.put(r, neww);
            			map1.get(r).put(array[r][c], 1);
            		}
            		
            		if(map2.containsKey(c))
            		{
            			if(map2.get(c).containsKey(array[r][c]))
            			{
            				if(!map4.containsKey(c))
            				{
            				numCols++;

        					map4.put(c, 1);
            				}
            			}
            			else
            			{
            				map2.get(c).put(array[r][c], 1);
            			}
            			
            		}
            		else
            		{
            			HashMap<Integer, Integer> neww2 = new HashMap<Integer, Integer>();
            			map2.put(c, neww2);
            			map2.get(c).put(array[r][c], 1);
            		}
            		if(r == c)
            		{
            			trace += array[r][c];
            			
            		}
            		
            	}
            }
            
            
            System.out.println("\n" + "Case #" + i + ": " + trace + " " + numRows + " " + numCols);
            trace = 0;
            numRows = 0;
            numCols = 0;
            map1.clear();
            map2.clear();
            
            }
        	//in.close();
        }

   
    }

