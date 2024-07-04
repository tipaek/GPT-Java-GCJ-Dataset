import java.io.*;
import java.util.*;

public class Solution {
    public static String not(String s){
        if (s.equals("C")){
            return "J";
        } else {
            return "C";
        }
    }
    public static String rearrange(String s, int[] map,int size){
        char[] rearranged = new char[size];
        char[] old = s.toCharArray();
        for(int i =0; i < size; i++){
            int newPosition = map[i];
            rearranged[newPosition]=old[i];
        }
        return new String(rearranged);
    }
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                boolean impossible=false;
                List<Pair<Integer,Integer>> activityPair = new LinkedList<>();
                StringBuilder sb = new StringBuilder();
                sb.append("C");
                int activities = scanner.nextInt();
                scanner.nextLine();
                for(int i =0; i< activities; i++){
                    String time = scanner.nextLine();
                    String[] twoTime = time.split(" ");
                    Pair<Integer,Integer> newPair = new Pair<>(Integer.parseInt(twoTime[0]),Integer.parseInt(twoTime[1]));
                    activityPair.add(newPair);
                }
                List<Pair<Integer,Integer>> oldPairs = (LinkedList) ((LinkedList<Pair<Integer, Integer>>) activityPair).clone();
                activityPair.sort((o1, o2) -> {
                    if (o1.getFirst().equals(o2.getFirst()))
                        return 0;
                    else if (o1.getFirst() > o2.getFirst())
                        return 1;
                    else
                        return -1;
                });
                int[] map = new int[activities];
                for(int i =0; i < oldPairs.size();i++){
                    map[i] = activityPair.indexOf(oldPairs.get(i));
                }
                String currentString = "C";
                for(int i =1; i< activityPair.size(); i++){
                    Pair<Integer, Integer> pair1 = activityPair.get(i-1);
                    Pair<Integer, Integer> pair2 = activityPair.get(i);
                    Pair<Integer, Integer> pair3 = null;
                    if(i+1 < activityPair.size()){
                        pair3 = activityPair.get(i+1);
                    }
                    if (pair2.getFirst()<pair1.getSecond()){
                        if(i+1 < activityPair.size()){
                            if (pair3.getFirst()<pair1.getSecond()&&pair3.getFirst()<pair2.getSecond()){
                                impossible=true;
                            }
                        }
                        sb.append(not(currentString));
                        currentString = not(currentString);
                    } else {
                        sb.append(currentString);
                    }
                }
                if(impossible){
                    System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
                } else {
                    String result = rearrange(sb.toString(),map,activities);
                    System.out.println("Case #" + testNumber + ": " + result);
                }
            }
        }
    }


    public static class Pair<A, B> {
        private A first;
        private B second;

        public Pair(A first, B second) {
            super();
            this.first = first;
            this.second = second;
        }

        public int hashCode() {
            int hashFirst = first != null ? first.hashCode() : 0;
            int hashSecond = second != null ? second.hashCode() : 0;

            return (hashFirst + hashSecond) * hashSecond + hashFirst;
        }

        public boolean equals(Object other) {
            if (other instanceof Pair) {
                Pair otherPair = (Pair) other;
                return
                        ((  this.first == otherPair.first ||
                                ( this.first != null && otherPair.first != null &&
                                        this.first.equals(otherPair.first))) &&
                                (  this.second == otherPair.second ||
                                        ( this.second != null && otherPair.second != null &&
                                                this.second.equals(otherPair.second))) );
            }

            return false;
        }

        public String toString()
        {
            return "(" + first + ", " + second + ")";
        }

        public A getFirst() {
            return first;
        }

        public void setFirst(A first) {
            this.first = first;
        }

        public B getSecond() {
            return second;
        }

        public void setSecond(B second) {
            this.second = second;
        }
    }
}
