
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Solution {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
      int caseCount = Integer.parseInt(br.readLine());
      for (int testCase = 1; testCase <= caseCount; testCase++) {
        int mxSize = Integer.parseInt(br.readLine());
        int k = 0, r = 0, c = 0;
        BitSet[] rowBits = newBits(mxSize);
        BitSet[] colBits = newBits(mxSize);
        for (int row = 0; row < mxSize; row++) {
          String[] rowValues = br.readLine().split(" ");
          for (int col = 0; col < mxSize; col++) {
            int mxVal = Integer.parseInt(rowValues[col].trim());
            rowBits[row].set(mxVal);
            colBits[col].set(mxVal);
            if (col == row) {
              k += mxVal;
            }
          }
        }
        for (int i = 0; i < mxSize; i++) {
          for (int b = 1; b <= mxSize; b++) {
            if (!rowBits[i].get(b)) {
              r++;
              break;
            }
          }
          for (int b = 1; b <= mxSize; b++) {
            if (!colBits[i].get(b)) {
              c++;
              break;
            }
          }
        }
        System.out.println("Case #" + testCase + ": " + k + " " + r + " " + c);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static BitSet[] newBits(int size) {
    BitSet[] bs = new BitSet[size];
    for (int i = 0; i < size; i++) {
      bs[i] = new BitSet();
    }
    return bs;
  }

}
