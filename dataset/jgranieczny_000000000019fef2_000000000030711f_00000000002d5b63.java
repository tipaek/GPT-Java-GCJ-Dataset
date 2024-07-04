
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static final int MAX_WIDTH=1000000000;
    final int MAX_HEIGHT=1000000000;
   static Scanner scanner;
    public static void main(String[] args) {


         scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();//min radius
            int B = scanner.nextInt();//max radius

            print(A,B);




        }
    }

    private static void print(int x, int y) {
        String result="";
        int squareNo = (int)(MAX_WIDTH/(x*2)+0.5);
        for(int i=0;i<squareNo;i++) {
            for(int j=0;j<squareNo;j++){
                int xShot = i * x + x / 2;
                int yShot = j * x + x / 2;
                System.out.println(xShot+" "+yShot);
                System.out.flush();

                String what = scanner.next();
                if(what == "CENTER")
                    return;

                if(what == "HIT"){
                    int newStartX=xShot-2*y;
                    int newFinishtX=xShot+2*y;
                    int newStartY=yShot-2*y;
                    int newFinishtY=yShot+2*y;
                    for(int i2=newStartX;i2<newFinishtX;i2++){
                        for(int j2=newStartY;j2<newFinishtY;j2++){
                            System.out.println(i2+" "+j2);
                            System.out.flush();
                             what = scanner.next();
                            if(what == "CENTER")
                                return;
                        }
                    }

                }
            }
        }
     


    }
}