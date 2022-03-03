package model;
import java.util.ArrayList;
import java.util.List;
public class Noeud {
    private Stagiaire stagiaire;
    private Noeud filsGauche;
    private Noeud filsDroit;
    
    public Noeud(Stagiaire stagiaire) {
        super();
        this.stagiaire = stagiaire;
    }
    
    
    
    public Noeud() {
		super();
	}



	public Stagiaire getStagiaire() {
        return stagiaire;
    }
    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }
    public Noeud getFilsGauche() {
        return filsGauche;
    }
    public void setFilsGauche(Noeud filsGauche) {
        this.filsGauche = filsGauche;
    }
    public Noeud getFilsDroit() {
        return filsDroit;
    }
    public void setFilsDroit(Noeud filsDroite) {
        this.filsDroit = filsDroite;
    }
    public String toString() {
        if (this.filsGauche != null) {
            if (this.filsDroit != null) {
                return "" + this.filsGauche + " " + this.stagiaire + " " + this.filsDroit;
            } else {
                return "" + this.filsGauche + " " + this.stagiaire;
            }
        } else {
            if (this.filsDroit != null) {
                return "" + this.stagiaire + " " + this.filsDroit;
            } else {
                return "" + this.stagiaire;
            }
        }
    }
    public void ajouterStagiaire(Stagiaire stagiaireAjouter) {
        if (this.stagiaire==null) {
            this.stagiaire=stagiaireAjouter;
        }
        if (this.stagiaire.getNom().compareTo(stagiaireAjouter.getNom()) <= 0) {
            if (this.filsDroit == null) {
                this.setFilsDroit(new Noeud(stagiaireAjouter));
            } else {
                this.filsDroit.ajouterStagiaire(stagiaireAjouter);
            }
        } else if (this.stagiaire.getNom().compareTo(stagiaireAjouter.getNom()) > 0) {
            if (this.filsGauche == null) {
                this.setFilsGauche(new Noeud(stagiaireAjouter));
            } else {
                this.filsGauche.ajouterStagiaire(stagiaireAjouter);
            }
        }
    }
    // recherche par nom
    public List<Stagiaire> rechercherParNom(String nomRecherche,List <Stagiaire>list) {
        if (this.stagiaire.getNom().equals(nomRecherche)) {
            list.add(this.stagiaire);
            //System.out.println(listRecherche);
        }
        if ((this.stagiaire.getNom().compareTo(nomRecherche) <= 0) && this.filsDroit != null) {
            return this.filsDroit.rechercherParNom(nomRecherche,list);
        } else if ((this.stagiaire.getNom().compareTo(nomRecherche) > 0) && this.filsGauche != null) {
            return this.filsGauche.rechercherParNom(nomRecherche,list);
        } else {
            return list;
        }
    }
        
    // recherche par prenom
    
    
    public List<Stagiaire> rechercherParPrenom(String prenomRecherche,List <Stagiaire>list){
      if (this.stagiaire.getPrenom().equals(prenomRecherche)) {
          list.add(this.stagiaire);
          
          } 
      if (this.filsDroit!=null && this.filsGauche!=null) {
           this.filsDroit.rechercherParPrenom(prenomRecherche,list); 
           this.filsGauche.rechercherParPrenom(prenomRecherche,list); }
     else if (this.filsDroit!=null && this.filsGauche==null) {
         return this.filsDroit.rechercherParPrenom(prenomRecherche,list); }
     else if (this.filsDroit==null && this.filsGauche!=null) {
         return this.filsGauche.rechercherParPrenom(prenomRecherche,list); }
         return list;
    
}
    public List<Stagiaire> rechercherParDepartement(String DepartementRecherche,List <Stagiaire>list){
          if (this.stagiaire.getDepartement().equals(DepartementRecherche)) {
              list.add(this.stagiaire);
              } 
          if (this.filsDroit!=null && this.filsGauche!=null) {
               this.filsDroit.rechercherParDepartement(DepartementRecherche,list); 
               this.filsGauche.rechercherParDepartement(DepartementRecherche,list); }
         else if (this.filsDroit!=null && this.filsGauche==null) {
             return this.filsDroit.rechercherParDepartement(DepartementRecherche,list); }
         else if (this.filsDroit==null && this.filsGauche!=null) {
             return this.filsGauche.rechercherParDepartement(DepartementRecherche,list); }
             return list;
        
    }
    public List<Stagiaire> rechercherParPromo(String promoRecherche,List <Stagiaire>list){
          if (this.stagiaire.getPromo().equals(promoRecherche)) {
              list.add(this.stagiaire);
              } 
          if (this.filsDroit!=null && this.filsGauche!=null) {
               this.filsDroit.rechercherParPromo(promoRecherche,list); 
               this.filsGauche.rechercherParPromo(promoRecherche,list); }
         else if (this.filsDroit!=null && this.filsGauche==null) {
             return this.filsDroit.rechercherParPromo(promoRecherche,list); }
         else if (this.filsDroit==null && this.filsGauche!=null) {
             return this.filsGauche.rechercherParPromo(promoRecherche,list); }
             return list;
        
    }
    public List<Stagiaire> rechercherParAnnee(int promoAnnee,List <Stagiaire>list){
          if (this.stagiaire.getAnnee()==(promoAnnee)) {
              list.add(this.stagiaire);
              } 
          if (this.filsDroit!=null && this.filsGauche!=null) {
               this.filsDroit.rechercherParAnnee(promoAnnee,list); 
               this.filsGauche.rechercherParAnnee(promoAnnee,list); }
         else if (this.filsDroit!=null && this.filsGauche==null) {
             return this.filsDroit.rechercherParAnnee(promoAnnee,list); }
         else if (this.filsDroit==null && this.filsGauche!=null) {
             return this.filsGauche.rechercherParAnnee(promoAnnee,list); }
             return list;
        
    }
public Noeud supprimerNoeud(Stagiaire stagiaireASupprimer) {
        
        if (this.stagiaire == stagiaireASupprimer) {
            return this.supprimerRacine();
        } else if (this.stagiaire.getNom().compareTo(stagiaireASupprimer.getNom())>=0) {    
            if (this.filsGauche!=null) {
                this.filsGauche = this.filsGauche.supprimerNoeud(stagiaireASupprimer);  
            }
            return this;
        } else {
            if (this.filsDroit!=null) {
                this.filsDroit = this.filsDroit.supprimerNoeud(stagiaireASupprimer);    
            }
            return this;
        }
}
public Noeud noeudSuccesseur() {
    
    Noeud noeudCourant = this.filsDroit;
    while (noeudCourant.filsGauche != null) {
        
        noeudCourant= noeudCourant.filsGauche;
    }
    
    return noeudCourant;
}
public Noeud supprimerRacine() {        
    
    //pas de descendant
    if ((this.filsDroit == null) && (this.filsGauche == null)) {
        return null;    
    } 
    //un seul descendant
    else if ((this.filsDroit == null) && (this.filsGauche != null)){
        return this.filsGauche;
    } else if ((this.filsDroit != null) && (this.filsGauche == null)){
        return this.filsDroit;
    } 
    //deux descendants
    else {
        this.stagiaire = this.noeudSuccesseur().stagiaire;
        this.filsDroit = this.filsDroit.supprimerNoeud(this.noeudSuccesseur().stagiaire);
        return this;
    }
    
    
}
public void modifier (Stagiaire stagiaireModifier) {
    
    List<Stagiaire> list1 =new ArrayList<>();
     this.rechercherParNom(stagiaireModifier.getNom(),list1);
    supprimerNoeud(list1.get(0));
    this.ajouterStagiaire(stagiaireModifier);
}
	
public List<Stagiaire> conversionEnListe(List<Stagiaire> listeRetournee){
	
	if (this.stagiaire != null){	
		if ((this.filsDroit != null)&&(this.filsGauche != null)){
			this.filsGauche.conversionEnListe(listeRetournee);
			listeRetournee.add(this.stagiaire);
			this.filsDroit.conversionEnListe(listeRetournee);					
		} else if ((this.filsDroit == null)&&(this.filsGauche != null)) {
			this.filsGauche.conversionEnListe(listeRetournee);
			listeRetournee.add(this.stagiaire);					
		} else if ((this.filsDroit != null)&&(this.filsGauche == null)){
			listeRetournee.add(this.stagiaire);
			this.filsDroit.conversionEnListe(listeRetournee);
		} else {
			listeRetournee.add(this.stagiaire);
		}
	}
	return listeRetournee;
}

}
