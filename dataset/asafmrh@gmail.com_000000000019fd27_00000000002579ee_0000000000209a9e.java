import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int t = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        for(int i = 0; i < t; i++){
            int indx = 1;
            int[] bytes = new int[b];
            for(int j = 1; j <= 150; j++){
                System.out.println(indx);
                int response = in.nextInt();
                if(j%10 == 1){
                    
                }
                bytes[indx] = response;
                indx = (indx)%(b) + 1;
            }
            System.out.println(getThem(bytes));
            if(in.nextLine().equals("N")){
                return;
            }
        }
    }

    public static String getThem(int[] bytes){
        String res = "";
        for(int i = 0 ; i < bytes.length; i++){
            res += bytes[i];
        }
        return res;
    }
}
