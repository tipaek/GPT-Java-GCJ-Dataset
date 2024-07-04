import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests = in.nextInt();

        for (int i=1;i <=tests;i++){
            String result = "";

            int size = in.nextInt();
            int value = in.nextInt();

            List<Integer> possibleValues = possibleValues(size);

            if (possibleValues.contains(value)) result = "POSSIBLE";
            else result = "IMPOSSIBLE";

            System.out.println("Case #"+i+": "+result);
        }
    }
    
    static public List<Integer> possibleValues(int size){
        List<Integer> result = new ArrayList<>();
        switch (size){
            case 2:
                result.add(2);
                result.add(4);
                break;
            case 3:
                result.add(6);
                result.add(9);
                result.add(3);

                break;
            case 4:
                result.add(4);
                result.add(6);
                result.add(9);
                result.add(7);
                result.add(8);
                result.add(12);
                result.add(11);
                result.add(16);

                break;
            case 5:
                result.add(5);
                result.add(6);
                result.add(9);
                result.add(7);
                result.add(8);
                result.add(12);
                result.add(11);
                result.add(16);
                result.add(15);
                result.add(25);

                break;



        }

        return result;
    }

}