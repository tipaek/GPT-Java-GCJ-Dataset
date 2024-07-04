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
            String ans = "";
            listGroupedNumber.add(groupedNumber);
            for (int i = 0; i < listGroupedNumber.size(); i++) {
                if (i != 0) {
                    if (listGroupedNumber.get(i).number == 0) {
                        ans += pad(listGroupedNumber.get(i).number.toString(),listGroupedNumber.get(i).quantity);
                        continue;
                    }                    
                    int parenthesesToBeRemoved = getEndParenthesesThatCanBeRemoved(ans);
                    int removedParenteses = 0;
                    if (parenthesesToBeRemoved - listGroupedNumber.get(i).number > 0) {
                        ans = ans.substring(0, ans.length() - listGroupedNumber.get(i).number);
                        removedParenteses = parenthesesToBeRemoved - listGroupedNumber.get(i).number;
                    } else {
                        ans = ans.substring(0, ans.length() - parenthesesToBeRemoved)
                            + pad("(", Math.abs(parenthesesToBeRemoved - listGroupedNumber.get(i).number));
                        removedParenteses = parenthesesToBeRemoved;
                    }
                    ans += pad(listGroupedNumber.get(i).number.toString(),listGroupedNumber.get(i).quantity)
                        + pad(")", (listGroupedNumber.get(i).number - removedParenteses )+ removedParenteses);
                } else {
                    ans = pad("(", listGroupedNumber.get(0).number)
                            + pad(listGroupedNumber.get(0).number.toString(),listGroupedNumber.get(0).quantity)
                            + pad(")", listGroupedNumber.get(0).number);;
                }
            }
            System.out.println(String.format("Case #%d: %s",iT,ans));
        }
        scanner.close();
    }

    private static int getEndParenthesesThatCanBeRemoved(final String string) {
        int ans = 0;
        for (int i = string.length(); i > 0 && string.charAt(i - 1) == ')'; i--, ans++);
        return ans;
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
