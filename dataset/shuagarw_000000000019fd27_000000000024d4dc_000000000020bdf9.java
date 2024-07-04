import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;
public class Solution {

  private static class Pair{
    public int x;
    public int y;
    public int index;
    public char ch;

    public Pair(int x , int y, int index){
      this.x = x;
      this.y = y;
      this.index = index;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int cases = Integer.parseInt( in .nextLine());

    for (int noOfCases = 0; noOfCases < cases; noOfCases++) {
      int noOfActivities = Integer.parseInt( in .nextLine());
      if(noOfActivities <=0)
        continue;
      List<Pair> list = new ArrayList<>();


      for (int activities = 0; activities < noOfActivities; activities++) {
        String[] startAndEndTime = in .nextLine().split(" ");
        Pair pair = new Pair(Integer.parseInt(startAndEndTime[0]), Integer.parseInt(startAndEndTime[1]), activities);
        list.add(pair);
      }
      Collections.sort(list, (a, b) -> {
        if(a.x == b.x){
          return a.y - b.y;
        }else{
          return a.x - b.x;
        }
      });


      StringBuilder output = new StringBuilder();

      Pair cameRonendPair = list.get(0);
      Pair JennicePair = null;

      cameRonendPair.ch = 'C';
      for (int assigne = 1; assigne < noOfActivities; assigne++) {

        Pair current = list.get(assigne);
        if(current.x >= cameRonendPair.y){
          current.ch = 'C';
          cameRonendPair = current;

        }else if(JennicePair == null || current.x >= JennicePair.y){
            current.ch = 'J';
            JennicePair = current;
        }else{
          output.append("IMPOSSIBLE");
          break;
        }
      }
      if (output.toString().equals("IMPOSSIBLE")) {
        System.out.println("Case #" + (noOfCases + 1) + ": " + output.toString());
      } else {
        Collections.sort(list, (a, b) -> {
          return a.index - b.index;
        });
        output = new StringBuilder();
        for(Pair pair : list){
          output.append(pair.ch);

        }
        System.out.println("Case #" + (noOfCases + 1) + ": " + output.toString());
      }
    }
  }

}
