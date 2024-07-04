
import java.util.Scanner;

public class Solution {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String[] line = sc.nextLine().split(" ");
            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);
            int rest = 0;
            boolean pos = false;
            int time1 = 1;
            for(Character m : line[2].toCharArray()){//SNSS
                if(m == 'S')Y--;
                if(m == 'N')Y++;
                if(m == 'E')X++;
                if(m == 'W')X--;
                rest = Math.abs(-X) + Math.abs(-Y);
                if(rest <= time1){
                    pos = true;
                    break;
                }
                time1++;

            }
            if(pos == false){
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+(t+1)+": "+time1);
            }




        }

    }
}
