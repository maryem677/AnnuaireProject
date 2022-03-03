package application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Stagiaire;
public class RechercheController {
	@FXML
	private TextField nom;
	
	@FXML
	private TextField prenom;
	
	@FXML
	private TextField departement;
	
	@FXML
	private TextField promo;
	
	@FXML
	private TextField annee;
	
	@FXML
	private Button btnRechercheStagiaire;
	
	@FXML
	private TableView<Stagiaire> tview;
	
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException
	{
		Stage stage;
        Parent root;
        // s'il s'agit du click sur le bouton 'btn' on va ajouter un nouveau produit
		if (event.getSource()==btnRechercheStagiaire)
		{
			
			String fxnom = nom.getText();
			String fxprenom = prenom.getText();
			String fxpromo = promo.getText();
			String fxdepartement = departement.getText();
			String fxannee =(annee.getText());
			
			List<Stagiaire> listeDeRecherche =new ArrayList<>();
			
			Main.monArbre.rechercherParNom(fxnom, listeDeRecherche);
			
			//On récupére le stage, ou bien le Window(cad le théatre)  à partir de la scène à partir de bouton
            stage = (Stage) btnRechercheStagiaire.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("AnnuaireTview.fxml"));
            //créer une scène à partir de root qui est notre nouveau BorderPane
            Scene scene = new Scene(root,600,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
		
	}
	
	
}