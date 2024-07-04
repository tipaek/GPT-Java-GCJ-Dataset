import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] arr = new String[t];
    for(int w = 0;w<t;w++) {
    	int x = in.nextInt();
    	int y = in.nextInt();
    	String path = in.next()+1;
    	int n = path.length();
    	Map<Integer,List<Integer>> map = new HashMap<>();
    	List<Integer> list = new ArrayList<>();
    	list.add(x); 	list.add(y);
    	map.put(0,list);
    	for(int i = 0;i<path.length();i++) {
    	  List<Integer> temp = new ArrayList<>();
    	  if(path.charAt(i)=='N')
            y++;
    	  if(path.charAt(i)=='S')
            y--;
    	  if(path.charAt(i)=='E')
            x++;
    	  if(path.charAt(i)=='W')
            x--;
          temp.add(x); temp.add(y);
          
          map.put(i+1,temp);
    	}
    	int min = Integer.MAX_VALUE;
    	for(int i = 0;i<n;i++) {
    	  x = 0; y = 0;
          int a = map.get(i).get(0);
          int b = map.get(i).get(1);
    	  if(Math.abs(a)+Math.abs(b)<=i) {
    	    min = Math.min(min,Math.max(i, a+b));
    	  }
    	}
    	if(min != Integer.MAX_VALUE)
          arr[w] = "Case #"+(w+1)+": "+min;
    	else
          arr[w] = "Case #"+(w+1)+": IMPOSSIBLE";
    }
    in.close();
    for(String s:arr)
    	System.out.println(s);
  }
}