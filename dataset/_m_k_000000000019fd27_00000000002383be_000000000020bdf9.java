import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for (int i = 0; i < a; i++) {
            int b = s.nextInt();
            ArrayList<int[]> list = new ArrayList<>();
            ArrayList<int[]> list2 = new ArrayList<>();
//            list.add(new int[]{1, 2, 3});
//            list.add(new int[]{1});
//            list.add(new int[]{1,2});
            for (int j = 0; j < b; j++) {
                int[] c = new int[2];
                c[0] = s.nextInt();
                c[1] = s.nextInt();
                list.add(c);
                list2.add(c);
            }
            Collections.sort(list2, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int freec = list2.get(0)[1];
            int freej = 0;
            char prev = 'C';
            boolean impossible=false;
            ArrayList<Character> list1 = new ArrayList<>();
            list1.add('C');
            HashMap<int[],Character> map=new HashMap<>();
            map.put(list2.get(0),list1.get(0));
            for (int j = 1; j < b; j++) {
                if (prev == 'C') {
                    if (freec <= list2.get(j)[0]) {
                        prev = 'C';
                        freec = list2.get(j)[1];
                        list1.add('C');
                    } else if (freej <= list2.get(j)[0]) {
                        prev = 'J';
                        freej = list2.get(j)[1];
                        list1.add('J');
                    } else {
                        impossible=true;
                        break;
                    }
                } else {
                    if (freej <= list2.get(j)[0]) {
                        prev = 'J';
                        freej = list2.get(j)[1];
                        list1.add('J');
                    } else if (freec <= list2.get(j)[0]) {
                        prev = 'C';
                        freec = list2.get(j)[1];
                        list1.add('C');
                    } else {
                        impossible=true;
                        break;
                    }
                }
                map.put(list2.get(j),list1.get(j));
            }
            StringBuilder sb=new StringBuilder();
            if(impossible==true)
                sb.append("IMPOSSIBLE");
            else{
                for(int j=0;j<b;j++){
                    sb.append(map.get(list.get(j)));
                }
            }
//                System.out.println(list.get(j)[0]+" "+list.get(j)[1]);
            System.out.println("Case #"+(i+1)+": "+sb.toString());
        }
    }
}
