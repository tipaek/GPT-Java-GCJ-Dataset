import java.util.*;
        import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int test = 1; test <= t; ++test) {
            String s=sc.next();
            char ch[] = s.toCharArray();
            int n = s.length();
            ArrayList<Character> list = new ArrayList<>();
            int count=0;
            for(int i=0;i<n;i++) {
                if((int)ch[i]-48>count) {
                    int temp = (int)ch[i]-48-count;
                    while(temp!=0) {
                        list.add('(');
                        count++;
                        temp--;
                    }
                    list.add(ch[i]);
                }
                else {
                    int temp = count-(int)ch[i]+48;
                    while(temp!=0) {
                        list.add(')');
                        count--;
                        temp--;
                    }
                    list.add(ch[i]);
                }
            }
            while(count!=0) {
                list.add(')');
                count--;
            }
            System.out.print("Case #" + test + ": ");
            for(char it:list)
                System.out.print(it);

            System.out.println();
        }
    }
}