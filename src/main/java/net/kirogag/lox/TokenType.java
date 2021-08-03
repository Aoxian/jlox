package net.kirogag.lox;

public enum TokenType {
  // Single-character tokens.
  LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
  COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, STAR,

  // One or two character tokens.
  BANG, BANG_EQUAL,
  EQUAL, EQUAL_EQUAL,
  LESS, LESS_EQUAL,
  GREATER, GREATER_EQUAL,

  // Literals.
  STRING, NUMBER,

  EOF
}
