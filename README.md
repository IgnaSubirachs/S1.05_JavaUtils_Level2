# Project: S1.05_JavaUtils_Level2

## Description
This project extends the functionality from Level 1 by listing the contents of a directory
and exporting the output to a `.txt` file. All behaviors are fully parameterized through an external
Java `.properties` configuration file.

## Key Features
- Read input and output parameters from a `config.properties` file.
- Supports:
  - Recursive directory listing
  - Showing file types (Directory/File)
  - Showing last modified dates
- Export the directory contents to a text file.

## Tools and Libraries Used
- Java Standard Edition (SE)
- Java `Properties` class for configuration loading (no external libraries)

## Project Structure
```
S1.05_JavaUtils_Level2/
├── src/
│   ├── ConfigReader.java
│   ├── DirectoryUtils.java
│   ├── DirectoryExporter.java
│   ├── DirectoryException.java
│   ├── ParametrizedExporter.java
│   └── Main.java
├── config/
│   └── config.properties
├── test-directory/ (sample input structure)
├── output/ (generated output files)
├── out/ (compiled .class files)
```

## Compilation
Open terminal at the root of the project and run:
```bash
javac -d out src/*.java
```

## Execution
Run the project using:
```bash
java -cp out Main config/config.properties
```

## Configuration File (`config.properties`)
Example configuration:
```properties
input.directory=test-directory
output.file=output/result.txt
```

## Notes
- The Java `Properties` API is used to load settings at runtime.
- There are no hardcoded paths in the source code.
- Errors are handled using a custom `DirectoryException` class.
