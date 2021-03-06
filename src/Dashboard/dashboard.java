package Dashboard;

import DisplayInfo.DisplayInfo;
import Login.Login;
import Login.exit;
import Registration.*;
import Sub_Reg.Search_Subject;
import Sub_Reg.SubjectInformation;
import Sub_Reg.subject_registration;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class dashboard extends Application {
    public Stage test;
    public static VBox box = new VBox();
    static int num =0;

    subject_registration subject_reg = new subject_registration();
    user_info info = new user_info();

    exit Exit = new exit();
    Button Home = new Button();
    Button Sub_reg = new Button("""

            Register Subject
            """);
    Button search_sub = new Button ("Search Subject\n");
    Button DisplayInformation = new Button ("View Info");
    Button Logout = new Button ("Logout");
    Button About = new Button ("About");
    Button DisplaySubjectInformation = new Button("Subject Information");
    BorderPane root = new BorderPane();
    Region region = new Region();

    public dashboard() {
    }
    @Override
    public void start(Stage primaryStage){
        String User = Login.UserName;
        String new_user = registration.user;
        this.test = primaryStage;
        Home.setText("Mr "+User);
        if(User == null){
            Home.setText("Mr "+new_user);
        }
        Logout.setId("logout_button");
        Home.setId("home_button");

        VBox vBox = new VBox(Sub_reg, search_sub, DisplaySubjectInformation, DisplayInformation, About);
        box = vBox;
        vBox.setId("left_box");
        HBox hBox = new HBox();
        hBox.setId("top_box");
        HBox.setHgrow(region, Priority.ALWAYS);
        hBox.getChildren().addAll(Home,region,Logout);

        //scene stuff
        Scene index = new Scene(root);
        root.setLeft(vBox);
        root.setTop(hBox);

        Sub_reg.setOnAction(new subject_reg());
        search_sub.setOnAction(new search_sub());
        DisplayInformation.setOnAction(new DisplayInfoHandle());
        Logout.setOnAction(new Logout());
        DisplaySubjectInformation.setOnAction(new SubjectInformationHandle());

        String css = getClass().getResource("dashboard.css").toExternalForm();
        index.getStylesheets().add(css);
        primaryStage.setTitle("Dashboard");
        primaryStage.setScene(index);
        primaryStage.show();
    }
    class subject_reg implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) { root.setCenter(subject_reg);}
    }

    class search_sub implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e)  { root.setCenter(new Search_Subject());}
    }

    class Logout implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {Exit.platform_way(test,"Are YoU SuRe You Wanna LogOut");}
    }

    class DisplayInfoHandle implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) { root.setCenter(new DisplayInfo());}
    }

    class SubjectInformationHandle implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) { if ( num < 1){
            root.setCenter(new SubjectInformation());
            num ++;
        }};
    }
   public static void main(String[] args) {
        launch(args);
    }
}