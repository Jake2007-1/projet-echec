package echecs;

public class Cavalier extends Piece{
    public Cavalier(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
