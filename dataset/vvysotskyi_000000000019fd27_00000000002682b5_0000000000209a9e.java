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
    private final byte[] bits;

    private int queryNumber = 1;
    private int readPosition;

    public BitsReader(int bitsSize, Scanner s) {
      this.bitsSize = bitsSize;
      this.s = s;
      bits = new byte[bitsSize];
    }

    // reads bits from the beginning and from the end symmetrically
    public String obtainBits() {
      while (queryNumber <= 150) {
        if (queryNumber > 1 && queryNumber % 10 == 1) {
          transformBits();
        }
        bits[readPosition] = getBitAtPosition(s, readPosition);
        int oppositeReadPosition = bitsSize - readPosition - 1;
        if (queryNumber > 1 && queryNumber % 10 == 1) {
          TransformationKind transformationKind = transformBits();
          switch (transformationKind) {
            case COMPLEMENTED_AND_REVERSED:
            case REVERSED:
              oppositeReadPosition = readPosition;
          }
        }
        bits[oppositeReadPosition] = getBitAtPosition(s, oppositeReadPosition);
        readPosition++;
        if (queryNumber > 1 && queryNumber % 10 == 1) {
          transformBits();
        }

        if (readPosition >= bitsSize / 2) {
          StringBuilder stringBuilder = new StringBuilder();
          for (byte bit : bits) {
            stringBuilder.append(String.valueOf(bit));
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

    private TransformationKind transformBits() {
      TransformationKind transformationKind = discoverTransformationKind();

      switch (transformationKind) {
        case REVERSED: {
          // may be used readPosition here, but should be added additional logic
          // for handling case when single value from pair is read before transformation
          for (int i = 0; i < bits.length / 2; i++) {
            byte temp = bits[i];
            int endIndex = bitsSize - 1 - i;
            bits[i] = bits[endIndex];
            bits[endIndex] = temp;
          }
          break;
        }
        case COMPLEMENTED: {
          for (int i = 0; i < bits.length / 2; i++) {
            bits[i] = complement(bits[i]);
            bits[bitsSize - 1 - i] = complement(bits[bitsSize - 1 - i]);
          }
          break;
        }
        case COMPLEMENTED_AND_REVERSED: {
          for (int i = 0; i < bits.length / 2; i++) {
            byte temp = complement(bits[i]);
            int endIndex = bitsSize - 1 - i;
            bits[i] = complement(bits[endIndex]);
            bits[endIndex] = temp;
          }
          break;
        }
      }
      return transformationKind;
    }

    private byte complement(byte bit) {
      return (byte) (bit == 1 ? 0 : 1);
    }

    private TransformationKind discoverTransformationKind() {
      int positionWithSymmetricBits = -1;
      int positionWithDiffBits = -1;

      for (int i = 0; i < readPosition; i++) {
        if (bits[i] == bits[bits.length - 1 - i]) {
          positionWithSymmetricBits = i;
        } else {
          positionWithDiffBits = i;
        }

        if (positionWithSymmetricBits >= 0 && positionWithDiffBits >= 0) {
          break;
        }
      }

      if (positionWithSymmetricBits >= 0) {
        byte newSymmetricBit = getBitAtPosition(s, positionWithSymmetricBits);

        if (bits[positionWithSymmetricBits] == newSymmetricBit) {
          // only reverse transformation possible in this case, ensure whether it happened
          if (positionWithDiffBits >= 0) {
            byte newAsymmetricBit = getBitAtPosition(s, positionWithDiffBits);
            if (bits[positionWithDiffBits] != newAsymmetricBit) {
              // only reverse transformation happened, transform bits
              return TransformationKind.REVERSED;
            }
          }
          return TransformationKind.NONE;
        } else {
          // bits complemented, check for reverse transformation
          if (positionWithDiffBits >= 0) {
            byte newAsymmetricBit = getBitAtPosition(s, positionWithDiffBits);
            if (bits[positionWithDiffBits] == newAsymmetricBit) {
              return TransformationKind.COMPLEMENTED_AND_REVERSED;
            }
          }
          return TransformationKind.COMPLEMENTED;
        }
      } else {
        if (positionWithDiffBits >= 0) {
          byte newAsymmetricBit = getBitAtPosition(s, positionWithDiffBits);

          if (bits[positionWithDiffBits] != newAsymmetricBit) {
            // bits complemented or reversed only, but all asymmetric, so transformation result is equivalent
            return TransformationKind.COMPLEMENTED;
          }
          // all bits are asymmetric, so nothing was changed
          return TransformationKind.NONE;
        }
      }
      return TransformationKind.NONE;
    }
  }
}