import java.io.*;
import java.util.*;

//Overexcited Fan
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<String> answers = new ArrayList<>();
        int cases = Integer.parseInt(in.nextLine());
        for(int c = 1; c <= cases; c++) {
            String[] input = in.nextLine().split(" ");
            int targetX = Integer.parseInt(input[0]);
            int targetY = Integer.parseInt(input[1]);
            String[] mov = input[2].split("");
            ArrayList<String> moves = new ArrayList<>();
            for(int i=0; i<mov.length; i++) moves.add(mov[i]);

            int min = 99999;
            //int tour_end = moves.size();
            String ans = "Case #" + c + ": ";
            for(int i=0; i<moves.size(); i++) {
                String move = moves.get(i);
                if(move.equals("N")) targetY += 1;
                if(move.equals("S")) targetY -= 1;
                if(move.equals("E")) targetX += 1;
                if(move.equals("W")) targetX -= 1;

                int dist = Math.abs(targetX) + Math.abs(targetY);
                //System.out.println("At (" + targetX + ", " + targetY + "), dist=" + dist + ", min=" + min + ", i+1=" + (i+1));
                if(i+1 >= dist) {
                    if(i+1 < min) min = i+1;
                }
            }

            if(min != 99999) ans += min;
            else ans += "IMPOSSIBLE";

            answers.add(ans);
        }

        for(String s : answers) System.out.println(s);
    }
}
