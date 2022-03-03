package application;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;


import javafx.application.Application;
import javafx.stage.Stage;
import model.Noeud;
import model.Stagiaire;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static Noeud monArbre = new Noeud();
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AnnuaireTview.fxml"));
			Scene scene = new Scene(root,900,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		launch(args);
		


	}
	
	// fonction qui lit un fichier.don et qui ajoute les stagiaire à monAbre
	
	public static void lireFichierDon(String cheminAccesFichierDon) {
		
				
		try {
			FileReader	fr = new FileReader(cheminAccesFichierDon);
			
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				
				String nom = br.readLine();
				String prenom = br.readLine();
				String departement =  br.readLine();
				String promo = br.readLine();
				int annee = Integer.parseInt(br.readLine());
				monArbre.ajouterStagiaire(new Stagiaire(nom,prenom,departement,promo,annee));
				br.readLine();
							
			}
			

			
			br.close();
			fr.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}
	
	// fonction qui ecrit monArbre dans un Fichier.bin
	
	public static void ecrireFichierBinaire(String cheminAccesFichier) {
	
		try {
			RandomAccessFile raf = new RandomAccessFile(cheminAccesFichier, "rw");
			
			raf.writeChars(monArbre.toString());
				
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// fonction qui lit un Fichier.bin et qui ajoute les stagiaire à monArbre
	
	public static void lireFichierBinaire(String cheminAccesFichierBin) {
		
				
		try {
			RandomAccessFile raf = new RandomAccessFile(cheminAccesFichierBin, "rw");
			
			// taille en octet d'un objet Stagiaire ecrit en binaire
			int tailleObjet = 8 + 4 * Stagiaire.TAILLE_MAX_NOM_PRENOM + 4*Stagiaire.TAILLE_MAX_DEP_PROMO;
			
			// nombre d'objets Stagiaire ecrits dans le fichier binaire
			int nbObjetEcrit = (int) raf.length() / tailleObjet;
			
			// boucle for qui parcours le Fichier.bin et qui recupère les donnees des stagiaires
			for(int i =0; i < nbObjetEcrit ; i++) {
				
				String nom = "";
				for(int j = 0; j < Stagiaire.TAILLE_MAX_NOM_PRENOM; j++) {
					nom += raf.readChar();
				}
				String prenom = "";
				for(int j = 0; j < Stagiaire.TAILLE_MAX_NOM_PRENOM; j++) {
					prenom += raf.readChar();
				}
				String departement = "";
				for(int j = 0; j < Stagiaire.TAILLE_MAX_DEP_PROMO; j++) {
					departement += raf.readChar();
				}
				String promo = "";
				for(int j = 0; j < Stagiaire.TAILLE_MAX_DEP_PROMO; j++) {
					promo += raf.readChar();
				}
				String annee = "";
				for(int j = 0; j < 8; j++) {
					annee += raf.readChar();
				}
				
				
				//trim() méthode qui enleve les espaces avant et apres 
				//une chaine de caractère
				nom = nom.trim();
				prenom = prenom.trim();
				departement = departement.trim();
				promo = promo.trim();
				//Stagiaire stagiaireLu = new Stagiaire(nom,prenom,departement,promo,annee);
				//monArbre.ajouterStagiaire(stagiaireLu);
			}
			
			raf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


}
