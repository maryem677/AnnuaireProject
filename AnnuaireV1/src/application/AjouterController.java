package application;
import java.io.IOException;
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
public class AjouterController {
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
	private Button btnAjoutStagiaire;
	
	@FXML
	private TableView<Stagiaire> tview;
	
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException
	
	
	{
		Stage stage;
        Parent root;
        // s'il s'agit du click sur le bouton 'btnAjoutStagiaire' on va ajouter un nouveau stagiaire
		if (event.getSource()==btnAjoutStagiaire)
		{
			String fxnom = nom.getText();
			String fxprenom = prenom.getText();
			String fxpromo = promo.getText();
			String fxdepartement = departement.getText();
			int fxannee = Integer.parseInt(annee.getText());
			
			Stagiaire s = new Stagiaire(fxnom,fxprenom,fxdepartement,fxpromo,fxannee);
			
			//Main.stagiaiares.ajouterNoeud(s);
			
			//On récupére le stage, ou bien le Window(cad le théatre)  à partir de la scène à partir de bouton
            stage = (Stage) btnAjoutStagiaire.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("AnnuaireTview.fxml"));
            //créer une scène à partir de root qui est notre nouveau BorderPane
            Scene scene = new Scene(root,600,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
	}
}