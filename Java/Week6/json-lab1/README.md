# JSON Lab

# Questions you must answer:
Some of these might require utilizing your Google skills.
1. How can ObjectMapper be used to format a string holding JSON?
1. ObjectMapper belongs to what library?
1. What is the group id, artifact id, and version of the library we are using?
1. What are the files under `src/main/resources/data/1`? What do they represent?
1. How do we indicate that a variable number of arguments can be passed to a method in java?
1. How do we pass a variable number of arguments to a method?
1. Which method in App.java is an example of passing a variable number of arguments to a method?
1. What is a `Path` object in Java?
1. What is a `File` object in Java?
1. What is the `Paths` class for?
1. What is the `Files` class for?
1. How do the jar files know which main method to run?
1. What did `jar tf` show us?
1. Are the Book and Author classes POJOs?
1. Why for the part 1 of lab are you making changes to a code base instead of writing it yourself?

# Part 1
1. Look at some of the files under `src/main/resources/data/1`, mainly the files starting with 550 and 551. See what they contain.
1. Read edu.mccneb.cs.App in its entirety - be able to fully explain what is happening.
1. Change the code to format files 551 instead of 550.
1. Change the code from making a cake to making some other food that you like. Think about what all should change.
1. Open the Terminal tab at the bottom of IntelliJ and run `gradle uberJar` (pressing ctrl + enter instead of just enter for this command), then `java -jar build/libs/json-lab1-uber.jar`
1. To see what's inside the jar, run `jar tf build/libs/json-lab1-uber.jar > toc.txt` then 
examine toc.txt with an editor.

## Part 2: SerializationDemo application
1. Using the `uberJar` task in `build.gradle` as a template, create a new gradle task called `uberSDJar` that builds `json-lab1-SerializationDemo.jar`.
1. Write the class `edu.mccneb.cs.SerializationDemo` with a main method in it.  
This class should build an instance of a Book object and serialize it to JSON using jackson. You can use your favorite book as the book object you create. Write the contents of the book to a new file, making sure it is formatted JSON.
The Book class should have at least these fields:
```
int id;
String title;
List<Author> authors;
```

The Author class should have at least these fields:
```
int id;
String name;
```
