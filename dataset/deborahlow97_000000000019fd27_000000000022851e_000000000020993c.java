import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Vesticum {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = Integer.parseInt(input.nextLine());
        int trace, col, row, counter;
        int len = 0;
        StringBuilder sb;
        ArrayList<HashSet<String>> list;
        HashSet<String> set;
        System.out.println("a");
        for (int i=0; i<num; i++) { //size
            trace = 0;
            col = 0;
            row = 0;
            len = Integer.parseInt(input.nextLine());
            list = new ArrayList<>(len);
            for (int a=0; a<len; a++) {
                list.add(new HashSet<>());
            }
            for (int j=0; j<len; j++) { //loop through size of square
                counter = 0;
                String line = input.nextLine();
                set = new HashSet<>();
                StringTokenizer st = new StringTokenizer(line, " ");
                while(st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    if (counter == j) trace+= Integer.parseInt(tok);
                    list.get(counter).add(tok);
                    set.add(tok);
                    counter++;
                }
                if (set.size() < len) row++;
            }
            for (HashSet<String> li: list) {
                if (li.size() < len) col++;
            }
            sb = new StringBuilder();
            sb.append("Case #").append(i+1).append(": ").append(trace).append(" ").append(row).append(" ").append(col);
            System.out.println(sb.toString());
        }
    }
}
