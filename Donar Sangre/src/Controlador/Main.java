package Controlador;

import java.io.IOException;

import Vista.DonantesControladora;
import Vista.MainMenuControler;
import Vista.NuevoDonante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {

    private static Stage stagePrincipal;
    private AnchorPane rootPane;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        Main.stagePrincipal = stagePrincipal;
        mostrarMainMenu();

    }

    /* En un proyecto JavaFX el main llama al launch que a su vez llama a start */
    public static void main(String[] args) {
        launch(args);
    }

    /*
     * cargamos la ventana principal
     */
    public void mostrarMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/MainMenu.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Menú Principal");
            stagePrincipal.setScene(scene);
            /*
             * Añadidos las llamadas del main al Controlador y del controlador al main ***/
            MainMenuControler controller = loader.getController();
            controller.setProgramaPrincipal(this);


            stagePrincipal.show();
        } catch (IOException e) {
            //tratar la excepción.
        }
   }
    
    public void mostrarDonantes() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/IUDonantes.fxml"));
            AnchorPane donan = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventana = new Stage();
            ventana.setTitle("Ventana Donantes");
            /* Le decimos a la ventana quién es la ventana original */
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(donan);
            ventana.setScene(scene);

            DonantesControladora controller2 = loader.getController();
            controller2.setStagePrincipal(ventana);
            controller2.setProgramaPrincipal(this);

            ventana.show();

        } catch (Exception e) {
            //tratar la excepción
        	System.out.println(e);
        }
    }
   
    public void pantallaNuevoDonante() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/NuevoDonante.fxml"));
            AnchorPane donan = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventana = new Stage();
            ventana.setTitle("Nuevo Donante");
            /* Le decimos a la ventana quién es la ventana original */
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(donan);
            ventana.setScene(scene);

            NuevoDonante controller2 = loader.getController();
            controller2.setStagePrincipal(ventana);
            controller2.setProgramaPrincipal(this);

            ventana.show();

        } catch (Exception e) {
            //tratar la excepción
        	System.out.println(e);
        }
    }
}