package org.webrtc.audio;

import org.webrtc.Logging;
import org.webrtc.Logging.Severity;

public class AudioTrack {

	public static final int PLAYSTATE_PLAYING = 2;
	public static final int STATE_INITIALIZED = 1;
	
	
	private int state = STATE_INITIALIZED;

	public void stop() {
		// TODO Auto-generated method stub
		
	}

	public int write(byte[] array, int arrayOffset, int sizeInBytes) {
		 Logging.log(Severity.LS_INFO, "AudioTrack.write: ","array:" + sizeInBytes);
		return sizeInBytes;
	}

	public static int getMinBufferSize(int sampleRate, int channelConfig, int encodingPcm16bit) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getState() {
		return state;
	}

	public void play() {
		state = PLAYSTATE_PLAYING;
		
	}

	public int getPlayState() {
		return PLAYSTATE_PLAYING;
	}

	public void release() {
		// TODO Auto-generated method stub
		
	}

}
