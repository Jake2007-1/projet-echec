package echecs;

public class Roi extends Piece{
    public Roi(Couleur couleur) {
        super(Type.ROI, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        return  (
                (depart.getColonne() + 1 == arrivee.getColonne() && depart.getLigne() == arrivee.getLigne()) ||
                (depart.getColonne() - 1 == arrivee.getColonne() && depart.getLigne() == arrivee.getLigne()) ||
                (depart.getLigne() + 1 == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne()) ||
                (depart.getLigne() - 1 == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne()) ||
                (depart.getLigne() + 1 == arrivee.getLigne() && depart.getColonne() + 1 == arrivee.getColonne()) ||
                (depart.getLigne() - 1 == arrivee.getLigne() && depart.getColonne() - 1 == arrivee.getColonne()) ||
                (depart.getLigne() - 1 == arrivee.getLigne() && depart.getColonne() + 1 == arrivee.getColonne()) ||
                (depart.getLigne() + 1 == arrivee.getLigne() && depart.getColonne() - 1 == arrivee.getColonne()));
    }
}
