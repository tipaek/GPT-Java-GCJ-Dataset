/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: Qualification
 * Problem: Problem D (ESAb ATAd)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final String RESPONSE_CORRECT = "Y";
  private static final String RESPONSE_0 = "0";
  private static final String RESPONSE_1 = "1";
  private static final char CHAR_0 = '0';
  private static final char CHAR_1 = '1';

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    int _B_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 1; t <= _T_; t++) {
      evaluateCase(_B_);
    }
    SYS_IN.close();
  }

  private static void evaluateCase(final int _B_) {
    char[] bits = new char[_B_ + 1];
    int watchIndexOpp = -1;
    int watchIndexSame = -1;
    int bitsFound = 0;
    int nextSeekIndex = -1;
    boolean nextSeekOpp = false;
    boolean nextSeekSame = false;
    int oppResultMatch = -1;
    int sameResultMatch = -1;
    String ipValueAtIndex = null;
    for (int tryCount = 1; tryCount <= 150 && bitsFound < _B_; tryCount++) {
      if (tryCount > 10) {
        if (tryCount % 10 == 1) {
          for (int i = 1; i <= bitsFound / 2 && (watchIndexOpp == -1 || watchIndexSame == -1); i++) {
            if (bits[i] == bits[_B_ + 1 - i]) {
              if (watchIndexSame == -1) {
                watchIndexSame = i;
              }
            } else {
              if (watchIndexOpp == -1) {
                watchIndexOpp = i;
              }
            }
          }
          nextSeekOpp = (watchIndexOpp != -1);
          nextSeekSame = (watchIndexSame != -1);
        }
      }
      if (nextSeekOpp) {
        nextSeekIndex = watchIndexOpp;
      } else if (nextSeekSame) {
        nextSeekIndex = watchIndexSame;
      } else {
        nextSeekIndex = (bitsFound % 2 == 0 ? (bitsFound / 2) + 1 : _B_ - (bitsFound / 2));
      }
      ipValueAtIndex = talkToJudge(nextSeekIndex, bits);
      if (ipValueAtIndex == null) {
        return;
      }
      if (nextSeekOpp) {
        nextSeekOpp = false;
        oppResultMatch = (bits[nextSeekIndex] == ipValueAtIndex.charAt(0) ? 1 : 0);
      } else if (nextSeekSame) {
        nextSeekSame = false;
        sameResultMatch = (bits[nextSeekIndex] == ipValueAtIndex.charAt(0) ? 1 : 0);
      }
      if (!nextSeekOpp && !nextSeekSame && (oppResultMatch != -1 || sameResultMatch != -1)) {
        boolean flip = false;
        boolean rev = false;
        if (oppResultMatch == -1) {
          if (sameResultMatch == 0) {
            flip = true;
          } else {
            // no flip, no rev
          }
        } else if (sameResultMatch == -1) {
          if (oppResultMatch == 0) {
            flip = true;
          } else {
            // no flip, no rev
          }
        } else if (oppResultMatch == 0 && sameResultMatch == 0) {
          flip = true;
        } else if (oppResultMatch == 0 && sameResultMatch == 1) {
          rev = true;
        } else if (oppResultMatch == 1 && sameResultMatch == 0) {
          flip = true;
          rev = true;
        } else if (oppResultMatch == 1 && sameResultMatch == 1) {
          // no flip, no rev
        }
        oppResultMatch = -1;
        sameResultMatch = -1;
        if (flip) {
          for (int i = 1; i <= _B_; i++) {
            if (bits[i] == CHAR_0) {
              bits[i] = CHAR_1;
            } else if (bits[i] == CHAR_1) {
              bits[i] = CHAR_0;
            }
          }
        }
        if (rev) {
          char ch;
          for (int i = 1; i <= _B_ / 2; i++) {
            ch = bits[i];
            bits[i] = bits[_B_ + 1 - i];
            bits[_B_ + 1 - i] = ch;
          }
        }
      } else if (oppResultMatch == -1 && sameResultMatch == -1) {
        bits[nextSeekIndex] = ipValueAtIndex.charAt(0);
        bitsFound++;
      }
    }
    talkToJudge(-1, bits);
  }

  private static String talkToJudge(final int seekIndex, final char[] bits) {
    if (seekIndex == -1) {
      System.out.println(new String(Arrays.copyOfRange(bits, 1, bits.length)));
    } else {
      System.out.println(seekIndex);
    }
    System.out.flush();
    switch (SYS_IN.next()) {
      case RESPONSE_CORRECT:
        return null;
      case RESPONSE_0:
        return RESPONSE_0;
      case RESPONSE_1:
        return RESPONSE_1;
      default:
        SYS_IN.close();
        System.exit(0);
    }
    return null;
  }

}
