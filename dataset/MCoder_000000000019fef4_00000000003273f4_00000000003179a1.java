import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution
{
  private static int t;
  private static int task;
  private static Scanner in;

  public static void main(String[] args) throws Exception
  {
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
    for (int i = 1; i <= t; ++i)
    {
      task = i;
      solve();
    }
  }

  private static void solve()
  {
    int u = in.nextInt();
    long[] q = new long[10000];
    String[] r = new String[10000];
    Set<Character> cs = new HashSet<>();
    for (int i = 0; i < 10000; i++)
    {
      q[i] = in.nextLong();
      r[i] = in.next();
      List<Character> listC = new ArrayList<Character>();
      for (char c : r[i].toCharArray())
      {
        listC.add(c);
      }

      cs.addAll(listC);
    }
    HashMap<Character, Integer> cimap = new HashMap<>();
    for (Character c : cs)
    {
      cimap.put(c, Integer.MAX_VALUE);
    }

    // List<Character> cl = new ArrayList<>(cs);
    // int[] ci = new int[cl.size()];
    for (int i = 0; i < 10000; i++)
    {
      String ints = String.valueOf(q[i]);
      char[] intc = ints.toCharArray();
      if (ints.length() == r[i].length())
      {
        char[] rc = r[i].toCharArray();
        for (int j = 0; j <= 0; j++)
        {
          Integer intmin = cimap.get(rc[j]);
          Integer ci = Character.getNumericValue(intc[j]);
          if (intmin > ci)
          {
            cimap.put((rc[j]), ci);
          }
        }
      }
    }

    Stream<Map.Entry<Character, Integer>> sorted = cimap.entrySet().stream().sorted(Map.Entry.comparingByValue());
    List<Entry<Character, Integer>> collect = sorted.collect(Collectors.toList());
    String res = "";
    res += collect.get(collect.size() - 1).getKey();// 0
    for (int i = 0; i < collect.size() - 1; i++)
    {
      res += collect.get(i).getKey();
    }

    // List<List<Integer>> out = new ArrayList<>();
    // out = permutations(new ArrayList(cs), cs.size());
    // for (List<Integer> list : out)
    // {
    //
    // }

    System.out.println("Case #" + task + ": " + res);
  }

  // static long convertNumber(String num, List<Integer> list)
  // {
  //
  //
  // }

  // // simple permutation: order: yes, repetition: no
  // static void permutations(List<Object> al, int size, List<Object> out, List<List<Object>> result)
  // {
  // if (out.size() == size)
  // {
  // result.add(out);
  // return;
  // }
  //
  // for (int i = 0; i < al.size(); i++)
  // {
  // ArrayList<Object> aln = new ArrayList<>(al);
  // ArrayList<Object> outn = new ArrayList<>(out);
  // outn.add(aln.remove(i));
  // permutations(aln, size, outn, result);
  // }
  // }
  //
  // static List<List<Object>> permutations(List<Object> al, int size)
  // {
  // ArrayList<List<Object>> result = new ArrayList<>();
  // permutations(al, size, new ArrayList<Object>(), result);
  // return result;
  // }

}