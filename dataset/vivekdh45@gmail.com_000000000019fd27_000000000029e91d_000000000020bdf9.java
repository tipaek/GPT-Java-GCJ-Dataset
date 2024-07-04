import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i1 = 0; i1 < t; i1++) {
      Map<Integer,ArrayList<Integer>> map = new LinkedHashMap<>();
      List<Pair<Integer,Integer>> vals = new ArrayList<>();
      int n = Integer.parseInt(br.readLine());
      char[] ans = new char[n];
      for(int i=0;i<n;i++) {
        String[] val = br.readLine().split(" ");
        int st = Integer.parseInt(val[0]);
        int et = Integer.parseInt(val[1]);
        if(map.containsKey(st)) {
          map.get(st).add(i);
        }
        else {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(i);
          map.put(st,list);
        }
        Pair<Integer,Integer> pair = new Pair<>(st,et);
        vals.add(pair);
      }
      vals.sort((p,q) -> p.getKey().compareTo(q.getKey()));
      int j = 0;
      int c = 0;
      boolean skip = true;
      for(int i = 0; i< vals.size(); i++) {
        int st = vals.get(i).getKey();
        int et = vals.get(i).getValue();
        if(st>=j) {
          int index = map.get(st).get(0);
          map.get(st).remove(0);
          ans[index] = 'J';
          j = et;
        }
        else if(st>=c) {
          int index = map.get(st).get(0);
          map.get(st).remove(0);
          ans[index] = 'C';
          c = et;
        }
        else {
          System.out.println("Case #" + (i1 + 1) + ": " + "IMPOSSIBLE");
          skip = false;
          break;
        }
      }
      if(skip) {
        String realAns = String.valueOf(ans);
        System.out.println("Case #" + (i1 + 1) + ": "+ realAns);
      }
    }
  }
}


class Pair<K, V> {
  private K key;
  private V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pair other = (Pair) obj;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
}
