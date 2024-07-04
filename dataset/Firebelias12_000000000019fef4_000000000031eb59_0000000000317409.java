import java.util.Scanner;

public class Solution {

    public static void main(String[] args){

        Scanner Myobj = new Scanner(System.in);
        int cases = Myobj.nextInt();

        for(int i = 0; i < cases; i++){

            int oX = 0;
            int oY = 0;

            int pX = Myobj.nextInt();
            int pY = Myobj.nextInt();

            int min = 0;

            String pos = Myobj.nextLine();

            for(int j = 0; j < pos.length(); j++){

                if(oX == pX && oY == pY)
                    break;

                char c = pos.charAt(j);

                if(c != 'S' && c != 'N' && c != 'E' && c != 'W')
                    continue;

                switch(c){
                    case 'N':
                        pY++;
                        if(oX == pX && oY == pY)
                            break;
                        if(oX != pX)
                            oX++;
                        else if(oY != pY){
                            oY++;
                        }
                        break;
                    case 'S':
                        pY--;
                        if(oX == pX && oY == pY)
                            break;
                        if(oX != pX)
                            oX++;
                        else if(oY != pY){
                            oY++;
                        }
                        break;
                    case 'W':
                        pX--;
                        if(oX == pX && oY == pY)
                            break;
                        if(oY != pY)
                            oY++;
                        else if(oX != pX){
                            oX++;
                        }
                        break;
                    case 'E':
                        pX++;
                        if(oX == pX && oY == pY)
                            break;
                        if(oY != pY)
                            oY++;
                        else if(oX != pX){
                            oX++;
                        }
                        break;
                }

                min++;
            }

            if(oX == pX && oY == pY)
                System.out.println("Case #" + (i+1) + ": " + min);
            else
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");

        }


    }

}
