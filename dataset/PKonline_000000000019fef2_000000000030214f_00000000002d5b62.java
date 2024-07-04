import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int x;
    static int y;
    static String bestWay = "";
    static ArrayList<String> ways;
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i<t; i++){
            x = sc.nextInt();
            y = sc.nextInt();

            ways = new ArrayList<>();

            if(move(1,0,0,"")){
                System.out.println("Case #"+(i+1)+": "+bestWay);
            }else {
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }

        }
    }


    public static boolean move(int i, int a, int b, String way){
        //System.out.println(i+" "+way);
        //System.out.println("Dist: "+Math.abs(x-a)+" "+Math.abs(y-b));
        if(i>(1000000000)){
            return false;
        }
        if(x==a&&y==b){
            bestWay = way;
            return true;
        }
        if((Math.abs(x-a)<i&&x!=a)||(Math.abs(y-b)<i&&y!=b)){
            return false;
        }
        if(b!=y) {
            if(Math.abs(b-y)==i){
                if(b<y){
                    if (move(i * 2, a, b + i, way + "N")) {
                        return true;
                    }
                }else {
                    if (move(i * 2, a, b - i, way + "S")) {
                        return true;
                    }
                }
            }else {
                if (move(i * 2, a, b + i, way + "N")) {
                    return true;
                }

                if (move(i * 2, a, b - i, way + "S")) {
                    return true;
                }
            }
        }
        if(x!=a) {
            if(Math.abs(a-x)==i){
                if(a<x){
                    if (move(i * 2, a+i, b, way + "E")) {
                        return true;
                    }
                }else {
                    if (move(i * 2, a-i, b, way + "W")) {
                        return true;
                    }
                }
            }else {
                if (move(i * 2, a + i, b, way + "E")) {
                    return true;
                }

                if (move(i * 2, a - i, b, way + "W")) {
                    return true;
                }
            }
        }
        return false;
    }
}
