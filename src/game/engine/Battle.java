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
    private BattlePhase battlePhase;
    private int numberOfTitansPerTurn;
    private int score;
    private int titanSpawnDistance;
    private final WeaponFactory weaponFactory;
    private final HashMap<Integer, TitanRegistry> titansArchives;
    private final ArrayList<Titan> approachingTitans;
    private final PriorityQueue<Lane> lanes;
    private final ArrayList<Lane> originalLanes;

    public Battle(int numberOfTurns, int score, int titanSpawnDistance, int initialNumOfLanes, int initialResourcesPerLane) throws IOException {
        this.numberOfTurns = numberOfTurns;
        this.resourcesGathered = initialResourcesPerLane * initialNumOfLanes;
        this.battlePhase = BattlePhase.EARLY;
        this.numberOfTitansPerTurn = 1;
        this.score = score;
        this.titanSpawnDistance = titanSpawnDistance;
        this.weaponFactory = new WeaponFactory();
        this.titansArchives = DataLoader.readTitanRegistry();
        this.approachingTitans = new ArrayList<>();
        this.lanes = new PriorityQueue<>();
        this.originalLanes = new ArrayList<>();
        initializeLanes(initialNumOfLanes);
    }

    public static int[][] getPhasesApproachingTitans() {
        return Battle.PHASES_APPROACHING_TITANS;
    }

    public static int getWallBaseHealth() {
        return Battle.WALL_BASE_HEALTH;
    }

    public int getNumberOfTurns() {
        return this.numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public int getResourcesGathered() {
        return this.resourcesGathered;
    }

    public void setResourcesGathered(int resourcesGathered) {
        this.resourcesGathered = resourcesGathered;
    }

    public BattlePhase getBattlePhase() {
        return this.battlePhase;
    }

    public void setBattlePhase(BattlePhase battlePhase) {
        this.battlePhase = battlePhase;
    }

    public int getNumberOfTitansPerTurn() {
        return this.numberOfTitansPerTurn;
    }

    public void setNumberOfTitansPerTurn(int numberOfTitansPerTurn) {
        this.numberOfTitansPerTurn = numberOfTitansPerTurn;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTitanSpawnDistance() {
        return titanSpawnDistance;
    }

    public void setTitanSpawnDistance(int titanSpawnDistance) {
        this.titanSpawnDistance = Math.max(titanSpawnDistance, 0);
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
