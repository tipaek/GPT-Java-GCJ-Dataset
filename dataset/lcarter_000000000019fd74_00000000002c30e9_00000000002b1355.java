import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int r = input.nextInt();
            int c = input.nextInt();

            List<List<Dancer>> dancersByR = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                dancersByR.add(new ArrayList<>());
            }
            List<List<Dancer>> dancersByC = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                dancersByC.add(new ArrayList<>());
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                {
                    Dancer d = new Dancer(input.nextInt());
                    dancersByR.get(i).add(d);
                    dancersByC.get(j).add(d);
                }
            }

            Pair elimintedAndInterest = new Pair(0, 0);
            int totalInterest = 0;
            do {
//                System.out.println("before");
//                for (List<Dancer> row : dancersByR) {
//                    System.out.println(row);
//                }
//                System.out.println("doing an iteration");
                DancersAndInterestAndEliminated res = iterate(dancersByR, dancersByC);
                dancersByR = res.dancersAndInterest.dancersByR;
                dancersByC = res.dancersAndInterest.dancersByC;

//                System.out.println("after");
//                for (List<Dancer> row : dancersByR) {
//                    System.out.println(row);
//                }
                elimintedAndInterest = new Pair(res.eliminated, res.dancersAndInterest.totalInterest);
                totalInterest += elimintedAndInterest.right;
            } while(elimintedAndInterest.left > 0);


//            for (List<Dancer> row : dancersByR) {
//                System.out.println(row);
//            }
//            System.out.println(dancersByR);
//            System.out.println(dancersByC);

//            System.out.println(dancersByC.get(0).get(0));
//            System.out.println(dancersByR.get(0).get(0));


            System.out.printf("Case #%d: %d\n", caseNum, totalInterest);
        }
    }

    private static DancersAndInterestAndEliminated iterate(List<List<Dancer>> dancersByR, List<List<Dancer>> dancersByC) {
        int nDancers = getLength(dancersByR);
        for (List<Dancer> row : dancersByR) {
            for (int i = 0; i < row.size(); i++) {
                if (i - 1 >= 0) {
                    row.get(i).addNeighbor(row.get(i - 1));
                }
                if (i +1 < row.size()) {
                    row.get(i).addNeighbor(row.get(i+1));
                }
            }
        }
        for (List<Dancer> col : dancersByC) {
            for (int i = 0; i < col.size(); i++) {
                if (i - 1 >= 0) {
                    col.get(i).addNeighbor(col.get(i - 1));
                }
                if (i +1 < col.size()) {
                    col.get(i).addNeighbor(col.get(i+1));
                }
            }
        }

//        System.out.println("before elimination");
//        for (List<Dancer> row : dancersByR) {
//            System.out.println(row);
//        }

        DancersAndInterest intermediateResult = eliminateAllDancers(dancersByR, dancersByC);


        return new DancersAndInterestAndEliminated(nDancers - getLength(intermediateResult.dancersByR), intermediateResult);
    }

    private static int getLength(List<List<Dancer>> dancersByR) {
        int res = 0;
        for (List<Dancer> row : dancersByR) {
            res += row.size();
        }
        return res;
    }

    private static DancersAndInterest eliminateAllDancers(List<List<Dancer>> dancersByR, List<List<Dancer>> dancersByC) {
        AtomicInteger totalInterest = new AtomicInteger();
        List<List<Dancer>> newDancersByR = new ArrayList<>();
        for (List<Dancer> row : dancersByR) {
            newDancersByR.add(row.stream()
                    .filter(dancer -> {
                        totalInterest.addAndGet(dancer.skill);
                        return !dancer.isEliminated();
                    }).collect(Collectors.toList()));
        }

        List<List<Dancer>> newDancersByC = new ArrayList<>();
        for (List<Dancer> col : dancersByC) {
            newDancersByC.add(col.stream()
                    .filter(dancer -> !dancer.isEliminated())
                    .collect(Collectors.toList()));
        }

        return new DancersAndInterest(totalInterest.get(), newDancersByR, newDancersByC);
    }

    private static class DancersAndInterestAndEliminated {
        DancersAndInterest dancersAndInterest;
        int eliminated;
        DancersAndInterestAndEliminated(int eliminated, DancersAndInterest dancersAndInterest) {
            this.eliminated = eliminated;
            this.dancersAndInterest = dancersAndInterest;
        }
    }

    private static class DancersAndInterest {
        int totalInterest;
        List<List<Dancer>> dancersByR;
        List<List<Dancer>> dancersByC;
        DancersAndInterest(int totalInterest, List<List<Dancer>> dancersByR, List<List<Dancer>> dancersByC) {
            this.dancersByC = dancersByC;
            this.dancersByR = dancersByR;
            this.totalInterest = totalInterest;
        }
    }

    private static class Dancer {
        int skill;
        int neighborSkillSum;
        int nNeighbors;
//        int r;
//        int c;

        Dancer(int skill) {
            this.skill = skill;
        }

        void addNeighbor(Dancer neighbor) {
            neighborSkillSum += neighbor.skill;
            nNeighbors++;
        }

        boolean isEliminated() {
            if (skill * nNeighbors >= neighborSkillSum) {
                nNeighbors = 0;
                neighborSkillSum = 0;
                return false;
            } else {
                return true;
            }
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", skill, neighborSkillSum, nNeighbors);
        }
    }

    private static class Pair {
        int left;
        int right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
