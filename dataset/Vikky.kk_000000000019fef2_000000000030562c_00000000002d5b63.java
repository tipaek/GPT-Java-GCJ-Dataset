import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t, n, a, b, error = 0;
        t = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        while (t-- > 0) {
            int found = 0;
            int vertical_cord_X = -10, vertical_cord_Y = 10, moves = 300;
            System.out.print(vertical_cord_X + " " + vertical_cord_Y + "\n");
            String response = sc.next();
            if (response.equals("MISS")) {
                vertical_cord_X = 10;

                System.out.print(vertical_cord_X + " " + vertical_cord_Y + "\n");
                response = sc.next();
                if (response.equals("MISS")) {
                    vertical_cord_Y = -10;

                    System.out.print(vertical_cord_X + " " + vertical_cord_Y + "\n");
                    response = sc.next();
                    if (response.equals("MISS")) {
                        vertical_cord_X = -10;
                        // this should surely be hit
                        System.out.print(vertical_cord_X + " " + vertical_cord_Y + "\n");
                        response = sc.next();
                        if (response.equals("CENTER")) {
                            found = 1;
                        }
                    } else if (response.equals("CENTER")) {
                        found = 1;
                    }
                } else if (response.equals("CENTER")) {
                    found = 1;
                }
            } else if (response.equals("CENTER")) {
                found = 1;
            }
            int maxN = 100000000, maxE = 100000000, maxS = -100000000, maxW = -100000000;
            if (found == 0 && error == 0) {

                int vertical_cord_X_Backup = vertical_cord_X, vertical_cord_Y_Backup = vertical_cord_Y;

                while (vertical_cord_Y_Backup <= maxN) {
                    int mid = (vertical_cord_Y_Backup + maxN) / 2;
                    System.out.print(vertical_cord_X + " " + mid + "\n");
                    String response = sc.next();
                    if (response.equals("CENTER")) {
                        found = 1;
                        break;
                    } else if (response.equals("HIT")) {
                        vertical_cord_Y_Backup = mid + 1;
                    } else if (response.equals("MISS")) {
                        maxN = mid - 1;
                    } else {
                        error = 1;
                        break;
                    }
                }
            }
            if (found == 0 && error == 0) {

                int vertical_cord_X_Backup = vertical_cord_X, vertical_cord_Y_Backup = vertical_cord_Y;
                while (vertical_cord_Y_Backup >= maxS) {
                    int mid = (vertical_cord_Y_Backup + maxS) / 2;
                    System.out.print(vertical_cord_X + " " + mid + "\n");
                    String response = sc.next();
                    if (response.equals("CENTER")) {
                        found = 1;
                        break;
                    } else if (response.equals("HIT")) {
                        vertical_cord_Y_Backup = mid - 1;
                    } else if (response.equals("MISS")) {
                        maxS = mid + 1;
                    } else {
                        error = 1;
                        break;
                    }

                }
            }
            if (found == 0 && error == 0) {

                int vertical_cord_X_Backup = vertical_cord_X, vertical_cord_Y_Backup = vertical_cord_Y;

                while (vertical_cord_X_Backup <= maxE) {
                    int mid = (vertical_cord_X_Backup + maxE) / 2;
                    System.out.print(mid + " " + ((maxN + maxS) / 2) + "\n");
                    String response = sc.next();
                    if (response.equals("CENTER")) {
                        found = 1;
                        break;
                    } else if (response.equals("HIT")) {
                        vertical_cord_X_Backup = mid + 1;
                    } else if (response.equals("MISS")) {
                        maxE = mid - 1;
                    } else {
                        error = 1;
                        break;
                    }
                }

            }
            if (found == 0 && error == 0) {

                int vertical_cord_X_Backup = vertical_cord_X, vertical_cord_Y_Backup = vertical_cord_Y;
                while (vertical_cord_X_Backup >= maxW) {
                    int mid = (vertical_cord_X_Backup + maxW) / 2;
                    System.out.print(mid + " " + ((maxN + maxS) / 2) + "\n");
                    String response = sc.next();
                    if (response.equals("CENTER")) {
                        found = 1;
                        break;
                    } else if (response.equals("HIT")) {
                        vertical_cord_X_Backup = mid - 1;
                    } else if (response.equals("MISS")) {
                        maxW = mid + 1;
                    } else {
                        error = 1;
                        break;
                    }

                }
            }

            if (found == 0 && error == 0) {
                System.out.print(((maxE + maxW) / 2) + " " + ((maxN + maxS) / 2) + "\n");
                String response = sc.next();
                if (!response.equals("CENTER")) {
                    System.out.print((((maxE + maxW) / 2) + 1) + " " + (((maxN + maxS) / 2) - 1) + "\n");
                    String response = sc.next();
                    if (!response.equals("CENTER")) {
                        System.out.print((((maxE + maxW) / 2) + 1) + " " + ((maxN + maxS) / 2) + "\n");
                        String response = sc.next();
                        if (!response.equals("CENTER")) {
                            System.out.print((((maxE + maxW) / 2) + 1) + " " + (((maxN + maxS) / 2) + 1) + "\n");
                            String response = sc.next();
                            if (!response.equals("CENTER")) {
                                System.out.print((((maxE + maxW) / 2)) + " " + (((maxN + maxS) / 2) - 1) + "\n");
                                String response = sc.next();
                                if (!response.equals("CENTER")) {
                                    System.out.print((((maxE + maxW) / 2)) + " " + (((maxN + maxS) / 2) + 1) + "\n");
                                    String response = sc.next();
                                    if (!response.equals("CENTER")) {
                                        System.out.print(
                                                (((maxE + maxW) / 2) - 1) + " " + (((maxN + maxS) / 2) - 1) + "\n");
                                        String response = sc.next();
                                        if (!response.equals("CENTER")) {
                                            System.out.print(
                                                    (((maxE + maxW) / 2) - 1) + " " + (((maxN + maxS) / 2)) + "\n");
                                            String response = sc.next();
                                            if (!response.equals("CENTER")) {
                                                System.out.print((((maxE + maxW) / 2) - 1) + " "
                                                        + (((maxN + maxS) / 2) + 1) + "\n");
                                                String response = sc.next();
                                                if (!response.equals("CENTER")) {
                                                    error = 1; // still no luck then you are doomed
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (error == 1) {
                break;
            }

        }
    }
}