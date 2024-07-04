import java.util.*;


public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #" + t + ": ");
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int X = sc.nextInt();
        int Y = sc.nextInt();
        String S = sc.next();

        int catx=X, caty=Y;
        int time=0;
        for(char c:S.toCharArray()){
            int len = Math.abs(catx) + Math.abs(caty);
            if(len <= time){
                System.out.println(time);
                return;
            }
            switch(c){
                case 'N':
                    caty++;
                    break;
                case 'S':
                    caty--;
                    break;
                case 'E':
                    catx ++;
                    break;
                case 'W':
                    caty --;
                    break;
            }
            time++;
        }
        int len = Math.abs(catx) + Math.abs(caty);
        if(len <= time){
            System.out.println(time);
            return;
        }
        System.out.println("IMPOSSIBLE");
    }
}
