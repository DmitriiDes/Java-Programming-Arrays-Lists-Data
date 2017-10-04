<h3>Assignment: Reading Web Logs</h3>

In this assignment you will complete the program to read and print web logs that was described in the lesson.
<p>
You will start with the files provided, which include:
</p><ul><li>
The class LogEntry from the lesson that has five private variables, a constructor, five get methods to access the private fields, and a toString method for printing out a LogEntry.
</li><li>The Class LogAnalyzer, which has been started for you.
</li><li>The Class WebLogParser, which we are providing. You should not edit this file—just use its parseEntry method.
</li><li>The Tester class from the lesson, which has been started for you.
</li></ul>
Specifically, you should do the following:
<ul><li>
In the LogAnalyzer class you will need to complete the constructor to initialize records to an empty ArrayList and complete the readFile method to create a FileResource and to iterate over all the lines in the file. For each line, create a LogEntry and store it in the records ArrayList. (Refer to the lecture on parsing log files for help.)
</li><li>In the Tester class you will need to complete the testLogAnalyzer method, which creates a LogAnalyzer object, calls readFile on the data file short-test_log, and then calls printAll to print all the web logs.
</li></ul>
<p>
Note: if your time zone is different from Durham, USA, you may want to temporarily change the time zone on your computer as the time zone setting of your computer affects the output value from the getAccessTime method.
</p>
