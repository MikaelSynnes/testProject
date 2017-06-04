package Game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

    private boolean running = true;

    private ArrayList<MovableSquare> enemies = new ArrayList<>();

    private KeyFrame k;
    private Timeline t;

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
        StackPane root = new StackPane();
        Pane bg = new Pane();
        Pane planets = new Pane();
        Pane ships = new Pane();
        VBox buttonBar = new VBox();

        ImageView bgImg = new ImageView("testBG.png");
        bgImg.setFitWidth(WINDOW_WIDTH);
        bgImg.setFitHeight(WINDOW_HEIGHT);

        root.getChildren().addAll(bg, planets, ships, buttonBar);
        bg.getChildren().add(bgImg);
        planets.setMinSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        planets.setMaxSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ships.setMinSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ships.setMaxSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(event -> pauseGame());
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> Platform.exit());
        buttonBar.getChildren().addAll(pauseButton, exitButton);

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Many Squares, Handle It!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Random rng = new Random();

        // Each KeyFrame represents one tick.
        k = new KeyFrame(Duration.millis(FRAME_DURATION), event ->
        {
            // Create squares at random.
            if (rng.nextInt(100) > 95)
            {
                MovableSquare newSquare = new MovableSquare(SQUARE_WIDTH, 2, (double) rng.nextInt(WINDOW_WIDTH), (double) -SQUARE_WIDTH - 10);
                newSquare.setFill(Color.WHITE);
                newSquare.setStroke(Color.BLACK);
                enemies.add(newSquare);
                ships.getChildren().add(newSquare);
            }

            ArrayList<MovableSquare> enemiesToRemove = new ArrayList<>();

            // Move enemies and remove enemies that are out of bounds.
            for (MovableSquare enemy : enemies)
            {
                enemy.move();
                if (enemy.getY() > WINDOW_HEIGHT + enemy.getHeight())
                {
                    enemiesToRemove.add(enemy);
                    ships.getChildren().remove(enemy);
                }
            }
            enemies.removeAll(enemiesToRemove);
            //enemiesToRemove.clear();
        });

        // Run the animation
        t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    private void pauseGame()
    {
        if (running)
        {
            running = false;
            t.pause();
        }
        else
        {
            running = true;
            t.play();
        }
    }
}
