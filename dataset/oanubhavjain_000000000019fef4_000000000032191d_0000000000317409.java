import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        try {

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = in.nextInt();

            for (int i = 0; i < T; i++) {
                int xP = in.nextInt();
                int yP = in.nextInt();
                String P = in.next();
                printOutput(i + 1, xP, yP, P);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printOutput(int T, int xP, int yP, String P) {
        int count = 0;
        boolean flag=true;
        int xA = 0, yA = 0;
        int xD = xP - xA, yD = yP - yA;
        for (int i = 0; i < P.length(); i++) {
            char dest=P.charAt(i);
            if (xD == 0 && yD == 0) {
                break;
            } else if(xD==0 && (yD==1||yD==-1)) {
                if (dest == 'S') yP--;
                else if (dest == 'N') yP++;
                else if (dest == 'E') xP++;
                else if (dest == 'W') xP--;
                yD = yP - yA;
                if(yD==0) {
                    count++;
                    break;
                } else if(yD>0){
                    yA++;
                    count++;
                }  else if(yD<0){
                    yA--;
                    count++;
                }
            } else if(yD==0 && (xD==1||xD==-1)) {
                if (dest == 'S') yP--;
                else if (dest == 'N') yP++;
                else if (dest == 'E') xP++;
                else if (dest == 'W') xP--;
                xD = xP - xA;
                if(xD==0) {
                    count++;
                    break;
                } else if(xD>0){
                    xA++;
                    count++;
                }  else if(xD<0){
                    xA--;
                    count++;
                }
            } else if(xD>0){
                xA++;
                if (dest == 'S') yP--;
                else if (dest == 'N') yP++;
                else if (dest == 'E') xP++;
                else if (dest == 'W') xP--;
                count++;
            }  else if(xD<0){
                xA--;
                if (dest == 'S') yP--;
                else if (dest == 'N') yP++;
                else if (dest == 'E') xP++;
                else if (dest == 'W') xP--;
                count++;
            } else if(yD>0){
                yA++;
                if (dest == 'S') yP--;
                else if (dest == 'N') yP++;
                else if (dest == 'E') xP++;
                else if (dest == 'W') xP--;
                count++;
            }  else if(yD<0){
                yA--;
                if (dest == 'S') yP--;
                else if (dest == 'N') yP++;
                else if (dest == 'E') xP++;
                else if (dest == 'W') xP--;
                count++;
            }
            xD = xP - xA; yD = yP - yA;
        }
        if(xD!=0 || yD!=0)
            System.out.println("Case #" + T + ": " + "IMPOSSIBLE");
        else
            System.out.println("Case #" + T + ": " + count);
    }
}
