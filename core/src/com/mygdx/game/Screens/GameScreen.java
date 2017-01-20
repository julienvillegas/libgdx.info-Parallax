package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Actors.ParallaxBackground;

/**
 * Created by julienvillegas on 17/01/2017.
 */
public class GameScreen implements Screen {

    private Stage stage;
    private Game game;
    private OrthographicCamera camera;



    public GameScreen(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());
        camera = (OrthographicCamera) stage.getViewport().getCamera();

        Array<Texture> textures = new Array<Texture>();
        for(int i = 1; i <=6;i++){
            textures.add(new Texture(Gdx.files.internal("parallax/img"+i+".png")));
            textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }

        ParallaxBackground parallaxBackground = new ParallaxBackground(textures);
        parallaxBackground.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        parallaxBackground.setSpeed(1);
        stage.addActor(parallaxBackground);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
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
