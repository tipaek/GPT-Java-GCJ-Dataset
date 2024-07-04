
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {


  private static void solve(int testCase) {
    out.printf("Case #%s: %s%n", testCase, solve());
    out.flush();
  }

  private static long solve() {

    // number of slices
    long numberOfSlices = in.nextLong(),
        // number of diners
        diners = in.nextLong();

    TreeMap<Long, Long> slices = new TreeMap<>();

    // Maak een lijst van alle slice groottes, met hoeveel je er NU van hebt
    for (Long i = 0L; i < numberOfSlices; i++) {
      Long size = in.nextLong();
      Long currentValue = 0L;
      if (slices.containsKey(size)) {
        currentValue = slices.get(size);
      }
      slices.put(size, currentValue + 1);
    }

    for (long multiplier = 1; multiplier < 5000; multiplier++) {
      // Order by amount available
      long finalMultiplier = multiplier;

      OptionalLong answer = slices.entrySet().stream()
          .map(entry -> cutsForSizeX(entry.getKey(), mapKeyTimesX(slices, finalMultiplier), diners))
          .filter(Optional::isPresent)
          .mapToLong(Optional::get)
          .min();

      if (answer.isPresent()) {
        return answer.getAsLong();
      }
    }

    return diners - 1;
  }

  private static TreeMap<Long, Long> mapKeyTimesX(TreeMap<Long, Long> originalMap, long x) {
    TreeMap<Long, Long> newMap = new TreeMap<>();
    for (Entry<Long, Long> originalEntry : originalMap.entrySet()) {
      newMap.put(originalEntry.getKey() * x, originalEntry.getValue());
    }
    return newMap;
  }

  private static Optional<Long> cutsForSizeX(long desiredSize, TreeMap<Long, Long> slices,
      final long desiredAmount) {
    List<Entry<Long, Long>> entriesInOrderOfImportance = slices.entrySet().stream()
        .sorted((o1, o2) -> {
          long size1 = o1.getKey(),
              size2 = o2.getKey();

          if (size1 == desiredSize) {
            return -1;
          }
          if (size2 == desiredSize) {
            return 1;
          }
          if (size1 % desiredSize == 0) {
            return -1;
          }
          if (size2 % desiredSize == 0) {
            return 1;
          }
          if (size1 > desiredSize) {
            return -1;
          }
          if (size2 > desiredSize) {
            return 1;
          }
          return 0;
        }).collect(Collectors.toList());

    long amountStillNeeded = desiredAmount;
    long cuts = 0L;

    for (Entry<Long, Long> entry : entriesInOrderOfImportance) {
      long thisSliceSize = entry.getKey();
      long thisSliceAmount = entry.getValue();

      // same size
      if (thisSliceSize == desiredSize) {
        amountStillNeeded -= thisSliceAmount;
      }

      // size multiple of desired size
      else if (thisSliceSize % desiredSize == 0) {
        long slicesFromThisSlice = thisSliceSize / desiredSize;

        while (thisSliceAmount > 0 && slicesFromThisSlice <= amountStillNeeded) {
          amountStillNeeded -= slicesFromThisSlice;
          cuts += slicesFromThisSlice - 1;
          thisSliceAmount--;
        }

        if (thisSliceAmount > 0) {
          cuts += amountStillNeeded;
          return Optional.of(cuts);
        }
      }

      // size other
      else {
        long amountWeCanCut = thisSliceSize / desiredSize;

        amountStillNeeded -= amountWeCanCut;
        cuts += amountWeCanCut;

        if (amountStillNeeded <= 0) {
          cuts += amountStillNeeded;
          return Optional.of(cuts);
        }
      }

      if (amountStillNeeded == 0) {
        return Optional.of(cuts);
      }
    }

    return Optional.empty();
  }

  // -----------

  public static void main(String[] args) {
    int testCount = in.nextInt();
    for (int testCase = 1; testCase <= testCount; testCase++) {
      solve(testCase);
    }
  }

  private static ScannerHelper in = new ScannerHelper(System.in);
  private static PrintStream out = System.out;
  private static PrintStream debug = System.err;

  static class ScannerHelper {

    private Scanner sc;

    static void override(String data) {
      System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    ScannerHelper(InputStream stream) {
      sc = new Scanner(stream);
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    BigInteger nextBigInteger() {
      return new BigInteger(next());
    }

    BigDecimal nextBigDecimal() {
      return new BigDecimal(next());
    }

    String next() {
      String word = sc.next();
      if (word != null && !word.isEmpty()) {
        return word;
      }

      sc.nextLine();
      return next();
    }

  }
}
