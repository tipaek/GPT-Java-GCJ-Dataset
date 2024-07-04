import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    // public static int meetiTime;
    // public static int time;

    // public static void recurse(int x1, int y1, int x2, int y2, int currIndex, String path) {
    //     if(x1 == x2 && y1 == y2) {
    //         meetiTime = time;
    //         return;
    //     }
    //     if(meetiTime != -1 || currIndex == path.length())
    //         return;
    //     time++;
    //     if(x1 == x2) {
    //         if(path.charAt(currIndex) == 'N') {
    //             y2++;
    //         }
    //         else
    //             y2--;
    //         if(x1 == x2 && y1 == y2) {
    //             meetiTime = time;
    //             return;
    //         }
    //         if(y1 < y2)
    //             y1++;
    //         else
    //             y1--;
    //     }
    //     else {
    //         if(path.charAt(currIndex) == 'N') {
    //             y2++;
    //         }
    //         else
    //             y2--;
    //         if(x1 == x2 && y1 == y2) {
    //             meetiTime = time;
    //             return;
    //         }
    //         if(x1 < x2)
    //             x1++;
    //         else
    //             x1--;
    //     }
    //     recurse(x1, y1, x2, y2, currIndex+1, path);
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];
            StringBuilder ans = new StringBuilder();
            int time = 0;
            int meetiTime = -1;
            //recurse(0, 0, x, y, 0, path);
            
            for(int j = 0; j < path.length(); j++) {
                if(path.charAt(j) == 'N') {
                    y++;
                }
                if(path.charAt(j) == 'E') {
                    x++;
                }
                if(path.charAt(j) == 'S') {
                    y--;
                }if(path.charAt(j) == 'W') {
                    x--;
                }
                int dist = Math.abs(x) + Math.abs(y);
                time++;
                if(time >= dist) {
                    meetiTime = time;
                    break;
                }
            }
            
            if(meetiTime != -1) 
                ans.append(meetiTime);
            else   
                ans.append("IMPOSSIBLE"); 

            sb.append("Case #"+(i+1)+": "+ans+"\n");
        }
        System.out.print(sb);
    } 
}
