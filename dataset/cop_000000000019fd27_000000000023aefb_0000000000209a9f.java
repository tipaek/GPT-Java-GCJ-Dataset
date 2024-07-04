import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.04.2020
 */
public class Solution {

    public static void main(String... args) throws IOException {

        final class Group {

            private final int val;
            private int total = 1;

            public Group(int val) {
                this.val = val;
            }
        }

        try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < total; i++) {
                String str = scan.nextLine();

                List<Group> groups = new LinkedList<>();
                Group data = null;

                for (int j = 0; j < str.length(); j++) {
                    int val = str.charAt(j) - '0';

                    if (data == null)
                        data = new Group(val);
                    else if (data.val == val)
                        data.total++;
                    else {
                        groups.add(data);
                        data = new Group(val);
                    }
                }

                if (data != null)
                    groups.add(data);

                StringBuilder buf = new StringBuilder();

                for (Group group : groups) {
                    for (int j = 0; j < group.val; j++)
                        buf.append('(');

                    for (int j = 0; j < group.total; j++)
                        buf.append(group.val);

                    for (int j = 0; j < group.val; j++)
                        buf.append(')');
                }

                System.out.format("Case #%d: %s\n", i + 1, buf.toString());
            }
        }
    }

}