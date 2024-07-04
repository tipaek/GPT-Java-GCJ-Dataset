import java.util.*;

public class Solution{

  int n;
  Event[] arr;

  public Solution(int n, Scanner sc){
    arr = new Event[n];
    this.n = n;
    for (int i = 0; i < n; i ++){
      Event e = new Event();
      e.starttime = sc.nextInt();
      e.endtime = sc.nextInt();
      e.order = i;
      e.used = false;
      e.usedBy = 'a';
      arr[i] = e;
    }
    Arrays.sort(arr,(Event o1, Event o2)->o1.endtime-o2.endtime);
  }

  public String calculate(){
    int count = 0;
    int position = 0;
    int currenttime = 0;
    while (position < n){
      if (arr[position].starttime < currenttime){
        position ++;
      }else{
        count ++;
        arr[position].used = true;
        arr[position].usedBy = 'C';
        currenttime = arr[position].endtime;
        position ++;
      }
    }
    position = 0;
    currenttime = 0;
    while (position < n){
      if (arr[position].used || arr[position].starttime < currenttime){
        position ++;
      }else{
        count ++;
        arr[position].usedBy = 'J';
        currenttime = arr[position].endtime;
        position ++;
      }
    }
    if (count < n) return "IMPOSSIBLE";
    char[] a = new char[n];
    for (int i = 0; i < n; i ++){
      a[arr[i].order] = arr[i].usedBy;
    }
    StringBuffer s = new StringBuffer("");
    for (int i = 0; i < n; i ++){
      s.append(a[i]);
    }
    return s.toString();
  }

  public static void main(String args[]){
    Scanner sc1 = new Scanner(System.in);
    int cases = sc1.nextInt();
    for (int c = 1; c < cases+1; c ++){
      int numEvents = sc1.nextInt();
      Solution b = new Solution(numEvents,sc1);
      System.out.println("Case #" + c + ": " + b.calculate());
    }
  }
}

class Event{
  int starttime;
  int endtime;
  int order;
  boolean used;
  char usedBy;
}
