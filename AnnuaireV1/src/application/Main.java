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
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static Noeud monArbre = new Noeud();
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AnnuaireTview.fxml"));
			Scene scene = new Scene(root);
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
				monArbre.ajouterUnStagiaire(new Stagiaire(nom,prenom,departement,promo,annee),"src/mesFichiers/STAGIAIRES.bin");
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


}
