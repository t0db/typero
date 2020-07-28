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
    
    public int getNumOfCorrectWords() {
        return idxOfCurrentWord;
    }
    
    public void setNumOfCorrectWords(int idxOfCurrentWord) {
        this.idxOfCurrentWord = idxOfCurrentWord;
    }
}
