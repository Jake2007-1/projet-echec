package echecs;

public class Roi extends Piece{
    public Roi(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
