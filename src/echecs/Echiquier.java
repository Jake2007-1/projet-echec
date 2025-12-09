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
                    case PION:
                        Position test = new Position(arrivee.getLigne(),arrivee.getColonne());
                        if (depart.getLigne() + 2 == arrivee.getLigne())
                            test = new Position(arrivee.getLigne() - 1, arrivee.getColonne());
                        if (depart.getLigne() -2 == arrivee.getLigne())
                            test = new Position(arrivee.getLigne() + 1, arrivee.getColonne());
                        Case c1 = getCase(test.getLigne(),test.getColonne());
                        if (c1.estOccupe())
                            break;
                        if(ca.estOccupe())
                            break;
                    case CAVALIER:
                    case ROI:
                        if(ca.estOccupe())
                            chemPos  = !ca.estOccupeCouleur(c.getPiece().getCouleur());
                        else
                            chemPos = true;
                        break;
                    case TOUR:
                        chemPos = deplacementLineaire(depart,arrivee,ca,c);
                        break;
                    case  FOU:
                        chemPos = deplacementDiagonal(depart,arrivee,ca,c);
                        break;
                    case REINE:
                        if (Math.pow(arrivee.getLigne() - depart.getLigne(),2) == Math.pow(arrivee.getColonne() - depart.getColonne(),2)) {
                            chemPos = deplacementDiagonal(depart, arrivee, ca, c);
                            break;
                        }
                        else if (depart.getColonne() == arrivee.getColonne() || depart.getLigne() == arrivee.getLigne()){
                            chemPos = deplacementLineaire(depart,arrivee,ca,c);
                            break;
                        }
                }
            }
        }
        return  chemPos;

    }
    public boolean deplacementLineaire(Position depart, Position arrivee, Case ca, Case c){
        boolean chemPos= false;
        boolean toutRegarder = false;
        boolean pieceDansChemin= false;
        Position temp = new Position(depart.getLigne(), depart.getColonne());
        while (!toutRegarder){
            if (temp.getLigne() < arrivee.getLigne())
                temp.setLigne(temp.getLigne() + 1);
            else if (temp.getLigne() > arrivee.getLigne())
                temp.setLigne(temp.getLigne() - 1);
            else if (temp.getColonne() < arrivee.getColonne())
                temp.setColonne(temp.getColonne() + 1);
            else if (temp.getColonne() > arrivee.getColonne())
                temp.setColonne(temp.getColonne() - 1);

            if (temp.getLigne() == arrivee.getLigne() && temp.getColonne() == arrivee.getColonne())
                toutRegarder = true;

            if (!toutRegarder)
                if(getCase(temp.getLigne(), temp.getColonne()).estOccupe()) {
                    pieceDansChemin = true;
                    toutRegarder = true;
                }

        }
        if (!pieceDansChemin)
            if (ca.estOccupe()) {
                if (!ca.estOccupeCouleur(c.getPiece().getCouleur())) {
                    chemPos = true;
                }
            }
            else
                chemPos = true;
        return  chemPos;
    }

    public boolean deplacementDiagonal(Position depart, Position arrivee, Case caseArrive, Case caseDepart){
        boolean chemPos = false;
        int verifC = 0;
        int verifL = 0;
        if (depart.getColonne() < arrivee.getColonne())
            verifC = 1;
        else
            verifC = -1;
        if (depart.getLigne() < arrivee.getLigne())
            verifL = 1;
        else
            verifL = -1;
        boolean toutRegarder = false;
        boolean pieceSurChemin = false;
        Position t = new Position(depart.getLigne(), depart.getColonne());
        while (!toutRegarder){
            t.setColonne(t.getColonne() + verifC);
            t.setLigne(t.getLigne() + verifL);
            if (t.getLigne() == arrivee.getLigne() && t.getColonne() == arrivee.getColonne())
                toutRegarder = true;
            if (!toutRegarder)
                if(getCase(t.getLigne(), t.getColonne()).estOccupe())
                    pieceSurChemin = true;
        }
        if (!pieceSurChemin && toutRegarder){
            if (caseArrive.estOccupe()) {
                if (!caseArrive.estOccupeCouleur(caseDepart.getPiece().getCouleur())) {
                    chemPos = true;
                }
            } else
                chemPos = true;
        }
        return chemPos;
    }

    @Override
    public boolean captureParUnPionPossible(Position depart, Position arrivee) {
        Case cd = new Case(getCase(depart.getLigne(), depart.getColonne()).getPiece());
        Case ca = new Case(getCase(arrivee.getLigne(), arrivee.getColonne()).getPiece());

        int direction;
        if (cd.getPiece().getCouleur().equals(Piece.Couleur.BLANC)) {
            direction = -1;
        } else {
            direction = 1;
        }

        int diffLigne = arrivee.getLigne() - depart.getLigne();
        int diffColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (diffLigne == direction && diffColonne == 1) {
            if (ca.estOccupe()) {
                return !ca.estOccupeCouleur(cd.getPiece().getCouleur());
            }
        }
        return false;
    }

//    @Override
//    public String toString(){
//        String board = "";
//        for (int li)
//    }
}
