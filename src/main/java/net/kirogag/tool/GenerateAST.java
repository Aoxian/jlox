package net.kirogag.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class GenerateAST {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.err.println("Usage: generate_ast <output_directory>");
      System.exit(64);
    }
    String outputDir = args[0];
    defineAst(outputDir, "Expression", Arrays.asList(
        "Binary   : Expression left, Token operator, Expression right",
        "Grouping : Expression expression",
        "Literal  : Object value",
        "Unary    : Token operator, Expression right"
    ));
  }

  private static void defineAst(String outputDir, String baseName, List<String> types) throws IOException {
    String path = outputDir + "/" + baseName + ".java";
    PrintWriter writer = new PrintWriter(path, "UTF-8");

    writer.println("package net.kirogag.lox;");
    writer.println();
    writer.println("import java.util.List;");
    writer.println();
    writer.println("abstract class " + baseName + " {");

    // The AST classes.
    for (String type : types) {
      String className = type.split(":")[0].trim();
      String fields = type.split(":")[1].trim();
      defType(writer, baseName, className, fields);
    }
    writer.println("}");
    writer.close();
  }

  private static void defType(PrintWriter writer, String baseName, String className, String fieldList) {
    String[] fields = fieldList.split(", ");

    writer.println();
    writer.println("  static class " + className + " extends " + baseName + " {");

    // Fields
    for (String field : fields) {
      writer.println("    final " + field + ";");
    }

    writer.println();

    // Constructor
    writer.println("    " + className + "(" + fieldList + ") {");
    for (String field :fields) {
      String name = field.split(" ")[1];
      writer.println("      this." + name + " = " + name + ";");
    }

    writer.println("    }");
    writer.println("  }");
  }
}
