# Sandbox

Essayez d'ajouter un ligne dans ce fichier pour tester git.

public abstract class Role {
private String name;
private String id;

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
