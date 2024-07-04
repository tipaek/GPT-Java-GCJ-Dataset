import java.util.Scanner;

class Main {
  public int a;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int size;
    int temp = 0, r = 0, c = 0;
    size = sc.nextInt();
    int a[][] = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        a[i][j] = sc.nextInt();
      }
    }
    sc.close();
    // for(int i=0;i<size;i++)
    // {
    // for(int j=0;j<size;j++)
    // {
    // System.out.print(a[i][j]+"\t");
    // }
    // System.out.println();
    // }
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == j) {

          temp = temp + a[i][j];

        }
        if (j < 3 && r != size) {
          if (a[i][j] == a[i][j + 1]) {
            r = r + 1;
          }
        }
        if (i < 3 && c != size) {
          if (a[i][j] == a[i + 1][j]) {
            c = c + 1;
          }
        }
      }
    }
    System.out.println(temp + "\t" + r + "\t" + c);

  }
}
