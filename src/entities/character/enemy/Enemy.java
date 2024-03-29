package entities.character.enemy;

import entities.character.Animal;
import graphics.Sprite;
import javafx.scene.image.Image;

import java.util.Random;

import static main.BombermanGame.bomber;

public abstract class Enemy extends Animal {
    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    protected void chooseDirection() {
        if (animationTime > 100000) animationTime = 0;
        if (animationTime % 50 == 0 && x % Sprite.SCALED_SIZE == 0 && y % Sprite.SCALED_SIZE == 0) {
            direction = Direction.values()[new Random().nextInt(Direction.values().length)];
        }
    }

    protected void enemyMoving() {
    }

    protected void interactWithBomber() {
        if (bomber.getBomberX() == getLocationX() && bomber.getBomberY() == getLocationY() /*&& !bomber.isProtectded()*/) {
            bomber.setHurt();
        }
    }
}
