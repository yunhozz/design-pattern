package behavior.memento;

import java.util.ArrayList;
import java.util.List;

// Memento class to store the state of the Game
class GameMemento {
    private final String level;
    private final int score;

    public GameMemento(String level, int score) {
        this.level = level;
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
}

// Originator class representing the Game
class Game {
    private String level;
    private int score;
    private GameMemento gameMemento;

    public void set(String level, int score) {
        this.level = level;
        this.score = score;
        System.out.println("Game state set to - Level: " + level + ", Score: " + score);
    }

    public GameMemento save() {
        return new GameMemento(level, score);
    }

    public void restore(GameMemento memento) {
        this.level = memento.getLevel();
        this.score = memento.getScore();
        System.out.println("Game state restored to - Level: " + level + ", Score: " + score);
    }
}

// Caretaker class to manage game mementos
class GameCaretaker {
    private final List<GameMemento> mementoList = new ArrayList<>();

    public void add(GameMemento state) {
        mementoList.add(state);
    }

    public GameMemento get(int index) {
        return mementoList.get(index);
    }
}

// Main class to demonstrate the Memento pattern in a game
class GameDemo {
    public static void main(String[] args) {
        Game game = new Game();
        GameCaretaker caretaker = new GameCaretaker();

        // Set initial game state
        game.set("Level 1", 100);
        caretaker.add(game.save());

        // Change game state
        game.set("Level 2", 200);
        caretaker.add(game.save());

        // Change game state again
        game.set("Level 3", 300);

        // Restore previous game states
        game.restore(caretaker.get(1)); // Restores to Level 2, Score 200
        game.restore(caretaker.get(0)); // Restores to Level 1, Score 100
    }
}