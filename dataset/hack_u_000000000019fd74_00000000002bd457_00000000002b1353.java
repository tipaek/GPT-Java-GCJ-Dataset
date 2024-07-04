import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  static class Pair<K,V> {

    /**
     * Key of this <code>Pair</code>.
     */
    private K key;

    /**
     * Gets the key for this pair.
     * @return key for this pair
     */
    public K getKey() { return key; }

    /**
     * Value of this this <code>Pair</code>.
     */
    private V value;

    /**
     * Gets the value for this pair.
     * @return value for this pair
     */
    public V getValue() { return value; }

    /**
     * Creates a new pair
     * @param key The key for this pair
     * @param value The value to use for this pair
     */
    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

    /**
     * <p><code>String</code> representation of this
     * <code>Pair</code>.</p>
     *
     * <p>The default name/value delimiter '=' is always used.</p>
     *
     *  @return <code>String</code> representation of this <code>Pair</code>
     */
    @Override
    public String toString() {
      return key + "=" + value;
    }

    /**
     * <p>Generate a hash code for this <code>Pair</code>.</p>
     *
     * <p>The hash code is calculated using both the name and
     * the value of the <code>Pair</code>.</p>
     *
     * @return hash code for this <code>Pair</code>
     */
    @Override
    public int hashCode() {
      // name's hashCode is multiplied by an arbitrary prime number (13)
      // in order to make sure there is a difference in the hashCode between
      // these two parameters:
      //  name: a  value: aa
      //  name: aa value: a
      return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }

    /**
     * <p>Test this <code>Pair</code> for equality with another
     * <code>Object</code>.</p>
     *
     * <p>If the <code>Object</code> to be tested is not a
     * <code>Pair</code> or is <code>null</code>, then this method
     * returns <code>false</code>.</p>
     *
     * <p>Two <code>Pair</code>s are considered equal if and only if
     * both the names and values are equal.</p>
     *
     * @param o the <code>Object</code> to test for
     * equality with this <code>Pair</code>
     * @return <code>true</code> if the given <code>Object</code> is
     * equal to this <code>Pair</code> else <code>false</code>
     */
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o instanceof Pair) {
        Pair pair = (Pair) o;
        if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
        if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
        return true;
      }
      return false;
    }
  }

  private static Scanner scanner;

  static long nCr(int n, int r)
  {
    return fact(n-1) / (fact(r-1) *
        fact(n - r));
  }

  // Returns factorial of n
  static long fact(int n)
  {
    int res = 1;
    for (int i = 2; i <= n; i++)
      res = res * i;
    return res;
  }


  private static void process(int tid) {
    int n = Integer.parseInt(scanner.nextLine());
    Set<Pair<Integer, Integer>> vis = new HashSet<>();
    Pair<Integer, Integer> c = new Pair<>(1, 1);
    List<Pair<Integer, Integer>> pth = new ArrayList<>();
    vis.add(c);
    dfs(n, vis, c, pth);
    System.out.printf("Case #%d: %d\n", tid, pth.size());
    StringBuilder sb = new StringBuilder();
    for(Pair<Integer, Integer> p : pth) {
      sb.append(p.getKey());
      sb.append(' ');
      sb.append(p.getValue());
      sb.append('\n');
    }
    System.out.print(sb.toString());
  }

  private static boolean isvalid(Pair<Integer, Integer> p) {
    return p.getKey() > 0 && p.getValue() > 0 && p.getKey() >= p.getValue();
  }

  private static boolean dfs(int n, Set<Pair<Integer, Integer>> vis, Pair<Integer, Integer> c,
      List<Pair<Integer, Integer>> pth) {
    long v = nCr(c.getKey(), c.getValue());
    if(v > n) return false;
    if(v == n) {
      pth.add(c);
      return true;
    }

    n -= v;
    pth.add(c);
    Pair<Integer, Integer> np = new Pair<>(c.getKey()-1, c.getValue()-1);
    if(isvalid(np) && !vis.contains(np)) {
      vis.add(np);
      if(dfs(n, vis, np, pth)) return true;
      vis.remove(np);
    }

    np = new Pair<>(c.getKey()-1, c.getValue());
    if(isvalid(np) && !vis.contains(np)) {
      vis.add(np);
      if(dfs(n, vis, np, pth)) return true;
      vis.remove(np);
    }

    np = new Pair<>(c.getKey(), c.getValue()-1);
    if(isvalid(np) && !vis.contains(np)) {
      vis.add(np);
      if(dfs(n, vis, np, pth)) return true;
      vis.remove(np);
    }

    np = new Pair<>(c.getKey(), c.getValue()+1);
    if(isvalid(np) && !vis.contains(np)) {
      vis.add(np);
      if(dfs(n, vis, np, pth)) return true;
      vis.remove(np);
    }

    np = new Pair<>(c.getKey()+1, c.getValue());
    if(isvalid(np) && !vis.contains(np)) {
      vis.add(np);
      if(dfs(n, vis, np, pth)) return true;
      vis.remove(np);
    }

    np = new Pair<>(c.getKey()+1, c.getValue()+1);
    if(isvalid(np) && !vis.contains(np)) {
      vis.add(np);
      if(dfs(n, vis, np, pth)) return true;
      vis.remove(np);
    }

    pth.remove(pth.size()-1);
    return false;
  }

  public static void main(String[] args) {
    scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(scanner.nextLine());
    for(int i=1; i<=t; i++) {
      process(i);
    }
  }

}
