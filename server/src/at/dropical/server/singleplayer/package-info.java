// Created by julian on 27.06.18.
/**
 * <h1>Rules of Tetris</h1>
 * The **gamefield** ([TetrisArena][at.htlwels.it.wollersbergerjulian.tetris.server.gamefield.TetrisArena])
 * is a rectangular area where the [Tetrominos][at.htlwels.it.wollersbergerjulian.tetris.server.gamefield.Tetromino]
 * get placed with the following rules:<br></br><br></br>
 *
 * **Going** down: The first Tetromino appears at the
 * very top and falls downwards. When it arrives
 * at the bottom or falls onto another existing
 * Tetromino, it gets placed in that position, and
 * another Tetromino appears at the top.<br></br><br></br>
 *
 * The **player** controls the Tetromino that is falling
 * down. It can be moved to the left, right or
 * down, but not upwards. It can also be rotated
 * by 90° clockwise (but not counterclockwise
 * the teacher said).<br></br><br></br>
 *
 * A **Tetromino** consists of four blocks that are
 * connected. There are 7 different possible
 * arrangements ([TetrominoTypes][at.htlwels.it.wollersbergerjulian.tetris.server.gamefield.TetrominoTypes]).<br></br><br></br>
 *
 * The **Goal of the game** is to fit the
 * Tetrominos together without gaps. If an entire
 * horizontal line is full, it gets cleared
 * and lines above fall down.<br></br><br></br>
 *
 * If the **player makes mistakes** (covers
 * a gap) he/she needs to clear the line above
 * before he/she can fill the gap.<br></br><br></br>
 *
 * The **game ends** when the player makes
 * so many mistakes that the gamefield is almost
 * filled to the top so that a new Tetromino immediately
 * collides with the ones that are already there.<br></br><br></br>
 *
 * The game **makes fun** because the Tetrominos
 * fall down automatically slowly at the beginning
 * but the more lines you clear the faster it gets. TODO
 * You then have less time to react and you
 * realy can't think anymore what to and then
 * mistakes come and the game over is unavoidable.
 *
 * You get **points** for clearing lines and
 * the score gets saved.
 */
package at.dropical.server.singleplayer;