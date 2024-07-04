class Solution{
  public int[] latins(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;
    int diagSum = 0;
    int rowDup = 0;
    int colDup = 0;
    Set<Integer>[] rowSet = new HashSet[row];
    Set<Integer>[] colSet = new HashSet[col];
    Arrays.fill(rowSet, new HashSet<>());
    Arrays.fill(colSet, new HashSet<>());

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == j) diagSum += mat[i][j];
        rowSet[i].add(mat[i][j]);
        colSet[j].add(mat[i][j]);
      }
    }

    for (int i = 0; i < row; i++) {
      if(rowSet[i].size() < row) rowDup++;
    }
    for (int i = 0; i < col; i++) {
      if (colSet[i].size() < row) colDup++;
    }
    return new int[]{diagSum, rowDup, colDup};
  }
}