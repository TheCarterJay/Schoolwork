/******************************************************************************
 *  Name: Carter Timpson
 *
 *  Partner Name: Marcell Romero
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
The firstIndexOf() method has a while loop that looks for the middle of the array.
Then it uses that value to compare it and see if its less than or greater than.
According to the boolean result, we make it the start or end of the array. 	

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: The O(N) is the big O, it goes through the argument array once to copy it to the private field.

allMatches(): The O(N) is the big O because it goes through the entire length of the matchingTerms.

numberOfMatches(): The O(1) is the big O because it doesn't have to loop. 




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
	There are no known bugs or limitations.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
	No help was received. 

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
	No serious problems were encountered.

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
	Marcell and Carter both followed the protocol as described on the assignment page.
	
	Marcell contributed heavily to both the Term and BinarySearchDeluxe classes, Carter 
	contributed heavily to the Autocomplete class.






/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/