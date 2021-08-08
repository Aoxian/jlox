# jlox
[![Java CI with Maven](https://github.com/Aoxian/jlox/actions/workflows/maven.yml/badge.svg)](https://github.com/Aoxian/jlox/actions/workflows/maven.yml)

An implementation of the Lox programing language, from the book [Crafting Interpreters](https://craftinginterpreters.com) by Bob Nystrom.
* This version of jlox is a tree-walk interpreter, written test first.
* Currently, only a scanner has been implemented, and the compiler simply displays the scanned tokens as strings.

## Setup
- For this implementation of jlox, we are using [Maven](https://maven.apache.org) for project management tasks.

## Run
- With no argument, the program will act as a Lox REPL.
- With one argument, a path to a file, the program will interpret the file.
