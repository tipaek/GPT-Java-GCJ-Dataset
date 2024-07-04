import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

   static Scanner scanner;
    public static void main(String[] args) {


         scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        int[][] grid = new int[1000][1000];

        for (int i = 0; i < T; i++) {
            int X = scanner.nextInt();//min radius
            int Y = scanner.nextInt();//max radius
            String M = scanner.next();//max radius
            char[] ch = new char[M.length()];

            // Copy character by character into array
            for (int j = 0; j < M.length(); j++) {
                ch[j] = M.charAt(j);
            }

            int res=print(X,Y,ch,0,0,0,0);
            if(res==-1)
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            else {
                System.out.println("Case #" + (i + 1) + ": " + res);
            }





        }
    }


    private static int print(int x, int y,char[] ch, int myX, int myY, int jumps,int index) {
        int[] tmpX=new int[ch.length];
        int[] tmpY=new int[ch.length];

        int sumX=x;
        int sumY=y;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='E'){
                sumX++;
            }
            else if(ch[i]=='W')
                sumX--;
            else  if(ch[i]=='N')
                sumY++;
            else  if(ch[i]=='S')
                sumY--;
            tmpX[i]=sumX;
            tmpY[i]=sumY;
            if(Math.abs(sumX)+Math.abs(sumY)<=i+1)
                return i+1;

        }
        return -1;

    }

}