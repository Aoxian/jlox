package net.kirogag.lox;

public class Token {

  private final String string;

  public Token(String string) {
    this.string = string;
  }

  public String toString() {
    return string;
  }
}
