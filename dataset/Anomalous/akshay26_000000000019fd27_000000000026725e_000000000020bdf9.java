import java.util.*;
import java.io.*;

class Name implements Comparable<Name> {
    private int firstName;
    private int lastName;
    private int index;

    public Name(int firstName, int lastName, int index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
    }

    public int getFirstName() {
        return firstName;
    }

    public int getLastName() {
        return lastName;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Name otherName) {
        if (this.firstName != otherName.firstName) {
            return Integer.compare(this.firstName, otherName.firstName);
        } else {
            return Integer.compare(this.lastName, otherName.lastName);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            Name[] names = new Name[n];
            String[] inputStrings = new String[n];

            for (int i = 0; i < n; i++) {
                names[i] = new Name(sc.nextInt(), sc.nextInt(), i);
                inputStrings[i] = names[i].getFirstName() + " " + names[i].getLastName() + " " + names[i].getIndex();
            }

            List<Name> nameList = new ArrayList<>(Arrays.asList(names));
            Collections.sort(nameList);

            Map<String, String> assignmentMap = new HashMap<>();
            int cEnd = 0, jEnd = 0;
            boolean impossible = false;

            for (Name name : nameList) {
                int start = name.getFirstName();
                int end = name.getLastName();
                int index = name.getIndex();

                if (cEnd <= start) {
                    assignmentMap.put(start + " " + end + " " + index, "C");
                    cEnd = end;
                } else if (jEnd <= start) {
                    assignmentMap.put(start + " " + end + " " + index, "J");
                    jEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (String input : inputStrings) {
                    System.out.print(assignmentMap.get(input));
                }
                System.out.println();
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}