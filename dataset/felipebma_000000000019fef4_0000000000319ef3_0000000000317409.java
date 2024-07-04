import java.util.*;

public class Solution {
    
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        int nCases = in.nextInt();
        for(int i=1;i<=nCases;i++){
            solve(i);
        }
    }

    private static void solve(int nCase){
        int[] pos = new int[2];
        pos[0] = in.nextInt();
        pos[1] = in.nextInt();
        String path = in.next();
        System.out.printf("Case #%d: ", nCase);
        for(int i=0;i<path.length();i++){
            char c = path.charAt(i);
            if(canReach(pos,i)){
                System.out.println(i);
                return;
            }
            move(pos,c);
        }
        if(canReach(pos,path.length())){
            System.out.println(path.length());
            return;
        }
        System.out.println("IMPOSSIBLE");

    }

    private static boolean canReach(int[] pos, int dist){
        return(dist >= (Math.abs(pos[0])+Math.abs(pos[1])));
    }

    private static void move(int[] pos, char dir){
        switch(dir){
            case 'N':
                pos[1]++;
                break;
            case 'S':
                pos[1]--;
                break;
            case 'E':
                pos[0]++;
                break;
            case 'W':
                pos[0]--;
                break;
        }
    }

}