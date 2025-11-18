package echecs;
 public abstract class Piece {
     public enum Couleur {
         NOIR,
         BLANC
     }

     public enum Type {
         PION,
         FOU,
         CAVALIER,
         TOUR,
         REINE,
         ROI
     }

     private Type type;
     private Couleur couleur;

     public Piece (Type type, Couleur couleur) {
         setType(type);
         setCouleur(couleur);
     }

     public Type getType () { return type; }
     public void setType (Type type) { this.type = type; }
     public Couleur getCouleur () { return couleur; }
     public void setCouleur (Couleur couleur) {
        if (couleur != Couleur.NOIR  ||  couleur != Couleur.BLANC)
            throw new IllegalArgumentException("Couleur non-valide");
        this.couleur = couleur;
     }

     /**
     *méthode permettant de calculer la norme mathématique entre deux Positions
     * @param depart Position de départ
     * @param arrivee Position d'arrivée de la Pièce
     * @return la somme des carrés des distances
     *
     */
     public double norme (Position depart, Position arrivee) {
        return Math.pow((depart.getLigne()-arrivee.getLigne()), 2)+ Math.pow((depart.getColonne() - arrivee.getColonne()),2);
     }

     /* méthode abstraite à implémenter dans chacune des sous-classes */
     public abstract boolean estValide (Position depart, Position arrivee);
 }




