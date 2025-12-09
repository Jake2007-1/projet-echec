package echecs;

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class FenetreJeu extends JFrame {
    private Echiquier e;        //echiquier
    private JLabel[][] tab;     //tableau de JLabels

    private JPanel panelControle = new JPanel();    // panel du haut
    private JPanel panelGrille = new JPanel();      // panel du bas (grille)
    GridLayout gridLayout1 = new GridLayout();

    private JButton boutonDebuter = new JButton();
    private JTextField champTexte = new JTextField();
    private JButton boutonReset = new JButton();

    private JPanel panelNoir, panelBlanc; // panels qu'on placera les pieces capturées

    public FenetreJeu() {   // constructeur appelle méthode JBInit
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        tab = new JLabel[8][8];   // création du tableau de JLabel
        e = new Echiquier();      // création de l'échiquier

        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(800, 629));
        this.setTitle("Jeu d'Echecs");
        panelControle.setBounds(new Rectangle(5, 10, 550, 45));
        panelControle.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        panelControle.setLayout(null);
        panelGrille.setBounds(new Rectangle(5, 65, 550, 465));
        panelGrille.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        panelGrille.setLayout(gridLayout1);
        gridLayout1.setColumns(8);
        gridLayout1.setRows(8);
        this.getContentPane().add(panelGrille, null);
        panelControle.add(boutonReset, null);
        panelControle.add(champTexte, null);
        panelControle.add(boutonDebuter, null);
        this.getContentPane().add(panelControle, null);
        boutonDebuter.setBounds(new Rectangle(15, 10, 130, 25));
        boutonDebuter.setText("DEBUTER");
        champTexte.setBounds(new Rectangle(160, 10, 215, 25));
        boutonReset.setText("RESET");
        boutonReset.setBounds(new Rectangle(390, 10, 130, 25));

        // les écouteurs (listners)
        GestionnaireEvenement gest = new GestionnaireEvenement();
        boutonDebuter.addMouseListener(gest);
        boutonReset.addMouseListener(gest);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tab[i][j] = new JLabel();    // cr�ation du JLabel
                panelGrille.add(tab[i][j]);  // ajouter au Panel
                tab[i][j].setOpaque(true);
                tab[i][j].setHorizontalAlignment(SwingConstants.CENTER);  // pour que les pieces apparaissent au centre de la case
                tab[i][j].addMouseListener(gest);  // ajouter l'�couteur aux sources

                // 1. attribuer couleur aux JLabels
                if((i+j) % 2 == 0)
                    tab[i][j].setBackground(Color.lightGray);
                else
                    tab[i][j].setBackground(Color.darkGray);
            }
        }

        //2. deux nouveaux panels pour les pièces capturées
    JPanel pieceBlanc = new JPanel();

    }
    // classe interne privée pour la gestion d'évènements
    private class GestionnaireEvenement extends MouseAdapter {

        Piece pieceTampon;
        ImageIcon iconeTampon;
        int ligneClic;
        int colonneClic;
        Position depart, arrivee;
        Piece.Couleur couleurControle = Piece.Couleur.BLANC;


        public void mouseReleased(MouseEvent eve) {
            // si on clique sur le bouton débuter
            if (eve.getSource() == boutonDebuter) {
                // 3.quoi faire ?
                // attribuer les icones aux JLabels
                champTexte.setText("C'est aux " + couleurControle.toString().toLowerCase() + "s à jouer ");
                for (int i = 0; i < 8; i++) {
                    tab[1][i].setIcon(new ImageIcon("./Icones/PN.gif"));
                    tab[6][i].setIcon(new ImageIcon("./Icones/PB.gif"));
                    switch (i){
                        case 0:
                        case 7:
                            tab[0][i].setIcon(new ImageIcon("./Icones/TN.gif"));
                            tab[7][i].setIcon(new ImageIcon("./Icones/TB.gif"));
                            break;
                        case 1:
                        case 6:
                            tab[0][i].setIcon(new ImageIcon("./Icones/CN.gif"));
                            tab[7][i].setIcon(new ImageIcon("./Icones/CB.gif"));
                            break;
                        case 2:
                        case 5:
                            tab[0][i].setIcon(new ImageIcon("./Icones/FN.gif"));
                            tab[7][i].setIcon(new ImageIcon("./Icones/FB.gif"));
                            break;
                        case 3:
                            tab[0][i].setIcon(new ImageIcon("./Icones/DN.gif"));
                            tab[7][i].setIcon(new ImageIcon("./Icones/DB.gif"));
                            break;
                        case 4:
                            tab[0][i].setIcon(new ImageIcon("./Icones/RN.gif"));
                            tab[7][i].setIcon(new ImageIcon("./Icones/RB.gif"));
                            break;
                    }

                }
            }

            // si on clique sur le bouton reset
            else if (eve.getSource() == boutonReset) {
                //4. votre travail
            } else { // donc on a cliqué sur un JLabel
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (eve.getSource() == tab[i][j]) {
                            ligneClic = i;
                            colonneClic = j;
                        }
                    }
                }
                //5. votre travail

            } // du grand else

        } // de la méthode mouseReleased

    } // de la classe de gestion


    // main pour pouvoir exécuter l'interface graphique
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreJeu frame = new FenetreJeu();
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}