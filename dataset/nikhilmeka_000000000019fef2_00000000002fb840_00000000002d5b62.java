import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        long n = Long.parseLong(s.nextLine());
        for (long i = 1; i <= n; i++) {
            String[] line = s.nextLine().split(" ");
            long frow = Long.parseLong(line[0]);
            long fcol= Long.parseLong(line[1]);

            String answer = solve(new Jump(0, 0, ""), Math.abs(fcol), Math.abs(frow));
            if(answer.equals("IMPOSSIBLE")){
                System.out.println("Case #" + i + ": " + answer);
            }
            else{
                String newAnswer = "";
                if(frow < 0){
                    for (int j = 0; j < answer.length(); j++) {
                        if(answer.charAt(j) == 'E'){
                            newAnswer += "W";
                        }
                        else if(answer.charAt(j) == 'E'){
                            newAnswer += "E";
                        }
                        else{
                            newAnswer += answer.charAt(j);
                        }
                    }
                    answer = newAnswer;
                }
                if(fcol < 0){
                    //flip NS
                    newAnswer = "";
                    for (int j = 0; j < answer.length(); j++) {
                        if(answer.charAt(j) == 'N'){
                            newAnswer += "S";
                        }
                        else if(answer.charAt(j) == 'S'){
                            newAnswer += "N";
                        }
                        else{
                            newAnswer += answer.charAt(j);
                        }
                    }
                    answer = newAnswer;
                }
                System.out.println("Case #" + i + ": " + answer);
            }
        }
        s.close();
    }
    public static String solve(Jump j, long frow, long fcol){
        Queue<Jump> q = new LinkedList<>();
        q.add(j);
        while(!q.isEmpty()){
            Jump ele = q.remove();
            if(ele.row == frow && ele.col == fcol){
                return ele.path;
            }
            long increment = (long)Math.pow(2, ele.path.length());
            Jump[] childrenIndexes = {new Jump(ele.row+increment, ele.col, ele.path+"N"),
                    new Jump(ele.row-increment, ele.col, ele.path+"S"),
                    new Jump(ele.row, ele.col+increment, ele.path+"E"),
                    new Jump(ele.row, ele.col-increment, ele.path+"W")};
            for(int i = 0; i < childrenIndexes.length; i++) {
                Jump child = childrenIndexes[i];
                if(Math.abs(child.row) > Math.pow(10, 2) || Math.abs(child.col) > Math.pow(10, 2)){
                    continue;
                }
                else {
                    q.add(child);
                }
            }
        }
        return "IMPOSSIBLE";
    }
    static class Jump{
        long row;
        long col;
        String path = "";
        public Jump(long r, long c, String path){
            row = r;
            col = c;
            this.path = path;
        }
    }
}
