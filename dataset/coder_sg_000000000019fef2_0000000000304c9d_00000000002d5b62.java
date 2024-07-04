import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static String minPath;

    public static void recurse(int currX, int currY, int endX, int endY, StringBuilder currPath) {
        if(currX < -100 || currX > 100 || currY < -100 || currY > 100)
            return;
        if(currX == endX && currY == endY) {
            if(minPath == null)
                minPath = currPath.toString();
            else if(currPath.length() < minPath.length())
                minPath = currPath.toString();
            return;
        }

        int step = currPath.length();
        int jump = (int)Math.pow(2, step);
       
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
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            StringBuilder ans = new StringBuilder();

            
            minPath = null;
            recurse(0, 0, x, y, new StringBuilder());
            if(minPath != null) 
                ans.append(minPath);
            else   
                ans.append("IMPOSSIBLE"); 

            sb.append("Case #"+(i+1)+": "+ans+"\n");
        }
        System.out.print(sb);
    } 
}
