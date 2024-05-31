Java-project
Implementation requirements:

The source image is BMP (file) – 24bit BMP – RGB
For processing, only algorithms and/or low-level code sequences are used (the use of processing methods other than those written in the theme is not accepted)
It includes all OOP concepts - encapsulation, inheritance, polymorphism, abstraction
The source code absolutely respects all "Coding standards". The source code is commented
Work operations with files
Input operations from the keyboard and through command line parameters for the assignment of input files, parameters / settings / execution options and for the assignment of output files
The application must be multimodular (classification with hierarchies - even with a cost in processing time). At least 3 levels of inheritance
Includes varargs
Includes constructors
It includes at least one initialization block and one static initialization block
Include Interface (with a class that implements it)
It includes Abstract Classes with abstract methods and concrete classes that extend abstract classes
Includes exception handling
The package contains 2 packages: Package 1 contains the test application, package 2 contains the rest of the classes
The application contains Producer-Consumer with the following requirements: a. a new thread is assigned to read the source image from the file - Producer Thread. Enter Not Runnable after reading each quarter (1/4) of information b. a new thread (Consumer Thread) is assigned to consume the information provided by the Producer Thread. "multithread communication" (notify) is used. c. Output to the console and sleep (1000) are inserted to highlight the communication stages. d. Synchronization elements are used to protect against possible interference with other possible threads e. After finishing the consumption of all the source image information, processing begins
