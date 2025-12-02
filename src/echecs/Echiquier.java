package echecs;

import java.lang.reflect.Type;

public class Echiquier implements MethodesEchiquier {
    private Case[][] echiquier;

    public Echiquier() {
        echiquier = new Case[8][8];
        initCase();
    }

    private void initCase(){
        for(int i = 0; i < 8; i++){
            for (int ii = 0; ii < 8; ii++){
                echiquier[i][ii] = new Case();
            }
        }
    }


    @Override
    public void debuter() {
        for (int i = 0; i < 8; i++) {
            echiquier[1][i].setPiece(new Pion(Piece.Couleur.NOIR));
            echiquier[6][i].setPiece(new Pion(Piece.Couleur.BLANC));
            switch (i){
                case 0:
                case 7:
                    echiquier[0][i].setPiece(new Tour(Piece.Couleur.NOIR));
                    echiquier[7][i].setPiece(new Tour(Piece.Couleur.BLANC));
                    break;
                case 1:
                case 6:
                    echiquier[0][i].setPiece(new Cavalier(Piece.Couleur.NOIR));
                    echiquier[7][i].setPiece(new Cavalier(Piece.Couleur.BLANC));
                    break;
                case 2:
                case 5:
                    echiquier[0][i].setPiece(new Fou(Piece.Couleur.NOIR));
                    echiquier[7][i].setPiece(new Fou(Piece.Couleur.BLANC));
                    break;
                case 3:
                    echiquier[0][i].setPiece(new Reine(Piece.Couleur.NOIR));
                    echiquier[7][i].setPiece(new Reine(Piece.Couleur.BLANC));
                    break;
                case 4:
                    echiquier[0][i].setPiece(new Roi(Piece.Couleur.NOIR));
                    echiquier[7][i].setPiece(new Roi(Piece.Couleur.BLANC));
                    break;
            }

        }
    }

    @Override
    public Case getCase(int ligne, int colonne) {
        return echiquier[ligne][colonne];
    }

    @Override
    public boolean cheminPossible(Position depart, Position arrivee) {
        Case c = getCase(depart.getLigne(), depart.getColonne());
        boolean chemPos = false;
        if(c.getPiece().estValide(depart,arrivee)){
            if (depart.getLigne() ==  arrivee.getLigne() && depart.getColonne() == arrivee.getColonne())
                chemPos = true;
            else{
                Case ca = getCase(arrivee.getLigne(), arrivee.getColonne());
                switch (c.getPiece().getType()){
                    case Piece.Type.PION:
                        Position test = new Position(arrivee.getLigne(),arrivee.getColonne());
                        if (depart.getLigne() + 2 == arrivee.getLigne())
                            test = new Position(arrivee.getLigne() - 1, arrivee.getColonne());
                        if (depart.getLigne() -2 == arrivee.getLigne())
                            test = new Position(arrivee.getLigne() + 1, arrivee.getColonne());
                        Case c1 = getCase(test.getLigne(),test.getColonne());
                        if (c1.estOccupe())
                            break;
                    case Piece.Type.CAVALIER:
                    case Piece.Type.ROI:

                        if(ca.estOccupe())
                            chemPos  = ca.estOccupeCouleur(c.getPiece().getCouleur());
                        else
                            chemPos = true;
                        break;
                    case Piece.Type.TOUR:
                        if (ca.estOccupe())
                            if (ca.estOccupeCouleur(c.getPiece().getCouleur())){

                                for (int i = 0; i < )
                            }

                }


            }
        }
        return  chemPos;

    }

    @Override
    public boolean captureParUnPionPossible(Position depart, Position arrivee) {
        return false;
    }
}
