package net.kirogag.lox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenTest {
  final String testLexeme = "123456";
  final TokenType testTokenType = TokenType.NUMBER;
  final int testLiteral = 123456;

  @Test
  public void TokenWithLiteralToString() {
    Token testToken = new Token(testTokenType, testLexeme, testLiteral, 1);
    String expectedToString = testTokenType + " " + testLexeme + " " + testLiteral;

    assertEquals(expectedToString, testToken.toString());
  }

  @Test
  public void TokenWithoutLiteralToString() {
    Token testToken = new Token(testTokenType, testLexeme, null, 1);
    String expectedToString = testTokenType + " " + testLexeme;

    assertEquals(expectedToString, testToken.toString());
  }
}
