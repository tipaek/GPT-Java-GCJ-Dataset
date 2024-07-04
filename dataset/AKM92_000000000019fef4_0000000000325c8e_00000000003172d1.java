/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package codejamr1c;
import java.util.*;
/**
 *
 * @author hp
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++)
        {
            int N = sc.nextInt();
            int D = sc.nextInt();
            int min = D-1;
            long arr[] = new long[N];
            Map<Long,Integer> mp = new HashMap();
            for(int j = 0; j < N; j++)
            {
                long y = sc.nextLong();
                int x = mp.getOrDefault(y, 0);
                x++;
                mp.put(y, x);
                arr[j] = y;
                if(x >= D)
                    min = 0;
                if(D == 3 && min > 1)
                {
                    long y1 = arr[j];
                    int x1 = mp.getOrDefault(y1*2, 0);
                    if(x1 > 0)
                        min = 1;
                    
                }
            }
            
            
            
            
            System.out.println("Case #" + (i+1) + ": " + min);
        }
    }
    
}
