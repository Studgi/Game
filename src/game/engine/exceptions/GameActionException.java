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

class InvalidLaneException extends GameActionException {
    private static final String MSG = "Action done on an invalid lane";

    public InvalidLaneException() {
        super(InvalidLaneException.MSG);
    }

    public InvalidLaneException(String message) {
        super(message);
    }
}

class InsufficientResourcesException extends GameActionException {
    private static final String MSG = "Not enough resources, resources provided = ";
    private int resourcesProvided;

    public int getResourcesProvided(){
        return this.resourcesProvided;
    }

    public void setResourcesProvided(int resourcesProvided){
        this.resourcesProvided = resourcesProvided;
    }

    public InsufficientResourcesException(int resourcesProvided){
        super(MSG + resourcesProvided);
        this.resourcesProvided = resourcesProvided;
    }
    public InsufficientResourcesException(String message, int resourcesProvided){
        super(message);
        this.resourcesProvided = resourcesProvided;
    }
}


class InvalidCSVFormat extends IOException {
    private static final String MSG = "Invalid input detected while reading csv file, input = \n";
    private String inputLine;

    public InvalidCSVFormat(String inputLine) {
        super(MSG + inputLine);
        this.inputLine = inputLine;
    }

    public InvalidCSVFormat(String message, String inputLine) {
        super(message);
        this.inputLine = inputLine;
    }

    public String getInputLine() {
        return inputLine;
    }

    public void setInputLine(String inputLine) {
        this.inputLine = inputLine;
    }
}