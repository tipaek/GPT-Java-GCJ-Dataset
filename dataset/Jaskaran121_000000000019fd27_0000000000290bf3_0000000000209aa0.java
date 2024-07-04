import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static void permute(List<Integer> arr, int k,List<String> listOfPermutation){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1,listOfPermutation);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            listOfPermutation.add(Arrays.toString(arr.toArray()));
        }
    }
    public static String calculate(int size,int sum,List<String> listOfPermutation){
        String result = "";
        for(int i=0;i<listOfPermutation.size();i++){
            int innerSum = 0;
            for(int j=0;j<size;j++){
                int count = j;
                int num = Character.getNumericValue(listOfPermutation.get(i).replaceAll("[^a-zA-Z0-9]","").charAt(j));
                while(count>0){
                    num = num +1;
                    if(num == size+1)
                        num = 1;
                    count--;
                }
                innerSum = innerSum + num;
            }

            if(innerSum == sum){
                //System.out.println("Success" + " - "+listOfPermutation.get(i));
                return listOfPermutation.get(i).replaceAll("[^a-zA-Z0-9]","");
            }
        }

        return "IMPOSSIBLE";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] result = new String[t];

        for (int i = 0; i <t; i++) {
            int size = in.nextInt();
            int sum = in.nextInt();
            List<Integer> myList = new ArrayList<Integer>();
            List<String> listOfPermutation = new ArrayList<>();
            for(int j=1;j<=size;j++){
                myList.add(j);
            }
            permute(myList,0,listOfPermutation);

            result[i] = calculate(size,sum,listOfPermutation);
        }
        for(int i=1;i<=t;i++){
            if(result[i-1].equals("IMPOSSIBLE"))
                System.out.println("Case #" + i + ": " + result[i-1]);
            else {
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                for(int j=0;j<result[i-1].length();j++){
                    for(int k=0;k<result[i-1].length();k++){
                        if(j ==0)
                            System.out.print(result[i-1].charAt(k) +" ");
                        else {
                            int num = Character.getNumericValue(result[i-1].charAt(k));
                            int count = j;
                            while(count>0){
                                num = num + 1;
                                if(num == result[i-1].length()+1)
                                    num = 1;
                                count--;
                            }
                            System.out.print(num +" ");
                        }
                    }
                    System.out.println("");
                }
            }
//            if(i!=t)
//                System.out.println("");
        }
    }
}
