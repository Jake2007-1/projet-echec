package echecs;

public class Pion extends Piece{
    public Pion(Couleur couleur) {
        super(Type.PION, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        if (depart.getColonne() != arrivee.getColonne())
            return false;
        if (depart.getLigne() == arrivee.getLigne())
            return true;
        if (depart.getLigne() == (getCouleur() == Couleur.BLANC ? arrivee.getLigne() + 1 : arrivee.getLigne() - 1))
            return true;
        return getCouleur() == Couleur.NOIR ? depart.getLigne() == 1 && arrivee.getLigne() == 3 : depart.getLigne() == 6 && arrivee.getLigne() == 4;
    }
}
