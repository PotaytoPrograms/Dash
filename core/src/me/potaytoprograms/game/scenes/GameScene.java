package me.potaytoprograms.game.scenes;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import me.potaytoprograms.pixi.p2d.box2d.PhysicsSystem;
import me.potaytoprograms.pixi.shared.scene.IScene;
import me.potaytoprograms.pixi.shared.scene.SceneManager;

public class GameScene implements IScene {
	
	private World world;
	private Engine engine;
	private SceneManager sceneManager;
	private PhysicsSystem physicsSystem;
	
	@Override
	public void init(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
		engine = sceneManager.engine;
		
		world = new World(new Vector2(0,-9.8f), true);
		physicsSystem = new PhysicsSystem();
		world.setContactListener(physicsSystem);
		world.setContactFilter(physicsSystem);
		
	}
	
	@Override
	public void update(float delta) {
		world.step(1f/60f, 6, 2);
		engine.update(delta);
	}
	
	@Override
	public void dispose() {
		world.dispose();
	}
}
