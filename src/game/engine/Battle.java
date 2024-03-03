package game.engine;

import game.engine.base.Wall;
import game.engine.dataloader.DataLoader;
import game.engine.lanes.Lane;
import game.engine.titans.*;
import game.engine.weapons.factory.WeaponFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Battle {

    private static final int[][] PHASES_APPROACHING_TITANS = {
            {PureTitan.TITAN_CODE, PureTitan.TITAN_CODE, PureTitan.TITAN_CODE, AbnormalTitan.TITAN_CODE, PureTitan.TITAN_CODE, ArmoredTitan.TITAN_CODE, ColossalTitan.TITAN_CODE},
            {AbnormalTitan.TITAN_CODE, AbnormalTitan.TITAN_CODE, AbnormalTitan.TITAN_CODE, PureTitan.TITAN_CODE, ArmoredTitan.TITAN_CODE, ArmoredTitan.TITAN_CODE, ColossalTitan.TITAN_CODE},
            {ColossalTitan.TITAN_CODE, ColossalTitan.TITAN_CODE, ColossalTitan.TITAN_CODE, ColossalTitan.TITAN_CODE, ColossalTitan.TITAN_CODE, ColossalTitan.TITAN_CODE, ColossalTitan.TITAN_CODE}
    };
    private static final int WALL_BASE_HEALTH = 10000;

    private int numberOfTurns;
    private int resourcesGathered;
    private BattlePhase battlePhase = BattlePhase.EARLY;
    private int numberOfTitansPerTurn = 1;
    private int score;
    private int titanSpawnDistance;
    private final WeaponFactory weaponFactory = new WeaponFactory();
    private final HashMap<Integer, TitanRegistry> titansArchives;
    private final ArrayList<Titan> approachingTitans = new ArrayList<>();
    private final PriorityQueue<Lane> lanes = new PriorityQueue<>();
    private final ArrayList<Lane> originalLanes = new ArrayList<>();

    public Battle(int numberOfTurns, int score, int titanSpawnDistance, int initialNumOfLanes, int initialResourcesPerLane) throws IOException {
        this.numberOfTurns = numberOfTurns;
        this.numberOfTitansPerTurn =
        this.score = score;
        this.titanSpawnDistance = titanSpawnDistance;
        this.resourcesGathered = initialResourcesPerLane * initialNumOfLanes;
        this.titansArchives = DataLoader.readTitanRegistry();
        // TODO; Initially equal to the value of initial resources per lane * initial number of lanes.
        initializeLanes(initialNumOfLanes);
    }

    public static int[][] getPhasesApproachingTitans() {
        return Battle.PHASES_APPROACHING_TITANS;
    }

    public static int getWallBaseHealth() {
        return Battle.WALL_BASE_HEALTH;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public int getResourcesGathered() {
        return resourcesGathered;
    }

    public void setResourcesGathered(int resourcesGathered) {
        this.resourcesGathered = resourcesGathered;
    }

    public BattlePhase getBattlePhase() {
        return battlePhase;
    }

    public void setBattlePhase(BattlePhase battlePhase) {
        this.battlePhase = battlePhase;
    }

    public int getNumberOfTitansPerTurn() {
        return numberOfTitansPerTurn;
    }

    public void setNumberOfTitansPerTurn(int numberOfTitansPerTurn) {
        this.numberOfTitansPerTurn = numberOfTitansPerTurn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTitanSpawnDistance() {
        return titanSpawnDistance;
    }

    public void setTitanSpawnDistance(int titanSpawnDistance) {
        this.titanSpawnDistance = titanSpawnDistance;
    }
    private void initializeLanes(int numOfLanes){
        for (int i = 0; i < numOfLanes; i++) {
            Lane l = new Lane(new Wall(Battle.WALL_BASE_HEALTH));
            this.lanes.add(l);
            this.originalLanes.add(l);
        }
    }

    public WeaponFactory getWeaponFactory() {
        return this.weaponFactory;
    }

    public HashMap<Integer, TitanRegistry> getTitansArchives() {
        return this.titansArchives;
    }

    public ArrayList<Titan> getApproachingTitans() {
        return this.approachingTitans;
    }

    public PriorityQueue<Lane> getLanes() {
        return this.lanes;
    }

    public ArrayList<Lane> getOriginalLanes() {
        return this.originalLanes;
    }
}
