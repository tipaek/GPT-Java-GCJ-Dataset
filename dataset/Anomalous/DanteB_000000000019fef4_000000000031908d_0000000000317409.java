import java.util.*;
import java.io.*;

public class Solution {
  
  static InputReader inputReader = new InputReader(System.in);
  static PrintWriter outputWriter = new PrintWriter(System.out);

  public static void main(String[] args) {
    int testCases = inputReader.nextInt();
    testLoop: for (int testCase = 1; testCase <= testCases; ++testCase) {
      int x = inputReader.nextInt();
      int y = inputReader.nextInt();
      char[] directions = inputReader.next().toCharArray();
      
      for (int i = 0; i < directions.length; i++) {
        switch (directions[i]) {
          case 'N':
            y++;
            break;
          case 'S':
            y--;
            break;
          case 'E':
            x++;
            break;
          case 'W':
            x--;
            break;
          default:
            break;
        }
        
        if (i + 1 >= Math.abs(x) + Math.abs(y)) {
          outputWriter.printf("Case #%d: %d\n", testCase, i + 1);
          continue testLoop;
        }
      }
      outputWriter.printf("Case #%d: IMPOSSIBLE\n", testCase);
    }
    closeResources();
  }

  public static void closeResources() {
    outputWriter.close();
    inputReader.close();
    System.exit(0);
  }

  static class InputReader implements Iterator<String>, Closeable {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private String currentToken;

    public InputReader(InputStream inputStream) {
      reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public boolean hasNext() {
      return peekNextToken() != null;
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public String next() {
      String token = peekNextToken();
      currentToken = null;
      return token;
    }

    public String nextLine() {
      peekNextToken();
      String line = tokenizer == null ? "" : tokenizer.nextToken("\n");
      currentToken = null;
      tokenizer = null;
      return line;
    }

    public void close() {
      try {
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    private String peekNextToken() {
      if (currentToken == null) {
        try {
          while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = reader.readLine();
            if (line == null) {
              return null;
            }
            tokenizer = new StringTokenizer(line);
          }
          currentToken = tokenizer.nextToken();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return currentToken;
    }
  }
}