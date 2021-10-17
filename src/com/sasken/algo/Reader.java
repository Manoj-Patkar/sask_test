package com.sasken.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reader {

  BufferedReader br;
  StringTokenizer tk;


  public Reader() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public String next() {
    while (tk == null || !tk.hasMoreElements()) {
      try {
        tk = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return tk.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Integer.parseInt(next());
  }

  public float nextFloat() {
    return Float.parseFloat(next());
  }

  public double nextDouble() {
    return Double.parseDouble(next());
  }
}
