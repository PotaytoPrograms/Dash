package me.potaytoprograms.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.potaytoprograms.game.scenes.GameScene;
import me.potaytoprograms.pixi.shared.scene.SceneManager;

public class Game extends ApplicationAdapter {
	
	SpriteBatch batch;
	SceneManager sceneManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		sceneManager = new SceneManager();
		
		sceneManager.loadScene(new GameScene());
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sceneManager.update(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		sceneManager.dispose();
	}
}
