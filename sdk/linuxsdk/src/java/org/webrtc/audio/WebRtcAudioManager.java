/*
 *  Copyright (c) 2015 The WebRTC project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package org.webrtc.audio;

import org.webrtc.Logging;
import org.webrtc.CalledByNative;

/**
 * This class contains static functions to query sample rate and input/output audio buffer sizes.
 */
class WebRtcAudioManager {
  private static final String TAG = "WebRtcAudioManagerExternal";

  private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;

  // Default audio data format is PCM 16 bit per sample.
  // Guaranteed to be supported by all devices.
  private static final int BITS_PER_SAMPLE = 16;

  private static final int DEFAULT_FRAME_PER_BUFFER = 256;
  
  private static AudioManager manager = new AudioManager(); 

  @CalledByNative
  static AudioManager getAudioManager() {
    return manager;
  }

  @CalledByNative
  static int getOutputBufferSize(AudioManager audioManager, int sampleRate, int numberOfOutputChannels) {
    return isLowLatencyOutputSupported()
        ? getLowLatencyFramesPerBuffer(audioManager)
        : getMinOutputFrameSize(sampleRate, numberOfOutputChannels);
  }

  @CalledByNative
  static int getInputBufferSize(AudioManager audioManager, int sampleRate, int numberOfInputChannels) {
    return isLowLatencyInputSupported()
        ? getLowLatencyFramesPerBuffer(audioManager)
        : getMinInputFrameSize(sampleRate, numberOfInputChannels);
  }

  private static boolean isLowLatencyOutputSupported() {
    return false;
  }

  private static boolean isLowLatencyInputSupported() {
    return false;
  }

  /**
   * Returns the native input/output sample rate for this device's output stream.
   */
  @CalledByNative
  static int getSampleRate(AudioManager audioManager) {
    // Override this if we're running on an old emulator image which only
    // supports 8 kHz and doesn't support PROPERTY_OUTPUT_SAMPLE_RATE.
    if (WebRtcAudioUtils.runningOnEmulator()) {
      Logging.d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
      return 8000;
    }
    // Deliver best possible estimate based on default Android AudioManager APIs.
    final int sampleRateHz = getSampleRateForApiLevel(audioManager);
    Logging.d(TAG, "Sample rate is set to " + sampleRateHz + " Hz");
    return sampleRateHz;
  }

  private static int getSampleRateForApiLevel(AudioManager audioManager) {
      return DEFAULT_SAMPLE_RATE_HZ;
  }

  // Returns the native output buffer size for low-latency output streams.
  private static int getLowLatencyFramesPerBuffer(AudioManager audioManager) {
      return DEFAULT_FRAME_PER_BUFFER;
  }

  // Returns the minimum output buffer size for Java based audio (AudioTrack).
  // This size can also be used for OpenSL ES implementations on devices that
  // lacks support of low-latency output.
  private static int getMinOutputFrameSize(int sampleRateInHz, int numChannels) {
    return DEFAULT_FRAME_PER_BUFFER; 
  }

  // Returns the minimum input buffer size for Java based audio (AudioRecord).
  // This size can calso be used for OpenSL ES implementations on devices that
  // lacks support of low-latency input.
  private static int getMinInputFrameSize(int sampleRateInHz, int numChannels) {
	  return DEFAULT_FRAME_PER_BUFFER;
  }
}
