package net.kirogag.lox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {
  @Test
  public void scanTokensTokenizesAStringAsOneToken() {
    String loxStatement = "var language = \"lox\";";
    Scanner testScanner = new Scanner(loxStatement);
    Token firstToken = testScanner.scanTokens().get(0);

    assertEquals(loxStatement, firstToken.toString());
  }
}
