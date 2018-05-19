/******************************************************************************
 *  Name:   Chris Bordoy 
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:     Carter Timpson
 *  Partner NetID:    
 *  Partner Precept:  
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/
Programming Assignment 2: Deques and Randomized Queues
/******************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 *****************************************************************************/
 For deque we used the linked list data structure. The linked list data structure seemed
 to be the most efficient for the program's needs which included inserting and removing items
 from both ends of the data structure.
 
 For randomized queue we used the array data structure. The array data structure seemed to be
 the most logical for the program's needs which was to remove an item at random.
/******************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 *****************************************************************************/
Creating the class RandomizedQueue takes up a total of 8N + 28 bytes
    -Class creation or object overhead (16 bytes) + Item[] (8 * N) + 3 int references (12 bytes) = 8N + 28 bytes
 
Randomized Queue:   ~  __8N___  bytes

Creating the class Deque takes up 40 bytes in memory.
    -Object overhead (16 bytes) + int itemsInDeque (4 bytes) + 2 node references (16 bytes) + padding (4 bytes) = 40
Inner class Node = 40 bytes regularly in memory but we are instructed to not include the memory for items so its 32 bytes
    -Inner class object overhead (16 bytes) + 2 node references (16 bytes) = 32 bytes
We then call class Node N times throughout the program so that would be N*32 bytes. This is the most amount of memory
usage in Class Deque

Deque:              ~  __32N__  bytes
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
None that we know of right now.
/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
None.
/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
Both people on this assignment followed the protocols set forward by the assignment page.
Both people put in equal contributions and collaboration to the coding of this assignment.
/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
Chris ran into a very inefficient memory usage problem in RandomizedQueue.java. Wrote a while
loop in the dequeue method which was taking massive amounts of time on runtime. Not a very serious
problem but we decided to opt out from using Sedgewick's StdRandom.shuffle.
/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
 
 This assignment was challenging and fun at the same time. Definitely led to some temporary bouts of frustration
 especially when having to rewrite some portions but it was a learning experience.