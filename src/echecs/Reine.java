package echecs;

public class Reine extends Piece{
    public Reine(Couleur couleur) {
        super(Type.REINE, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        return  (
                depart.getColonne() == arrivee.getColonne() ||
                depart.getLigne() == arrivee.getLigne() ||
                Math.pow(arrivee.getLigne() - depart.getLigne(),2) == Math.pow(arrivee.getColonne() - depart.getColonne(),2));
    }
}
