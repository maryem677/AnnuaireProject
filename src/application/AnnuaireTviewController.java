package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Stagiaire;
public class AnnuaireTviewController implements Initializable {
	@FXML
	private TableView<Stagiaire> tview;
	@FXML
	private Button search;
	@FXML
	private Button add;
	@FXML
	private Button change;
	@FXML
	private Button delete;
	@FXML
	private Button print;
	@FXML
	private TableColumn<Stagiaire, String> nom;
	@FXML
	private TableColumn<Stagiaire, String> prenom;
	@FXML
	private TableColumn<Stagiaire, String> departement;
	@FXML
	private TableColumn<Stagiaire, String> promo;
	@FXML
	private TableColumn<Stagiaire, Integer> annee;
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == search) {
			// System.out.println("Clicked");
			// On récupére le stage, ou bien le Window(cad le théatre) à partir de la scène
			// à partir de bouton
			stage = (Stage) search.getScene().getWindow();
			// root = FXMLLoader.load(getClass().getResource("ListProduit.fxml"));
			root = FXMLLoader.load(getClass().getResource("Recherche.fxml"));
			// créer une scène à partir de root qui est notre nouveau AnchorPane
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		else if (event.getSource() == add) {
			// System.out.println("Clicked");
			// On récupére le stage, ou bien le Window(cad le théatre) à partir de la scène
			// à partir de bouton
			stage = (Stage) search.getScene().getWindow();
			// root = FXMLLoader.load(getClass().getResource("ListProduit.fxml"));
			root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
			// créer une scène à partir de root qui est notre nouveau AnchorPane
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		else if (event.getSource() == change) {
			// System.out.println("Clicked");
			// On récupére le stage, ou bien le Window(cad le théatre) à partir de la scène
			// à partir de bouton
			stage = (Stage) search.getScene().getWindow();
			// root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
			root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
			// créer une scène à partir de root qui est notre nouveau AnchorPane
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		else if (event.getSource() == delete) {
			// System.out.println("Clicked");
			// On récupére le stage, ou bien le Window(cad le théatre) à partir de la scène
			// à partir de bouton
			stage = (Stage) search.getScene().getWindow();
			// root = FXMLLoader.load(getClass().getResource("Supprimer.fxml"));
			root = FXMLLoader.load(getClass().getResource("Supprimer.fxml"));
			// créer une scène à partir de root qui est notre nouveau AnchorPane
			Scene scene = new Scene(root, 800, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		else if (event.getSource() == print) {
			// System.out.println("Clicked");
			// On récupére le stage, ou bien le Window(cad le théatre) à partir de la scène
			// à partir de bouton
			stage = (Stage) search.getScene().getWindow();
			// root = FXMLLoader.load(getClass().getResource("Imprimer.fxml"));
			root = FXMLLoader.load(getClass().getResource("Imprimer.fxml"));
			// créer une scène à partir de root qui est notre nouveau AnchorPane
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Stagiaire> StagiaireList = FXCollections.observableArrayList();
		Main.lireFichierDon("src/mesFichiers/STAGIAIRES.DON");
		System.out.println(Main.monArbre);
		Main.monArbre.conversionEnListe(StagiaireList);

		// System.out.println(ProduitList);
		nom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
		departement.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("departement"));
		promo.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
		annee.setCellValueFactory(new PropertyValueFactory<Stagiaire, Integer>("annee"));

		tview.setItems(StagiaireList);
	}
}