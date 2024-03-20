/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demineur;

/**
 *
 * @author jules
 */
public abstract class Case {
    
    //Cette classe est une superclasse de CaseVide et Mine
    
//Attributs 
    
    protected Plateau P;
    protected int lig, col; // coordonnées de la cases
    protected String description;
    /*
    Quand la case n'est pas activée sa description est "[l:c]", avec l et c 
    correspondant à ces coordonnées.
    */
    
    
//Constructeur
    
    public Case(Plateau pl, int l, int c){
        this.P = pl;
        this.col = c;
        this.lig = l;
        this.description = "["+ this.lig+":"+this.col+"]";
        
    }
    
//Accessseurs
    
    public int getLigne(){
        // renvoie la ligne de la case
        return this.lig;
    }
    
    public int getColonne(){
        //renvoie la colonne de la case
        return this.col;
    }
    
    public Plateau getPlateau(){
        //renvoie le plateau
        return this.P;
    }
    
    public String getDescription(){
        //renvoie la desciption de la case
        return this.description;
    }
 
    public void setDescription(String d){
        // modifie la description de la case
        this.description = d;
    }
    
    
//Méthodes
    
    public abstract void ActivationCase();
   
}
