import java.util.Scanner;

public class Solution {

    /**
     * This is just a point-grab version at this point.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = Integer.parseInt(sc.nextLine());

        for(int t = 1; t <= numTests; t++){
            int n = Integer.parseInt(sc.nextLine());

            String[] inputs = new String[n];
            int[] starIndex = new int[n];

            for(int i = 0; i < n; i++){
                inputs[i] = sc.nextLine();
                starIndex[i] = inputs[i].indexOf("*");
            }

            int maxBefore = -1;
            int maxBeforeIndex = 0;

            int maxAfter = -1;
            int maxAfterIndex = 0;

            for(int i = 0; i < inputs.length; i++){
                int before = starIndex[i];
                int after = inputs[i].length() - starIndex[i] - 1;
                if(before > maxBefore){
                    maxBefore = before;
                    maxBeforeIndex = i;
                }
                if(after > maxAfter){
                    maxAfter = after;
                    maxAfterIndex = i;
                }
            }

            boolean bad = false;

            for(int i = 0; i < maxBefore; i++){
                for(int j = 0; j < inputs.length; j++){
                    if(starIndex[j] <= i){
                        continue;
                    }
                    if(inputs[j].charAt(i) != inputs[maxBeforeIndex].charAt(i)){
                        bad = true;
                        break;
                    }
                }
                if(bad) break;
            }

            for(int i = 0; i < maxAfter; i++){
                for(int j = 0; j < inputs.length; j++){
                    if(i > inputs[j].length() - 1) continue;
                    if(inputs[j].length() - i - 1 <= starIndex[j]){
                        continue;
                    }

                    if(inputs[j].charAt(inputs[j].length() - i - 1) != inputs[maxAfterIndex].charAt(inputs[maxAfterIndex].length() - i - 1)){
                        bad = true;
                        break;
                    }
                }
                if(bad) break;
            }

            String result = inputs[maxBeforeIndex].substring(0,starIndex[maxBeforeIndex]) + inputs[maxAfterIndex].substring(starIndex[maxAfterIndex] + 1);

            if(bad){
                System.out.println("Case #" + t + ": *");
            } else {
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }
}


