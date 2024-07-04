import java.util.*;

public class Solution {

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.next());

        for(int caseNo=1; caseNo<= T; caseNo++) {  // each case

            int[] alp = new int[26];
            for(int i=0; i<26; i++)
                alp[i] = 0;


            int u = Integer.parseInt(scanner.next());

            for(int i=0; i<10000; i++) {

                int in = Integer.parseInt(scanner.next());
                String s = scanner.next();

                for(char c : s.toCharArray()) {

                    alp[c-'A']++;
                }
            }

            HashMap<String,Integer> map = new HashMap<>(26);

            for(int i=0; i<26; i++) {
                char c = (char) (i + 'A');
                map.put(String.valueOf(c),alp[i]);
            }

            HashMap<String, Integer> sortedMap = sortByValue(map);

            //Set<String> keys = sortedMap.entrySet();
            //Character[] objects = (Character[]) keys.toArray();

            char[] alpha = new char[10];

//            for(int i=1; i<10; i++)
//                alpha[i] = objects[26-i];
//
//            alpha[0] = objects[16];

            int inc = 0;
            for (Map.Entry<String, Integer> en : sortedMap.entrySet()) {
                inc++;
//                System.out.println(inc + " Key = " + en.getKey() +
//                        ", Value = " + en.getValue());

                if(inc == 17) {
                    alpha[0] = en.getKey().toCharArray()[0];
                } else if(inc > 16) {
                    alpha[27-inc] = en.getKey().toCharArray()[0];
                }
            }

            //System.out.println(new String(alpha));

            System.out.println("Case #" + caseNo + ": " + new String(alpha));
        }
    }
}
