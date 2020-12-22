package models;

import javax.websocket.Session;


public class Player {
    private Session session;
    private int idxOfCurrentWord;
    
    public Player(Session session) {
        this.session = session;
        idxOfCurrentWord = 0;
    }
    
    public Session getSession() {
        return session;
    }
    
    public void setSession(Session seesion) {
        this.session = seesion;
    }
    
    public int getIdxOfCurrentWord() {
        return idxOfCurrentWord;
    }
    
    public void increaseIndex() {
        this.idxOfCurrentWord += 1;
    }
}
