package at.dropical.server.singleplayer.gamefield;
// Created by julian on 17.11.17.

import java.util.Random;

/**
 * The Game Arena is a 2D-Array that stores which
 * spaces (blocks) in the Tetris game are occupied
 * or empty.<br><br>
 *
 * Axes: arena[h][w]
 *  h=0 is top, h=height is the bottom of the arena.
 *  w=0 is left, w=width is right.
 *
 * The *internal* array is bigger than the actual
 * arena to make it easier doing checks with Tetrominos
 * without getting {@link ArrayIndexOutOfBoundsException}s.
 * The *actual* array is the arena the player sees.
 *
 * The array is int because the transmission protocol uses int.
 * The value 0 means there is no block,
 * the numbers are for the different types of Tetrominos/colors.
 */
public class TetrisArena {
    /** How big the standard arena is. */
    public static final int height = 20;
    public static final int width = 10;

    /** How much free space on the side is. */
    static final int marginLeftRight = 4;
    static final int marginBottom = 4;
    static final int marginTop = 4;
    /** The resulting internal dimensions. */
    static final int internalHeight = height + marginBottom + marginTop;
    static final int internalWidth = width + 2*marginLeftRight;

    /** Axis of the Arena: <br>
     *  Height is the first dimension and goes down,<br>
     *  Width the second and goes to the right.
     *  Therefore, (0|0) is top left. */
    private int[][] arena;

    /** Creates an empty arena. */
    public TetrisArena() {
        arena = new int[TetrisArena.internalHeight][TetrisArena.internalWidth];
    }

    /** Constructor for testing.
     * @param isActual lets you choose if the given arena has the internal
     * size or the actual size. */
    TetrisArena(int[][] arena, boolean isActual) throws IllegalArgumentException {
        if(isActual) {
            fromArray(arena);
        } else {
            // Internal Array
            if(arena.length != internalHeight || arena[0].length != internalWidth)
                throw new IllegalArgumentException("Wrong Dimensions: " + arena.length + "*" + arena[0].length);

            this.arena = arena;
        }
    }

    /** Converts an actual arena to the internal arena. */
    private void fromArray(int[][] newArena) throws IllegalArgumentException {
        if(newArena.length != height || newArena[0].length != width)
            throw new IllegalArgumentException("Wrong Dimensions: "+ newArena.length +"*"+ newArena[0].length);

        this.arena = new int[TetrisArena.internalHeight][TetrisArena.internalWidth];
        for(int h = 0; h < height; h++) {
            // IntelliJ suggest that function. Is the overhead even worth it?
            System.arraycopy(newArena[h], 0, this.arena[h + marginTop], marginLeftRight, width);
        }
    }

    /** Return a 2D Array with the normal dimensions
     * (height*width), that is sent to the client.*/
    public int[][] toArray() {
        int[][] actualArena = new int[height][width];

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                actualArena[h][w] = arena[h+marginTop][w+marginLeftRight];
            }
        }
        
        return actualArena;
    }

    /** Checks if a Tetromino can be placed in a certain position.
     * @param h distance from the upper border of the actual arena.
     *          Can be negative.
     * @param w distance from the left border of the actual arena.
     * @param overTopAllowed should this return true when tetromino is out top?
     * @return false if it's out of bounds or if there are already
     * blocks at those positions. */
    public boolean checkTetromino(Tetromino tetromino, int h, int w, boolean overTopAllowed) {
        int[][] tetrominoArr = tetromino.toArray();
        boolean emptyTetromino = true;
        for(int i = 0; i < Tetromino.size; i++) {
            for(int j = 0; j < Tetromino.size; j++) {
                // Only care if there is a block
                if(tetrominoArr[i][j] >= 1) {
                    emptyTetromino = false;

                    // If space is occupied Or out of bounds of actual arena
                    if(arena[marginTop + h + i][marginLeftRight + w + j] >= 1
                            || w+j < 0    // Out left
                            || w+j >= width // Out right
                            || h+i >= height // Out bottom
                            || !overTopAllowed && (h+i <0))
                            /* Out top is sometimes allowed because the tetromino
                             * has to start falling down from over the top.*/

                        return false; //Stop if one block fails.
                }
            }
        }
        // Only when all 4*4 spaces of the Tetromino are ok.
        // Special case when tetromino is empty, then return false. To prevent endless loops.
        return !emptyTetromino;
    }

    /** First checks, if the place is not obscured and if not,
     * write it into the arena.
     * @return false If the tetromino is in a
     * invalid position. -> Game Over!
     * But this is actually a programming error! */
    public boolean placeTetromino(Tetromino tetromino, int h, int w) {
        // Can it be placed here?
        boolean canBePlaced = checkTetromino(tetromino, h, w, false);
        if(canBePlaced) {
            // Place it.
            int[][] tetrominoArr = tetromino.toArray();
            for(int i = 0; i < Tetromino.size; i++) {
                for(int j = 0; j < Tetromino.size; j++) {
                    arena[marginTop + h + i][marginLeftRight + w + j] += tetrominoArr[i][j];
                }
            }
        }
        return canBePlaced;
    }

    /** Checks if lines are full (every block in a horizontal
     * line != 0) and removes those by moving what's on top
     * downwards.
     * @return number of lines cleared. */
    public int clearLines() {
        int count = 0;
        // From top to bottom.
        for(int h = marginTop; h < marginTop+height; h++) {
            // If one block is empty, the row isn't full.
            boolean completelyFull = true;
            for(int w = marginLeftRight; completelyFull && w < marginLeftRight+width; w++) {
                if(arena[h][w] == 0)
                    completelyFull = false; //And jump out of the for loop.
            }
            // Copy lines above downwards.
            if(completelyFull) {
                copyDown(h);
                count++;
            }
        }
        return count;
    }
    /** Moves the arena downwards.
     * @param lineToOverride includes marginTop. (=internal arena line) */
    private void copyDown(int lineToOverride) {
        /* Start with bottom most column (lineToOverride),
         * end with top most of actual arena. */
        for(int h = lineToOverride; h >= marginTop; h--) {
            //The line that is over the top gets accessed.
            for(int w = marginLeftRight; w < marginLeftRight+width; w++) {
                arena[h][w] = arena[h-1][w];
            }
        }
    }

    /** Copies the arena (starting at "bottom")
     * one blocks upwards.
     * This makes space to insert something at line "bottom".
     * @param bottom: what line. Without margin.
     * @return wherever a block got over the top of
     * the arena. True -> game over!*/
    private boolean copyUp(int bottom) {
        /* Start with top of actual arena,
         * end with bottom. */
        for(int h = marginTop -1; h < marginTop + bottom; h++) {
            //The line that is over the top gets written.
            for(int w = marginLeftRight; w < marginLeftRight+width; w++) {
                arena[h][w] = arena[h+1][w];
            }
        }

        /* Check the line that has been copied over the top. */
        int isThereSomething = 0;
        for(int w = marginLeftRight; w < marginLeftRight+width; w++) {
            isThereSomething += arena[marginTop-1][w];
        }
        // If one block was not 0, returns true.
        return isThereSomething > 0;
    }

    /** Adds uncomplete random lines at the bottom of the arena.
     * This <b>does not adjust the tetromino position!</b>
     * This is for multiplayer.
     * Maybe add a mode with this in singleplayer too?
     * @return wherever a block got over the top of
     * the arena. True -> game over! */
    public boolean addLines(int lineCount) {
        boolean overTop = false;
        Random rand = new Random();

        for(int i = 0; i < lineCount && !overTop; i++) {
            overTop = copyUp(height-1);

            // Make random line with only one hole.
            for(int w = marginLeftRight; w < marginLeftRight+width; w++) {
                arena[marginTop+height-1][w] = rand.nextInt(TetrominoTypes.count) +1;
            }
            // One hole.
            arena[marginTop+height-1][rand.nextInt(width)+marginLeftRight] = 0;
        }

        return overTop;
    }

    /** Only the actual arena. */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = marginTop; i < internalHeight-marginBottom; i++) {
            for(int j = marginLeftRight; j < internalWidth-marginLeftRight; j++) {
                builder.append(arena[i][j]);
            }
            builder.append('\n');
        }

        return builder.toString();
    }
}
