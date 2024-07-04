import java.util.Scanner;
import java.util.*;
import javafx.util.Pair; 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); 
        for (int c = 0; c<num; c++) {
            String ret = "";
            boolean impos = false;
            boolean[] schedule1 = new boolean[1440];
            boolean[] schedule2 = new boolean[1440];
            for (int i = 0; i<1440; i++) {
                schedule1[i]=false;
                schedule2[i]=false;
            }
            ArrayList<int[]> events = new ArrayList<int[]>();
            int event = sc.nextInt();
            int[] results = new int[event];
            for (int i = 0; i<event; i++) {
                //System.out.println(i);
                int start = sc.nextInt();
                int end = sc.nextInt();
                events.add(new int[]{start,end});
            }
            Pair<ArrayList<int[]>, ArrayList<Integer>> sorted = sort(events);
            for (int i = 0; i<sorted.getKey().size(); i++) {
                int start = sorted.getKey().get(i)[0];
                int end = sorted.getKey().get(i)[1];
                boolean pos1 = true;
                boolean pos2 = true;
                for (int time = start; time<end; time++) {
                    if (schedule1[time]) {
                        pos1 = false;
                    }
                }
                if (pos1) {
                    for (int time = start; time<end; time++) {
                        schedule1[time]=true;
                    }
                    results[sorted.getValue().get(i)]='C';
                }
                if (!pos1) {
                    for (int time = start; time<end; time++) {
                        if (schedule2[time]) {
                            pos2 = false;
                        }
                    }
                    if (pos2) {
                        for (int time = start; time<end; time++) {
                            schedule2[time]=true;
                        }
                        results[sorted.getValue().get(i)]='J';
                    }
                    if (!pos2) {
                        impos=true;
                    }
                }
            }
            if (impos) {
                System.out.println("Case #"+(c+1)+": IMPOSSIBLE");
            }
            else {
                String ret2 = "";
                for (int ch: results) {
                    ret2+=(char)ch;
                    //System.out.println((char)ch);
                }
                System.out.println("Case #"+(c+1)+": "+ret2);
            }
        }
    }
    public static Pair<ArrayList<int[]>, ArrayList<Integer>> sort(ArrayList<int[]> arr) {
        ArrayList<int[]> sortedArray = new ArrayList<int[]>();
        ArrayList<int[]> temp = (ArrayList<int[]>) arr.clone();
        boolean[] found = new boolean[arr.size()];
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int length = arr.size();
        while (sortedArray.size()<arr.size()) {
            int min = 1441;
            int indMin = -1;
            for (int i = 0; i<temp.size(); i++) {
                if ((temp.get(i)[0]<min)&&(found[i]==false)) {
                    min=temp.get(i)[0];
                    indMin=i;
                }
            }
            if (indMin==-1) {
                continue;
            }
            sortedArray.add(temp.get(indMin));
            ret.add(indMin);
            found[indMin]=true;
        }
        return new Pair<ArrayList<int[]>, ArrayList<Integer>>(sortedArray, ret);
    }
}