package net.kirogag.lox;

import org.junit.jupiter.api.Disabled;
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

  @Test
  public void scanBangEqualToken() {
    String bang_equal = "!=";
    String expectedToken = TokenType.BANG_EQUAL + " " + bang_equal;

    Token firstToken = scanFirstToken(bang_equal);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanBangToken() {
    String bang = "!";
    String expectedToken = TokenType.BANG + " " + bang;

    Token firstToken = scanFirstToken(bang);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanEqualEqualToken() {
    String equal_equal = "==";
    String expectedToken = TokenType.EQUAL_EQUAL + " " + equal_equal;

    Token firstToken = scanFirstToken(equal_equal);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanEqualToken() {
    String equal = "=";
    String expectedToken = TokenType.EQUAL + " " + equal;

    Token firstToken = scanFirstToken(equal);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanLessEqualToken() {
    String less_equal = "<=";
    String expectedToken = TokenType.LESS_EQUAL + " " + less_equal;

    Token firstToken = scanFirstToken(less_equal);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanLessToken() {
    String less = "<";
    String expectedToken = TokenType.LESS + " " + less;

    Token firstToken = scanFirstToken(less);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanGreaterEqualToken() {
    String greater_equal = ">=";
    String expectedToken = TokenType.GREATER_EQUAL + " " + greater_equal;

    Token firstToken = scanFirstToken(greater_equal);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanGreaterToken() {
    String greater = ">";
    String expectedToken = TokenType.GREATER + " " + greater;

    Token firstToken = scanFirstToken(greater);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanIgnoreCommentsUntilTheEndOfALine() {
    String loxCode = "{ // A comment a plus + token\n}";

    Scanner testScanner = new Scanner(loxCode);
    List<Token> tokens = testScanner.scanTokens();

    assertEquals(TokenType.LEFT_BRACE, tokens.get(0).type);
    assertEquals(TokenType.RIGHT_BRACE, tokens.get(1).type);
    assertEquals(TokenType.EOF, tokens.get(2).type);

  }

  @Test
  public void scanIgnoresSpace() {
    String space = " ";
    String expectedToken = TokenType.EOF.toString();

    Token firstToken = scanFirstToken(space);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanIgnoresReturnToken() {
    String returnToken = "\r";
    String expectedToken = TokenType.EOF.toString();

    Token firstToken = scanFirstToken(returnToken);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanIgnoresTabToken() {
    String tabToken = "\t";
    String expectedToken = TokenType.EOF.toString();

    Token firstToken = scanFirstToken(tabToken);

    assertEquals(expectedToken, firstToken.toString());
  }

  @Test
  public void scanIgnoresNewLineTokenAndIncreasesLineCount() {
    String loxCodeWithNewLine = "{\n}";

    Scanner testScanner = new Scanner(loxCodeWithNewLine);
    List<Token> tokens = testScanner.scanTokens();

    Token secondToken = tokens.get(1);

    assertEquals(TokenType.RIGHT_BRACE, secondToken.type);
    assertEquals(2, secondToken.line);
  }
}
