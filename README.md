# Arxml sorter assignment using exception handling

## Task Description

Your program should perform the following steps:

- Read an ARXML file that contains a list of containers, each with a unique ID and 
a name sub-container “SHORT-NAME”.

- Reorder the containers alphabetically by their name sub-container “SHORT-NAME”.

- Write the reordered containers to a new ARXML file with the same name as the input file, 
but with “_mod.arxml” appended to it. For example, if the input file is “Rte_Ecuc.arxml”, 
the output file should be “Rte_Ecuc_mod.arxml”

## Requirements:

- The name of the arxml file shall be an argument which needs to passed through the command line.

- If the input file doesn't have an .arxml extension, user-defined exception 
called “NotValidAutosarFileException”.

- If the input file is empty, your program should throw a user-defined exception 
called “EmptyAutosarFileException”.

- The output file shall be named as the same of the input file concatenated with “_mod.arxml”
• e.g. if the input was named “Rte_Ecuc.arxml” then the output should be “Rte_Ecuc_mod.arxml”.

- If any requirement is missing or unclear, you should make reasonable assumptions and 
document them in your code.

## Files used in assignment:

- **LAB6.java**: This is the java code section.

- **emptyfile.arxml**: This is an empty ARXML file for testing the empty file case.

- **testt.arxml**: This is a normal ARXML file for testing the normal case.

- **testing code.bat**: This is a batch file that runs the program with different input files for testing purposes.

## How to run:

To run your program with a single input file, use the following command: `java LAB6.java <your_file>`

For example:
`java LAB6.java testt.arxml`

At the end of code this will create a new file called “testt_mod.arxml” with the containers sorted by order.

To run your program with all the test files provided, use the following command: `testing code.bat`

This will run your program with each of the test files and show the output on the console.
