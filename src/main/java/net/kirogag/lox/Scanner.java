package net.kirogag.lox;

import java.util.ArrayList;
import java.util.List;

public class Scanner {
  private final String source;
  private final List<Token> tokens = new ArrayList<>();

  Scanner(String source) {
    this.source = source;
    tokens.add(new Token(source));
  }

  List<Token> scanTokens() {
    return tokens;
  }
}
