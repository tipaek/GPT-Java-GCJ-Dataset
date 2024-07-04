import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static String full = "";

    public static void add(int[] num){
        if(num[0] == 0){
            full = full + "0";
        }
        else {
            String lineup = "";

            boolean decreasing = false;
            int prevNum = 0;
            for (int i = 0; i < num.length; i++) {
                if (i == 0 && i != num.length-1) {
                    for (int a = 0; a < num[i]; a++) {
                        lineup = lineup + "(";
                    }
                    lineup = lineup + num[i];
                }
                else {
                    if (num[i] != prevNum) {
                        if (prevNum < num[i]) {
                            decreasing = false;
                        }
                        if (prevNum > num[i]) {
                            decreasing = true;
                        }

                        if (decreasing == false) {
                            for (int b = 0; b < num[i] - prevNum; b++) {
                                lineup = lineup + "(";
                            }
                            lineup = lineup + num[i];
                        } else {
                            for (int b = 0; b < (prevNum - num[i]); b++) {
                                lineup = lineup + ")";
                            }
                            lineup = lineup + num[i];
                        }
                    } else {
                        lineup = lineup + num[i];
                    }
                    if (i == num.length - 1) {
                        for (int c = 0; c < num[i]; c++) {
                            lineup = lineup + ")";
                        }
                    }
                }
                prevNum = num[i];
            }

            full = full + lineup;
        }


    }

    public static void process(int[] num){
        List<Integer> endPos = new ArrayList<>();
        List<Integer> divSizes = new ArrayList<>();
        int counter = 0;

        //get sizes and end positions of intervals of pyramids
        for(int i = 0; i < num.length; i ++){
            counter ++;
            if(i == num.length - 1){
                endPos.add(i);
                divSizes.add(counter);
            }
            else {
                if(num[i] == 0){
                    endPos.add(i);
                    divSizes.add(counter);
                    counter = 0;
                }
                if (num[i+1] == 0 && num[i] != 0) {
                    endPos.add(i);
                    divSizes.add(counter);
                    counter = 0;
                }
            }
        }
        
        int [] shipment;
        int count = 0;

        for(int j = 0 ; j < endPos.size(); j ++){
             shipment = new int[divSizes.get(j)];

             for(int a = (endPos.get(j) - divSizes.get(j) + 1); a <= endPos.get(j); a ++){
                 shipment[count] = num[a];
                 count ++;
             }
             count = 0;
             add(shipment);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = Integer.parseInt(input.nextLine());
        int [] num;

        for(int i = 1; i <= T; i ++){
            String s = input.nextLine();
            int size = s.length();
            num = new int[size];

            for(int j = 0; j < size; j ++){
                num[j] = Integer.parseInt(s.substring(j, j + 1));
            }

            process(num);
            System.out.println("Case #" + i + ": " + full);
            full = "";


        }
    }
}
