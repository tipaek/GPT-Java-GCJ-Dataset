    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
          int n  = in.nextInt();
          String output = "";
          PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.get(0) - e2.get(0));
          ArrayList<ArrayList<Integer>> orderList = new ArrayList<ArrayList<Integer>>();
          for(int j = 0; j < n; ++j){
              int s = in.nextInt();
              int e = in.nextInt();
              ArrayList<Integer> inner = new ArrayList<Integer>();
              inner.add(s);
              inner.add(e);
              pq.add(inner);
              orderList.add(inner);
          }
          HashMap<ArrayList<Integer>, ArrayList<String>> lastTimeMap = new HashMap<ArrayList<Integer>, ArrayList<String>>();
          ArrayList<ArrayList<Integer>> lastTimes = new ArrayList<ArrayList<Integer>>();
          ArrayList<Integer> addStart = new ArrayList<Integer>();
          addStart.add(-1);
          addStart.add(-1);
          lastTimes.add(addStart);
          ArrayList<String> addLetters = new ArrayList<String>();
          addLetters.add("");
          lastTimeMap.put(addStart, addLetters);
          HashMap<ArrayList<Integer>, Integer> orderMapping = new HashMap<ArrayList<Integer>, Integer>();
          int count = 0;
          while(pq.size() > 0 && lastTimes.size() > 0){
              ArrayList<Integer> next = pq.poll();
              orderMapping.put(next, count);
              ++count;
            //   if(i == 3){
            //   System.out.println("----------------");
            //   for (Map.Entry<ArrayList<Integer>, ArrayList<String>> entry : lastTimeMap.entrySet()) {
            //     ArrayList<Integer> keys = entry.getKey();
            //     ArrayList<String> values = entry.getValue();
            //     System.out.println("Keys:");
            //     System.out.println(keys.get(0) + ":" + keys.get(1));
            //     System.out.println("Values:");
            //     for(int h = 0; h < values.size(); ++h){
            //         System.out.println(values.get(h));
            //     }
            //   }
            //   System.out.println("SSSSSSSSSSSSSSS");
            //   for(int o = 0; o < lastTimes.size(); ++o){
            //       System.out.println(lastTimes.get(o).get(0) + ":" + lastTimes.get(o).get(1));
            //   }
            //   System.out.println("----------------");}
              int sizeToIt = lastTimes.size();
              HashMap<ArrayList<Integer>, ArrayList<String>> newLastTimeMap = new HashMap<ArrayList<Integer>, ArrayList<String>>();
              ArrayList<ArrayList<Integer>> newLastTimes = new ArrayList<ArrayList<Integer>>();
              for(int q = 0; q < sizeToIt; ++q){
                int endingTime = next.get(1);
                int one = lastTimes.get(q).get(0);
                int two = lastTimes.get(q).get(1);
                if(lastTimes.get(q).get(0) <= next.get(0)){
                  ArrayList<Integer> addPoint = new ArrayList<Integer>();
                  addPoint.add(endingTime);
                  addPoint.add(two);
                  newLastTimes.add(addPoint);
                  ArrayList<String> getStrings = lastTimeMap.get(lastTimes.get(q));
                  ArrayList<String> newStrings = new ArrayList<String>();
                  for(int m = 0; m < getStrings.size(); ++m){
                      newStrings.add(getStrings.get(m) + "C");
                  }
                  newLastTimeMap.put(addPoint, newStrings);
                }
                if(lastTimes.get(q).get(1) <= next.get(0)){
                  ArrayList<Integer> addPoint = new ArrayList<Integer>();
                  addPoint.add(one);
                  addPoint.add(endingTime);
                  newLastTimes.add(addPoint);
                  ArrayList<String> getStrings = lastTimeMap.get(lastTimes.get(q));
                  ArrayList<String> newStrings = new ArrayList<String>();
                  for(int m = 0; m < getStrings.size(); ++m){
                      newStrings.add(getStrings.get(m) + "J");
                  }
                  newLastTimeMap.put(addPoint, newStrings);
                }
              }
              lastTimeMap = newLastTimeMap;
              lastTimes = newLastTimes;
          }
          if(pq.size() != 0 || lastTimes.size() == 0){
              System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
          }
          else{
              for (ArrayList<String> value : lastTimeMap.values()) {
                String outputVal = value.get(0);
                String buildOuput = "";
                for(int u = 0; u < orderList.size(); ++u){
                    buildOuput += outputVal.charAt(orderMapping.get(orderList.get(u)));
                }
                System.out.println("Case #" + i + ": " + buildOuput);
                break;
              }
          }
        }
      }
    }