/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author EliteBook
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {

        new Solution().getResult();
    }

    public void getResult() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++) {
            String[] ip = br.readLine().trim().split(" ");
            int x = Integer.parseInt(ip[0]);
            int y = Integer.parseInt(ip[1]);

           int res= bfs(0, 0, x, y, ip[2], 0, 0);
//            System.out.println(found);
            
            System.out.print("Case #"+t+": ");

           if(res==Integer.MAX_VALUE){
               System.out.print("IMPOSSIBLE");
           }
           else{
                System.out.print(res);
           }
            System.out.println();
//            

        }

    }
    boolean found=false;

    public int bfs(int mx, int my, int tx, int ty, String dir, int steps, int ind) {
        //System.out.println(mx+" "+ my+" " +" "+tx+" "+ ty+" "+" "+" "+  steps+" "+ ind);

        

        if (mx == tx && my == ty) {
            found=true;
          //  System.out.println(steps);
            return steps;
        }
        
        
        int dx = 0;
        int dy = 0;
        
        if(ind==dir.length()){
            return Integer.MAX_VALUE;
        }
        
        char c = dir.charAt(ind);
        switch (c) {
            case 'N':
                dy++;
                break;
            case 'S':
                dy--;
                break;
            case 'E':
                dx++;
                break;
            case 'W':
                dx--;
                break;
            default:
                break;
        }
        int m1 = bfs(mx, my, tx + dx, ty + dy, dir, steps + 1, ind + 1);
        int m2 = bfs(mx, my + 1, tx + dx, ty + dy, dir, steps + 1, ind + 1);//n
        int m3 = bfs(mx, my - 1, tx + dx, ty + dy, dir, steps + 1, ind + 1);//s
        int m4 = bfs(mx + 1, my, tx + dx, ty + dy, dir, steps + 1, ind + 1);//e
        int m5 = bfs(mx - 1, my, tx + dx, ty + dy, dir, steps + 1, ind + 1);//w
        return Math.min(m1, Math.min(m2, Math.min(m3, Math.min(m4, m5))));

    }

}


