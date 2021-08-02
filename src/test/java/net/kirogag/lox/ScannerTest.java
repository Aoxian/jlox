package net.kirogag.lox;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {
  private Token scanFirstToken(String source) {
    Scanner testScanner = new Scanner(source);
    List<Token> tokens = testScanner.scanTokens();
    return tokens.get(0);
  }

  @Test
  public void scanLeftParenToken() {
    String leftParenToken = "(";
    String expectedToken = TokenType.LEFT_PAREN + " " + leftParenToken;

    Token firstToken = scanFirstToken(leftParenToken);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanRightParenToken() {
    String rightParenToken = ")";
    String expectedToken = TokenType.RIGHT_PAREN + " " + rightParenToken;

    Token firstToken = scanFirstToken(rightParenToken);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanLeftBraceToken() {
    String leftBraceToken = "{";
    String expectedToken = TokenType.LEFT_BRACE + " " + leftBraceToken;

    Token firstToken = scanFirstToken(leftBraceToken);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanRightBraceToken() {
    String rightBraceToken = "}";
    String expectedToken = TokenType.RIGHT_BRACE + " " + rightBraceToken;

    Token firstToken = scanFirstToken(rightBraceToken);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanCommaToken() {
    String comma = ",";
    String expectedToken = TokenType.COMMA + " " + comma;

    Token firstToken = scanFirstToken(comma);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanDotToken() {
    String dot = ".";
    String expectedToken = TokenType.DOT + " " + dot;

    Token firstToken = scanFirstToken(dot);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanMinusToken() {
    String minus = "-";
    String expectedToken = TokenType.MINUS + " " + minus;

    Token firstToken = scanFirstToken(minus);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanPlusToken() {
    String plusToken = "+";
    String expectedToken = TokenType.PLUS + " " + plusToken;

    Token firstToken = scanFirstToken(plusToken);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanSemicolonToken() {
    String semicolon = ";";
    String expectedToken = TokenType.SEMICOLON + " " + semicolon;

    Token firstToken = scanFirstToken(semicolon);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanSlashToken() {
    String slash = "/";
    String expectedToken = TokenType.SLASH + " " + slash;

    Token firstToken = scanFirstToken(slash);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanStarToken() {
    String star = "*";
    String expectedToken = TokenType.STAR + " " + star;

    Token firstToken = scanFirstToken(star);

    assertEquals(expectedToken, firstToken.toString());
  }
}
