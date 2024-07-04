import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{

  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    int cases = s.nextInt();
    for (int q = 0; q < cases; q++)
    {
      int n = s.nextInt();
      int[] starts = new int[n];
      int[] ends = new int[n];
      String answer = "";
      int c = 0;
      for (int i = 0; i < n; i++)
      {
        starts[i] = s.nextInt();
        ends[c] = s.nextInt();
        c++;
      }
      ArrayList<Item> times = new ArrayList<>();
      // add starting nums to arraylist
      for (int i = 0; i < n; i++)
      {
        times.add(new Item(starts[i], i, true));
      }
      // add ending nums to arraylist
      for (int i = 0; i < n; i++)
      {
        times.add(new Item(ends[i], i, false));
      }
      sortItems(times);

      boolean cTaken = true;
      boolean jTaken = true;
      boolean[] worker = new boolean[times.size()];
      for (int i = 0; i < times.size(); i++)
      {

        if (times.get(i).getStart())
        {
          if (cTaken)
          {
            worker[times.get(i).getIndex()] = true;// check this
            answer += "C";
            cTaken = false;
          }
          else if (jTaken) // might have to do else
          {
            worker[times.get(i).getIndex()] = false;// check
            answer += "J";
            jTaken = false;
          }
          else
          {
            answer = "IMPOSSIBLE";
          }
        }
        else
        {
          if (worker[times.get(i).getIndex()])
          {
            cTaken = true;
          }
          else
          {
            jTaken = true;
          }

        }

      }
      System.out.println(answer);
    }
  }

  public static ArrayList<Item> sortItems(ArrayList<Item> items)
  {
    int n = items.size();

    for (int i = 0; i < n; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        if (items.get(i).getTime() > items.get(j).getTime())
        {
          Item temp = items.get(i);
          items.set(i, items.get(j));
          items.set(j, temp);
        }
      }
    }

    for (int i = 0; i < n; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        if (items.get(i).getTime() == items.get(j).getTime())
        {
          if (items.get(i).getStart())
          {
            Item temp = items.get(i);
            items.set(i, items.get(j));
            items.set(j, temp);
          }

        }
      }
    }

    return items;
  }

}

class Item
{
  private int time;
  private int index;
  private boolean start;

  public Item(int time, int index, boolean start)
  {
    this.time = time;
    this.index = index;
    this.start = start;
  }

  public int getTime()
  {
    return time;
  }

  public int getIndex()
  {
    return index;
  }

  public boolean getStart()
  {
    return start;
  }

}