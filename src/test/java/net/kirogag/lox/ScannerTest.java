package net.kirogag.lox;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {
  private void assertTokenEquals(Token token1, Token token2) {
    assertEquals(token1.toString(), token2.toString());
  }

  private Token loxToken(TokenType type, String lexeme){
    return new Token(type, lexeme, null, 1);
  }

  private Token loxToken(TokenType type, String lexeme, Object literal, int line){
    return new Token(type, lexeme, literal, line);
  }

  private Token scanToken(String source) {
    Scanner testScanner = new Scanner(source);
    List<Token> tokens = testScanner.scanTokens();
    return tokens.get(0);
  }

  @Test
  public void scanLeftParenToken() {
    String loxCode = "(";

    assertTokenEquals(loxToken(TokenType.LEFT_PAREN, "("), scanToken(loxCode));
  }

  @Test
  public void scanRightParenToken() {
    String loxCode = ")";

    assertTokenEquals(loxToken(TokenType.RIGHT_PAREN, ")"), scanToken(loxCode));
  }

  @Test
  public void scanLeftBraceToken() {
    String loxCode = "{";

    assertTokenEquals(loxToken(TokenType.LEFT_BRACE, "{"), scanToken(loxCode));
  }

  @Test
  public void scanRightBraceToken() {
    String loxCode = "}";

    assertTokenEquals(loxToken(TokenType.RIGHT_BRACE, "}"), scanToken(loxCode));
  }

  @Test
  public void scanCommaToken() {
    String loxCode = ",";

    assertTokenEquals(loxToken(TokenType.COMMA, ","), scanToken(loxCode));
  }

  @Test
  public void scanDotToken() {
    String loxCode = ".";

    assertTokenEquals(loxToken(TokenType.DOT, "."), scanToken(loxCode));
  }

  @Test
  public void scanMinusToken() {
    String loxCode = "-";

    assertTokenEquals(loxToken(TokenType.MINUS, "-"), scanToken(loxCode));
  }

  @Test
  public void scanPlusToken() {
    String loxCode = "+";

    assertTokenEquals(loxToken(TokenType.PLUS , "+"), scanToken(loxCode));
  }

  @Test
  public void scanSemicolonToken() {
    String loxCode = ";";

    assertTokenEquals(loxToken(TokenType.SEMICOLON, ";"), scanToken(loxCode));
  }

  @Test
  public void scanSlashToken() {
    String loxCode = "/";

    assertTokenEquals(loxToken(TokenType.SLASH, "/"), scanToken(loxCode));
  }

  @Test
  public void scanStarToken() {
    String loxCode = "*";

    assertTokenEquals(loxToken(TokenType.STAR, "*"), scanToken(loxCode));
  }

  @Test
  public void scanBangEqualToken() {
    String loxCode = "!=";

    assertTokenEquals(loxToken(TokenType.BANG_EQUAL, "!="), scanToken(loxCode));
  }

  @Test
  public void scanBangToken() {
    String loxCode = "!";

    assertTokenEquals(loxToken(TokenType.BANG, "!"), scanToken(loxCode));
  }

  @Test
  public void scanEqualEqualToken() {
    String loxCode = "==";

    assertTokenEquals(loxToken(TokenType.EQUAL_EQUAL, "=="), scanToken(loxCode));
  }

  @Test
  public void scanEqualToken() {
    String loxCode = "=";

    assertTokenEquals(loxToken(TokenType.EQUAL, "="), scanToken(loxCode));
  }

  @Test
  public void scanLessEqualToken() {
    String loxCode = "<=";

    assertTokenEquals(loxToken(TokenType.LESS_EQUAL, "<="), scanToken(loxCode));
  }

  @Test
  public void scanLessToken() {
    String loxCode = "<";

    assertTokenEquals(loxToken(TokenType.LESS, "<"), scanToken(loxCode));
  }

  @Test
  public void scanGreaterEqualToken() {
    String loxCode = ">=";

    assertTokenEquals(loxToken(TokenType.GREATER_EQUAL, ">="), scanToken(loxCode));
  }

  @Test
  public void scanGreaterToken() {
    String loxCode = ">";

    assertTokenEquals(loxToken(TokenType.GREATER, ">"), scanToken(loxCode));
  }

  @Test
  public void scanIgnoreCommentsUntilTheEndOfALine() {
    String loxCode = "{ // A comment a plus + token\n}";

    Scanner testScanner = new Scanner(loxCode);
    List<Token> tokens = testScanner.scanTokens();

    assertTokenEquals(loxToken(TokenType.LEFT_BRACE, "{"), tokens.get(0));
    assertTokenEquals(loxToken(TokenType.RIGHT_BRACE, "}"), tokens.get(1));
    assertTokenEquals(loxToken(TokenType.EOF, ""), tokens.get(2));
  }

  @Test
  public void scanIgnoresSpace() {
    String loxCode = " ";

    assertTokenEquals(loxToken(TokenType.EOF, ""), scanToken(loxCode));
  }

  @Test
  public void scanIgnoresReturnToken() {
    String loxCode = "\r";

    assertTokenEquals(loxToken(TokenType.EOF, ""), scanToken(loxCode));
  }

  @Test
  public void scanIgnoresTabToken() {
    String loxCode = "\t";

    assertTokenEquals(loxToken(TokenType.EOF, ""), scanToken(loxCode));
  }

  @Test
  public void scanIgnoresNewLineTokenAndIncreasesLineCount() {
    String loxCode = "{\n}";

    Scanner testScanner = new Scanner(loxCode);
    List<Token> tokens = testScanner.scanTokens();
    Token secondToken = tokens.get(1);

    assertEquals(2, secondToken.line);
  }

  @Test
  public void scanStringLiterals() {
    String loxCode = "\"A string\"";

    assertTokenEquals(loxToken(TokenType.STRING, "\"A string\"", (String) "A string", 1), scanToken(loxCode));
  }

  @Test
  public void scanMultiLineStringLiterals() {
    String loxCode = "\"A\nString\"";

    assertTokenEquals(loxToken(TokenType.STRING, "\"A\nString\"", (String) "A\nString", 1), scanToken(loxCode));
  }

  @Test
  public void scanStringLiteralsDoesNotSupportEscapeSequences() {
    String loxCode = "\"string with a \"quote\"\"";

    Scanner testScanner = new Scanner(loxCode);
    List<Token> tokens = testScanner.scanTokens();

    assertTokenEquals(loxToken(TokenType.STRING, "\"string with a \"", (String) "string with a ", 1), tokens.get(0));
    assertTokenEquals(loxToken(TokenType.IDENTIFIER, "quote", null, 1), tokens.get(1));
  }

  @Test
  public void scanNumberLiteral() {
    String loxCode = "12345";

    assertTokenEquals(loxToken(TokenType.NUMBER, "12345", (double) 12345, 1), scanToken(loxCode));
  }

  @Test
  public void scanNumberCanIncludeFractional() {
    String loxCode = "123.45";

    assertTokenEquals(loxToken(TokenType.NUMBER, "123.45", (double) 123.45, 1), scanToken(loxCode));
  }

  @Test
  public void scanNumberLiteralDoesNotBeginWithADecimal() {
    String loxCode = ".12345";

    Scanner testScanner = new Scanner(loxCode);
    List<Token> tokens = testScanner.scanTokens();

    assertTokenEquals(loxToken(TokenType.DOT, "."), tokens.get(0));
    assertTokenEquals(loxToken(TokenType.NUMBER, "12345", (double) 12345, 1), tokens.get(1));
  }

  @Test
  public void scanNumberLiteralDoesNotEndWithADecimal() {
    String loxCode = "12345.";

    Scanner testScanner = new Scanner(loxCode);
    List<Token> tokens = testScanner.scanTokens();

    assertTokenEquals(loxToken(TokenType.NUMBER, "12345", (double) 12345, 1), tokens.get(0));
    assertTokenEquals(loxToken(TokenType.DOT, "."), tokens.get(1));
  }

  @Test
  public void scanIdentifierLiterals() {
    String loxCode = "foo";

    assertTokenEquals(loxToken(TokenType.IDENTIFIER, "foo"), scanToken(loxCode));
  }

  @Test
  public void scanAndKeyword() {
    String loxCode = "and";

    assertTokenEquals(loxToken(TokenType.AND, "and"), scanToken(loxCode));
  }

  @Test
  public void scanClassKeyword() {
    String loxCode = "class";

    assertTokenEquals(loxToken(TokenType.CLASS, "class"), scanToken(loxCode));
  }

  @Test
  public void scanElseKeyword() {
    String loxCode = "else";

    assertTokenEquals(loxToken(TokenType.ELSE, "else"), scanToken(loxCode));
  }

  @Test
  public void scanFalseKeyword() {
    String loxCode = "false";

    assertTokenEquals(loxToken(TokenType.FALSE, "false"), scanToken(loxCode));
  }

  @Test
  public void scanForKeyword() {
    String loxCode = "for";

    assertTokenEquals(loxToken(TokenType.FOR, "for"), scanToken(loxCode));
  }

  @Test
  public void scanFunKeyword() {
    String loxCode = "fun";

    assertTokenEquals(loxToken(TokenType.FUN, "fun"), scanToken(loxCode));
  }

  @Test
  public void scanIfKeyword() {
    String loxCode = "if";

    assertTokenEquals(loxToken(TokenType.IF, "if"), scanToken(loxCode));
  }

  @Test
  public void scanNilKeyword() {
    String loxCode = "nil";

    assertTokenEquals(loxToken(TokenType.NIL, "nil"), scanToken(loxCode));
  }

  @Test
  public void scanOrKeyword() {
    String loxCode = "or";

    assertTokenEquals(loxToken(TokenType.OR, "or"), scanToken(loxCode));
  }

  @Test
  public void scanPrintKeyword() {
    String loxCode = "print";

    assertTokenEquals(loxToken(TokenType.PRINT, "print"), scanToken(loxCode));
  }

  @Test
  public void scanReturnKeyword() {
    String loxCode = "return";

    assertTokenEquals(loxToken(TokenType.RETURN, "return"), scanToken(loxCode));
  }

  @Test
  public void scanSuperKeyword() {
    String loxCode = "super";

    assertTokenEquals(loxToken(TokenType.SUPER, "super"), scanToken(loxCode));
  }

  @Test
  public void scanThisKeyword() {
    String loxCode = "this";

    assertTokenEquals(loxToken(TokenType.THIS, "this"), scanToken(loxCode));
  }

  @Test
  public void scanTrueKeyword() {
    String loxCode = "true";

    assertTokenEquals(loxToken(TokenType.TRUE, "true"), scanToken(loxCode));
  }

  @Test
  public void scanVarKeyword() {
    String loxCode = "var";

    assertTokenEquals(loxToken(TokenType.VAR, "var"), scanToken(loxCode));
  }

  @Test
  public void scanWhileKeyword() {
    String loxCode = "while";

    assertTokenEquals(loxToken(TokenType.WHILE, "while"), scanToken(loxCode));
  }
}
