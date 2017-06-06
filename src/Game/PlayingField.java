package Game;

import MoveableObjects.Enemy;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
public class PlayingField
{

    private Stage stage;

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final double FRAME_DURATION = 10;
    private static final int SQUARE_WIDTH = 40;

    private boolean running = true;

    private ArrayList<Enemy> enemies = new ArrayList<>();

    private Timeline t;

    public PlayingField(Stage stage)
    {
        this.stage = stage;
    }

    /**
     * Main game loop.
     * It creates random squares which RAIN FROM THE MOTHER-EFFING SKY.
     * These squares are also IN OUTER SPACE.
     */
    public void run()
    {
        // UI layers
        StackPane root = new StackPane();
        Pane bg = new Pane();
        Pane planets = new Pane();
        Pane ships = new Pane();

        // Buttons
        VBox buttonBar = new VBox();

        // Background image
        ImageView bgImg = new ImageView("testBG.png");
        bgImg.setFitWidth(WINDOW_WIDTH + 20);
        bgImg.setFitHeight(WINDOW_HEIGHT + 20);

        // Set up UI
        root.getChildren().addAll(bg, planets, ships, buttonBar);
        bg.getChildren().add(bgImg);
        planets.setMinSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        planets.setMaxSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ships.setMinSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ships.setMaxSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        Random rng = new Random();

        // Set up planet
        ImageView planet = new ImageView("testPlanet.png");
        planets.getChildren().add(planet);
        planet.setX(WINDOW_WIDTH + 10);
        planet.setY((double) rng.nextInt(WINDOW_HEIGHT) - 200);

        // Set up buttons
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(event -> pauseGame());
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> Platform.exit());
        buttonBar.getChildren().addAll(pauseButton, exitButton);

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.setOnKeyReleased(this::keyPressed);
        stage.setTitle("Norway 9001 Prototype");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Each KeyFrame represents one tick.
        KeyFrame k = new KeyFrame(Duration.millis(FRAME_DURATION), event ->
        {
            // Create squares at random.
            if (rng.nextInt(100) > 95)
            {
                Enemy newSquare = new Enemy(SQUARE_WIDTH, rng.nextInt(4) + 1, (double) WINDOW_WIDTH + 10, (double) rng.nextInt(WINDOW_HEIGHT - SQUARE_WIDTH - 10));
                newSquare.setFill(Color.WHITE);
                newSquare.setStroke(Color.BLACK);
                enemies.add(newSquare);
                ships.getChildren().add(newSquare);
            }

            // Move the planet
            if (planet.getX() < -500)
            {
                planet.setX(WINDOW_WIDTH + 10);
                planet.setY((double) rng.nextInt(WINDOW_HEIGHT));
            }
            else
            {
                planet.setX(planet.getX() - 0.5);
            }

            ArrayList<Enemy> enemiesToRemove = new ArrayList<>();

            // Move enemies and remove enemies that are out of bounds.
            for (Enemy enemy : enemies)
            {
                enemy.move();
                if (enemy.getX() < -enemy.getWidth() - 10)
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

    /**
     * Pauses and unpauses the game.
     */
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

    /**
     * Handle keyboard keyPressed events.
     * @param ke The keyboard event to handle.
     */
    private void keyPressed(KeyEvent ke)
    {
        if (ke.getCode() == KeyCode.P)
        {
            pauseGame();
        }
    }
}