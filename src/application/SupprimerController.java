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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Stagiaire;
public class SupprimerController {

    @FXML
    private Button no;

    @FXML
    private Button yes;
   
    Stagiaire stagiaire = new Stagiaire(null, null, null, null, 0);
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == yes) {
			
     	Main.monArbre.suppressionNoeud(stagiaire, "src/mesFichiers/STAGIAIRES.bin", 0);
     	   
		
		 stage = (Stage) yes.getScene().getWindow();
	         root = FXMLLoader.load(getClass().getResource("AnnuaireTview.fxml"));
	     stage.close();
		}
		
		if (event.getSource() == no) {
			 stage = (Stage) no.getScene().getWindow();
			 stage.close();
		}
	}
}