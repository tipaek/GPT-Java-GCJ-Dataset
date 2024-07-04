import java.util.Scanner;

public class Solution {

    public static void main(String[] args){

        Scanner Myobj = new Scanner(System.in);
        int cases = Myobj.nextInt();

        for(int i = 0; i < cases; i++){

            int x = Myobj.nextInt();
            int y = Myobj.nextInt();

            String pos = Myobj.nextLine();
            pos = pos.substring(1);

            boolean pic = false;

            int[] pX = new int[pos.length()+1];
            int[] pY = new int[pos.length()+1];

            pX[0] = x;
            pY[0] = y;

            for(int j = 1; j < pX.length; j++){
                switch(pos.charAt(j-1)){
                    case 'N':
                        pX[j] = pX[j-1];
                        pY[j] = pY[j-1]+1;
                        break;
                    case 'S':
                        pX[j] = pX[j-1];
                        pY[j] = pY[j-1]-1;
                        break;
                    case 'E':
                        pX[j] = pX[j-1]+1;
                        pY[j] = pY[j-1];
                        break;
                    case 'W':
                        pX[j] = pX[j-1]-1;
                        pY[j] = pY[j-1];
                        break;
                }
            }

            for(int j = 0; j < pX.length; j++){
                if(j >= Math.abs(pX[j]) + Math.abs(pY[j])) {
                    System.out.println("Case #" + (i+1) + ": " + j);
                    pic = true;
                    break;
                }
            }

            if(!pic)
            System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");

        }


    }

}
