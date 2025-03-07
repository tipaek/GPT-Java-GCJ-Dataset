import java.util.Scanner;

/**
 *
 * @author arabtech
 */
public class Solution {
    static String s;
    static String[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 0; z < t; z++) {
            dp = new String[300][300];
            for(int i=0 ; i<300; i++){
                for(int j=0;j<300;j++){
                    dp[i][j]="";
                }
            }
            s = "";
            int x = sc.nextInt();
            int y = sc.nextInt();
            solve(x,y,0,0,"",0);
            if(s.equals("")){
               System.out.println("Case #" + (z + 1) + ": " + "IMPOSSIBLE"); 
            }
            else{
                System.out.println("Case #" + (z + 1) + ": " + s); 
            }
        }

    }
    public static void solve(int x, int y,int currentX, int currentY, String ans,int step){
        if(Math.abs(currentX) > Math.abs(x) || Math.abs(currentY)>Math.abs(y)){
            return;
        }
        if(!dp[currentX + 100][currentY + 100].equals("")){
            return;
        }
        if(currentX == x && currentY == y){
            if(s.equals("") || ans.length() < s.length()){
                s = ans;
                dp[currentX + 100][currentY + 100] = ans;
                return;
            }
        }
        solve(x,y, currentX, (int) (currentY -Math.pow(2, step)),ans+"S",step+1);
        solve(x,y, (int) (currentX+Math.pow(2, step)),currentY,ans+"E",step+1);
        solve(x,y, currentX, (int) (currentY +Math.pow(2, step)),ans+"N",step+1);
        solve(x,y, (int) (currentX-Math.pow(2, step)),currentY,ans+"W",step+1);
        
        
    }
   static class Pair{
        int key;
        int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return this.key;
        }
        public int getValue(){
            return this.value;
        }
    }

}
