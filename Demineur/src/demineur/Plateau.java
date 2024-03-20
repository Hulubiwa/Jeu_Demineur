/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demineur;

import java.util.ArrayList;

/**
 *
 * @author jules
 */
public class Plateau {
    
//Attributs
    
    private int NbCV;   //nombre de case vide
    private int NbM; // nombre de mines
    private int lig, col; //pour la dimensions du plateau
    private Case[][] tab;    //Grille du plateau 
    private boolean termine;    // vérifie si  le jeu est terminé
    private boolean gagne;   // vérifie si le joueur a gagné
    private Jeu jeu;
    
//Constructeur
    
    public Plateau(Jeu j, int lig, int col){
        this.col = col;
        this.lig = lig;
        this.jeu = j;
        this.tab = new Case[lig][col];
        this.NbCV = this.jeu.getNbCaseVide();
        this.NbM = this.jeu.getNbMines();
        this.termine = false;
        this.gagne = true;
        initPlateau();  // initialisation du plateau de jeu
    }
    
//Accesseurs en lecture (get)
    
    public Case getCase(int l, int c){
        // renvoie la case se situant à la ligne l et la colonne c
        if(l<0 || c<0 || c>this.col-1 || l>this.lig-1)
            return null;
        else
            return this.tab[l][c];
        
    }
    
    public int getLigne(){
        // renvoie le nombre de ligne
        return this.lig;
    }
    
    public int getColonne(){
        //renvoie le nombre de colonne
        return this.col;
    }

    public boolean getTermine() {
        /*
        renvoie
            - true : le jeu est terminé
            - false : le jeu n'est pas terminé
        */
        return termine;
    }

    public boolean getGagne() {
        /*
        renvoie
            - true : le joueur a gagné
            - false : le joueur a perdu
        */
        return gagne;
    }
    
    public int getNbCaseVide(){
        //renvoie le nombre de cases vides
        return this.NbCV;
    }
    
    public int getNbMine(){
        //renvoie le nombre mines
        return this.NbM;
    }
    
//Accesseurs en écriture (set)
    
    public void setTermine(boolean f){
        // modifie l'état du jeu, c'est-à-dire s'il est terminé ou pas
        this.termine = f;
    }
    
    public void setGagne(boolean g){
        //modifie le statut du joueur, i.e. s'il est gagnt ou perdant
        this.gagne = g;
    }
    
    public void setCase(int i,int j, Case k){
        //remplace la case de coordonnées (i, j) par la case k
        this.tab[i][j]= k;
    }
    
    public void setNbCasevide(int cv){
        // modifie le nombre de case vide
        this.NbCV = cv;
    }
    
//Méthodes
    
    public void initPlateau(){
        /*
        Cette méthode initialise le plateau de jeu. Elle crée un plateau de case
        vides, elle prend ensuite des coordonnées aléatoire, elle vérifie si la case
        avec ces coordonées est une case vide afin de la remplacer par une mine.
        */
        int nbmines = getNbMine();  // nombre de mines
        /*
            On créer un plateau de cases vides. Ensuite on génère aléatoirement 
            des coordonnées, puis si les coordonnées correspondent à celle d'une 
            case vide, alors on remplace la case vide par une mine. On effectuera 
            cette action en fonction du nombre de mines.
        */
        for(int i=0; i<this.lig; i++){
            for(int j=0; j<this.col; j++){
                // Création d'un plateau de cases vides
                Case c = new CaseVide(this, i, j);
                setCase(i, j, c);
            }
        }
        do{
            //génération de coordonnées alétoires
            int alea1 = (int)(Math.random()*this.lig);
            int alea2 = (int)(Math.random()*this.col);
            //on vérifie la nature de la case 
            if(this.tab[alea1][alea2] instanceof CaseVide){
                // On remplace la case vide par une mine
                this.setCase(alea1,alea2, new Mine(this, alea1, alea2));
                nbmines--;
            }
        }while(nbmines>0);
    }
    
    public void DevoilePlateau(){
        // méthode qui permt d'afficher le plateau avec les dernières modifications 
        for(int i=0; i<this.lig; i++){
            for(int j=0; j<this.col; j++){
                System.out.print(""+this.tab[i][j].getDescription());
            }
            System.out.println();
        }
    }
    

}
