import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String ans = "";

            int posX = Math.abs(x);
            int posY = Math.abs(y);
            int pathL =  posX + posY;

            //x+y be +- from 2^n
            if( (log2 ((pathL) - 1) % 1 == 0 || log2 ((pathL) + 1) % 1 == 0 )&& pathL != 2 ){
                if(posX == 3 && posY == 0){
                    ans = "EE";
                } else if (posX == -3 && posY == 0){
                    ans = "WW";
                } else if(posX == 0 && posY == 3){
                    ans = "NN";
                } else if (posX == 0 && posY == -3){
                    ans = "SS";
                }
                else if(posX % 2 != 0){ //x odd
                    int newX = 0;

                    //+- is pow of 2
                    if( log2 (posX + 1) % 1 == 0){
                        newX = posX + 1;
                        //TODO: go opp direction
                        if(x < 0){
                            ans += "E";
                        } else {
                            ans += "W";
                        }
                    } else if( log2 (posX - 1) % 1 == 0 ){
                        newX = posX - 1;
                        //TODO: go same direction
                        if(x < 0){
                            ans += "W";
                        } else {
                            ans += "E";
                        }
                    }

                    String s = decomp(newX, posY, x, y);
                    if(s.contains("IMPOSSIBLE")){
                        ans = s;
                    } else {
                        ans += s;
                    }

                }
                else if (posY % 2 != 0 ){ //y odd
                    int newY = 0;

                    if( log2 (posY + 1) % 1 == 0 ){
                        newY = posY + 1;
                        //TODO: go opp direction
                        if(y < 0){
                            ans += "N";
                        } else {
                            ans += "S";
                        }
                    } else if( log2 (posY - 1) % 1 == 0 ){
                        newY = posY - 1;
                        //TODO: go same direction
                        if(y < 0){
                            ans += "S";
                        } else {
                            ans += "N";
                        }
                    }

                    String s = decomp(posX, newY, x, y);
                    if(s.contains("IMPOSSIBLE")){
                        ans = s;
                    } else {
                        ans += s;
                    }
                }

            } else{
                ans = "IMPOSSIBLE";
            }

            System.out.println("Case #" + i +  ": " + ans);
        }
    }

    public static double log2(int x) {
        return (Math.log(x) / Math.log(2));
    }

    public static String decomp(int x2, int y2, int realx, int realy){
        ArrayList<Integer> xmoves = new ArrayList<>();
        ArrayList<Integer> ymoves = new ArrayList<>();
        String ans = "";

        //binary decomp
        while(x2 + y2 != 0){
            int big = Math.max(x2, y2);
            int mul = 0;

            if(x2 > y2){
                mul =  (int) Math.pow(2, (int) Math.floor(log2(x2)));
                x2 = x2 - mul;
                if(xmoves.contains(mul)){
                    return "IMPOSSIBLE";
                }
                xmoves.add(mul);

            } else {
                mul = (int) Math.pow(2, (int) Math.floor(log2(y2)));
                y2 = y2 - mul;
                if(ymoves.contains(mul)){
                    return "IMPOSSIBLE";
                    //TODO fails case 1
                }
                ymoves.add(mul);

            }
        }

        while (xmoves.size() + ymoves.size() != 0){
            if(xmoves.size() == 0){
                ans += moveY(realy);
                ymoves.remove(ymoves.size() - 1);
            } else if (ymoves.size() == 0){
                ans += moveX(realx);
                xmoves.remove(xmoves.size() - 1);
            } else if(xmoves.get(xmoves.size() - 1) < ymoves.get(ymoves.size() - 1)){
                ans += moveX(realx);
                xmoves.remove(xmoves.size() - 1);
            } else {
                ans += moveY(realy);
                ymoves.remove(ymoves.size() - 1);
            }
        }

        return ans;
    }

    public static String moveX (int realX){
        if(realX > 0){
            return "E";
        } else {
            return "W";
        }
    }

    public static String moveY (int realY){
        if(realY > 0){
            return "N";
        } else {
            return "S";
        }
    }

}