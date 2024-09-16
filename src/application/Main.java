package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			/* Carregar o arquivo FXML: O FXMLLoader 
			é inicializado com o caminho para o arquivo FXML.
			Esse arquivo contém a definição da interface, incluindo o ScrollPane. */
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml")); 
			
			
			/*Instanciar o ScrollPane: O método load() é chamado, o que lê o arquivo FXML e cria os objetos
			 correspondentes à estrutura nele definida. No caso, retorna o nó raiz do arquivo FXML é um ScrollPane
			 ,pois contém toda a estrutura da árvore de nodos */
			ScrollPane scrollPane = loader.load(); 
			
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true); // esticar a tela
			
			mainScene = new Scene(scrollPane);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
