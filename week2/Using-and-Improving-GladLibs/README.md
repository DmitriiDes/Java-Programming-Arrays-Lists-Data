<h1>Using GladLibs</h1>
<h3>Assignment: Verbs and Fruits</h3>
<p>
Run the GladLib.java program that is provided. 
You should also have a data folder with several files. 
This program should generate a story using the file madtemplate.txt, which is also in the data folder. 
This program creates a story by replacing placeholder words such as <noun> by looking for a random word of that type. 
This approach uses multiple private ArrayLists, one for each type of word, to store each type of replacement. 
For example, one ArrayList stores different nouns. 
These nouns are initially read in from a file called noun.txt and stored in the ArrayList named nounList. 
Whenever the templated word <noun> is found in the story, a random noun from the nounList is used in place of <noun>.
</p><p>
You will now modify the GladLib.java file to handle two additional categories—verbs and fruits. Specifically, you should make the following adjustments to your program:
<p><ul><li>
Modify the program to handle replacing verbs with <verb> tags and fruits with <fruit> tags. You will read in choices of verbs from the file verb.txt and choices for fruit from the file fruit.txt. These files are already in the data folder. There are several parts of the program that you will need to modify.
</li><li>
Add private ArrayLists, one for verbs and one for fruits.
</li><li>
Modify the method initializeFromSource to read the data from these two files.
</li><li>Modify the method getSubstitute to handle the replacements of <verb> and <fruit> with random words of those types.
</li><li>Modify the file makeStory to read in the template file madtemplate2.txt that also uses the <verb> and <fruit> tags.
</li><li>Run your program to make sure it works before making additional changes.
</li><li>Now modify your program so that once it uses a word, it never uses that word again. You should declare and initialize an additional private ArrayList to keep track of words that have been seen. HINT: You will need to modify the method processWord. Once it finds a word to use, check to see if that word has been used before or not. You should also be sure that you clear out this new ArrayList in makeStory before each run of your program. The folder datalong with longer data files is provided.
</li><li>Modify your program to print out the total number of words that were replaced right after the story is printed.
</li></ul>
<h1>Improving GladLibs</h1>
<h3>Assignment 1: Codon Count</h3>
<p>
Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames. A strand of DNA is made up of the symbols C, G, T, and A. A codon is three consecutive symbols in a strand of DNA such as ATT or TCC. A reading frame is a way of dividing a strand of DNA into consecutive codons. Consider the following strand of DNA = “CGTTCAAGTTCAA”.
</p>
There are three reading frames.
<ul><li>
The first reading frame starts at position 0 and has the codons: “CGT”, “TCA”, “AGT” and “TCA”. Here TCA occurs twice and the others each occur once.
</li><li>The second reading frame starts at position 1 (ignoring the first C character) and has the codons: “GTT”, “CAA”, “GTT”, “CAA”. Here both GTT and CAA occur twice.
</li><li>The third reading frame starts at position 2 (ignoring the first two characters CG) and has the codons: “TTC”, “AAG”, “TTC”. Here TTC occurs twice and AAG occurs once.
</li></ul><p>A map of DNA codons to the number times each codon appears in a reading frame would be helpful in solving this problem.
</p><p>
Specifically, you should do the following:</p>
<ul><li>
Create a new class for this problem
</li><li>Create a private variable to store a HashMap to map DNA codons to their count.
</li><li>Write a constructor to initialize the HashMap variable.
</li><li>Write a void method named buildCodonMap that has two parameters, an int named start and a String named dna. This method will build a new map of codons mapped to their counts from the string dna with the reading frame with the position start (a value of 0, 1, or 2). You will call this method several times, so make sure your map is empty before building it.
</li><li>Write a method named getMostCommonCodon that has no parameters. This method returns a String, the codon in a reading frame that has the largest count. If there are several such codons, return any one of them. This method assumes the HashMap of codons to counts has already been built.
</li><li>Write a void method named printCodonCounts that has two int parameters, start and end. This method prints all the codons in the HashMap along with their counts if their count is between start and end, inclusive.
</li><li>Write a tester method that prompts the user for a file that contains a DNA strand (could be upper or lower case letters in the file, convert them all to uppercase, since case should not matter). Then for each of the three possible reading frames, this method builds a HashMap of codons to their number of occurrences in the DNA strand, prints the total number of unique codons in the reading frame, prints the most common codon and its count, and prints the codons and their number of occurrences for those codons whose number of occurrences in this reading frame are between two numbers inclusive.
</li></ul><p>For example, for the string above and here: “CGTTCAAGTTCAA,” also in smalldna.txt, if we run our program and print the output requested above and specify to print codons and counts for those codons whose counts are between 1 and 5 inclusive, we might get the output:
</p><p>
Reading frame starting with 0 results in 3 unique codons

and most common codon is TCA with count 2
</p>
Counts of codons between 1 and 5 inclusive are:
<p>
CGT 1
</p><p>
TCA 2
</p><p>
AGT 1
</p><p>
Reading frame starting with 1 results in 2 unique codons

and most common codon is CAA with count 2
</p><p>
Counts of codons between 1 and 5 inclusive are:
</p><p>
CAA 2
</p><p>
GTT 2
</p><p>
Reading frame starting with 2 results in 2 unique codons

and most common codon is TTC with count 2
</p><p>
Counts of codons between 1 and 5 inclusive are:
</p><p>
TTC 2
</p><p>
AAG 1
</p><p>
Note: The convention for text files is to end with a line break, so the above DNA string will have length 13 if directly defined as a String in your tester method, but length 14 if the text file containing it is read in as a FileResource. You can deal with this in several ways. One is to use the String method .trim() (http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#trim() ) to get rid of white space. Another way to guard against identifying the final “AA “ as a codon would be adding a check that requires the last element of each codon be a letter before adding to the codon map.
</p>
<h3>Assignment 2: Words in Files</h3>

Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in.
</p><p>
For example, consider you are given the four files: brief1.txt, brief2.txt, brief3.txt, and brief4.txt.
</p><p>
brief1.txt is:

cats are funny and cute
</p><p>
brief2.txt is:

dogs are silly
</p><p>
brief3.txt is:

love animals cats and dogs
</p><p>
brief4.txt is:

love birds and cats
</p><p>
The greatest number of files a word appears in is three, and there are two such words: “cats” and “and”.
</p><p>
“cats” appears in the files: brief1.txt, brief3.txt, brief4.txt
</p><p>
“and” appears in the files: brief1.txt, brief3.txt, brief4.txt
</p><p>
To solve this problem, you will create a map of words to the names of files they are in. That is, you will map a String to an ArrayList of Strings. Then you can determine which ArrayList value is the largest (has the most filenames) and its key is thus, a word that is in the most number of files.
</p><p>
Specifically, you should do the following:
</p><ul><li>
Create a new class called WordsInFiles. Put all the remaining listed items in this class.
</li><li>Create a private variable to store a HashMap that maps a word to an ArrayList of filenames.
</li><li>Write a constructor to initialize the HashMap variable.
</li><li>Write a private void method named addWordsFromFile that has one parameter f of type File. This method should add all the words from f into the map. If a word is not in the map, then you must create a new ArrayList of type String with this word, and have the word map to this ArrayList. If a word is already in the map, then add the current filename to its ArrayList, unless the filename is already in the ArrayList. You can use the File method getName to get the filename of a file.
</li><li>Write a void method named buildWordFileMap that has no parameters. This method first clears the map, and then uses a DirectoryResource to select a group of files. For each file, it puts all of its words into the map by calling the method addWordsFromFile. The remaining methods to write all assume that the HashMap has been built.
</li><li>Write the method maxNumber that has no parameters. This method returns the maximum number of files any word appears in, considering all words from a group of files. In the example above, there are four files considered. No word appears in all four files. Two words appear in three of the files, so maxNumber on those four files would return 3. This method assumes that the HashMap has already been constructed.
</li><li>Write the method wordsInNumFiles that has one integer parameter called number. This method returns an ArrayList of words that appear in exactly number files. In the example above, the call wordsInNumFiles(3) would return an ArrayList with the words “cats” and “and”, and the call wordsInNumFiles(2) would return an ArrayList with the words “love”, “are”, and “dogs”, all the words that appear in exactly two files.
</li><li>Write the void method printFilesIn that has one String parameter named word. This method prints the names of the files this word appears in, one filename per line. For example, in the example above, the call printFilesIn(“cats”) would print the three filenames: brief1.txt, brief3.txt, and brief4.txt, each on a separate line.
</li><li>Write the void method tester that has no parameters. This method should call buildWordFileMap to select a group of files and build a HashMap of words, with each word mapped to an ArrayList of the filenames this word appears in, determine the maximum number of files any word is in, considering all words, and determine all the words that are in the maximum number of files and for each such word, print the filenames of the files it is in. (optional) If the map is not too big, then you might want to print out the complete map, all the keys, and for each key its ArrayList. This might be helpful to make sure the map was built correctly.
</li></ul>
<h3>Assignment 3: Maps Version of GladLibs</h3>
<ul><li>
Start with your GladLibs program you completed earlier in this lesson. Make a copy of it and call it GladLibMap.java. Now modify this program to use one HashMap that maps word types to ArrayList of possible words to select. Your program should still work for the additional categories verbs and fruits and should not use duplicate words from a category. Specifically, you should make the following adjustments to this program:
</li><li>
Replace the ArrayLists for adjectiveList, nounList, colorList, countryList, nameList, animalList, timeList, verbList, and fruitList with one HashMap myMap that maps a String representing a category to an ArrayList of words in that category. Caution: Don’t replace the ArrayList representing the words that have already been used!
</li><li>Create the new HashMap in the constructors.
</li><li>Modify the method initializeFromSource to create an Array of categories and then iterate over this Array. For each category, read in the words from the associated file, create an ArrayList of the words (using the method readIt), and put the category and ArrayList into the HashMap.
</li><li>Modify the method getSubstitute to replace all the if statements that use category labels with one call to randomFrom that passes the appropriate ArrayList from myMap.
</li><li>Run your program to make sure it works.
</li><li>Write a new method named totalWordsInMap with no parameters. This method returns the total number of words in all the ArrayLists in the HashMap. After printing the GladLib, call this method and print out the total number of words that were possible to pick from.
</li><li>Write a new method named totalWordsConsidered with no parameters. This method returns the total number of words in the ArrayLists of the categories that were used for a particular GladLib. If only noun, color, and adjective were the categories used in a GladLib, then only calculate the sum of all the words in those three ArrayLists. Hint: You will need to keep track of the categories used in solving the GladLib, then compute this total.
</li></ul>
