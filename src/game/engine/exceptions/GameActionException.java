package game.engine.exceptions;

import java.io.IOException;

public abstract class GameActionException extends Exception{
    public GameActionException() {
        super();
    }

    public GameActionException(String message) {
        super(message);
    }
}


