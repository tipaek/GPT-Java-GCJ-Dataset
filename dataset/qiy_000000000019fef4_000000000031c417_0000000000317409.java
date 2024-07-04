import java.util.*;


public class Solution{
    static Scanner s = new Scanner(System.in);

    static void solve(int T){
        int X = s.nextInt(), Y = s.nextInt();
        String M = s.next();
        int[][] distance = new int[M.length()+1][2];
        distance[0][0] = X;
        distance[0][1] = Y;
        for(int i = 1; i <= M.length(); i++){
            char c = M.charAt(i-1);
            if(c == 'N'){
                distance[i][1] = distance[i-1][1]+1;
                distance[i][0] = distance[i-1][0];
            }else if(c  == 'E'){
                distance[i][0] = distance[i-1][0]+1;
                distance[i][1] = distance[i-1][1];   
            }else if(c == 'S'){
                distance[i][1] = distance[i-1][1]-1;
                distance[i][0] = distance[i-1][0];
            }else{
                distance[i][0] = distance[i-1][0]-1;
                distance[i][1] = distance[i-1][1];
            }
            if(Math.abs(distance[i][0])+Math.abs(distance[i][1]) <= i){
                output(T, ""+i);
                return;
            }
        }
        
        output(T, "IMPOSSIBLE");
        
    }
    
    static void output(int T, String s){
        System.out.println("Case #"+T+": "+s);
    }
     
    public static void main(String[] args){
        int numCases = s.nextInt();
        for(int i = 0; i < numCases; i++){
            solve(i+1);
        }
        s.close();
    }
}


