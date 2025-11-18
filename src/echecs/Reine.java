package echecs;

public class Reine extends Piece{
    public Reine(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
