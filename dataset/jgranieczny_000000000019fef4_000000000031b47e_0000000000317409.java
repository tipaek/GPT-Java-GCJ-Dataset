
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

   static Scanner scanner;
    public static void main(String[] args) {


         scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            int X = scanner.nextInt();//min radius
            int Y = scanner.nextInt();//max radius
            String M = scanner.next();//max radius
            char[] ch = new char[M.length()];

            // Copy character by character into array
            for (int j = 0; j < M.length(); j++) {
                ch[j] = M.charAt(j);
            }

            int res=print(X,Y,ch,0,0,0);
            if(res==-1)
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            else {
                System.out.println("Case #" + (i + 1) + ": " + res);
            }





        }
    }

    private static int print(int x, int y,char[] ch, int myX, int myY, int jumps) {
//        System.out.println(x+" "+y+ " "+myX+ " "+myY+" "+Arrays.toString(ch));
        if(myX==x&&myY==y)
            return jumps;
        if(ch.length==0)
            return -1;
        if(myX-x==1&&ch[0]=='E'&&myY-y==0)
            return jumps+1;
        if(myX-x==-1&&ch[0]=='W'&&myY-y==0)
            return jumps+1;
        if(myY-y==1&&ch[0]=='N'&&myX-x==0)
            return jumps+1;
        if(myY-y==-1&&ch[0]=='S'&&myX-x==0)
            return jumps+1;

        if(ch[0]=='E')
            x=x+1;
        if(ch[0]=='W')
            x=x-1;
        if(ch[0]=='N')
            y+=1;
        if(ch[0]=='S')
            y-=1;

        if(x>myX){
            int jumpstmp=print(x,y, Arrays.copyOfRange(ch,1,ch.length),myX+1,myY,jumps+1);
            if(jumpstmp!=-1)
                return jumpstmp;
        }

        if(y>myY){
            int jumpstmp=print(x,y, Arrays.copyOfRange(ch,1,ch.length),myX,myY+1,jumps+1);
            if(jumpstmp!=-1)
                return jumpstmp;
        }
        return -1;


    }
}