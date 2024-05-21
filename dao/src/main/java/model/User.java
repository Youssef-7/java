package model;

public class User {
    protected int id;
    protected String pseudo;
	private String mot_de_passe;


    public User() {}

    public User(String pseudo) {
        super();
        this.pseudo = pseudo;
    }

    public User(int id, String pseudo) {
        super();
        this.id = id;
        this.pseudo = pseudo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return pseudo;
    }
    public void setName(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getMotDePasse() {
        return mot_de_passe;
    }

    public void setMotDePasse(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}