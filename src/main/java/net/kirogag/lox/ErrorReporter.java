package net.kirogag.lox;

public interface ErrorReporter {
  public void error(int line, String message);
}
