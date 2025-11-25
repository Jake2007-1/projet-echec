package echecs;

public class Fou extends Piece{
    public Fou(Couleur couleur) {
        super(Type.FOU, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        return Math.pow(arrivee.getLigne() - depart.getLigne(),2) == Math.pow(arrivee.getColonne() - depart.getColonne(),2);
    }
}
