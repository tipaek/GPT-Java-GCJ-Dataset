public class TraceMatrix {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      int arr[][] = new int[n][n];
      int rowCount = 0;
      int colCount = 0;
      for (int row = 0; row < n * n; row++) {
        String s = scanner.next();
        if (s.isEmpty()) {
            continue;
        }
        arr[rowCount][colCount] = Integer.parseInt(s);
        colCount += 1;
        if (colCount >= n) {
          rowCount += 1;
          colCount = 0;
        }
      }
       
    }
  }
}
