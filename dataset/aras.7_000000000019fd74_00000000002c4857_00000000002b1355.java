import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static class Dancer {
        int r;
        int c;
        int score;

        Dancer up, down, left, right;


        Dancer(int _r, int _c, int s) {
            this.r = _r;
            this.c = _c;
            this.score = s;
            this.up = null;
            this.down = null;
            this.left = null;
            this.right = null;
        }

        public boolean hasToBeEliminated() {
            int value = 0;
            int neighboursCount = 0;

            if (this.up != null) {
                value += this.up.score;
                neighboursCount++;
            }
            if (this.down != null) {
                value += this.down.score;
                neighboursCount++;
            }

            if (this.left != null) {
                value += this.left.score;
                neighboursCount++;
            }
            if (this.right != null) {
                value += this.right.score;
                neighboursCount++;
            }

            return value > score * neighboursCount;
        }
    }

    public static void main(String []args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCount = in.nextInt();
        for (int testNumber = 1; testNumber <= testCount; testNumber++) {
            int rows = in.nextInt();
            int columns = in.nextInt();

            Dancer[][] dancers = new Dancer[rows][columns];
            List<Dancer> dancersAlive = new LinkedList<>();

            for (int i = 0; i < rows; i++) {
                dancers[i] = new Dancer[columns];
                for (int j = 0; j < columns; j++) {
                    Dancer dancer = new Dancer(i, j, in.nextInt());
                    dancers[i][j] = dancer;
                    dancersAlive.add(dancer);
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i != 0) {
                        dancers[i][j].up = dancers[i - 1][j];
                    }
                    if (i + 1 != rows) {
                        dancers[i][j].down = dancers[i + 1][j];
                    }

                    if (j != 0) {
                        dancers[i][j].left = dancers[i][j - 1];
                    }
                    if (j + 1 != columns) {
                        dancers[i][j].right = dancers[i][j + 1];
                    }
                }
            }
            int totalScore = 0;

            boolean hasEliminated = true;
            while(hasEliminated) {
                hasEliminated = false;
                int roundScore = 0;

                Iterator<Dancer> it = dancersAlive.iterator();

                boolean [][]ToDelete = new boolean [rows + 1][columns + 1];

                List<Dancer> iterationToDelete = new ArrayList<>();
                int itCount = -1;
                // check delete
                while(it.hasNext()) {
                    itCount++;

                    Dancer dancer = it.next();
                    roundScore += dancer.score;

                    // do I have to eliminate?
                    if (dancer.hasToBeEliminated()) {
                        ToDelete[dancer.r][dancer.c] = true;
                        hasEliminated = true;
                    }
                }
                totalScore += roundScore;

                it = dancersAlive.iterator();
                itCount = -1;
                while(it.hasNext()) {
                    itCount++;
                    Dancer dancer = it.next();
//                    System.out.printf("(%d, %d) ", dancer.r, dancer.c);
                    // delete and update
                    if (ToDelete[dancer.r][dancer.c]) {
                        if (dancer.up != null) {
                            dancer.up.down = dancer.down;
                        }
                        if (dancer.down != null) {
                            dancer.down.up = dancer.up;
                        }

                        if (dancer.left != null) {
                            dancer.left.right = dancer.right;
                        }
                        if (dancer.right != null) {
                            dancer.right.left = dancer.left;
                        }
                        it.remove();

                    }
                }
//                System.out.printf("\nround: %d\n", totalScore);

            }


            System.out.printf("Case #%d: %d\n", testNumber, totalScore);

        }
    }
}
/*
1
3 3
3 1 1
1 2 1
2 1 2


Input

Output

4
1 1
15
3 3
1 1 1
1 2 1
1 1 1
1 3
3 1 2
1 3
1 2 3


Case #1: 15
Case #2: 16
Case #3: 14
Case #4: 14



*/