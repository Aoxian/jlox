package net.kirogag.lox;

import java.util.ArrayList;
import java.util.List;

public class Scanner {
  private final String source;
  private final List<Token> tokens = new ArrayList<>();
  private ErrorReporter errorReporter = (line, message) -> { };;

  Scanner(String source) {
    this.source = source;
  }

  Scanner(String source, ErrorReporter errorReporter) {
    this.source = source;
    this.errorReporter = errorReporter;
  }

  List<Token> scanTokens() {
    scanToken(source);
    return tokens;
  }

  private void scanToken(String source) {
    char c = source.charAt(0);
    switch (c) {
      case '(': addToken(TokenType.LEFT_PAREN, c); break;
      case ')': addToken(TokenType.RIGHT_PAREN, c); break;
      case '{': addToken(TokenType.LEFT_BRACE, c); break;
      case '}': addToken(TokenType.RIGHT_BRACE, c); break;
      case ',': addToken(TokenType.COMMA, c); break;
      case '.': addToken(TokenType.DOT, c); break;
      case '-': addToken(TokenType.MINUS, c); break;
      case '+': addToken(TokenType.PLUS, c); break;
      case ';': addToken(TokenType.SEMICOLON, c); break;
      case '/': addToken(TokenType.SLASH, c); break;
      case '*': addToken(TokenType.STAR, c); break;
      default:
        errorReporter.error(1, String.format("Unexpected character: \"%s\"", c));
        break;
    }
  }

  private void addToken(TokenType type, char c) {
    String text = Character.toString(c);
    tokens.add(new Token(type, text, null, 1));
  }
}
