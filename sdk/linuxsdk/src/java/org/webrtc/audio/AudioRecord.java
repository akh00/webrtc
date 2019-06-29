package org.webrtc.audio;

import java.nio.ByteBuffer;

public class AudioRecord {

	public static final int ERROR_INVALID_OPERATION = -1;
	public static final int ERROR = -1;
	public static final int ERROR_BAD_VALUE = 0;
	public static final int STATE_INITIALIZED = 0;
	public static final int RECORDSTATE_RECORDING = 1;

	public AudioRecord(int audioSource, int sampleRate, int channelConfig, int audioFormat, int bufferSizeInBytes) {
		// TODO Auto-generated constructor stub
	}

	public int read(ByteBuffer byteBuffer, int capacity) {
		// TODO Auto-generated method stub
		return 256;
	}

	public int getChannelCount() {
		return 2;
	}

	public int getSampleRate() {
		return 16000;
	}

	public int getAudioFormat() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}

	public static int getMinBufferSize(int sampleRate, int channelConfig, int audioFormat) {
		return 256;
	}

	public int getState() {
		return STATE_INITIALIZED;
	}

	public int getAudioSessionId() {
		return 0;
	}

	public void startRecording() {
		// TODO Auto-generated method stub
		
	}

	public int getRecordingState() {
		// TODO Auto-generated method stub
		return RECORDSTATE_RECORDING;
	}

	public void release() {
		// TODO Auto-generated method stub
		
	}

}
