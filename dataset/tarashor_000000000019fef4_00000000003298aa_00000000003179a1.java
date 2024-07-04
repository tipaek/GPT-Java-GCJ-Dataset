
import java.io.PrintStream;
import java.util.*;

public class Solution {

    Scanner             sc       = new Scanner(System.in);
    static final String FILENAME = "in20201C";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    int LINES_COUNT = 10000;

    private void solve() {
        int U = sc.nextInt();
        String[] responses = new String[LINES_COUNT];
        Set<Character> Dset = new HashSet<>();
        Set<Character> notZeroChars = new HashSet<>();
        for (int i = 0; i < LINES_COUNT; i++){
            String m = sc.next();
            responses[i] = sc.next();
            for (int j = 0; j < responses[i].length(); j++){
                Dset.add(responses[i].charAt(j));
                if (j == 0) notZeroChars.add(responses[i].charAt(j));
            }
        }


        int maxLength = 0;
        HashMap<Integer, List<String>> lengthToResponse = new HashMap<>();
        for (int i = 0; i < LINES_COUNT; i++){
            int l = responses[i].length();
            List<String> responsesWithLength = lengthToResponse.getOrDefault(l, new ArrayList<>());
            responsesWithLength.add(responses[i]);
            lengthToResponse.put(l, responsesWithLength);

            maxLength = Integer.max(maxLength, l);
        }

        Map<Character, Integer>[] m = new HashMap[maxLength];
        for (int i = 0; i < maxLength; i++)
            m [i] = new HashMap<>();

        for (int i = 0; i < LINES_COUNT; i++){
            for (int j = 0; j < responses[i].length(); j++){
                char c = responses[i].charAt(j);
                int count = m[j].getOrDefault(c, 0);
                m[j].put(c, count+1);
            }
        }
        Character[] D = new Character[10];

        int i = 0;
        for (Character c : Dset){
             D[i] = c;
             i++;
        }

        final int finalMaxLength = maxLength;
        Arrays.sort(D, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if (!notZeroChars.contains(c1) && Dset.contains(c2)) return -1;

                for (int i1 = 0; i1 < finalMaxLength; i1++) {
                    int count1 = m[0].getOrDefault(c1, -1);
                    int count2 = m[0].getOrDefault(c2, -1);
                    if (count1 != -1 && count2 != -1){
                        return count1 > count2 ? -1 : 1;
                    }
                }
                return 0;
            }
        }
         );


        StringBuilder ans = new StringBuilder();
        for (Character c : D){
            ans.append(c);
        }

        out.println(ans.toString());
    }

    private void run() throws Exception {
//        sc = new Scanner(new File(IN));
        // out = new PrintStream(new FileOutputStream(OUT));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Problem2().run();
    }



}