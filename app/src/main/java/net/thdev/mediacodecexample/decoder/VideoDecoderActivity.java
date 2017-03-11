package net.thdev.mediacodecexample.decoder;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;

/**
 * MediaCodec SurfaceHolder Example
 * @author taehwan
 *
 */
public class VideoDecoderActivity extends Activity implements SurfaceHolder.Callback , TextureView.SurfaceTextureListener {
	private VideoDecoderThread mVideoDecoder;
	
	private static final String FILE_PATH = "/storage/9C33-6BBD/1.mp4";
	TextureView mTextureView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		SurfaceView surfaceView = new SurfaceView(this);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//		surfaceView.getHolder().addCallback(this);
//		setContentView(surfaceView);
		mTextureView = new TextureView(this);
		mTextureView.setSurfaceTextureListener(this);
		setContentView(mTextureView);
		mVideoDecoder = new VideoDecoderThread();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,	int height) {
		if (mVideoDecoder != null) {
			if (mVideoDecoder.init(holder.getSurface(), FILE_PATH)) {
				mVideoDecoder.start();
				
			} else {
				mVideoDecoder = null;
			}
			
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		if (mVideoDecoder != null) {
			mVideoDecoder.close();
		}
	}

	@Override
	public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
//		if (mVideoDecoder != null) {
//			if (mVideoDecoder.init(surfaceTexture, FILE_PATH)) {
//				mVideoDecoder.start();
//
//			} else {
//				mVideoDecoder = null;
//			}
//
//		}
	}

	@Override
	public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

	}

	@Override
	public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
		return false;
	}

	@Override
	public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

	}
}
