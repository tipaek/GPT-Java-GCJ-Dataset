import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static class Entry implements Comparable<Entry> {
        int start;
        int end;

        Entry(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Entry other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            StringBuilder currentResult = new StringBuilder();
            String currentChar = "C";
            int numEntries = scanner.nextInt();
            PriorityQueue<Entry> entries = new PriorityQueue<>();

            for (int i = 0; i < numEntries; i++) {
                entries.add(new Entry(scanner.nextInt(), scanner.nextInt()));
            }

            Entry firstEntry = entries.poll();
            int currentStart = firstEntry.start;
            int currentEnd = firstEntry.end;
            currentResult.append(currentChar);

            for (int i = 1; i < numEntries; i++) {
                Entry nextEntry = entries.poll();

                if (nextEntry.start >= currentEnd) {
                    currentStart = nextEntry.start;
                    currentEnd = nextEntry.end;
                    currentResult.append(currentChar);
                } else if (!entries.isEmpty()) {
                    if (nextEntry.end < currentEnd) {
                        Entry peekEntry = entries.peek();
                        if (peekEntry.start < nextEntry.end) {
                            currentResult.setLength(0);
                            currentResult.append("IMPOSSIBLE");
                            break;
                        } else {
                            currentChar = toggleChar(currentChar);
                            currentStart = nextEntry.end;
                            currentResult.append(currentChar);
                            currentChar = toggleChar(currentChar);
                        }
                    } else {
                        Entry peekEntry = entries.peek();
                        if (peekEntry.start < currentEnd) {
                            currentResult.setLength(0);
                            currentResult.append("IMPOSSIBLE");
                            break;
                        } else {
                            currentChar = toggleChar(currentChar);
                            currentStart = nextEntry.start;
                            currentEnd = nextEntry.end;
                            currentResult.append(currentChar);
                        }
                    }
                } else {
                    currentChar = toggleChar(currentChar);
                    currentResult.append(currentChar);
                    break;
                }
            }

            resultBuilder.append(currentResult).append("\n");
        }

        System.out.println(resultBuilder);
    }

    private static String toggleChar(String currentChar) {
        return currentChar.equals("C") ? "J" : "C";
    }
}