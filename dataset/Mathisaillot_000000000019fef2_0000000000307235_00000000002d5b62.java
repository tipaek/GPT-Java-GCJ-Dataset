import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String reponse ="IMPOSSIBLE";
            if (X % 2 == Y % 2) {
                reponse = "IMPOSSIBLE";
            } else {

                LinkedList<couple> couples = new LinkedList<>();
                LinkedList<couple> couples1 = new LinkedList<>();
                if (X%2 == 1) {
                    couples.add(new couple(1,0, "E"));
                    couples.add(new couple(-1,0, "W"));
                } else {
                    couples.add(new couple(0,1, "N"));
                    couples.add(new couple(0,-1, "S"));
                }
                int a = 2;

                boolean trouver = false;

                while (!couples.isEmpty() && !trouver) {
                    couples1.clear();
                    for (couple c : couples) {
                        int dx = Math.abs(X - c.x);
                        int dy = Math.abs(Y - c.y);
                        if((dx < a && dx !=0) || (dy < a && dy != 0)) {
                            continue;
                        }
                        if (dx != 0) {
                            couple c1 = new couple(c.x + a,c.y,c.str + "E");
                            if (c1.x == X && c1.y == Y) {
                                reponse = c1.str;
                                trouver = true;
                                break;
                            }
                            couples1.add(c1);

                            c1 = new couple(c.x - a,c.y,c.str + "W");
                            if (c1.x == X && c1.y == Y) {
                                reponse = c1.str;
                                trouver = true;
                                break;
                            }
                            couples1.add(c1);

                        }
                        if (dy != 0) {

                            couple c1 = new couple(c.x,c.y + a,c.str + "N");
                            if (c1.x == X && c1.y == Y) {
                                reponse = c1.str;
                                trouver = true;
                                break;
                            }
                            couples1.add(c1);

                            c1 = new couple(c.x,c.y - a,c.str + "S");
                            if (c1.x == X && c1.y == Y) {
                                reponse = c1.str;
                                trouver = true;
                                break;
                            }
                            couples1.add(c1);
                        }
                    }
                    a *= 2;
                    couples.clear();
                    couples.addAll(couples1);
                }

            }

            System.out.println("Case #" + i + ": " + reponse);
            System.gc();
        }
    }
}

class couple {
    int x, y;
    String str;

    public couple(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
    }
}
