import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int testCasesCount = s.nextInt();
    int bitsSize = s.nextInt();

    for (int i = 0; i < testCasesCount; i++) {
      System.out.println(new BitsReader(bitsSize, s).obtainBits());
      if ("N".equals(s.next())) {
        // incorrect bits were returned
        break;
      }
    }
  }

  public enum TransformationKind {
    COMPLEMENTED,
    REVERSED,
    COMPLEMENTED_AND_REVERSED,
    NONE
  }

  public static class BitsReader {
    private final int bitsSize;
    private final Scanner s;

    private int queryNumber;
    private int readPosition;

    public BitsReader(int bitsSize, Scanner s) {
      this.bitsSize = bitsSize;
      this.s = s;
    }

    public String obtainBits() {
      byte[] bits = new byte[bitsSize];

      while (queryNumber < 149) {
        if (queryNumber % 10 == 1) {
          transformBits(bits);
        }
        bits[readPosition] = getBitAtPosition(s, readPosition);
        int oppositeReadPosition = bitsSize - readPosition - 1;
        bits[oppositeReadPosition] = getBitAtPosition(s, oppositeReadPosition);

        readPosition++;
        if (readPosition >= bitsSize / 2) {
          StringBuilder stringBuilder = new StringBuilder();
          for (byte bit : bits) {
            stringBuilder.append(bit);
          }
          return stringBuilder.toString();
        }
      }
      // cannot read bits of provided length using 150 attempts
      return null;
    }

    private byte getBitAtPosition(Scanner s, int position) {
      System.out.println(position + 1);
      queryNumber++;
      return s.nextByte();
    }

    private void transformBits(byte[] bits) {
      TransformationKind transformationKind = findTransformationKind(bits);

      switch (transformationKind) {
        case REVERSED: {
          for (int i = 0; i < readPosition; i++) {
            byte temp = bits[i];
            int endIndex = bitsSize - 1 - i;
            bits[i] = bits[endIndex];
            bits[endIndex] = temp;
          }
          break;
        }
        case COMPLEMENTED: {
          for (int i = 0; i < readPosition; i++) {
            bits[i] = (byte) ~bits[i];
            bits[bitsSize - 1 - i] = (byte) ~bits[bitsSize - 1 - i];
          }
          break;
        }
        case COMPLEMENTED_AND_REVERSED: {
          for (int i = 0; i < readPosition; i++) {
            byte temp = (byte) ~bits[i];
            int endIndex = bitsSize - 1 - i;
            bits[i] = (byte) ~bits[endIndex];
            bits[endIndex] = temp;
          }
          break;
        }
      }
    }

    private TransformationKind findTransformationKind(byte[] bits) {
      int positionWithSymmetricBits = -1;
      int positionWithDiffBits = -1;

      for (int i = 0; i < readPosition; i++) {
        if (bits[i] == bits[bits.length - 1 - i]) {
          positionWithSymmetricBits = i;
        } else {
          positionWithDiffBits = i;
        }

        if (positionWithSymmetricBits > 0 && positionWithDiffBits > 0) {
          break;
        }
      }

      if (positionWithSymmetricBits > 0) {
        byte newSymmetricBit = getBitAtPosition(s, positionWithSymmetricBits);

        if (bits[positionWithSymmetricBits] == newSymmetricBit) {
          // only reverse transformation possible in this case, ensure whether it happened
          if (positionWithDiffBits > 0) {
            byte newAsymmetricBit = getBitAtPosition(s, positionWithDiffBits);
            if (bits[positionWithDiffBits] != newAsymmetricBit) {
              // only reverse transformation happened, transform bits
              return TransformationKind.REVERSED;
            }
          }
        } else {
          // bits complemented, check for reverse transformation
          if (positionWithDiffBits > 0) {
            byte newAsymmetricBit = getBitAtPosition(s, positionWithDiffBits);

            if (bits[positionWithDiffBits] != newAsymmetricBit) {
              // bits complemented only
              return TransformationKind.COMPLEMENTED;
            } else {
              return TransformationKind.COMPLEMENTED_AND_REVERSED;
            }
          }
        }
      } else {
        if (positionWithDiffBits > 0) {
          byte newAsymmetricBit = getBitAtPosition(s, positionWithDiffBits);

          if (bits[positionWithDiffBits] != newAsymmetricBit) {
            // bits complemented or reversed only, but all asymmetric, so transformations are the same
            return TransformationKind.COMPLEMENTED;
          } else {
            // all bits are asymmetric, so weren't changed
            return TransformationKind.NONE;
          }
        }
      }
      throw new UnsupportedOperationException("Illegal bits provided");
    }
  }
}