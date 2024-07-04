import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    static List<String> list = new ArrayList<>();
    static int leftBraces=0, rightBraces=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); //test
        for (int i = 1; i <= t; ++i) {
           String str=in.next();
            int len = str.length();

            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                int dig = Integer.parseInt(Character.toString(str.charAt(j)));
               arr[j]=dig;
            }
            for (int k = 0; k <len; k++) {
                if (k == 0) {
                    addBraces("(", arr[k]);
                    list.add(Integer.toString(arr[k]));
                } else {
                    int num = Math.abs(arr[k] - arr[k - 1]);
                    if (arr[k] == 0) {
                        addBraces(")", num);
                        list.add(Integer.toString(arr[k]));
                    } else {
                        if(arr[k-1]!=0)
                        addBraces(")", num);
                        addBraces("(", num);
                        list.add(Integer.toString(arr[k]));
                    }
                }
            }
            addBraces(")",Math.abs(arr[len-1]));
            StringBuffer sb = new StringBuffer("");
            list.forEach(s -> sb.append(s));
            System.out.println("Case #"+i+": "+sb.toString());
            list.clear();
        }
    }

    public static void addBraces(String brace, int num) {
        for (int j = 0; j < num; j++) {
            list.add(brace);
            leftBraces++;
        }
    }
}