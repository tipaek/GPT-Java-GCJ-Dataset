
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public static void main(String args[]) {

        Solution s = new Solution();
        List<String> results = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int numberOfCases = in.nextInt();
        in.nextLine();
        int x = 0;
        for (int i = 0; i < numberOfCases; i++) {

            ArrayList<Integer> input = new ArrayList<>();
            ArrayList<Integer> maxPosition = new ArrayList<>();
            int maxValue = 0;

            String y = "";
            String inputString;
            x = i + 1;


            inputString = in.next();
            in.nextLine();


            SingleNumber h = s.new SingleNumber(0, 0, null, null, null);
            SingleNumber header = h;
            for (int c = 0; c < inputString.length(); c++) {
                SingleNumber n = s.new SingleNumber(Integer.parseInt(String.valueOf(inputString.charAt(c))), Integer.parseInt(String.valueOf(inputString.charAt(c))), null, null, h);
                h.nextStringValue = n;
                h.nextNumberValue = n;
                h = n;
            }

            do {
                maxValue = 0;
                h = header.nextNumberValue;
                while (h != null) {
                    if (h.decrementedValue > maxValue) maxValue = h.decrementedValue;
                    h = h = h.nextNumberValue;
                }

                if(maxValue == 0) break;
                h = header.nextNumberValue;
                while (h != null) {
                    SingleNumber n = h;
                    if (h.decrementedValue != maxValue) {
                        h = h.nextNumberValue;
                        continue;
                    }
                    while (n != null && n.decrementedValue == maxValue) {
                        n.decrementedValue--;
                        if(n.nextNumberValue == null || n.nextNumberValue.decrementedValue != maxValue) break;
                        else n = n.nextNumberValue;

                    }
                    SingleNumber a = s.new SingleNumber(-1, -1, h, h, h.prexStringValue);
                    SingleNumber c = s.new SingleNumber(-2, -2, n.nextStringValue, n.nextNumberValue, n);

                    h.prexStringValue.nextStringValue=a;
                    h.prexStringValue = a;
                    n.nextStringValue = c;
                    if(n.nextStringValue!=null) n.nextStringValue.prexStringValue=c;

                    h = n.nextNumberValue;
                }
            } while (maxValue > 0);

            SingleNumber r = header.nextStringValue;
            while(r!=null){
                input.add(r.originalValue);
                r=r.nextStringValue;
            }

            results.add(resultFormatter(x,listToString(input)));

        }
        for (String r : results) {
            System.out.println(r);
        }
    }

    public static String resultFormatter(int x, String y) {
        return "Case #" + x + " " + y + "\n";
    }

    public static String listToString(List<Integer> l) {
        StringBuilder r = new StringBuilder();
        for (Integer i : l) {
            if (i == -1) r.append("(");
            else if (i == -2) r.append(")");
            else r.append(i);
        }
        return r.toString();
    }

    public static void addParentesys(ArrayList<Integer> a, int m, int n) {
        a.add(m, -1);
        a.add(n, -2);
    }

    public class SingleNumber {
        int originalValue;
        int decrementedValue;
        SingleNumber nextStringValue;
        SingleNumber nextNumberValue;
        SingleNumber prexStringValue;

        public SingleNumber(int originalValue,
                            int decrementedValue,
                            SingleNumber nextStringValue,
                            SingleNumber nextNumberValue,
                            SingleNumber prexStringValue) {
            this.originalValue = originalValue;
            this.decrementedValue = decrementedValue;
            this.nextStringValue = nextStringValue;
            this.nextNumberValue = nextNumberValue;
            this.prexStringValue = prexStringValue;
        }
    }
}
