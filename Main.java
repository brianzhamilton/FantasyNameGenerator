package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	
	// GridPane variable
	public GridPane gridPane;
	
	// variables for producing the previous name generated
	public String saveName;
	public String previousName;
	public int counter;
	
	@Override
	public void start(Stage primaryStage) {
		
		// create labels
		Text lblNameType = new Text("Name Type: ");
		Text lblGender = new Text("Gender: ");
		Text lblNation = new Text("Nationality: ");
		Text lblRegion = new Text("Region: ");
		Text lblClimate = new Text("Climate: ");
		Text lblTerrain = new Text("Terrain: ");
		Text lblHabitat = new Text("Habitat: ");
		Text lblDiet = new Text("Diet: ");
		Text lblResult = new Text("Result: ");
		
		// Person ChoiceBoxes
		ChoiceBox<String> cBoxNameType = new ChoiceBox<String>();
		cBoxNameType.getItems().addAll("Person", "Place", "Animal");
		ChoiceBox<String> cBoxGender = new ChoiceBox<String>();
		cBoxGender.getItems().addAll("Male", "Female");
		ChoiceBox<String> cBoxNation = new ChoiceBox<String>();
		cBoxNation.getItems().addAll("Water", "Earth", "Fire", "Air");
		
		// Place ChoiceBoxes
		ChoiceBox<String> cBoxRegion = new ChoiceBox<String>();
		cBoxRegion.getItems().addAll("North", "South", "East", "West");
		ChoiceBox<String> cBoxClimate = new ChoiceBox<String>();
		cBoxClimate.getItems().addAll("Dry", "Humid");
		ChoiceBox<String> cBoxTerrain = new ChoiceBox<String>();
		cBoxTerrain.getItems().addAll("Desert", "Forest", "Grassland", "Tundra");
		
		// Animal ChoiceBoxes
		ChoiceBox<String> cBoxHabitat = new ChoiceBox<String>();
		cBoxHabitat.getItems().addAll("Desert", "Forest", "Freshwater", "Grassland", "Saltwater", "Tundra");
		ChoiceBox<String> cBoxDiet = new ChoiceBox<String>();
		cBoxDiet.getItems().addAll("Herbivore", "Carnivore", "Omnivore");
		
		// Generate and Previous Button
		Button btnPrevious = new Button("Previous");
		Button btnGenerate = new Button("Generate");
		
		// Text Result and Error Message
		Text inputResult = new Text();
		Text errMsg = new Text();
		
		// Setup Grid Layout
		gridPane = new GridPane();
		gridPane.setMinSize(400, 300);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(10);
		gridPane.setHgap(50);
		gridPane.setAlignment(Pos.TOP_LEFT);
		
		// Setup Grid nodes
		gridPane.add(lblNameType, 1, 1);
		gridPane.add(cBoxNameType, 2, 1);

		// Create Scene Object and display
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Fantasy Name Generator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Listener to dynamically change the viewport based upon Name Type Selection
		cBoxNameType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// if statements compare previous value with present value;
				// adds and removes buttons as necessary
				
				// if first selection is "Person"
				if (arg1 == null && arg2 == cBoxNameType.getItems().get(0)) {
					gridPane.add(lblGender, 1, 2);
					gridPane.add(cBoxGender, 2, 2);
					gridPane.add(lblNation, 1, 3);
					gridPane.add(cBoxNation, 2, 3);
					gridPane.add(lblResult, 1, 7);
					gridPane.add(inputResult, 2, 7);
					gridPane.add(errMsg, 2, 8);
					gridPane.add(btnPrevious, 1, 9);
					gridPane.add(btnGenerate, 2, 9);
					
				// if first selection is "Place"
				} else if (arg1 == null && arg2 == cBoxNameType.getItems().get(1)) {
					gridPane.add(lblNation, 1, 2);
					gridPane.add(cBoxNation, 2, 2);
					gridPane.add(lblRegion, 1, 3);
					gridPane.add(cBoxRegion, 2, 3);
					gridPane.add(lblClimate, 1, 4);
					gridPane.add(cBoxClimate, 2, 4);
					gridPane.add(lblTerrain, 1, 5);
					gridPane.add(cBoxTerrain, 2, 5);
					gridPane.add(lblResult, 1, 7);
					gridPane.add(inputResult, 2, 7);
					gridPane.add(errMsg, 2, 8);
					gridPane.add(btnPrevious, 1, 9);
					gridPane.add(btnGenerate, 2, 9);
					
				// if first selection is "Animal"
				} else if (arg1 == null && arg2 == cBoxNameType.getItems().get(2)) {
					gridPane.add(lblNation, 1, 2);
					gridPane.add(cBoxNation, 2, 2);
					gridPane.add(lblHabitat, 1, 3);
					gridPane.add(cBoxHabitat, 2, 3);
					gridPane.add(lblDiet, 1, 4);
					gridPane.add(cBoxDiet, 2, 4);
					gridPane.add(lblResult, 1, 7);
					gridPane.add(inputResult, 2, 7);
					gridPane.add(errMsg, 2, 8);
					gridPane.add(btnPrevious, 1, 9);
					gridPane.add(btnGenerate, 2, 9);
					
				// if selection changes from "Place" to "Person"
				} else if (arg1 == cBoxNameType.getItems().get(1) && arg2 == cBoxNameType.getItems().get(0)) {
					// clear previous selections
					cBoxNation.getSelectionModel().clearSelection();
					cBoxRegion.getSelectionModel().clearSelection();
					cBoxClimate.getSelectionModel().clearSelection();
					cBoxTerrain.getSelectionModel().clearSelection();
					inputResult.setText("");
					
					// remove old and add new children
					gridPane.getChildren().removeAll(lblNation, cBoxNation, lblRegion, cBoxRegion, lblClimate, cBoxClimate, lblTerrain, cBoxTerrain);
					gridPane.add(lblGender, 1, 2);
					gridPane.add(cBoxGender, 2, 2);
					gridPane.add(lblNation, 1, 3);
					gridPane.add(cBoxNation, 2, 3);

				// if selection changes from "Animal" to "Person"
				} else if (arg1 == cBoxNameType.getItems().get(2) && arg2 == cBoxNameType.getItems().get(0)) {
					// clear previous selections
					cBoxNation.getSelectionModel().clearSelection();
					cBoxHabitat.getSelectionModel().clearSelection();
					cBoxDiet.getSelectionModel().clearSelection();
					inputResult.setText("");
					
					// remove old and add new children
					gridPane.getChildren().removeAll(lblNation, cBoxNation, lblHabitat, cBoxHabitat, lblDiet, cBoxDiet);
					gridPane.add(lblGender, 1, 2);
					gridPane.add(cBoxGender, 2, 2);
					gridPane.add(lblNation, 1, 3);
					gridPane.add(cBoxNation, 2, 3);

				// if selection changes from "Person" to "Place"
				} else if (arg1 == cBoxNameType.getItems().get(0) && arg2 == cBoxNameType.getItems().get(1)) {
					// clear previous selections
					cBoxGender.getSelectionModel().clearSelection();
					cBoxNation.getSelectionModel().clearSelection();
					inputResult.setText("");
					
					// remove old and add new children
					gridPane.getChildren().removeAll(lblGender, cBoxGender, lblNation, cBoxNation);
					gridPane.add(lblNation, 1, 2);
					gridPane.add(cBoxNation, 2, 2);
					gridPane.add(lblRegion, 1, 3);
					gridPane.add(cBoxRegion, 2, 3);
					gridPane.add(lblClimate, 1, 4);
					gridPane.add(cBoxClimate, 2, 4);
					gridPane.add(lblTerrain, 1, 5);
					gridPane.add(cBoxTerrain, 2, 5);
					
				// if selection changes from "Animal" to "Place"
				} else if (arg1 == cBoxNameType.getItems().get(2) && arg2 == cBoxNameType.getItems().get(1)) {
					// clear previous selections
					cBoxNation.getSelectionModel().clearSelection();
					cBoxHabitat.getSelectionModel().clearSelection();
					cBoxDiet.getSelectionModel().clearSelection();
					inputResult.setText("");
					
					// remove old and add new children
					gridPane.getChildren().removeAll(lblNation, cBoxNation, lblHabitat, cBoxHabitat, lblDiet, cBoxDiet);
					gridPane.add(lblNation, 1, 2);
					gridPane.add(cBoxNation, 2, 2);
					gridPane.add(lblRegion, 1, 3);
					gridPane.add(cBoxRegion, 2, 3);
					gridPane.add(lblClimate, 1, 4);
					gridPane.add(cBoxClimate, 2, 4);
					gridPane.add(lblTerrain, 1, 5);
					gridPane.add(cBoxTerrain, 2, 5);
					
				// if selection changes from "Person" to "Animal"
				} else if (arg1 == cBoxNameType.getItems().get(0) && arg2 == cBoxNameType.getItems().get(2)) {
					// clear previous selections
					cBoxGender.getSelectionModel().clearSelection();
					cBoxNation.getSelectionModel().clearSelection();
					inputResult.setText("");
					
					// remove old and add new children
					gridPane.getChildren().removeAll(lblGender, cBoxGender, lblNation, cBoxNation);
					gridPane.add(lblNation, 1, 2);
					gridPane.add(cBoxNation, 2, 2);
					gridPane.add(lblHabitat, 1, 3);
					gridPane.add(cBoxHabitat, 2, 3);
					gridPane.add(lblDiet, 1, 4);
					gridPane.add(cBoxDiet, 2, 4);
					
				// if selection changes from "Place" to "Animal"
				} else if (arg1 == cBoxNameType.getItems().get(1) && arg2 == cBoxNameType.getItems().get(2)) {
					// clear previous selections
					cBoxNation.getSelectionModel().clearSelection();
					cBoxRegion.getSelectionModel().clearSelection();
					cBoxClimate.getSelectionModel().clearSelection();
					cBoxTerrain.getSelectionModel().clearSelection();
					inputResult.setText("");
					
					// remove old and add new children
					gridPane.getChildren().removeAll(lblNation, cBoxNation, lblRegion, cBoxRegion, lblClimate, cBoxClimate, lblTerrain, cBoxTerrain);
					gridPane.add(lblNation, 1, 2);
					gridPane.add(cBoxNation, 2, 2);
					gridPane.add(lblHabitat, 1, 3);
					gridPane.add(cBoxHabitat, 2, 3);
					gridPane.add(lblDiet, 1, 4);
					gridPane.add(cBoxDiet, 2, 4);
				}
				
				// empties error message
				errMsg.setText("");
			}
			
		});
		
		
		// Event Handler for when the Generate Button is clicked
		btnGenerate.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// empties error message, if populated
				errMsg.setText("");
				
				// Checks which Name Type is selected;
				// Puts selection values into variables
				
				// if "Person" is selected
				if (cBoxNameType.getSelectionModel().isSelected(0)) {
					int genderInput = cBoxGender.getSelectionModel().getSelectedIndex();
					int nationInput = cBoxNation.getSelectionModel().getSelectedIndex();
					
					// input validation to ensure other necessary values have been selected
					if (genderInput == -1) {
						errMsg.setText("Please select a gender.");
					} else if (nationInput == -1) {
						errMsg.setText("Please select an ethnicity.");
					} else {
						Person person = new Person(	genderInput, 
													nationInput);
						inputResult.setText(person.toString());
						saveName = person.toString();
						
						// a counter function for the "previous name" feature
						count();
					}
				
				// if "Place" is selected
				} else if (cBoxNameType.getSelectionModel().isSelected(1)) {
					int nationInput = cBoxNation.getSelectionModel().getSelectedIndex();
					int regionInput = cBoxRegion.getSelectionModel().getSelectedIndex();
					int climateInput = cBoxClimate.getSelectionModel().getSelectedIndex();
					int terrainInput = cBoxTerrain.getSelectionModel().getSelectedIndex();
					
					// input validation to ensure other necessary values have been selected
					if (nationInput == -1) {
						errMsg.setText("Please select a nationality.");
					} else if (regionInput == -1) {
						errMsg.setText("Please select a region.");
					} else if (climateInput == -1) {
						errMsg.setText("Please select a climate.");
					} else if (terrainInput == -1) {
						errMsg.setText("Please select a terrain.");
					} else {
						Place place = new Place(	nationInput, 
													regionInput, 
													climateInput, 
													terrainInput);
						inputResult.setText(place.toString());
						saveName = place.toString();
						
						// a counter function for the "previous name" feature
						count();
					}
					
				// if "Animal" is selected
				} else if (cBoxNameType.getSelectionModel().isSelected(2)) {
					int nationInput = cBoxNation.getSelectionModel().getSelectedIndex();
					int habitatInput = cBoxHabitat.getSelectionModel().getSelectedIndex();
					int dietInput = cBoxDiet.getSelectionModel().getSelectedIndex();

					// input validation to ensure other necessary values have been selected
					if (nationInput == -1) {
						errMsg.setText("Please select a nationality.");
					} else if (habitatInput == -1) {
						errMsg.setText("Please select a habitat.");
					} else if (dietInput == -1) {
						errMsg.setText("Please select a diet.");
					} else {
						Animal animal = new Animal(	nationInput,
												habitatInput,
												dietInput);
						inputResult.setText(animal.toString());
						
						// a counter function for the "previous name" feature
						saveName = animal.toString();
						count();
					}
				}
				
			}
			
		});
		
		
		// event handler for when previous button is clicked
		btnPrevious.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				// checks if generate button has generated more than one name
				if (getCount() < 2) {
				
					errMsg.setText("No previous name stored.");
				
				// checks if previous button has already been pressed
				} else if (previousName == saveName 
						&& getCount() > 1 
						&& inputResult.getText() != "") {
					
					errMsg.setText("May only go back by one name.");		
				
				// goes back to previous name if more than one name has been generated
				// otherwise, button does nothing
				} else if (getCount() > 1) {
				
					inputResult.setText(previousName);
					previousName = saveName;
				
				}
			}
		});
		
	}
	
	public void count() {
		counter++;
		if (counter == 1) {
			previousName = saveName;
		}
	}
	
	public int getCount() {
		return counter;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
