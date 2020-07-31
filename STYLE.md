# Style Guide

1. No lines longer than 120 columns. Try to keep it at 80 columns if you can.

2. Every method should be described in a Javadoc string.

3. Explain your code in comments with clarity. Someone who has never seen it before should know how it works.

4. variables, and method/function names should be lowerCamelCased likeThis pleaseAndThankYou

5. Class names should be UpperCamelCased LikeThis PleaseAndThankYou

6. When printing to the screen for the player please avoid using straight up System.out.print lines.
  - Create an intelligent method that takes the text you want to print and displays it elegantly.
  - This method of course can use System.out.print
  - When constructing multi-line and complex strings to display use the StringBuilder class.
  
7. Do not litter our nice code with unnecessary trash comments at the end of every block like
  - //end if
  - //end for
  - //end while
  - I don't know why some classes teach this garbage. It is an arcane practice and has no place in modern code. Drop the habit today.
  
8. Make use of the many intelligent Java data types when appropriate to simplify our code. 
  - One common example is to use ArrayList instead of regular arrays when having a fixed size and position array isn't the goal.
