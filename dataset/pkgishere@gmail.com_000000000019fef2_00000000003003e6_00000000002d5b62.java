import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p0g00mf
 */
public class Solution {
    static int X;
    static int Y;
    static int max_distance;
    static class D{
        int x;
        int y;
        int distance;
        int count;
        StringBuilder sb = new StringBuilder();
        public D(int x,int y,int count){
            this.x=x;
            this.y=y;
            this.count= count;
            this.distance=dist(x,y);
        }
        int dist(int x, int y){
            return Math.abs(X-x)+Math.abs(Y-y);
        }
    }
    
    static boolean flag= false;
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_cases = in.nextInt();
        for (int i = 1; i <= test_cases; ++i) {
            boolean odd = false;
            int first = in.nextInt();
            int secound = in.nextInt();
            
            X= first;
            Y =secound;
            max_distance=2* (Math.abs(X)+Math.abs(Y));
            if(first==0 && secound ==0){
                System.out.println("Case #" + i + ": ");
                continue;
            }
            if((Math.abs(first)%2==0 && Math.abs(secound)%2==0)||(Math.abs(first)%2==1 && Math.abs(secound)% 2 ==1)){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } 
            else{
                System.out.println("Case #" + i + ": "+ Search());
            }
        }
       
    }

    private static String Search() {
        PriorityQueue<D> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.distance, b.distance));
        pq.add(new D(0, 0,0));
        while(!(pq.isEmpty())){
            D current = pq.poll();
            int count =current.count;
            if(current.distance==0) return current.sb.toString();
            if(count>31);
            else{
                int value =(int) Math.pow(2, count);
                D north= new D(current.x+value, current.y,count+1);
                north.sb.append(current.sb.toString());
                north.sb.append("E");
                if(north.distance<max_distance) pq.add(north);
                D south= new D(current.x-value, current.y,count+1);
                south.sb.append(current.sb.toString());
                south.sb.append("W");
                if(south.distance<max_distance)pq.add(south);
                D east= new D(current.x, current.y+value,count+1);
                east.sb.append(current.sb.toString());
                east.sb.append("N");
                if(east.distance<max_distance)pq.add(east);
                D west= new D(current.x, current.y-value,count+1);
                west.sb.append(current.sb.toString());
                west.sb.append("S");
                if(west.distance<max_distance)pq.add(west);
            }
        }
        return "IMPOSSIBLE";
    }

}
