package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Stagiaire;
public class AnnuaireTviewController implements Initializable {
	
	Stagiaire stagiaire = new Stagiaire(null, null, null, null, 0);
	ObservableList<Stagiaire> StagiaireList = FXCollections.observableArrayList();
	Stage stage;
	Parent root;
	
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
    private TableColumn<Stagiaire, String> edit;
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
		} else if (event.getSource() == print) {
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
	
	
	 @FXML
	    private void refreshTable() {
	        
	            StagiaireList.clear();
	            try {
	    			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/STAGIAIRES.bin", "rw");
	    			if (raf.length()==0) {
	    			Main.lireFichierDon("src/mesFichiers/STAGIAIRES.DON");
	    			}
	    		} catch (FileNotFoundException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		Main.monArbre.parcoursInfixe(StagiaireList, "src/mesFichiers/STAGIAIRES.bin", 0);
	            tview.setItems(StagiaireList);	        
	    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		refreshTable();

		// System.out.println(ProduitList);
		nom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
		departement.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("departement"));
		promo.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
		annee.setCellValueFactory(new PropertyValueFactory<Stagiaire, Integer>("annee"));
       
		//add cell of button edit 
        Callback<TableColumn<Stagiaire, String>, TableCell<Stagiaire, String>> cellFoctory = (TableColumn<Stagiaire, String> param) -> {
           // make cell containing buttons
           final TableCell<Stagiaire, String> cell = new TableCell<Stagiaire, String>() {
               @Override
               public void updateItem(String item, boolean empty) {
                   super.updateItem(item, empty);
                   //that cell created only on non-empty rows
                   if (empty) {
                       setGraphic(null);
                       setText(null);

                   } else {

                       FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                       FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                       deleteIcon.setStyle(
                               " -fx-cursor: hand ;"
                               + "-glyph-size:28px;"
                               + "-fx-fill:Crimson;"
                       );
                       editIcon.setStyle(
                               " -fx-cursor: hand ;"
                               + "-glyph-size:28px;"
                               + "-fx-fill:#00E676;"
                       );
                       deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                    	   
                    	   stagiaire = tview.getSelectionModel().getSelectedItem();
                    	   FXMLLoader loader = new FXMLLoader ();
                           loader.setLocation(getClass().getResource("Supprimer.fxml"));
                           try {
							loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                           SupprimerController supprimerController = loader.getController();
                           supprimerController.stagiaire = stagiaire;
                           Parent parent = loader.getRoot();
                           Stage stage = new Stage();
                           Scene scene = new Scene(parent);
                           scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                           stage.setScene(scene);
                           stage.show();
                           



                       });
                       editIcon.setOnMouseClicked((MouseEvent event) -> {
                           
   

                       });

                       HBox managebtn = new HBox(editIcon, deleteIcon);
                       managebtn.setStyle("-fx-alignment:center");
                       HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                       HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                       setGraphic(managebtn);

                       setText(null);

                   }
               }

           };

           return cell;
       };
        edit.setCellFactory(cellFoctory);
        
		tview.setItems(StagiaireList);
	}
}