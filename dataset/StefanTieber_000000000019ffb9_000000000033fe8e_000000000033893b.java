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
            Comparator<Point> comparator = Comparator.comparing(point -> point.costInfinite);
            comparator.thenComparing(point -> point.cost);

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
                    Arrays.stream(points).forEach(point -> point.costInfinite = 1);
                    Arrays.stream(points).forEach(point -> point.visited = false);

                    points[querie.start].cost = 0;
                    points[querie.start].costInfinite = 0;

                    List<Point> pointList = Arrays.stream(points).collect(Collectors.toList());

                    while (pointList.size() > 0) {
                        pointList.sort(comparator);
                        Point shortest = pointList.get(0);

                        if (shortest.pos == querie.end) {
                            break;
                        }

                        shortest.recalc();
                        pointList.remove(0);
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
    int costInfinite;
    
    boolean visited;

    void recalc() {
        int potLeft = cost + timeLeft;
        int potRight = cost + timeRight;
        int potJump = cost + timeJump;

        if (!Solution.points[left].visited && (Solution.points[left].costInfinite > 0 || Solution.points[left].cost > potLeft)) {
            Solution.points[left].cost = potLeft;
            Solution.points[left].costInfinite = 0;
        }
        if (!Solution.points[right].visited && (Solution.points[right].costInfinite > 0 || Solution.points[right].cost > potRight)) {
            Solution.points[right].cost = potRight;
            Solution.points[right].costInfinite = 0;
        }
        if (!Solution.points[jump].visited && (Solution.points[jump].costInfinite > 0 || Solution.points[jump].cost > potJump)) {
            Solution.points[jump].cost = potJump;
            Solution.points[jump].costInfinite = 0;
        }
        
        visited = true;
    }
}

class Querie {
    int start;
    int end;
    int cost;
}
