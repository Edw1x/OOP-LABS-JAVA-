
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainController implements Initializable 
{

    @FXML private TableView<Album> tableView;
    
    @FXML private TableColumn<Album, String> nameColumn;
    
    @FXML private TableColumn<Album, String> genreColumn;
    
    @FXML private TableColumn<Album, String> peformerColumn;
    
    @FXML private TableColumn<Album, LocalDate> dateColumn;
    
    @FXML private TableColumn<Album, String> descriptionColumn;
    
    @FXML private TableColumn<Album, String> durationColumn;
    
    @FXML private TableColumn<Album, String> typeColumn;
    
    @FXML private TableColumn<Album, String> contestColumn;
    
    @FXML private TableColumn<Album, String> placeColumn;
    
    @FXML private TextField nameTextField;
    
    @FXML private TextField genreTextField;
    
    @FXML private TextField peformerTextField;
    
    @FXML private DatePicker dateTextField;
    
    @FXML private TextField descriptionTextField;
    
    @FXML private TextField durationTextField;
    
    @FXML private TextField typeTextField;
    
    @FXML private TextField contestTextField;
    
    @FXML private TextField placeTextField;
    
    
    @FXML
    private MenuBar fileMenu;
    
    @SuppressWarnings("rawtypes")
	public void changeName(CellEditEvent edittedCell)
    {
        Album nameSelected =  tableView.getSelectionModel().getSelectedItem();
        
        nameSelected.setName(edittedCell.getNewValue().toString());
    }
    
    @SuppressWarnings("rawtypes")
	public void changeGenre(CellEditEvent edittedCell)
    {
        Album genreSelected =  tableView.getSelectionModel().getSelectedItem();
        
        genreSelected.setGenre(edittedCell.getNewValue().toString());
    }
    
    @SuppressWarnings("rawtypes")
	public void changePeformer(CellEditEvent edittedCell)
    {
        Album peformerSelected =  tableView.getSelectionModel().getSelectedItem();
        
        peformerSelected.setPeformer(edittedCell.getNewValue().toString());
    }
    
    @SuppressWarnings("rawtypes")
	public void changeDescription(CellEditEvent edittedCell)
    {
        Album descriptionSelected =  tableView.getSelectionModel().getSelectedItem();
        
        descriptionSelected.setDescription(edittedCell.getNewValue().toString());
    }
    
    @SuppressWarnings("rawtypes")
	public void changeDuration(CellEditEvent edittedCell)
    {
        Album durationSelected =  tableView.getSelectionModel().getSelectedItem();
        
        durationSelected.setDuration(edittedCell.getNewValue().toString());
    }
    
    @SuppressWarnings("rawtypes")
	public void changeType(CellEditEvent edittedCell)
    {
        Album typeSelected =  tableView.getSelectionModel().getSelectedItem();
        
        typeSelected.setType(edittedCell.getNewValue().toString());
    }
    
    @SuppressWarnings("rawtypes")
   	public void changeContest(CellEditEvent edittedCell)
       {
           Album contestSelected =  tableView.getSelectionModel().getSelectedItem();
           
           contestSelected.setContest(edittedCell.getNewValue().toString());
       }
       
       @SuppressWarnings("rawtypes")
   	public void changePlace(CellEditEvent edittedCell)
       {
           Album placeSelected =  tableView.getSelectionModel().getSelectedItem();
           
           placeSelected.setPlace(edittedCell.getNewValue().toString());
       }
    

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("name"));
        
        genreColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("genre"));
        
        peformerColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("peformer"));
        
        dateColumn.setCellValueFactory(new PropertyValueFactory<Album, LocalDate>("date"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("description"));
        
        durationColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("duration"));
        
        typeColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("type"));
        
        contestColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("contest"));
        
        placeColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("place"));
        
        
        tableView.setEditable(true);
        
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        genreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        peformerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        durationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        contestColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        placeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
     
        
    }    
    
    public void newAlbumButton()
    {
        Album newAlbum = new Album
        		(
	        		nameTextField.getText(),   
	        		
	        		genreTextField.getText(),
	        		
	        		peformerTextField.getText(),
	        		
	        		dateTextField.getValue(),
	        		
	        		descriptionTextField.getText(),
	        		
	        		durationTextField.getText(),
	        		
	        		typeTextField.getText(),
	        		
	        		contestTextField.getText(),
	        		
	        		placeTextField.getText()
        		);
        
        tableView.getItems().add(newAlbum);
        
        nameTextField.clear();
        
        genreTextField.clear();
        
        peformerTextField.clear();
        
        descriptionTextField.clear();
        
        durationTextField.clear();
        
        typeTextField.clear();
        
        contestTextField.clear();
        
        placeTextField.clear();
        
    }
    
    public void deleteAlbumButton()
    {
        ObservableList<Album> selectedRows, allAlbums;
        
        allAlbums = tableView.getItems();

        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (Album album: selectedRows)
        {
            allAlbums.remove(album);
        }
        
    }
    
    
    public void handleSave(ActionEvent event) 
    {
        Stage secondaryStage = new Stage();
        
        FileChooser fileChooser = new FileChooser();
        
        fileChooser.setTitle("Save Albums");
        
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

		File file = fileChooser.showSaveDialog(secondaryStage);
		
		if(file != null) 
		{
			saveFile(tableView.getItems(), file);
		}
		
    }
    
    public void saveFile(ObservableList<Album> albums, File file) 
    {
        try 
        {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));

            for(Album allbs : albums) 
            {
                outWriter.write(allbs.toString());
                
                outWriter.newLine();
            }
            
            System.out.println(albums.toString());
            
            outWriter.close();
        } 
        catch (IOException e) 
        {
            Alert ioAlert = new Alert(Alert.AlertType.ERROR, "OOPS!", ButtonType.OK);
            
            ioAlert.setContentText("Sorry. An error has occurred.");
            
            ioAlert.showAndWait();
            
            if(ioAlert.getResult() == ButtonType.OK) 
            {
                ioAlert.close();
            }
            
        }
    }
    
    public void closeApp(ActionEvent event) 
    {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm", ButtonType.OK, ButtonType.CANCEL);
        
        Stage stage = (Stage) fileMenu.getScene().getWindow();
        
        exitAlert.setContentText("Are you sure you want to exit?");
        
        exitAlert.initModality(Modality.APPLICATION_MODAL);
        
        exitAlert.initOwner(stage);
        
        exitAlert.showAndWait();

        if(exitAlert.getResult() == ButtonType.OK)
        {
            Platform.exit();
        }
        else
        {
            exitAlert.close();
        }
        
    }
   
}