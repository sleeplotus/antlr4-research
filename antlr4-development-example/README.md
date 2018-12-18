# Reference
[Java With ANTLR](https://www.baeldung.com/java-antlr)  
# Maven Configuration
* Add ANTLR Runtime Dependency
```
<dependency>
    <groupId>org.antlr</groupId>
    <artifactId>antlr4-runtime</artifactId>
    <version>4.7.1</version>
</dependency>
```
# Exception Correction
## File size exceeds configured limit (2.56MB), code insight features not available
* Go To IDEA > Help > Edit Custom Properties...
* Add The Following Content
```
# Maximum file size (kilobytes) IDE should provide code assistance for.
idea.max.intellisense.filesize=60000

# Maximum file size (kilobytes) IDE is able to open.
idea.max.content.load.filesize=60000
```
* Save And Restart All IDEA's Windows