

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hao Wu (wuhao.02@gmail.com) on 4/3/20.
 */
public class Solution {

  private static final class Item {
    int index;
    int start;
    int end;

    int assign;
    Item(int index, int start, int end) {
      this.index = index;
      this.start = start;
      this.end = end;
    }


  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));


    int T = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(reader.readLine());
      List<Item> items = new ArrayList<>(N);
      for (int i = 0; i < N; i++) {
        String[] tokens = reader.readLine().split(" ");
        items.add(new Item(i, Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
      }

      items.sort((x, y) -> x.start - y.start);
      int next0 = 0;
      int next1 = 0;
      boolean fail = false;
      for (int i = 0; i<N; i++) {
        Item item = items.get(i);
        if (next0 <= item.start) {
          item.assign = 0;
          next0 = item.end;
        } else if (next1 <= item.start) {
          item.assign = 1;
          next1 = item.end;
        } else {
          fail = true;
          break;
        }
      }
      String sol;
      if (fail) {
        sol = "IMPOSSIBLE";
      } else {
        items.sort((x,y)-> x.index - y.index);
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
          if (item.assign == 0) {
            sb.append("C");
          } else {
            sb.append("J");
          }
        }
        sol = sb.toString();
      }
      System.out.println("Case #" + t + ": " + sol);

    }


  }
}
