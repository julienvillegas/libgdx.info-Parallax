package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

/**
 * Created by julienvillegas on 20/01/2017.
 */

public class TitleScreen implements Screen {
    private Stage stage;
    private Game game;

    public TitleScreen(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());

        Label title = new Label("Parallax with Scene2D", MyGdxGame.skin,"big-black");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        TextButton playButton = new TextButton("See!",MyGdxGame.skin);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()/2-playButton.getHeight()/2);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playButton);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
