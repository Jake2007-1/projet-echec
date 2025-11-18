package echecs;

public class Pion extends Piece{
    public Pion(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
