import java.util.*;
import java.io.*;

public class Solution{

    public static void getTime(int x, int y, String route){
        if(x == 0 && y == 0){
            System.out.println(0);
            return;
        }
        int timeToReach;
        int purrTime = 0;

        for(char c : route.toCharArray()){
            switch(c){
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            timeToReach = (x >= 0 ? x: (x * -1)) + (y >= 0 ? y: (y * -1));
            purrTime++;

            if(timeToReach <= purrTime){
                System.out.println(purrTime);
                return;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tc = 0;

        if(input.hasNextLine())
            tc = Integer.parseInt(input.nextLine());

        for(int i = 0; i < tc; i++){

            String[] detail = input.nextLine().split(" ");

            System.out.print("Case #" + (i + 1) + ": ");

            getTime(Integer.parseInt(detail[0]), Integer.parseInt(detail[1]), detail[2]);
        }
        input.close();
    }
}