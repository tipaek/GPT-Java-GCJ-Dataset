import java.util.*;

class Pair {
    Integer first;
    Integer second;

    Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    Integer getKey() {
        return this.first;
    }

    Integer getValue() {
        return this.second;
    }
}

class SortComparator implements Comparator<Pair> {
    SortComparator() {
    }

    @Override
    public int compare(Pair p1, Pair p2) {
        int result = p1.getKey().compareTo(p2.getKey());
        if(result == 0) {
            result = p1.getValue().compareTo(p2.getValue());
        }
        return result;
    }
}


class Solution {

    public static boolean validate(char fillAr[], int start, int end, char target) {
        int flag = 0;
        for(int i=start+1; i<=end; i++) {
            if(fillAr[i] == target) {
                flag = 1;
            }
        }
        if(flag == 1) {
            return false;
        } else {
            for(int i=start; i<=end; i++) {
                fillAr[i] = target;
            }
            return true;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for(int t=0; t<test; t++) {
            int n = sc.nextInt();
            ArrayList<Pair> alist = new ArrayList<>();
            ArrayList<Pair> real = new ArrayList<>();

            for(int i=0; i<n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                alist.add(new Pair(start, end));
                real.add(new Pair(start, end));
            }
            SortComparator comp = new SortComparator();
            Collections.sort(alist, comp);

//            System.out.println("Array List: ");
//            System.out.println(alist);



            char[] fillAr = new char[1441];
            for(int i=0; i<1441; i++) {
                fillAr[i] = 'F';
            }
            int flag = 0;
            String ansStr = "";
            String finalAns = "";

            for(int i=0; i<alist.size(); i++) {
                int start = alist.get(i).getKey();
                int end = alist.get(i).getValue();

                    if(validate(fillAr, start, end, 'C') == true) {
//                        System.out.println("\nC is filled from "+start+" to "+end);
                        ansStr += "C";
//                        System.out.println();
//                        for(int j=0; j<1441; j++) {
//                            System.out.print(fillAr[j]);
//                        }
                    } else if(validate(fillAr, start, end, 'J') == true) {
//                        System.out.println("\nJ is filled from " + start + " to " + end);
                        ansStr += "J";
//                        System.out.println();
//                        for(int j=0; j<1441; j++) {
//                            System.out.print(fillAr[j]);
//                        }
                    } else {
                        flag = 1;
                    }
            }

            if(flag == 1) {
                ansStr = "IMPOSSIBLE";
                finalAns = "IMPOSSIBLE";
            } else {
                for(int i=0; i<real.size(); i++) {
                    int key = real.get(i).getKey();
                    int value = real.get(i).getValue();
                    for(int j=0; j<alist.size(); j++) {
                        int ele = alist.get(j).getKey();
                        int eleValue = alist.get(j).getValue();
                        if((key == ele) && (value == eleValue)) {
                            finalAns += ansStr.charAt(j);
                        }
                    }
                }
            }
            System.out.println("Case #"+(t+1)+": "+finalAns);
        }
    }
}
