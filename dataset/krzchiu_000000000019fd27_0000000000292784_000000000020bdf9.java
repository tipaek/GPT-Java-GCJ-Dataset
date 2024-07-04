import java.util.*;
public class Solution{ 
  public static void main(String[] args)             {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for(int qq = 0; qq < N; qq++){
      int n = sc.nextInt();
      ArrayList<int[]> arr = new ArrayList();
      for(int i = 0; i < n;i++) arr.add(new int[]{sc.nextInt(),sc.nextInt(),i});
      arr.sort((int[] o1, int[] o2) -> (o1[0]-o2[0]!=0?o1[0]-o2[0]:o1[1]-o2[1]));
      int c = 0, j = 0;
      //StringBuilder sb = new StringBuilder();
      char[] ch = new char[n];
      for(int i = 0; i < n; i++) {
      	if(c <= arr.get(i)[0]) {
      		c = arr.get(i)[1];
      		//sb.append("C");
      		ch[arr.get(i)[2]]='C';
      	} else if(j <= arr.get(i)[0]){
      		j = arr.get(i)[1];
      		//sb.append("J");
      		ch[arr.get(i)[2]]='J';
      	} else {
      		//sb = new StringBuilder("IMPOSSIBLE");
      		ch = null;
      		break;
      	}
      }
      //for(int[] a : arr) System.out.println(a[0]+" "+a[1]);
      System.out.println("Case #"+qq+": "+(ch != null ? new String(ch) : "IMPOSSIBLE"));

	  }
	}
}