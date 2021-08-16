package net.kirogag.lox;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AstPrinterTest {
  private static AstPrinter astPrinter;

  @BeforeAll
  static void setup() {
    astPrinter = new AstPrinter();
  }

  @Test
  public void printsBinaryExpression() {
    Expression expression = new Expression.Binary(
        new Expression.Literal(1),
        new Token(TokenType.PLUS, "+", null, 1),
        new Expression.Literal(2)
    );

    assertEquals("(+ 1 2)", astPrinter.print(expression));
  }

  @Test
  public void printsGroupingExpression() {
    Expression expression = new Expression.Grouping(
        new Expression.Literal(123.45)
    );

    assertEquals("(group 123.45)", astPrinter.print(expression));
  }

  @Test
  public void printsNumberLiteralExpression() {
    Expression expression = new Expression.Literal(123.45);

    assertEquals("123.45", astPrinter.print(expression));
  }

  @Test
  public void printsStringLiteralExpression() {
    Expression expression = new Expression.Literal("string literal");

    assertEquals("string literal", astPrinter.print(expression));
  }

  @Test
  public void printsEmptyLiteralExpressionAsNil() {
    Expression expression = new Expression.Literal(null);

    assertEquals("nil", astPrinter.print(expression));
  }

  @Test
  public void printsUnaryExpression() {
    Expression expression = new Expression.Unary(
        new Token(TokenType.MINUS, "-", null, 1),
        new Expression.Literal(1)
    );

    assertEquals(("(- 1)"), astPrinter.print(expression));
  }

  @Test
  public void printsCanHandleExpressionsInAST() {
    Expression expression = new Expression.Binary(
        new Expression.Unary(
            new Token(TokenType.MINUS, "-", null, 1),
            new Expression.Literal(123)
        ),
        new Token(TokenType.STAR, "*", null, 1),
        new Expression.Grouping(
            new Expression.Literal(45.67)
        )
    );

    assertEquals("(* (- 123) (group 45.67))", astPrinter.print(expression));
  }
}