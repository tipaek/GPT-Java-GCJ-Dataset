import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    static List<Tree> threes = solve(3);
    static List<Tree> fours = solve(4);
    static List<Tree> fives = solve(5);

    public static void main(String[] args) throws IOException {
        List<String> results = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < numberOfTestCases; i++) {
            String[] nAndK = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nAndK[0]);
            int k = Integer.parseInt(nAndK[1]);

            List<Tree> solutionTrees = null;
            if (n == 2) {
                if (k == 2) {
                    String res = "Case #" + (i + 1) + ": POSSIBLE\n1 2\n2 1";
                    results.add(res);
                    continue;
                } else if (k == 4) {
                    String res = "Case #" + (i + 1) + ": POSSIBLE\n2 1\n1 2";
                    results.add(res);
                    continue;
                } else {
                    String res = "Case #" + (i + 1) + ": IMPOSSIBLE";
                    results.add(i == numberOfTestCases - 1 ? res : res + "\n");
                    continue;
                }
            }

            if (n == 3) {
                solutionTrees = threes;
            } else if (n == 4) {
                solutionTrees = fours;
            } else if (n == 5) {
                solutionTrees = fives;
            } else {
                solutionTrees = solve(n);
            }

            boolean hasSolution = false;
            for (Tree solutionTree : solutionTrees) {
                List<int[]> trace = getTrace(solutionTree, 0, n, 0, k, new ArrayList<>());
                if (trace == null) {
                    continue;
                } else {
                    hasSolution = true;
                    StringBuilder sb = new StringBuilder("Case #" + (i + 1) + ": POSSIBLE\n");
                    for (int j = 0; j < trace.size(); j++) {
                        int[] ints = trace.get(j);
                        for (int anInt : ints) {
                            sb.append(anInt).append(" ");
                        }

                        if (j < n - 1) {
                            sb.append("\n");
                        }
                    }

                    results.add(sb.toString());
                    break;
                }
            }

            if (!hasSolution) {
                String res = "Case #" + (i + 1) + ": IMPOSSIBLE";
                results.add(res);
            }

        }
        br.close();

        for (String result : results) {
            System.out.println(result);
        }


        /*int n = 3;
        int k = 6;
        List<Tree> solves = solve(n);
        for (Tree solve : solves) {
            List<int[]> trace = getTrace(solve, 0, n, 0, k, new ArrayList<>());
            if (trace == null) continue;
            for (int[] ints : trace) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println("----------------");

        }*/
        /*List<int[]> permutate = permutate(3);
        for (int[] ints : permutate) {
            System.out.println(Arrays.toString(ints));
        }*/

    }

    static List<int[]> getTrace(Tree tree, int currentLevel, int maxLevel, int currentTrace, int neededTrace, List<int[]> currentPath) {
        if (currentLevel > maxLevel - 1) {
            if (currentTrace == neededTrace) {
                currentPath.add(tree.data);
                return currentPath;
            }
            return null;
        }

        currentTrace += tree.data[currentLevel];
        if (tree.getChildren() != null) {
            for (Tree child : tree.getChildren()) {
                currentPath.add(tree.data);
                List<int[]> trace = getTrace(child, currentLevel + 1, maxLevel, currentTrace, neededTrace, currentPath);
                if (trace != null) {
                    return trace;
                }
                currentPath.remove(currentPath.size() - 1);
            }

        } else {
            if (currentLevel == maxLevel - 1 && currentTrace == neededTrace) {
                currentPath.add(tree.data);
                return currentPath;
            }
        }

        return null;
    }

    static List<Tree> solve(int n) {
        List<int[]> permutations = permutate(n);

        List<Tree> solutionTrees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<int[]> used = new ArrayList<>();
            used.add(permutations.get(i));

            List<int[]> notUsed = new ArrayList<>(permutations);
            notUsed.remove(permutations.get(i));

            solutionTrees.add(buildTree(new Tree(permutations.get(i), null), used, notUsed));

            used.remove(permutations.get(i));
            notUsed.add(permutations.get(i));
        }

        return solutionTrees;
    }

    private static List<int[]> permutate(int n) {
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i + 1;
        }

        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                res.add(elements.clone());
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }

        return res;
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static Tree buildTree(Tree tree, List<int[]> used, List<int[]> notUsed) {
        Set<int[]> possibilities = getPossibilities(used, notUsed);
        List<Tree> children = new ArrayList<>();
        for (int[] possibility : possibilities) {
            used.add(possibility);
            notUsed.remove(possibility);
            children.add(buildTree(new Tree(possibility, tree), used, notUsed));
            used.remove(possibility);
            notUsed.add(possibility);
        }

        if (children.isEmpty()) {
            children = null;
        }

        tree.setChildren(children);
        return tree;
    }

    private static Set<int[]> getPossibilities(List<int[]> used, List<int[]> notUsed) {
        Set<int[]> res = new HashSet<>();
        for (int[] notUsedPerm : notUsed) {
            boolean isPossible = true;
            for (int i = 0; i < notUsedPerm.length; i++) {
                for (int j = 0; j < used.size(); j++) {
                    if (notUsedPerm[i] == used.get(j)[i]) {
                        isPossible = false;
                        break;
                    }
                }

                if (!isPossible) {
                    break;
                }
            }

            if (isPossible) {
                res.add(notUsedPerm);
            }

            isPossible = true;
        }

        return res;
    }

    static class Tree {
        public final int[] data;
        public final Tree parent;
        private List<Tree> children;

        public Tree(int[] data, Tree parent) {
            this.data = data;
            this.parent = parent;
        }

        public List<Tree> getChildren() {
            return children;
        }

        public void setChildren(List<Tree> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "Tree{" +
                            "data=" + Arrays.toString(data) +
                            ", children=" + children +
                            '}';
        }
    }
}