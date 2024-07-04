import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 1; test <= t; test++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (Math.abs(x) % 2 == Math.abs(y) % 2) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", test));
                continue;
            }
            String binX = Integer.toBinaryString(Math.abs(x));
            String binY = Integer.toBinaryString(Math.abs(y));


            int[] top = new int[Math.max(binX.length(), binY.length()) + 1];
            int[] bottom = new int[Math.max(binX.length(), binY.length()) + 1];
            for (int i = 1; i <= binX.length(); i++) {
                top[i - 1] = Integer.parseInt(binX.substring(binX.length() - i, binX.length() - i + 1));
            }
            for (int i = 1; i <= binY.length(); i++) {
                bottom[i - 1] = Integer.parseInt(binY.substring(binY.length() - i, binY.length() - i + 1));
            }

            char[] out = new char[top.length];
            boolean possible = true;
            for (int i = 0; i < top.length; i++) {
                if (i==top.length-1){
                    if (bottom[i]==top[i]){
                        if(bottom[i]==1){
                            possible=false;
                            break;
                        }else{
                            break;
                        }
                    }else{
                        if(bottom[i]==1){
                            out[i] = 'N';
                        }else out[i]='E';
                    }
                    break;
                }
                if (top[i] == bottom[i]) {
                    possible = false;
                    break;
                }
                else{
                    if (i < top.length - 1 && (top[i + 1] != bottom[i + 1] || (i == top.length - 2 && top[i + 1] == 0 && bottom[i + 1] == 0))) {
                        if (top[i] == 1) out[i] = 'E';
                        else if (bottom[i] == 1) out[i] = 'N';
                    } else {
                        if (top[i] == 1) {
                            out[i] = 'W';
                            for (int j = i + 1; j < top.length; j++) {
                                if (top[j] == 1) top[j] = 0;
                                else {
                                    top[j] = 1;
                                    break;
                                }
                            }
                        } else if (bottom[i] == 1) {
                            out[i] = 'S';
                            for (int j = i + 1; j < bottom.length; j++) {
                                if (bottom[j] == 1) bottom[j] = 0;
                                else {
                                    bottom[j] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(x<0){
                for(int i=0; i<out.length; i++){
                    if(out[i]=='E') out[i]='W';
                    else if(out[i]=='W') out[i]='E';
                }
            }
            if(y<0){
                for(int i=0; i<out.length; i++){
                    if(out[i]=='S') out[i]='N';
                    else if(out[i]=='N') out[i]='S';
                }
            }

            if (possible) {
                System.out.println(String.format("Case #%d: %s", test, new String(out)));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", test));
            }


        }
    }
}
