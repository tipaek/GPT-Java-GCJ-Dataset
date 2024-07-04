import java.util.Scanner;

public class Solution {
    private static String PATTEN = "Case #%d: %s";
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if ((x ==0 ) && (y==0)){
                System.out.println(String.format(PATTEN, p, ""));
                continue;
            }
            int zhengX = x;
            if (zhengX<0){
                zhengX = -zhengX;
            }
            int zhengY = y;
            if (zhengY<0){
                zhengY = -zhengY;
            }
            if ((zhengX+zhengY) % 2 ==0){
                System.out.println(String.format(PATTEN, p, "IMPOSSIBLE"));
                continue;
            }
            long v = 1;
            for (int i=0;i<=32;i++){
                String ans = getLast(x, y, v);
                if (ans!=null){
                    System.out.println(String.format(PATTEN, p, ans));
                    break;
                }
                v = v*2;
            }
        }
    }

    private static String getLast(long x ,long y, long value){
        if ((x==0) && (y==0)){
            return "";
        }
        if (value ==0){
            return null;
        }
        long zhengX = x;
        if (zhengX<0){
            zhengX = -zhengX;
        }
        long zhengY = y;
        if (zhengY<0){
            zhengY = -zhengY;
        }
        if (zhengX>zhengY){
            if (x!=zhengX){
                String before = getLast(x+value,y,value/2);
                return before==null?null:before+"W";
            } else {
                String before = getLast(x-value,y,value/2);
                return before==null?null:before+"E";
            }
        } else {
            if (y!=zhengY){
                String before = getLast(x,y+value,value/2);
                return before==null?null:before+"S";
            } else {
                String before = getLast(x,y-value,value/2);
                return before==null?null:before+"N";
            }
        }
    }
}