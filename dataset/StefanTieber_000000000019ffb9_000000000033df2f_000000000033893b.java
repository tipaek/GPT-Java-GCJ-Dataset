import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static Point[] points;
    public static Querie[] queries;

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            String[] parts;

            line = reader.readLine();
            int numberOfSets = Integer.parseInt(line);

            for (int iSet = 0; iSet < numberOfSets; iSet++) {
                line = reader.readLine();
                parts = line.split("\\s+");
                int numPoints = Integer.parseInt(parts[0]);
                int numQueries = Integer.parseInt(parts[1]);

                points = new Point[numPoints];
                for (int iPoint = 0; iPoint < numPoints; iPoint++) {
                    points[iPoint] = new Point();
                }

                queries = new Querie[numQueries];
                for (int iQ = 0; iQ < numQueries; iQ++) {
                    queries[iQ] = new Querie();
                }

                char[] chars = reader.readLine().toCharArray();

                line = reader.readLine();
                parts = line.split("\\s+");
                for (int iPoint = 0; iPoint < numPoints; iPoint++) {
                    int timeLeft = Integer.parseInt(parts[iPoint]);
                    points[iPoint].timeLeft = timeLeft;
                }

                line = reader.readLine();
                parts = line.split("\\s+");
                for (int iPoint = 0; iPoint < numPoints; iPoint++) {
                    points[iPoint].timeRight = Integer.parseInt(parts[iPoint]);
                }

                line = reader.readLine();
                parts = line.split("\\s+");
                for (int iPoint = 0; iPoint < numPoints; iPoint++) {
                    points[iPoint].timeJump = Integer.parseInt(parts[iPoint]);
                }

                line = reader.readLine();
                parts = line.split("\\s+");
                for (int iQ = 0; iQ < numQueries; iQ++) {
                    queries[iQ].start = Integer.parseInt(parts[iQ]) - 1;
                }

                line = reader.readLine();
                parts = line.split("\\s+");
                for (int iQ = 0; iQ < numQueries; iQ++) {
                    queries[iQ].end = Integer.parseInt(parts[iQ]) - 1;
                }

                for (int iPoint = 0; iPoint < numPoints; iPoint++) {
                    points[iPoint].pos = iPoint;
                    points[iPoint].left = iPoint - 1;
                    points[iPoint].right = iPoint + 1;
                }
                points[0].left = 0;
                points[numPoints - 1].right = numPoints - 1;

                for (int iPoint = 0; iPoint < numPoints; iPoint++) {
                    if (chars[iPoint] == ')') {
                        for (int i2P = iPoint; i2P >= 0; i2P--) {
                            if (chars[i2P] == '(' && !points[i2P].hasJump) {
                                points[i2P].jump = iPoint;
                                points[i2P].hasJump = true;
                                points[iPoint].jump = i2P;
                                points[iPoint].hasJump = true;
                                break;
                            }
                        }
                    }
                }

                for (Querie querie : queries) {
                    Arrays.stream(points).forEach(point -> point.costInfinite = true);

                    points[querie.start].cost = 0;
                    points[querie.start].costInfinite = false;

                    List<Point> pointList = Arrays.stream(points).collect(Collectors.toList());

                    while (pointList.size() > 0) {
                        List<Point> pointListTemp = pointList.stream()
                                .filter(point -> !point.costInfinite)
                                .sorted(Comparator.comparing(point -> point.cost))
                                .collect(Collectors.toList());
                        Point shortest = pointListTemp.get(0);

                        if (shortest.pos == querie.end) {
                            break;
                        }

                        shortest.recalc();
                        pointList.remove(shortest);
                    }
                    
                    querie.cost = points[querie.end].cost;
                }

                int sumCost = Arrays.stream(queries).mapToInt(q -> q.cost).sum();

                System.out.println("Case #" + (iSet + 1) + ": " + sumCost);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Point {
    int pos;
    int left;
    int right;
    int jump;
    boolean hasJump = false;

    int timeLeft;
    int timeRight;
    int timeJump;

    int cost;
    boolean costInfinite;

    void recalc() {
        int potLeft = cost + timeLeft;
        int potRight = cost + timeRight;
        int potJump = cost + timeJump;

        if (Solution.points[left].costInfinite || Solution.points[left].cost > potLeft) {
            Solution.points[left].cost = potLeft;
            Solution.points[left].costInfinite = false;
        }
        if (Solution.points[right].costInfinite || Solution.points[right].cost > potRight) {
            Solution.points[right].cost = potRight;
            Solution.points[right].costInfinite = false;
        }
        if (Solution.points[jump].costInfinite || Solution.points[jump].cost > potJump) {
            Solution.points[jump].cost = potJump;
            Solution.points[jump].costInfinite = false;
        }
    }
}

class Querie {
    int start;
    int end;
    int cost;
}
