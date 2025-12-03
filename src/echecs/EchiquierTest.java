package echecs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EchiquierTest {
  Echiquier e;

  @BeforeEach
  public void setUp () {
    e = new Echiquier ();
    //e.debuter();
    e.getCase(2,0).setPiece(new Reine(Piece.Couleur.NOIR));
    e.getCase(4,0).setPiece(new Pion(Piece.Couleur.BLANC));
    e.getCase(5,0).setPiece(new Tour(Piece.Couleur.BLANC));
    e.getCase(0,1).setPiece(new Tour(Piece.Couleur.NOIR));
    e.getCase(1,1).setPiece(new Pion(Piece.Couleur.NOIR));
    e.getCase(5,2).setPiece(new Fou(Piece.Couleur.NOIR));
    e.getCase(3,3).setPiece(new Cavalier(Piece.Couleur.NOIR));
    e.getCase(1,4).setPiece(new Pion(Piece.Couleur.BLANC));
    e.getCase(4,4).setPiece(new Roi(Piece.Couleur.BLANC));
    e.getCase(7,4).setPiece(new Cavalier(Piece.Couleur.NOIR));
    e.getCase(2,5).setPiece(new Pion(Piece.Couleur.NOIR));
    e.getCase(1,6).setPiece(new Pion(Piece.Couleur.BLANC));
    e.getCase(3,6).setPiece(new Pion(Piece.Couleur.BLANC));
    e.getCase(4,6).setPiece(new Pion(Piece.Couleur.NOIR));
    e.getCase(5,6).setPiece(new Reine(Piece.Couleur.BLANC));
    e.getCase(7,7).setPiece(new Tour(Piece.Couleur.BLANC));
    e.getCase(6,4).setPiece(new Pion(Piece.Couleur.NOIR));
    e.getCase(0,5).setPiece(new Roi(Piece.Couleur.NOIR));
  }


  //test vérifiant qu'un Pion peut se déplacer en ligne droite
  @Test
  public void test1 (){
    Position depart = new Position (4,0);
    Position arrivee = new Position (3,0);
    assertTrue(e.cheminPossible(depart, arrivee));
  }
  
  // test vérifiant qu'une Reine peut capturer une pièce ennemie en ligne droite
  @Test
  public void test2(){
    Position depart = new Position (2,0);
    Position arrivee = new Position (4,0);
    assertTrue(e.cheminPossible(depart, arrivee));
  }
  
  // test vérifiant qu'une Reine ne peut passer au-dessus d'une autre Piece
  @Test
  public void test3(){
    Position depart = new Position (2,0);
    Position arrivee = new Position (5,0);
    assertFalse(e.cheminPossible(depart, arrivee));
  }

  // test vérifiant qu'une Tour  peut capturer une Piece ennemie
  @Test
  public void test4(){
    Position depart = new Position (5,0);
    Position arrivee = new Position (5,2);
    assertTrue(e.cheminPossible(depart, arrivee));
  }

  // test vérifiant qu'un Fou peut se déplacer en diagonale vers une case libre
  @Test
  public void test5(){
    Position depart = new Position (5,2);
    Position arrivee = new Position (3,0);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 

  // test vérifiant qu'un Fou ne peut capturer une piece de m�me couleur
  @Test
  public void test6(){
    Position depart = new Position (5,2);
    Position arrivee = new Position (7,4);
    assertFalse(e.cheminPossible(depart, arrivee));
  } 

  // test vérifiant qu'un Pion  peut se déplacer en ligne droite
  @Test 
  public void test7(){
    Position depart = new Position (1,1);
    Position arrivee = new Position (2,1);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 

  // test vérifiant qu'un Cavalier ne peut capturer une piece de même couleur
  @Test
  public void test8(){
    Position depart = new Position (3,3);
    Position arrivee = new Position (5,2);
    assertFalse(e.cheminPossible(depart, arrivee));
  } 
    // test vérifiant qu'un Cavalier peut se déplacer vers une case vide
  @Test
  public void test9(){
    Position depart = new Position (3,3);
    Position arrivee = new Position (1,2);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 

  // un Cavalier peut capturer une piece ennemie
  @Test
  public void test10(){
    Position depart = new Position (3,3);
    Position arrivee = new Position (1,4);
    assertTrue(e.cheminPossible(depart, arrivee));
  }

    // un Roi peut capturer une Piece ennemie
  @Test
  public void test11(){
    Position depart = new Position (4,4);
    Position arrivee = new Position (3,3);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 

    // test vérifiant qu'un Roi peut se déplacer vers une case vide
  @Test
  public void test12(){
    Position depart = new Position (4,4);
    Position arrivee = new Position (4,5);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 
    // test vérifiant qu'une Reine peut capturer une autre Piece en diagonale
  @Test
  public void test13(){
    Position depart = new Position (5,6);
    Position arrivee = new Position (0,1);
    assertTrue(e.cheminPossible(depart, arrivee));
  }

  // test vérifiant qu'une Reine ne peut pas passer au-dessus d'une autre Piece
  @Test
  public void test14(){
    Position depart = new Position (5,6);
    Position arrivee = new Position (5,1);
    assertFalse(e.cheminPossible(depart, arrivee));
  } 
    // test vérfiiant qu'une Reine peut capturer une Piece ennemie à l'horizontale
  @Test
  public void test15(){
    Position depart = new Position (5,6);
    Position arrivee = new Position (5,2);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 
  
  // test vérfiiant qu'une Reine peut se déplacer vers une case libre
  @Test
  public void test16(){
    Position depart = new Position (5,6);
    Position arrivee = new Position (5,3);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 
  
  // test vérfiiant qu'un Pion ne peut pas capturer une Piece en ligne droite
  @Test
  public void test17(){
    Position depart = new Position (4,6);
    Position arrivee = new Position (5,6);
    assertFalse(e.cheminPossible(depart, arrivee));
  } 
  
  // test vérfiiant qu'une Tour peut se dplacer vers une case vide
  @Test
  public void test18(){
    Position depart = new Position (7,7);
    Position arrivee = new Position (0,7);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 
  
  // une Tour peut se déplacer vers une case vide
  @Test
  public void test19(){
    Position depart = new Position (7,7);
    Position arrivee = new Position (5,7);
    assertTrue(e.cheminPossible(depart, arrivee));
  } 
  
  // test vérfiiant qu'une Piece peut ne pas bouger
  @Test
  public void test20(){
    Position depart = new Position (2,0);
    Position arrivee = new Position (2,0);
    assertTrue(e.cheminPossible(depart, arrivee));
  }
  
  // test vérifiant qu'une reine est bloquée en diagonale
  @Test
  public void test21(){
    Position depart = new Position (2,0);
    Position arrivee = new Position (7,5);
    assertFalse(e.cheminPossible(depart, arrivee));
  }
  
  // test vérifiant qu'un pion ne peut pas capturer une piece en ligne droite, en plus n'a pas la bonne couleur
  @Test
  public void test22(){
    Position depart = new Position (6,4);
    Position arrivee = new Position (7,4);
    assertFalse(e.cheminPossible(depart, arrivee));
  }
  
  // test vérifiant qu'une reine peut se déplacer de plusieurs cases sans obstacle
  @Test
  public void test23(){
    Position depart = new Position (2,0);
    Position arrivee = new Position (2,3);
    assertTrue(e.cheminPossible(depart, arrivee));
  }

  // test vérifiant qu'un Pion ne peut pas se déplacer diagonalement vers une Case libre
//  @Test
//  public void testUn(){
//    Position depart = new Position (1,4);
//    Position arrivee = new Position (0,5);
//    assertTrue(e.captureParUnPionPossible(depart, arrivee));
//  }
//
//  // test vérifiant qu'un Pion ne peut pas se déplacer diagonalement en reculant
//  @Test
//  public void testDeux(){
//    Position depart = new Position (1,4);
//    Position arrivee = new Position (2,5);
//    assertFalse(e.captureParUnPionPossible(depart, arrivee));
//  }
//
//  // test vérifiant qu'un Pion ne peut pas se déplacer diagonalement vers une case vide
//  @Test
//  public void testTrois(){
//    Position depart = new Position (2,5);
//    Position arrivee = new Position (3,4);
//    assertFalse(e.captureParUnPionPossible(depart, arrivee));
//  }
//
//  // test vérifiant qu'un Pion ne peut pas se déplacer diagonalement en reculant
//  @Test
//  public void testQuatre(){
//    Position depart = new Position (1,6);
//    Position arrivee = new Position (2,5);
//    assertFalse(e.captureParUnPionPossible(depart, arrivee));
//  }
//
//  // test vérifiant qu'un Pion ne peut pas se déplacer diagonalement en reculant
//  @Test
//  public void testCinq(){
//    Position depart = new Position (1,6);
//    Position arrivee = new Position (2,7);
//    assertFalse(e.captureParUnPionPossible(depart, arrivee));
//  }
//
//  // test vérifiant qu'un Pion peut capturer une piece ennemie en diagonale
//  @Test
//  public void testSix(){
//    Position depart = new Position (2,5);
//    Position arrivee = new Position (3,6);
//    assertTrue(e.captureParUnPionPossible(depart, arrivee));
//  }
//
//  // test vérifiant qu'un Pion ne peut pas capturer une piece de sa couleur
//  @Test
//  public void testSept(){
//    Position depart = new Position (1,1);
//    Position arrivee = new Position (2,0);
//    assertFalse(e.captureParUnPionPossible(depart, arrivee));
//  }
}