package Game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Asgeir on 03.06.2017.
 */
public class Squares
{

    private Stage stage;

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final int SQUARE_WIDTH = 40;

    private ArrayList<Rectangle> enemies = new ArrayList<>();

    public Squares(Stage stage)
    {
        this.stage = stage;
    }

    public void run()
    {
        Group root = new Group();

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Many Squares, Handle It!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        new Rectangle()
    }
}
