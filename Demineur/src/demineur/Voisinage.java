/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demineur;



/**
 *
 * @author jules
 */
public class Voisinage {
    
//Attributs
    
    private Case c;
    private Plateau plat;
    
//Constructeur
    
    public Voisinage(Case c){
        this.c = c;
        this.plat = c.getPlateau();
    }
    
//Accesseurs
    
    public Case[] getVoisinage(){
        /*
        renvoie dans tableau de "case" le voisinage de la case 
        */
        int ind = 0;
        Case[] t = new Case[9];
        /*
        On parcours le plateau au niveau du voisinage de la case
        */
        for(int i=this.c.getLigne()-1; i<=this.c.getLigne()+1; i++){
            for(int j=this.c.getColonne()-1; j<=this.c.getColonne()+1 ;j++){
                // si on arrive sur la case elle même, alors on affecte la valeur "null"
                if(i == this.c.getLigne() && j == this.c.getColonne()){
                    t[ind] =  null;
                }
                else
                    t[ind] = this.plat.getCase(i, j);
                ind++;
            }
        }
        return t; // retourne le tableau
    }
    
    public int getNbMines(){
        //Renvoie le nombre de mines dans le voisinage de la case
        int cpt = 0;
        for(int i=this.c.getLigne()-1; i<=this.c.getLigne()+1; i++){
            for(int j=this.c.getColonne()-1; j<=this.c.getColonne()+1 ;j++){
                if(this.plat.getCase(i, j) instanceof Mine)
                    cpt++;
            }
        }
        return cpt;
    }  
    
//Méthodes
    
    public void ActivationVoisinage(){
        /*
        On active une à une les case du voisinage de la cases
        */
        for(int i=this.c.getLigne()-1; i<=this.c.getLigne()+1; i++){
            for(int j=this.c.getColonne()-1; j<=this.c.getColonne()+1 ;j++){
                //On parcours le voisinage
                if(i>=0 && j>=0 && i<this.plat.getLigne() && j<this.plat.getColonne()){
                    /*
                    Avec cette première boucle 'if' on vérifie si i et j correspondent
                    aux coordonnées de d'une cases située dans le plateau. Si oui, alors
                    on active la case dde coordonnées (i, j).
                    */
                    if(this.plat.getCase(i, j).description.equals("["+i+":"+j+"]")){
                        //cette boucle vérifie si la case n'a pas géjà été activée
                        this.plat.getCase(i, j).ActivationCase();           
                    }   
                }     
            }
        }
    }
    
}
