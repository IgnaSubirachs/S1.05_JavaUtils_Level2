# Project: S1.05_JavaUtils_Level2

## Description
This project extends the functionality from Level 1 by listing the contents of a directory
and exporting the output to a .txt file. All behaviors are fully parameterized through an external
configuration file using the Apache Commons Configuration library.

## Key Features
- Read input and output parameters from a config.properties file.
- Support for:
    - Recursive directory listing
    - Showing file types (Directory/File)
    - Showing last modified dates
- Export the directory contents to a text file.

## Tools and Libraries Used
- Java Standard Edition
- Apache Commons Configuration 2
- Additional dependencies:
    - commons-lang3
    - commons-logging
    - commons-beanutils
    - commons-text

## Project Structure
```
S1.05_JavaUtils_Level2/
├── config.properties
├── lib/ (external .jar libraries)
├── src/
│   ├── ConfigLoader.java
│   ├── DirectoryExporter.java
│   ├── DirectoryException.java
│   └── Main.java
├── example_directory/ (input sample directory)
├── output/ (generated output files)
├── out/ (compiled .class files)
```

## Compilation
Open terminal at project root and run:
```
javac -cp "lib/*" -d out src/*.java
```

## Execution
Run the project using:
```
java -cp "out;lib/*" Main
```
(Note: Use ";" for Windows, ":" for Linux/Mac when setting classpath.)

## Configuration File (config.properties)
Example:
```
input.directory=example_directory
output.file=output/result.txt
recursive=true
show.type=true
show.lastmodified=true
```

## Notes
- Apache Commons Configuration is used to dynamically load runtime parameters.
- No hardcoded paths or settings exist in the Java code.
- Proper exception handling is implemented with a custom DirectoryException class.
