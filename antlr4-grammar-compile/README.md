# Reference
[Java With ANTLR](https://www.baeldung.com/java-antlr)  
[ANTLR Official Web Site](https://www.antlr.org/)  
[ANTLR v4 Maven plugin](https://www.antlr.org/api/maven-plugin/latest/index.html)  
[Grammars-V4](https://github.com/sleeplotus/grammars-v4)
# ANTLR Shell Hello.g4 Example
## Prepare A Grammar File  
* Hello.g4
```
grammar Hello; // Define a grammar called Hello
r : 'hello' ID ; // match keyword hello followed by an identifier
ID : [a-z]+ ; // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines, \r (Windows)
```
## Generate Java Sources
```
$ antlr4 Hello.g4 # Generate parser and lexer using antlr4 alias from before
$ ll
Hello.g4 
HelloLexer.java 
HelloParser.java
Hello.tokens 
HelloLexer.tokens
HelloBaseListener.java 
HelloListener.java
Hello.interp
HelloLexer.interp
```
## Compile ANTLR-Generated Java Sources Code
```
$ javac *.java # Compile ANTLR-generated code
```
##Create The Listener

# ANTLR Maven Hello.g4 Example
## Maven Configuration
* Add ANTLR Maven Plugin
```
<plugin>
    <groupId>org.antlr</groupId>
    <artifactId>antlr4-maven-plugin</artifactId>
    <version>4.7.1</version>
    <executions>
        <execution>
            <goals>
                <goal>antlr4</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
* Default layout of files of Antlr4 Maven Plugin 
```
By default, the antlr4 goal will search for grammar files in the directory ${basedir}/src/main/antlr4 and any additional .tokens files in the directory ${basedir}/src/main/antlr4/imports. This can be configured to search other directories using the plugin configuration parameters as described in the antlr4 goal documentation.

The following figure shows the expected layout of files for the default configuration of this plugin.

 src/main/
      |
      +--- antlr4/...       .g4 files organized in the required package structure
             |
             +--- imports/  user-created .tokens files and .g4 files that are imported by other grammars
```
## Prepare A Grammar File  
* src/main/antlr4/Hello.g4
```
grammar Hello; // Define a grammar called Hello
r : 'hello' ID ; // match keyword hello followed by an identifier
ID : [a-z]+ ; // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines, \r (Windows)
```
## Generate Java Sources
* Generate Java Source File From Grammar File Only
```
$ mvn org.antlr:antlr4-maven-plugin:4.7.1:antlr4
```
* Generate Java Source File From Grammar File And Compile Them
```
$ mvn compile
```
* Generated Java Sources
```
$ cd target/generated-sources/antlr4
$ ll
Hello.interp  
HelloBaseListener.java  
HelloLexer.java    
HelloListener.java
Hello.tokens  
HelloLexer.interp      
HelloLexer.tokens  
HelloParser.java
```
* Compiled Java Classes
```
$ cd target/classes
$ ll
HelloBaseListener.class  
HelloLexer.class    
HelloListener.class
HelloParser.class
```

