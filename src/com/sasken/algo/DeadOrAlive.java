package com.sasken.algo;

import java.util.HashSet;
import java.util.Set;

public class DeadOrAlive {

  public static boolean isDead(int xAlien, int yAlien, Set<Integer> xSet, Set<Integer> ySet, int x, int y) {
    // if both x and y cord has enemy he is dead if he moves either on x or y
    if (xSet.contains(xAlien) && ySet.contains(yAlien)) {
      return true;
    } else if (xSet.contains(xAlien)) {
      return xSet.contains(xAlien + 1 > x ? x : xAlien + 1) && xSet.contains(xAlien - 1 < 0 ? 0 : xAlien - 1);
    } else if (ySet.contains(yAlien)) {
      return ySet.contains(yAlien + 1 > y ? y : yAlien + 1) && ySet.contains(yAlien - 1 < 0 ? 0 : yAlien - 1);
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Reader reader = new Reader();

    int x = reader.nextInt();
    int y = reader.nextInt();

    int n = reader.nextInt();

    Set<Integer> xSet = new HashSet<>();
    Set<Integer> ySet = new HashSet<>();

    for (int i = 0; i < n; i++) {
      int xCord = reader.nextInt();
      int yCord = reader.nextInt();

      xSet.add(xCord);
      ySet.add(yCord);
    }

    int xAlien = reader.nextInt();
    int yAlien = reader.nextInt();

    if (isDead(xAlien, yAlien, xSet, ySet, x, y)) {
      System.out.println("DEAD!");
    } else {
      System.out.println("ALIVE!");
    }
  }
}
