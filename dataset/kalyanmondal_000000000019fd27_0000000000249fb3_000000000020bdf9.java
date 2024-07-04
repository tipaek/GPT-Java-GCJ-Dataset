import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))).useDelimiter("\n");
        String test = in.next();
        int t = Integer.parseInt(test);
        for (int i=0; i<t; i++) {
            String num = in.next();
            int n = Integer.parseInt(num);
            List<Node> nodesList = new ArrayList<>();
            for(int j=0; j<n; j++) {
                String line = in.next();
                String lineArr[] = line.split(" ");
                nodesList.add(new Node(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), j));
            }
            Collections.sort(nodesList);
            int lastCameron = 0;
            int lastJamie = 0;
            boolean flag = true;
            for(int j=0; j<n; j++) {
                if(lastCameron <= nodesList.get(j).start){
                    lastCameron = nodesList.get(j).end;
                    nodesList.get(j).person = 'C';
                } else if(lastJamie <= nodesList.get(j).start) {
                    lastJamie = nodesList.get(j).end;
                    nodesList.get(j).person = 'J';
                } else {
                    flag = false;
                    break;
                }
            }
            char[] arr = new char[n];
            for(int j=0; j<n; j++) {
                arr[nodesList.get(j).index] = nodesList.get(j).person;
            }
            if(flag)
                System.out.println("Case #"+(i+1)+": "+String.valueOf(arr));
            else
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        }
        in.close();
    }

    static class Node implements Comparable {
        int start;
        int end;
        int index;
        char person;

        public Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            return this.start-((Node)o).start;
        }
    }
}
