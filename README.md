# Tic-Tac-Toe

Play Tic-Tac-Toe! The game is implemented using JavaFX. Note that the project was built through `Maven`.
The pom.xml file has been included should you wish to run the project in this way.

The game follows standard Tic-Tac-Toe rules:
1. Connecting three squares in a row, column, or diagonal wins the game.
2. The game ends in a draw if all squares are selected without a winner.

## UI

Currently the project UI is quite crude. I may improve the styling, but it is not a high priority. The primary goal was to implement the
game in such a way that it can be played from start to finish with:

1. No bugs
2. Correct results (e.g. win, loss, draw)

## Possible Future Updates
- Add a button to restart the game
- Refactor code that determines if a player has won the game (see below)
- Improve UI styling


## Identifying a Winner

Whether a player has won is currently checked using a brute force algorithm. The`Coordinates` class is used to identify which squares a
player has selected. The `GameState` contains a multidimensional array whose subarrays consist of the possible winning coordinates. The
`GameState` compares player selections to the possible winning coordinates to identify a winner.

#### Alternative methods for identifying a winner
I also considered using a graph whose nodes contain information about each player selection. A node could contain the following information:

- A `Coordinates` object indicating the location of the selected square
- Which player selected the square (X or O)
- Adjacent squares selected (by either player)
  - 

A winner could be identified by counting the number of connected nodes belong to a particular player. Alternatively nodes could be linked
in such a way that identifying a cycle from one player would indicate that said player had won the game.

While this seemed like an interesting application of graphs, it felt like overkill for this task. It required the creation of an additional
node class and it was unclear how the graph implementation may affect performance. That said, I may return to implement it as an 
exercise.

