package echecs;

public class Fou extends Piece{
    public Fou(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return depart.getColonne() != arrivee.getColonne() && depart.getLigne() != arrivee.getLigne() && (arrivee.getLigne() % 2 == arrivee.getColonne() % 2);
    }
}
