import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int iT = 1; iT <= T; iT++) {
            String[] split = scanner.next().split("");
            List<GroupedNumber> listGroupedNumber = new ArrayList<>();
            String control = split[0];
            int count = 1;
            for (int i = 1; i < split.length; i++) {
                if (!control.equals(split[i])) {
                    GroupedNumber groupedNumber = new GroupedNumber();
                    groupedNumber.number = Integer.valueOf(control);
                    groupedNumber.quantity = count;
                    control = split[i];
                    count = 1;
                    listGroupedNumber.add(groupedNumber);
                } else {
                    count++;
                }
            }
            GroupedNumber groupedNumber = new GroupedNumber();
            groupedNumber.number = Integer.valueOf(control);
            groupedNumber.quantity = count;
            listGroupedNumber.add(groupedNumber);
            int numberOfEndParent = listGroupedNumber.get(0).number;
            String ans = pad("(", listGroupedNumber.get(0).number)
                    + pad(listGroupedNumber.get(0).number.toString(),listGroupedNumber.get(0).quantity)
                    + pad(")", listGroupedNumber.get(0).number);;
            for (int i = 1; i < listGroupedNumber.size(); i++) {
                numberOfEndParent = listGroupedNumber.get(i).number;
                if (listGroupedNumber.get(i).number == 0) {
                    ans += pad(listGroupedNumber.get(i).number.toString(),listGroupedNumber.get(i).quantity);
                    continue;
                }
                int parentToBeRemoved = numberOfEndParent - listGroupedNumber.get(i).number < 0
                         ? numberOfEndParent : numberOfEndParent - listGroupedNumber.get(i).number;
                if (parentToBeRemoved > 0) {
                    ans = ans.substring(0, ans.length() - parentToBeRemoved);
                } else {
                    parentToBeRemoved = listGroupedNumber.get(i).number;
                }
                ans+= pad("(", parentToBeRemoved)
                    + pad(listGroupedNumber.get(i).number.toString(),listGroupedNumber.get(i).quantity)
                    + pad(")", listGroupedNumber.get(i).number);
            }
            System.out.println(String.format("Case #%d: %s",iT,ans));
        }
        scanner.close();
    }
    static class GroupedNumber {
        Integer number;
        Integer quantity;
    }
    public static String pad(String s, int n) {
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans+=s;
        }
        return ans;
    }


}
