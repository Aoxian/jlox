package net.kirogag.lox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenTest {
  @Test
  public void aTokenIsJustAString() {
    String testString = "Something";
    Token token = new Token(testString);
    assertEquals(Token.class, token.getClass());
    assertEquals(testString, token.toString());
  }
}
