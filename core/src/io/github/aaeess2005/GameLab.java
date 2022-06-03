package io.github.aaeess2005;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameLab extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img0,img1,img2;
	PerspectiveCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img0 = new Texture("badlogic.jpg");
		img1=new Texture("sample.png");
		img2=new Texture("man.gif");
		camera=new PerspectiveCamera();
	}

	@Override
	public void render () {
		Gdx.gl.glViewport( 0 ,  0 , SharedConstants.WIDTH, SharedConstants.HEIGHT);
		Gdx.gl.glClear( GL20.GL_DEPTH_BUFFER_BIT);

		batch.begin();
		batch.draw(img2,Gdx.graphics.getFrameId()*2f-100,100,100,100);
		batch.end();
		if(Gdx.graphics.getFrameId()*2f-100>SharedConstants.WIDTH){
			Gdx.app.exit();
			Gdx.app.log("aaeess2005","Surprise!");
		}
		RandomXS128 rand=new RandomXS128();
		if(
				rand.nextBoolean() &&
				rand.nextBoolean() &&
				rand.nextBoolean() &&
				rand.nextBoolean() &&
				rand.nextBoolean() &&
				rand.nextBoolean()){
			ScreenUtils.clear(0,1,1,1);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img0.dispose();
		img1.dispose();
		img2.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

	}

	@Override
	public void resume() {
		super.resume();
	}
}
