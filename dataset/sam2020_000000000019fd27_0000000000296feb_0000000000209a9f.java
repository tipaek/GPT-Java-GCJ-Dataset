import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(sc.nextLine());
        int counter = 1;

        while(testCases-- > 0) {
            String str = sc.nextLine();
            Set<Integer> set = new HashSet<Integer>();

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '0'){
                    set.add(i);
                }
            }

            String[] arr = str.split("0");
            int i = 0;
            int index = 0;
            StringBuilder sb = new StringBuilder();
            while(i < str.length()) {
                if(set.contains(i)) {
                    sb.append("0");
                    i++;
                }
                else{
                    if(arr[index].length() > 0) {
                        sb.append("("+arr[index]+")");
                        i += (arr[index].length());
                    }
                    index++;
                }
            }
            System.out.println("Case #"+counter+": "+sb.toString());
            counter++;
        }
    }
}