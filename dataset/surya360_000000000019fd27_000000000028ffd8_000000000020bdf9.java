import java.util.*;
import java.io.*;
public class Solution {
  private static Scanner sc;
  static int tn = 1;
  public static void main(String[] args) {
    sc = new Scanner(System.in);

    int t = sc.nextInt();
    sc.nextLine();

    while(t-- > 0){

      compute();
    }
  }
  private static void compute(){
    int n = sc.nextInt();

    int[][] mat = new int[n][2];
    int[][] matSorted = mat.clone();

    StringBuilder sb = new StringBuilder();
    char person = 'J';

    char[] chars = new char[n];

    Stack<int[]> JStack = new Stack<>();
    Stack<int[]> CStack = new Stack<>();

    boolean impossible = false;


    Map<int[], Integer> map = new HashMap<>();




    for (int i=0; i < mat.length ; i++ ) {
      for (int j = 0; j < mat[i].length ; j++) {

        mat[i][j] = sc.nextInt();
        
      }
      map.put(mat[i], i);
      
    }

    Arrays.sort(matSorted, new Comparator<int[]>(){
      public int compare(int[] a, int[] b){
        return a[0] - b[0];
      }
    });

    for (int i = 0 ; i < matSorted.length ; i++ ) {
      chars[map.get(matSorted[i])] = person;
      if (i < matSorted.length -1 && overlap(matSorted[i], matSorted[i+1])) {
        if (person == 'J') {
          JStack.push(matSorted[i]);
          person = getPerson(person);

          if (!CStack.isEmpty() && overlap(CStack.peek(), matSorted[i+1])) {
            impossible = true;
            break;
          }
        }
        else{
          CStack.push(matSorted[i]);
          person = getPerson(person);

          if (!JStack.isEmpty() && overlap(JStack.peek(), matSorted[i+1])) {
            impossible = true;
            break;
          }
        }
      }
        else{

          if (person == 'J') {
            JStack.push(matSorted[i]);
          }
          else {
            CStack.push(matSorted[i]);
          }
        }

    }

    System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));

  }

  private static char getPerson(char P){
    return P == 'J' ? 'C' : 'J';
  }

  private static boolean overlap(int[] a, int[] b){

    return a[1] > b[0];
  }
}
