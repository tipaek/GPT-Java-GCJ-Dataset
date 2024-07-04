import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int u = input.nextInt();
            input.nextLine();
            TreeSet<Character>[] nums = new TreeSet[10];
            for(int k = 0; k < 10; k++) {
                nums[k] = new TreeSet<>();
            }
            int find = 1;
            Set<Character> all = new HashSet<>();
            for(int k = 0; k < 10000; k++) {
                String[] line = input.nextLine().split(" ");
                String temp1 = line[0];
                String temp2 = line[1];
                for(int h = 0; h < temp2.length(); h++) {
                    all.add(temp2.charAt(h));
                }
                if(temp1.length() == temp2.length()) {
                    int first = Integer.parseInt(temp1.substring(0, 1));
                    for(int h = 0; h < 10; h++) {
                        if(h == first) {
                            if(nums[h].contains(temp2.charAt(0))) {
                                continue;
                            }
                            nums[h].add(temp2.charAt(0));
                        }
                    }
                }
            }
            ArrayList<Character> stuff = new ArrayList<>();
            for(int k = 1; k < 10; k++) {
                for(Character c : stuff) {
                    if(nums[k].contains(c)) {
                        nums[k].remove(c);
                    }
                }
                stuff.add(nums[k].first());
            }
            for(Iterator<Character> it = all.iterator(); it.hasNext();) {
                char temp = it.next();
                if(!stuff.contains(temp)) {
                    stuff.add(0, temp);
                    break;
                }
            }
            String answer = "";
            for(int k = 0; k < 10; k++) {
                answer += stuff.get(k);
            }
            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }
}
