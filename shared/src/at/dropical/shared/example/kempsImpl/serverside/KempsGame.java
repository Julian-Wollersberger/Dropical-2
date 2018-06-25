package at.dropical.shared.example.kempsImpl.serverside;

import at.dropical.shared.example.kempsImpl.serverside.gamestates.GameState;

import java.util.ArrayList;
import java.util.List;

public class KempsGame {
    private List<KempsUser> users=new ArrayList<>();
    private GameState state;


    private void addUser(KempsUser user){
        users.add(user);
    }


}
