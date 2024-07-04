import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static String minPath;

    public static void recurse(int currX, int currY, int endX, int endY, StringBuilder currPath) {
        if(currPath.length() > 7 || currX < -100 || currX > 100 || currY < -100 || currY > 100)
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

       
        currPath.append("S");
        recurse(currX, currY - jump, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length()-1);
        
        currPath.append("E");
        recurse(currX + jump, currY, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length()-1);

        currPath.append("N");
        recurse(currX, currY + jump, endX, endY, currPath);
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

            // if(x >= -4 && x <= 4 && y >= -4 && y <= 4) {

            //     if((Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) || (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1))
            //         ans.append("IMPOSSIBLE");
                
            //     else {
            //         if(x == -4) {
            //             if(y == -3) {
            //                 ans.append("SSW");
            //             }else if(y == -1) {
            //                 ans.append("NSW");
            //             }else if(y == 1) {
            //                 ans.append("SNW");
            //             }else if(y == 3) {
            //                 ans.append("NNW");
            //             }
            //         }
            //         else if(x == -3) {
            //             if(y == -4) {
            //                 ans.append("WWS");
            //             }else if(y == -2) {
            //                 ans.append("ESW");
            //             }else if(y == 0) {
            //                 ans.append("WW");
            //             }else if(y == 2) {
            //                 ans.append("ENW");
            //             }else if(y == 4) {
            //                 ans.append("WWN");
            //             }
            //         }
            //         else if(x == -2) {
            //             if(y == -3) {
            //                 ans.append("NWS");
            //             }else if(y == -1) {
            //                 ans.append("SW");
            //             }else if(y == 1) {
            //                 ans.append("NW");
            //             }else if(y == 3) {
            //                 ans.append("SWN");
            //             }
            //         }
            //         else if(x == -1) {
            //             if(y == -4) {
            //                 ans.append("EWS");
            //             }else if(y == -2) {
            //                 ans.append("WS");
            //             }else if(y == 0) {
            //                 ans.append("W");
            //             }else if(y == 2) {
            //                 ans.append("WN");
            //             }else if(y == 4) {
            //                 ans.append("EWN");
            //             }
            //         }else if(x == 0) {
            //             if(y == -3) {
            //                 ans.append("SS");
            //             }else if(y == -1) {
            //                 ans.append("S");
            //             }else if(y == 1) {
            //                 ans.append("N");
            //             }else if(y == 3) {
            //                 ans.append("NN");
            //             }
            //         }else if(x == 1) {
            //             if(y == -4) {
            //                 ans.append("WES");
            //             }else if(y == -2) {
            //                 ans.append("ES");
            //             }else if(y == 0) {
            //                 ans.append("E");
            //             }else if(y == 2) {
            //                 ans.append("EN");
            //             }else if(y == 4) {
            //                 ans.append("WEN");
            //             }
            //         }else if(x == 2) {
            //             if(y == -3) {
            //                 ans.append("NES");
            //             }else if(y == -1) {
            //                 ans.append("SE");
            //             }else if(y == 1) {
            //                 ans.append("NE");
            //             }else if(y == 3) {
            //                 ans.append("SEN");
            //             }
            //         }
            //         else if(x == 3) {
            //             if(y == -4) {
            //                 ans.append("EES");
            //             }else if(y == -2) {
            //                 ans.append("WSE");
            //             }else if(y == 0) {
            //                 ans.append("EE");
            //             }else if(y == 2) {
            //                 ans.append("WNE");
            //             }else if(y == 4) {
            //                 ans.append("EEN");
            //             }
            //         }

            //         else if(x == 4) {
            //             if(y == -3) {
            //                 ans.append("SSE");
            //             }else if(y == -1) {
            //                 ans.append("NSE");
            //             }else if(y == 1) {
            //                 ans.append("SNE");
            //             }else if(y == 3) {
            //                 ans.append("NNE");
            //             }
            //         }
            //     }
            // }

            //else {
                minPath = null;
                recurse(0, 0, x, y, new StringBuilder());
                if(minPath != null) 
                    ans.append(minPath);
                else   
                    ans.append("IMPOSSIBLE"); 
            //}

            sb.append("Case #"+(i+1)+": "+ans+"\n");
        }
        System.out.print(sb);
    } 
}
