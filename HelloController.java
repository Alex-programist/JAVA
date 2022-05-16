package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private ImageView a;
    @FXML private TextField day;
    @FXML private TextField group;
    @FXML private TextField count;
    private static int i = 0;
    @FXML private TableView<TimeTable> elementsTable;
    private static TableView<TimeTable> elementsTableStatic;
    @FXML private TableColumn<TimeTable, String> idColumn;
    @FXML private TableColumn<TimeTable, String> dayColumn;
    @FXML private TableColumn<TimeTable, String> groupColumn;
    @FXML private TableColumn<TimeTable, String> countColumn;
    @FXML private TextField idEdit;
    @FXML private TextField dayEdit;
    @FXML private TextField groupEdit;
    @FXML private TextField countEdit;
    @FXML private TextField idDelete;
    @FXML private TextField daySearch;
    @FXML private Label erorl;

    @FXML public void AddButton() throws SQLException {
        String day_;
        int group_ = 0;
        int count_ = 0;
        try{
            day_ = day.getText();
            group_ = Integer.parseInt(group.getText());
            count_ = Integer.parseInt(count.getText());
            if(count_>6)
            {
                erorl.setText("Ви вийшли за межі!!!");
                return;
            }
        }
        catch (Exception ex){
            erorl.setText("Введене не коретні значення!");
            return;
        }
        erorl.setText("");
        day.setText("");
        group.setText("");
        count.setText("");
        Statement stat = HelloApplication.conn.createStatement();
        String selectAll = "INSERT INTO pozklad(day_, group_, count_) VALUES('"+day_+"', '"+group_+"', '"+count_+"')";
        stat.executeUpdate(selectAll);
        UpdateTable();
    }
    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        if(i != 0) {
            return;
        }
        i++;
        a.setImage(new Image("C:\\Users\\38066\\Desktop\\in.jpg"));

        elementsTableStatic = elementsTable;
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<>("group"));
        countColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        try {
            UpdateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void UpdateTable() throws SQLException {
        if(elementsTableStatic != null){
            if(elementsTableStatic.getItems() != null){
                elementsTableStatic.getItems().clear();
            }
        }
        Statement stat = HelloApplication.conn.createStatement();
        String selectAll = "SELECT * FROM pozklad";
        ResultSet results = stat.executeQuery(selectAll);
        List<TimeTable> tableList = new ArrayList<>();
        while(results.next()){
            int id_ = results.getInt(1);
            String day_ = results.getString(2);
            int group_ = results.getInt(3);
            int count_ = results.getInt(4);
            tableList.add(new TimeTable(id_, day_, group_, count_));
        }
        elementsTableStatic.getItems().addAll(tableList);
    }
    @FXML public void EditWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EditWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage newWindow = new Stage();
        newWindow.setTitle("");
        newWindow.setScene(scene);
        newWindow.setResizable(false);
        newWindow.show();
    }
    @FXML public void InsertValues(){
        int n = -1;
        try {
            n = Integer.parseInt(idEdit.getText());
            Statement stat = HelloApplication.conn.createStatement();
            String selectAll = "SELECT * FROM pozklad WHERE id_=" + n;
            ResultSet results = stat.executeQuery(selectAll);
            results.next();
            dayEdit.setText(results.getString(2));
            groupEdit.setText(Integer.toString(results.getInt(3)));
            countEdit.setText(results.getString(4));
        }
        catch(Exception ex){
            dayEdit.setText("!");
            groupEdit.setText("!");
            countEdit.setText("!");
            return;
        }
    }
    @FXML public void SaveEdit() throws SQLException {
        try {
            Integer.parseInt(countEdit.getText());
            Integer.parseInt(groupEdit.getText());
        }
        catch (Exception ex){
            return;
        }

        Statement stat = HelloApplication.conn.createStatement();
        String selectAll = "UPDATE pozklad SET day_ = \'"+dayEdit.getText()+ "\', group_ = \'"+
                groupEdit.getText()+"\', count_ = \'"+countEdit.getText()+"\' WHERE id_ = "+ idEdit.getText();
        stat.executeUpdate(selectAll);
        UpdateTable();
    }
    @FXML public void DeleteAll() throws SQLException {
        Statement stat = HelloApplication.conn.createStatement();
        String selectAll = "TRUNCATE TABLE pozklad";
        stat.executeUpdate(selectAll);
        UpdateTable();
    }
    @FXML public void DeleteOne() throws SQLException {
        int n = 0;
        try {
            n = Integer.parseInt(idDelete.getText());
        }
        catch(Exception ex){
            erorl.setText("Ви вийшли за межі!!!");
            return;
        }
        erorl.setText("");
        Statement stat = HelloApplication.conn.createStatement();
        String selectAll = "DELETE FROM pozklad WHERE id_ = "+n+"";
        stat.executeUpdate(selectAll);
        idDelete.setText("");
        UpdateTable();
    }
    @FXML public void Search() throws SQLException {
        if(daySearch.getText().equals("")){
            UpdateTable();
            return;
        }
        Statement stat = HelloApplication.conn.createStatement();
        String selectAll = "SELECT * FROM pozklad WHERE day_ = '" + daySearch.getText() + "'";
        ResultSet results = stat.executeQuery(selectAll);
        List<TimeTable> tableList = new ArrayList<>();
        while(results.next()){
            int id_ = results.getInt(1);
            String day_ = results.getString(2);
            int group_ = results.getInt(3);
            int count_ = results.getInt(4);
            tableList.add(new TimeTable(id_, day_, group_, count_));
        }
        if(elementsTableStatic != null){
            if(elementsTableStatic.getItems() != null){
                elementsTableStatic.getItems().clear();
            }
        }
        elementsTableStatic.getItems().addAll(tableList);
    }
    @FXML public void Sort() throws SQLException {
        if(elementsTableStatic != null){
            if(elementsTableStatic.getItems() != null){
                elementsTableStatic.getItems().clear();
            }
        }
        Statement stat = HelloApplication.conn.createStatement();
        String selectAll = "SELECT * FROM pozklad ORDER BY count_";
        ResultSet results = stat.executeQuery(selectAll);
        List<TimeTable> tableList = new ArrayList<>();
        while(results.next()){
            int id_ = results.getInt(1);
            String day_ = results.getString(2);
            int group_ = results.getInt(3);
            int count_ = results.getInt(4);
            tableList.add(new TimeTable(id_, day_, group_, count_));
        }
        elementsTableStatic.getItems().addAll(tableList);
    }
    @FXML public void Reload() throws SQLException {
        UpdateTable();
        erorl.setText("");
    }
}