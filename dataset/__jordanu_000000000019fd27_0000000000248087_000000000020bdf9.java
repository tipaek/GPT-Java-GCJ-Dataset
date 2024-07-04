import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        // Solve each test case
        for (int i=1; i<cases+1; i++) {
            solve(i, in);
        }
    }

    public static void solve(int i, Scanner in) {
        int number = in.nextInt();
        int appointments[][] = new int[number][2];
        for (int j=0; j<number; j++) {
            for (int k=0; k<2; k++) {
                appointments[j][k] = in.nextInt();
            }
        }

        // Count number of colliding tasks
        int collision_count = 0;
        int collisions[][] = new int[number * number][2];
        for (int k=0; k<number; k++) {
            for (int m=k; m<number; m++) {
                if ((appointments[k][0] < appointments[m][0] && appointments[k][1] > appointments[m][0]) ||
                        (appointments[m][0] < appointments[k][0] && appointments[m][1] > appointments[k][0])) {
                    collisions[collision_count][0] = k;
                    collisions[collision_count][1] = m;
                    collision_count++;
                }
            }
        }

        if (collision_count == 0) {
            StringBuffer sb = new StringBuffer();

            for (int n=0; n<number; n++) {
                sb.append("C");
            }
            String str = sb.toString();
            System.out.println("Case #" + i + ": " + str);
            return;
        }

        int nameOne, nameTwo;
        ArrayList<Integer> unique = new ArrayList<Integer>();
        for (int j=0; j<number; j++) {
            nameOne = collisions[j][0];
            nameTwo = collisions[j][1];

            if (!unique.contains(nameOne)) {
                unique.add(nameOne);
            }
            if (!unique.contains(nameTwo)) {
                unique.add(nameTwo);
            }
        }

        ArrayList<Integer> listOne = new ArrayList<Integer>();
        ArrayList<Integer> listTwo = new ArrayList<Integer>();

        // Store first villian in one list and it's adversaries in another
        int firstVillian = unique.get(0);
        listOne.add(firstVillian);

        // Find which villians that our first cannot be in same list as
        for (int k=0; k<collision_count; k++) {
            if (collisions[k][0] == firstVillian) {
                listTwo.add(collisions[k][1]);
            } else if (collisions[k][1] == firstVillian) {
                listTwo.add(collisions[k][0]);
            }
        }

        ArrayList<Integer> unseen = new ArrayList<Integer>(unique);
        unseen.remove(firstVillian);

        while (unseen.size() > 0) {
            for (Integer name : unique) {
                // Already checked them
                if (!unseen.contains(name)) {
                    continue;
                }

                if (listTwo.contains(name)) {
                    for (int k=0; k<collision_count; k++) {
                        if (collisions[k][0] == name) {
                            if (listTwo.contains(collisions[k][1])) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                return;
                            }
                            listOne.add(collisions[k][1]);
                        } else if (collisions[k][1] == name) {
                            if (listTwo.contains(collisions[k][0])) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                return;
                            }
                            listOne.add(collisions[k][0]);
                        }
                    }
                    unseen.remove(name);
                }
                else if (listOne.contains(name)) {
                    for (int k=0; k<collision_count; k++) {
                        if (collisions[k][0] == name) {
                            if (listOne.contains(collisions[k][1])) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                return;
                            }
                            listTwo.add(collisions[k][1]);
                        } else if (collisions[k][1] == name) {
                            if (listOne.contains(collisions[k][0])) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                return;
                            }
                            listTwo.add(collisions[k][0]);
                        }
                    }
                    unseen.remove(name);
                }
            }
        }
        StringBuffer sb = new StringBuffer();

        for (int n=0; n<number; n++) {
            if (listOne.contains(n)) {
                sb.append("J");
            } else if (listTwo.contains(n)) {
                sb.append("C");
            } else {
                // No collisions can choose either tbh
                sb.append("C");
            }
        }
        String str = sb.toString();
        System.out.println("Case #" + i + ": " + str);
    }
}