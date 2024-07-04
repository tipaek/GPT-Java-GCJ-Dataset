import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {



  public static void main(String[] args) throws InterruptedException {
  Scanner  IN =  new Scanner(System.in);
    int t = getInt(IN);
    int b = getInt(IN);
    for (int a = 1; a <= t; ++a) {
      String reply = new ArraySolver(a, b, IN).findArray();
      System.out.println(reply);
      System.out.flush();
      if (isCancel(getInput(IN))) {
        System.err.println("CANCELED");
        return;
      }else{
        System.err.println("DONE!");
      }
    }
  }

  private static int getInt(Scanner IN) throws InterruptedException {
    return IN.nextInt();
  }

  private static boolean isCancel(String input) {
    return input.equals("N");
  }
  private static String getInput(Scanner IN) throws InterruptedException {
    return IN.next();
  }

}

class ArraySolver {

  static Scanner in;
  int id;
  int size;
  int qcount;

  boolean changeHappened;

  int maxQuery = 150;

  List<EqualPair> eps = new ArrayList<>();
  List<UnEqualPair> ups = new ArrayList<>();
  List<FixPoint> fps = new ArrayList<>();

  public ArraySolver(int a, int b, Scanner in) {
    this.in = in;
    this.id = a;
    this.size = b;
  }

  public String findArray() {

      for (int j = 0; j < (size+1)/2 && qcount<maxQuery; j++) {
        findPair(j);
      }

      return createResult();

  }

  private String createResult() {
    String[] result = new String[size];
    eps.forEach(it -> {
      result[it.x] = it.getStringValue();
      result[it.y] = it.getStringValue();
    } );
    ups.forEach(it -> {
      result[it.x] = it.getStringX();
      result[it.y] = it.getStringY();
    } );
    fps.forEach(it -> result[it.x]=it.getStringValue());

    return Arrays.stream(result).collect(Collectors.joining());
  }

  private void findPair(int x) {
    int y = (size-1) - x;
    boolean by;
    boolean bx;

    bx = queryForValue(x);

    if (y == x) {
      fps.add(new FixPoint(x, bx));
    }
    if(qcount % 10 == 0 ){
      checkChange();
      findPair(x);
      return;
    }

    by = queryForValue(y);

    if(by==bx){
      eps.add(new EqualPair(x,y,bx));
    }else{
      ups.add(new UnEqualPair(x,y,bx,by));
    }
    if(changeHappened) {
      checkChange();
    }

  }

  private void checkChange() {
    final Optional<UnEqualPair> up = this.ups.stream().findFirst();
    final Optional<EqualPair> ep = eps.stream().findFirst();
    boolean flip;
    boolean reverse;
    reverse = up.map(it -> queryForValue(it.x) == it.currentValueX).orElse(false);
    if (fps.isEmpty()) {
      flip = ep.map(it -> queryForValue(it.x) == it.currentValue).orElse(false);
    } else {
      flip = fps.stream().findFirst().map(it -> queryForValue(it.x) == it.currentValue)
          .orElse(false);
    }
    if (flip) {
     flip();
    }
    if(reverse) {
      reverse();
    }
    changeHappened = false;
  }


  private boolean queryForValue(int x) {
    if(qcount < maxQuery) {
      boolean bx;
      Scanner scanner = in;
      System.out.println(x + 1);
      System.out.flush();
      final int a = scanner.nextInt();
      bx = resolve(a);
      qcount++;
      if (qcount != 1 && qcount % 10 == 1) {
        changeHappened = true;
      }
      return bx;
    }
    return false;
  }

  boolean resolve(int a) {
    return a == 1;
  }

  void flip() {
    eps.forEach(EqualPair::flip);
    ups.forEach(UnEqualPair::flip);
    fps.forEach(FixPoint::flip);
  }

  void reverse() {
    eps.forEach(EqualPair::reverse);
    ups.forEach(UnEqualPair::reverse);
    fps.forEach(FixPoint::reverse);
  }

}

class FixPoint {

  int x;
  boolean currentValue;

  public FixPoint(int x, boolean currentValue) {
    this.x = x;
    this.currentValue = currentValue;
  }

  void flip() {
    currentValue = !currentValue;
  }

  void reverse() {
    //Do Nothing
  }

  public String getStringValue() {
    if(currentValue) return ""+1;
    return ""+0;
  }
}


class EqualPair {

  int x;
  int y;
  boolean currentValue;

  public EqualPair(int x, int y, boolean currentValue) {
    this.x = x;
    this.y = y;
    this.currentValue = currentValue;
  }

  void flip() {
    currentValue = !currentValue;
  }

  void reverse() {
    //Do Nothing
  }

  public String getStringValue() {
    if(currentValue) return ""+1;
    return ""+0;
  }
}

class UnEqualPair {

  int x;
  int y;

  boolean currentValueX;
  boolean currentValueY;

  public UnEqualPair(int x, int y, boolean currentValueX, boolean currentValueY) {
    this.x = x;
    this.y = y;
    this.currentValueX = currentValueX;
    this.currentValueY = currentValueY;
  }

  void flip() {
    currentValueX = !currentValueX;
    currentValueY = !currentValueY;
  }

  void reverse() {
    currentValueX = !currentValueX;
    currentValueY = !currentValueY;
  }

  public String getStringX() {
    if(currentValueX) return ""+1;
    return ""+0;
  }
  public String getStringY() {
    if(currentValueY) return ""+1;
    return ""+0;
  }

}