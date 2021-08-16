package net.kirogag.lox;

import java.util.List;

abstract class Expression {

  static class Binary extends Expression {
    final Expression left;
    final Token operator;
    final Expression right;

    Binary(Expression left, Token operator, Expression right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
    }
  }

  static class Grouping extends Expression {
    final Expression expression;

    Grouping(Expression expression) {
      this.expression = expression;
    }
  }

  static class Literal extends Expression {
    final Object value;

    Literal(Object value) {
      this.value = value;
    }
  }

  static class Unary extends Expression {
    final Token operator;
    final Expression right;

    Unary(Token operator, Expression right) {
      this.operator = operator;
      this.right = right;
    }
  }
}
