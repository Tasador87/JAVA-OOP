package Exercises.FootballTeamGen_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String name){
        this.players.removeIf(player -> player.getName().equals(name));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public double getRating(){
        double rating = 0.0;
        for (Player player : this.players) {
            rating += player.overallSkillLevel();
        }
        return rating / this.players.size();

        //може и така:
        //return this.players.stream().mapToDouble(Player:overallSkillLevel).sum() / this.players.size();
    }
}