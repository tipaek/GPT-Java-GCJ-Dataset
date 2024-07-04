import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static String minPath;

    public static void recurse(long currX, long currY, long endX, long endY, StringBuilder currPath) {
        if(currPath.length() > 29 || currX < -1000000000 || currX > 1000000000 || currY < -1000000000 || currY > 1000000000)
            return;
        if(currX == endX && currY == endY) {
            if(minPath == null)
                minPath = currPath.toString();
            else if(currPath.length() < minPath.length())
                minPath = currPath.toString();
            return;
        }

        long step = currPath.length();
        long jump = (long)Math.pow(2, step);
       
        currPath.append("N");
        recurse(currX, currY + jump, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length()-1);
        
        currPath.append("S");
        recurse(currX, currY - jump, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length()-1);
        
        currPath.append("E");
        recurse(currX + jump, currY, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length()-1);
 
        currPath.append("W");
        recurse(currX - jump, currY, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            StringBuilder ans = new StringBuilder();

            if((Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) || (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1))
                ans.append("IMPOSSIBLE");
            else {
                minPath = null;
                recurse(0L, 0L, x, y, new StringBuilder());
                if(minPath != null) 
                    ans.append(minPath);
                else   
                    ans.append("IMPOSSIBLE"); 
            }

            sb.append("Case #"+(i+1)+": "+ans+"\n");
        }
        System.out.print(sb);
    } 
}
