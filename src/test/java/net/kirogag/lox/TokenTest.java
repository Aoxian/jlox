package net.kirogag.lox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TokenTest {
  @Test
  public void aTokenHasAType() {
    TokenType testTokenType = TokenType.STRING;
    String testString = "A string";
    Token testToken = new Token(testTokenType, testString, testString, 1);
    assertEquals(testTokenType, testToken.type);
  }

  @Test
  public void aTokenHasALexeme() {
    String testLexeme = "987654";
    Token testToken = new Token(TokenType.NUMBER, testLexeme, 987654, 1);
    assertEquals(testLexeme, testToken.lexeme);
  }

  @Test
  public void aTokenHasALiteral() {
    double testLiteral = 123456;
    Token testToken = new Token(TokenType.NUMBER, "123456", testLiteral, 1);
    assertEquals(Double.class, testToken.literal.getClass());
    assertEquals(testLiteral, testToken.literal);
  }

  @Test
  public void aTokenHasALineNumber() {
    final int testLine = 10;
    Token testToken = new Token(TokenType.NUMBER, "123456", 123456, testLine);
    assertEquals(testLine, testToken.line);
  }
}
