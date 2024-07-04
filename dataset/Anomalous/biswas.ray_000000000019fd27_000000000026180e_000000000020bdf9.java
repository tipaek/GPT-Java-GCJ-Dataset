import java.util.*;

class Line {
    public int start, end;
    public char person;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
        this.person = 'N';
    }

    public boolean intersect(Line other) {
        return (other.start > this.start && other.start < this.end) || 
               (other.end > this.start && other.end < this.end);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numberOfLines = scanner.nextInt();
            Line[] lines = new Line[numberOfLines];

            for (int j = 0; j < numberOfLines; j++) {
                lines[j] = new Line(scanner.nextInt(), scanner.nextInt());
            }

            char currentPerson = 'C';
            StringBuilder result = new StringBuilder();
            ArrayList<Line> cLines = new ArrayList<>();
            ArrayList<Line> jLines = new ArrayList<>();

            outerLoop:
            for (int u = 0; u < numberOfLines; u++) {
                boolean canAssign = true;

                if (currentPerson == 'C') {
                    for (Line line : cLines) {
                        if (line.intersect(lines[u])) {
                            canAssign = false;
                            break;
                        }
                    }

                    if (canAssign) {
                        cLines.add(lines[u]);
                        result.append(currentPerson);
                    } else {
                        currentPerson = 'J';
                        canAssign = true;

                        for (Line line : jLines) {
                            if (line.intersect(lines[u])) {
                                canAssign = false;
                                break;
                            }
                        }

                        if (canAssign) {
                            jLines.add(lines[u]);
                            result.append(currentPerson);
                        } else {
                            result = new StringBuilder("IMPOSSIBLE");
                            break outerLoop;
                        }
                    }
                } else {
                    for (Line line : jLines) {
                        if (line.intersect(lines[u])) {
                            canAssign = false;
                            break;
                        }
                    }

                    if (canAssign) {
                        jLines.add(lines[u]);
                        result.append(currentPerson);
                    } else {
                        currentPerson = 'C';
                        canAssign = true;

                        for (Line line : cLines) {
                            if (line.intersect(lines[u])) {
                                canAssign = false;
                                break;
                            }
                        }

                        if (canAssign) {
                            cLines.add(lines[u]);
                            result.append(currentPerson);
                        } else {
                            result = new StringBuilder("IMPOSSIBLE");
                            break outerLoop;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}