# Tetris Kata #

This kata is intended to simulate a game of [Tetris](https://en.wikipedia.org/wiki/Tetris). 

The point of this kata to to provide a larger than trivial exercise that can be used to practice TDD. A significant portion of the effort will be in determining what tests should be written and, more importantly, written next.  

Considerations:
- Multi-threading should not be a consideration.  This should be done in a single thread.
- Drawing the board is a bonus feature, and is not required in order to solve the problem.
- For the purpose of the kata we do not need a true "game loop".  We simply need to implement the rules in such a way as to advance the game state.
- You do not need to implement these stories in the order in which they are listed.  Part of the complexity of this kata is deciding the order in which to implement the stories.

<pre>
As the game
In order to restrict play area
I want to create a board with dimensions 10 by 24</pre>

The tetris board should be created with 10 columns and 24 rows.  This board is empty to begin with, and will be filled as the game is played based on the placement of pieces by the player.

<pre>As the game
In order to add complexity to the Game
I want different pieces of 4 contiguous blocks</pre>

The player will have the ability to manipulate different pieces during the course of the game.  There are a set number of possible configurations for the pieces, the shapes for which are listed below.  

Pieces:
<pre>
x                    
x           x      x        x    x        x
x    x x    x x    x x    x x    x        x
x    x x    x        x    x      x x    x x</pre>

<pre>As the game
In order to advance the game
I want to create a new piece if no active pieces exist</pre>
At the beginning of the game a new piece will be created at the top center of the board.

<pre>As the game
In order to advance the game
I want to move a piece down the board</pre>
At a regular interval the game will move the active piece one unit towards the bottom of the board.

<pre>As the game
In order to advance the game
I want to stop a piece from advancing further</pre>
If a piece collides with another occupied block that piece will no longer be active and will stop advancing and will retain it's current rotation and previous position.  Concurrently, if a piece collides with the bottom of the board it will also stop advancing (maintaining it's current rotation and previous position).

<pre>As the game
In order to advance the game
I want to clear complete lines</pre>
When a piece comes to rest and it and any part of that piece completes a line (meaning that all 10 columns of that line are now occupied) then that line is cleared, meaning that no columns in that line are now occupied. Multiple lines may be completed at once. 

<pre>As the game
In order to advance the game
I want to collapse cleared lines</pre>
When a line is cleared, then the rows above it move down one unit.  Multiple lines may be affected at once.

<pre>As the player 
In order to place pieces 
I want to rotate pieces</pre>
At every interval the player may decide to rotate the active piece 90 degrees clockwise. Rotation should not be allowed if the rotation would cause any part of the piece to collide with another piece or the edge of the board. Rotation is not required, but in order to complete lines may be necessary.

<pre>As the player 
In order to place pieces
I want to move pieces horizontally</pre>
At every interval the player may decide to move the piece horizontally by one unit. Movement can be left or right unless that movement would cause any part of the piece to collide with another piece or the edge of the board. Movement is not required, but in order to complete lines may be necessary.
 
<pre>As the game
In order to end the game
I want to stop execution when a piece rests above the top of the board</pre>
If pieces have stacked up to the top of the board, if the next active piece comes to rest on top of the board, then the game is over. 

## Additional / Bonus features ##

<pre>As the player
In order to play the game
I want to view the board</pre>
After every interval, print out the state of the board by drawing the board and the active piece location as well as the resting pieces.

<pre>As the player
In order to play the game quickly
I want to move pieces down quickly</pre>
If the player chooses, they can advance the piece down until it collides with the bottom edge of the board or another resting piece.

<pre>As the player
In order to be better than my friends
I want to keep track of my score</pre>
A single line cleared is 100 points. A Tetris (four lines cleared simultaneously) is worth 800. A back-to-back Tetris is worth 1200.
