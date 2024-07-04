import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int numberOfTestCases = Integer.parseInt(input.readLine());
            for(int index = 0;index<numberOfTestCases;++index){
                
                int N = Integer.parseInt(input.readLine());
                
                LinkedList<Integer[]> givenSchedule = new LinkedList<Integer[]>();
                
                for(int i = 0;i<N;++i) {
                    givenSchedule.add(parseValues(input.readLine()));
                }
                
                LinkedList<Integer[]> sortedSchedule = new LinkedList<Integer[]>(givenSchedule);
                Collections.sort(sortedSchedule, new Comparator<Integer[]>() {

                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        
                        if(o1[0] < o2[0]) {
                            return -1;
                        }
                        if(o1[0] > o2[0]) {
                            return 1;
                        }
                        return 0;
                    }
                    
                });
                
                //print(givenSchedule);
                //System.out.println("--------------------");
                //print(sortedSchedule);
                //System.out.println("--------------------");
                
                int[] idx = indexOf(sortedSchedule,givenSchedule);
                
                //System.out.println(Arrays.toString(idx));
                //System.out.println("--------------------");
                //String s = getScheule(sortedSchedule);
                //System.out.println(s);
                System.out.println("Case #"+(index+1)+": "+getCorrectAns(idx,getScheule(sortedSchedule)));
                
                //System.out.println(getCorrectAns(idx,getScheule(sortedSchedule)));
                
                
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    private static String getCorrectAns(int[] idx, String schedule) {
        if(schedule.equals("-1")) {
            return "IMPOSSIBLE";
        }
        char[] c = new char[idx.length];
        
        for(int i=0;i<idx.length;++i) {
            c[idx[i]] = schedule.charAt(i);
        }
        return new String(c);
    }
    
    private static String getScheule(LinkedList<Integer[]> sortedSchedule) {
        if(sortedSchedule.size()<=1) {
            return "-1";
        }
        if(sortedSchedule.size()==2) {
            return "JC";
        }
        String ans = "JC";
        int jEnd = sortedSchedule.get(0)[1];
        int cEnd = sortedSchedule.get(1)[1];
        
        for(int index = 2;index < sortedSchedule.size();++index) {
            Integer[] schedule = sortedSchedule.get(index);
            if(schedule[0] < jEnd && schedule[0] < cEnd) {
                return "-1";
            }
            if(schedule[0] >= jEnd) {
                jEnd = schedule[1];
                ans+="J";
            }else if (schedule[0] >= cEnd) {
                cEnd = schedule[1];
                ans+="C";
            }
        }
        return ans;
    }
    
    private static int[] indexOf(LinkedList<Integer[]> sortedSchedule, LinkedList<Integer[]> givenSchedule) {
        int[] in = new int[givenSchedule.size()];
        boolean[] visited = new boolean[givenSchedule.size()];
        Arrays.fill(visited, false);
        
        int i = 0;
        for(Integer[] schedule:sortedSchedule) {
            for(int index = 0;index<givenSchedule.size();++index) {
                Integer[] given = givenSchedule.get(index);
                if(schedule[0].equals(given[0]) && schedule[1].equals(given[1]) && !visited[index]) {
                    in[i] = index;
                    visited[index] = true;
                    i++;
                    break;
                }
            }
        }
        return in;
    }
    
    private static Integer[] parseValues(String line) {
        Integer[] values = new Integer[2];
        int i = 0;
        for(String s:line.split(" ")) {
            values[i++] = Integer.parseInt(s);
        }
        return values;
    }
    
    private static void print(LinkedList<Integer[]> givenSchedule) {
        for(Integer[] g:givenSchedule) {
            System.out.println(g[0]+" - "+g[1]);
        }
    }

}
