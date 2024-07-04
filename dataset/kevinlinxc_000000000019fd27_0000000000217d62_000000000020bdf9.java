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
                for(int i =0; i< activities; i++){
                    String time = scanner.nextLine();
                    String[] twoTime = time.split(" ");
                    Pair<Integer,Integer> newPair = new Pair<>(Integer.parseInt(twoTime[0]),Integer.parseInt(twoTime[1]));
                    activityPair.add(newPair);
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
                            if (pair3.getFirst()<pair1.getSecond()){
                                impossible=true;
                                break;
                            }
                        }
                        sb.append(not(currentString));
                        currentString = not(currentString);
                    } else {
                        sb.append(currentString);
                    }
                }
                scanner.nextLine();
                if(impossible){
                    System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + testNumber + ": " + sb.toString());
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
