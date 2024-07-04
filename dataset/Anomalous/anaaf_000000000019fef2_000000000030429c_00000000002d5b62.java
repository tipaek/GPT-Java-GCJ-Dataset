package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void peaks() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int j = 1; j <= t; j++) {
            int N = in.nextInt();
            int[] chk = new int[N];

            for (int i = 0; i < chk.length; i++) {
                chk[i] = in.nextInt();
            }

            int peaks = 0;

            for (int i = 1; i < chk.length - 1; i++) {
                if (chk[i] > chk[i - 1] && chk[i] > chk[i + 1]) {
                    peaks++;
                }
            }
            System.out.println("Case #" + j + ": " + peaks);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int x = 0;
            int y = 0;
            int targetX = in.nextInt();
            int targetY = in.nextInt();
            boolean isPossible = true;
            StringBuilder finalString = new StringBuilder();
            int moves = 0;
            boolean fmove = true;

            while (isPossible) {
                if (targetY % 2 != 0) {
                    if (!fmove) {
                        finalString = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        if (targetY == 1) {
                            finalString.append("N");
                            fmove = false;
                            moves++;
                        } else if (targetY == -1) {
                            finalString.append("S");
                            fmove = false;
                            moves++;
                        } else if ((targetY - 1) % 2 == 0) {
                            y--;
                            moves++;
                            finalString.append("S");
                            fmove = false;
                        } else if ((targetY + 1) % 2 == 0) {
                            y++;
                            moves++;
                            finalString.append("N");
                            fmove = false;
                        }
                    }
                } else if (targetX % 2 != 0) {
                    if (!fmove) {
                        finalString = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        if (targetX == 1) {
                            finalString.append("E");
                            x--;
                            moves++;
                            fmove = false;
                        } else if (targetX == -1) {
                            finalString.append("W");
                            x--;
                            moves++;
                            fmove = false;
                        } else if ((targetX - 1) % 2 == 0) {
                            x--;
                            moves++;
                            finalString.append("W");
                            fmove = false;
                        } else if ((targetX + 1) % 2 == 0) {
                            x++;
                            moves++;
                            finalString.append("E");
                            fmove = false;
                        }
                    }
                } else {
                    finalString = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(finalString.toString());
        }
    }
}