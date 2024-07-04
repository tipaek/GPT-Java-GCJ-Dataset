import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//import java.io.File;

public class Solution{

  public static void sortbyColumn(int arr[][],int col) {


    Arrays.sort(arr,new Comparator<int[]>() {

      @Override
      public int compare(int[] o1, int[] o2) {


        // To sort in descending order revert
        // the '>' Operator
        if(o1[col]>o2[col])
          return 1;
        else
          return -1;

      }});
  }





  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t1 = Integer.parseInt(br.readLine());

//    char j='J';
//    char c='C';
    for (int t = 0; t < t1; ++t) {
      StringBuilder answer = new StringBuilder();
      int n = Integer.parseInt(br.readLine().trim());
      int arr [][]=new int[n][3];
      for(int i=0;i<n;++i)
      {
        String s[] = br.readLine().trim().split(" ");
       arr[i][0] = Integer.parseInt(s[0]);
        arr[i][1] = Integer.parseInt(s[1]);
        arr[i][2]=i;
          answer.append('R');

      }
      sortbyColumn(arr,0);

//      for (int i = 0; i < n; ++i) {
//        System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
//      }
      ArrayList<Integer> sj = new ArrayList<>();
      ArrayList<Integer> ej = new ArrayList<>();
      ArrayList<Integer> sc = new ArrayList<>();
      ArrayList<Integer> ec = new ArrayList<>();
      sj.add(arr[0][0]);
      ej.add(arr[0][1]);
      sc.add(arr[1][0]);
      ec.add(arr[1][1]);
      answer.replace(arr[0][2],arr[0][2]+1,"J");
      answer.replace(arr[1][2],arr[1][2]+1,"C");

      int jn = 1;
      int cn = 1;
      int a, b;
      int breaks = 0;
      String kk="";
      for (int i = 2; i < n; ++i) {
        a=arr[i][0];
        b=arr[i][1];
        int flagj = 0;
        int flagc = 0;
        for (int j = 0; j < jn; ++j) {
          if (!((a < sj.get(j) && b <= sj.get(j)) || (a >= ej.get(j) && b > ej.get(j)))) {
            flagj = 1;
            break;
          }
        }
        for (int j = 0; j < cn; ++j) {
          if (!((a < sc.get(j) && b <= sc.get(j)) || (a >= ec.get(j) && b > ec.get(j)))) {
            flagc = 1;
            break;
          }
        }
        if (flagj == 0) {
          answer.replace(arr[i][2],arr[i][2]+1,"J");
          sj.add(a);
          ej.add(b);
          ++jn;
        } else if (flagc == 0) {
          answer.replace(arr[i][2],arr[i][2]+1,"C");
          sc.add(a);
          ec.add(b);
          ++cn;
        } else {
          //System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
          kk="IMPOSSIBLE";
          breaks = 1;
        }

      }
      if (breaks == 0) {
        System.out.println("Case #" + (t + 1) + ": " + answer);
      } else {
        System.out.println("Case #" + (t + 1) + ": "+kk);
      }
    }


  }
}