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

            int[] alp2 = new int[26];
            for(int i=0; i<26; i++)
                alp2[i] = 0;

            scanner.next();// read u

            for(int i=0; i<10000; i++) {

                scanner.next();// read input
                String s = scanner.next();

                alp[s.charAt(0)-'A']++;

                for(char c : s.toCharArray()) {

                    alp2[c-'A']++;
                }
            }

//            System.out.println("alp");
//            for(int i=0; i<26; i++)
//                System.out.println(alp[i]);
//            System.out.println("alp2");
//            for(int i=0; i<26; i++)
//                System.out.println(alp2[i]);


            HashMap<String,Integer> map = new HashMap<>(26);
            HashMap<String,Integer> map2 = new HashMap<>(26);

            for(int i=0; i<26; i++) {
                char c = (char) (i + 'A');
                map.put(String.valueOf(c),alp[i]);
                map2.put(String.valueOf(c),alp2[i]);
            }

            HashMap<String, Integer> sortedMap = sortByValue(map);
            HashMap<String, Integer> sortedMap2 = sortByValue(map2);

            //Set<String> keys = sortedMap.entrySet();
            //Character[] objects = (Character[]) keys.toArray();

            char[] alpha = new char[10];
            char[] a9 = new char[9];
            char[] a10 = new char[10];

//            for(int i=1; i<10; i++)
//                alpha[i] = objects[26-i];
//
//            alpha[0] = objects[16];

            int inc = 0;
            for (Map.Entry<String, Integer> en : sortedMap.entrySet()) {
                inc++;
//                System.out.println(inc + " Key = " + en.getKey() +
//                        ", Value = " + en.getValue());

//                if(inc == 17) {
//                    //alpha[0] = en.getKey().toCharArray()[0];
//                } else if(inc > 16) {
//                    alpha[27-inc] = en.getKey().toCharArray()[0];
//                }

                if(inc > 17) {  // last 9
                    int idx = 27 - inc;
//                    System.out.println("inc:"+inc+" 27-inc:"+idx);
                    alpha[idx] = en.getKey().toCharArray()[0];
                    a9[idx-1] = en.getKey().toCharArray()[0];
                }
            }

            // zifir
            inc = 0;
            for (Map.Entry<String, Integer> en : sortedMap2.entrySet()) {
                inc++;
//                System.out.println(inc + " Key = " + en.getKey() +
//                        ", Value = " + en.getValue());

                if(inc > 16) {  // last 9
                    int idx = 27 - inc;
//                    System.out.println("inc:"+inc+" 27-inc:"+idx);
                    //alpha[idx] = en.getKey().toCharArray()[0];
                    a10[idx-1] = en.getKey().toCharArray()[0];
                }

//                if(inc == 17) {
//                    alpha[0] = en.getKey().toCharArray()[0];
//                }
//                } else if(inc > 16) {
////                    alpha[27-inc] = en.getKey().toCharArray()[0];
////                }

//                if(inc > 16) {
//                    alpha[27 - inc] = en.getKey().toCharArray()[0];
//                }
            }

            String zero = "";
            String a9s = new String(a9);
            for(char c : a10) {
                if(!a9s.contains(String.valueOf(c))) {
                    zero = String.valueOf(c);
                    break;
                }
            }

            zero+=a9s;


            //String birdokuz = new String(alpha);

            //System.out.println(new String(alpha));

            System.out.println("Case #" + caseNo + ": " + zero);
        }
    }
}
