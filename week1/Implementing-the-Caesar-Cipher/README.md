</style>
<h2> Assignment 1: Word Play </h2>

You will write a program to transform words from a file into another form, such as replacing vowels with an asterix.
<p>
Specifically, you should do the following.
</p><p>
Create a new class called WordPlay.</p>
<ul>
<li>
Write a method isVowel that has one Char parameter named ch. This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. You should write a tester method to see if this method works correctly. For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.
</li><li>
Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. Be sure to call the method isVowel that you wrote and also test this method.
</li><li>
Write a method emphasize with two parameters, a String named phrase and a character named ch. This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
</li></ul>
<p>
‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or
</p><p>
‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).
</p><p>
For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”. Be sure to test this method.
</p>
<h2> Assignment 2: Caesar Cipher</h2>

You will start with the Caesar Cipher algorithm you learned about in the videos, and you will make some enhancements to it, so that it works with all letters (both uppercase and lowercase) and to make it a little bit harder to decrypt. Write these methods in a CaesarCipher class you can use in the next lesson.
<p>
Specifically, you should do the following:
</p>
<ul><li>
Create a new class called CaesarCipher.
</li><li>
Write the method encrypt that has two parameters, a String named input and an int named key. This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos. Assume that all the alphabetic characters are uppercase letters. For example, the call
encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23) should return the string “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
</li><li>
Write the void method testCaesar that has no parameters. This method should read a file and encrypt the complete file using the Caesar Cipher algorithm, printing the encrypted message. You may want to include the lines:
<div><ul><li>
FileResource fr = new FileResource();
</li><li>
String message = fr.asString();
</li><li>
String encrypted = encrypt(message, key);
</li><li>
System.out.println("key is " + key + "\n" + encrypted);
</li></ul></div>
</li><li>
Modify the encrypt method to be able to handle both uppercase and lowercase letters. For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”. Be sure to test the encrypt method.
</li><li>
Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2. This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to encrypt every other character, starting with the second character. 
<p>For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. Be sure to test this method.</p>
</li></ul>
