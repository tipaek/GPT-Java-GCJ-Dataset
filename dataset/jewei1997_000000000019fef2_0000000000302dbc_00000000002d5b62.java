import java.util.*;

public class Solution {

  // lets just do adding and subtracting all combos as long as positive
  static List<Character> getCombos(Map<List<Integer>,List<Character>> combos, int expLimit, int X, int Y) {

    List<Integer> XY = new ArrayList<>();
    XY.add(X); XY.add(Y);
    if (combos.containsKey(XY)) return combos.get(XY);

    for (int exp = 1; exp <= expLimit; exp++) {
      // System.out.println("exp = " + exp);
      int num = (1 << exp);
      Map<List<Integer>,List<Character>> oldCombos = new HashMap<>(combos);
      combos = new HashMap<>();
      for (List<Integer> tuple : oldCombos.keySet()) {
        List<Character> path = oldCombos.get(tuple);

        List<Integer> newTuple1 = new ArrayList<>(tuple);
        List<Integer> newTuple2 = new ArrayList<>(tuple);
        List<Character> path1 = new ArrayList<>(path);
        List<Character> path2 = new ArrayList<>(path);

        newTuple1.set(0, newTuple1.get(0) + num);
        path1.add('N');
        newTuple2.set(1, newTuple2.get(1) + num);
        path2.add('E');

        combos.put(newTuple1, path1);
        combos.put(newTuple2, path2);


        //if (tuple.get(0) > num) {
        List<Integer> newTuple3 = new ArrayList<>(tuple);
        newTuple3.set(0, newTuple3.get(0) - num);
        List<Character> path3 = new ArrayList<>(path);
        path3.add('S');
        combos.put(newTuple3, path3);
        //}

        //if (tuple.get(1) > num) {
        List<Integer> newTuple4 = new ArrayList<>(tuple);
        newTuple4.set(1, newTuple4.get(1) - num);
        List<Character> path4 = new ArrayList<>(path);
        path4.add('W');
        combos.put(newTuple4, path4);
        //}
      }
      // System.out.println("Combos = " + combos);
      // check for X and Y
      if (combos.containsKey(XY)) return combos.get(XY);
    }
    return null;
  }


  static String algo(int X, int Y) {
    /*
    boolean isXFlipped = false;
    boolean isYFlipped = false;
    if (X < 0) {X = -1 * X; isXFlipped = true; }
    if (Y < 0) {Y = -1 * Y; isYFlipped = true; }
    */
    Map<List<Integer>,List<Character>> combos = new HashMap<>();

    List<Integer> c1 = new ArrayList<>();
    c1.add(1); c1.add(0);
    List<Character> path1 = new ArrayList<>();
    path1.add('N');
    combos.put(c1, path1);
    
    List<Integer> c2 = new ArrayList<>();
    c2.add(0); c2.add(1);
    List<Character> path2 = new ArrayList<>();
    path2.add('E');
    combos.put(c2, path2);

    List<Integer> c3 = new ArrayList<>();
    c3.add(-1); c3.add(0);
    List<Character> path3 = new ArrayList<>();
    path3.add('S');
    combos.put(c3, path3);

    List<Integer> c4 = new ArrayList<>();
    c4.add(0); c4.add(-1);
    List<Character> path4 = new ArrayList<>();
    path4.add('W');
    combos.put(c4, path4);

    List<Character> path = getCombos(combos, 8, Y, X);

    if (path == null) {
      return "IMPOSSIBLE";
    }

    /*
    if (isXFlipped) {
      for (int i = 0; i < path.size(); i++) {
        if (path.get(i) == 'N') { path.set(i, 'S'); }
        if (path.get(i) == 'S') { path.set(i, 'N'); }
      }
    }
    if (isYFlipped) {
      for (int i = 0; i < path.size(); i++) {
        if (path.get(i) == 'E') { path.set(i, 'W'); }
        if (path.get(i) == 'W') { path.set(i, 'E'); }
      }
    }
    */

    String ans = "";
    for (int i = 0; i < path.size(); i++) {
      ans += path.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t = 0; t < T; t++) {
      int X = sc.nextInt();
      int Y = sc.nextInt();
      String ans = algo(X, Y);
      System.out.printf("Case #" + (t+1) + ": %s\n", ans);
    }
  }
}
