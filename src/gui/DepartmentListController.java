package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {

	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department,String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id")); // padrão pra iniciar o comportamento das colunas
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		
		/* Upcasting é implícito, por isso que o downcasting dá certo 
		 * o certo seria verificar com intanceof, mas como stage é um Window, automaticamente a relação também é contrária
		 * 
		 * obs: eu não achei nenhuma outra explicação melhor. Frustrante. */
		
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty()); // TableView acompanha o tamanho da Scene. 
		
	}
}
