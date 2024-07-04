import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream input = System.in;
        InputReader reader = new InputReader(input);
        int testCases = reader.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = reader.nextInt();
            ArrayList<Task> startList = new ArrayList<>();
            ArrayList<Task> endList = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                startList.add(new Task(start, i));
                endList.add(new Task(end, i));
            }
            
            Collections.sort(startList, new TaskComparator());
            Collections.sort(endList, new TaskComparator());
            
            int endIndex = 0, startIndex = 1, overlap = 1;
            boolean isImpossible = false;
            StringBuilder assignment = new StringBuilder("C");
            ArrayList<Integer> freePerson = new ArrayList<>();
            freePerson.add(startList.get(0).index);
            freePerson.add(-1);
            
            while (startIndex < n && endIndex < n) {
                if (startList.get(startIndex).time < endList.get(endIndex).time) {
                    overlap++;
                    if (overlap > 2) {
                        isImpossible = true;
                        break;
                    }
                    if (freePerson.get(0) == -1) {
                        freePerson.set(0, startList.get(startIndex).index);
                        assignment.append("C");
                    } else if (freePerson.get(1) == -1) {
                        freePerson.set(1, startList.get(startIndex).index);
                        assignment.append("J");
                    }
                    startIndex++;
                } else {
                    int finishedTaskIndex = endList.get(endIndex).index;
                    if (freePerson.get(0) == finishedTaskIndex) {
                        freePerson.set(0, -1);
                    } else if (freePerson.get(1) == finishedTaskIndex) {
                        freePerson.set(1, -1);
                    }
                    endIndex++;
                    overlap--;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    result.append("D");
                }
                for (int i = 0; i < n; i++) {
                    result.setCharAt(startList.get(i).index, assignment.charAt(i));
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        
        public InputReader(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }
        
        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Task {
        int time;
        int index;
        
        Task(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }

    static class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task t1, Task t2) {
            return Integer.compare(t1.time, t2.time);
        }
    }
}