package Game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Asgeir on 03.06.2017.
 */
public class Squares
{

    private Stage stage;

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final double FRAME_DURATION = 10;
    private static final int SQUARE_WIDTH = 40;

    private ArrayList<MovableSquare> enemies = new ArrayList<>();

    public Squares(Stage stage)
    {
        this.stage = stage;
    }

    /**
     * Main game loop.
     * It creates random squares which RAIN FROM THE MOTHER-EFFING SKY.
     */
    public void run()
    {
        Group root = new Group();

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Many Squares, Handle It!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Random rng = new Random();

        // Each KeyFrame represents one tick.
        KeyFrame k = new KeyFrame(Duration.millis(FRAME_DURATION), event ->
        {
            // Create squares at random.
            if (rng.nextInt(100) > 95)
            {
                MovableSquare newSquare = new MovableSquare(SQUARE_WIDTH, 2, (double) rng.nextInt(WINDOW_WIDTH), (double) -SQUARE_WIDTH - 10);
                newSquare.setFill(Color.WHITE);
                newSquare.setStroke(Color.BLACK);
                enemies.add(newSquare);
                root.getChildren().add(newSquare);
            }

            ArrayList<MovableSquare> enemiesToRemove = new ArrayList<>();

            // Move enemies and remove enemies that are out of bounds.
            for (MovableSquare enemy : enemies)
            {
                enemy.move();
                if (enemy.getY() > WINDOW_HEIGHT + enemy.getHeight())
                {
                    enemiesToRemove.add(enemy);
                }
            }
            enemies.removeAll(enemiesToRemove);
            //enemiesToRemove.clear();
        });

        // Run the animation
        Timeline t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
