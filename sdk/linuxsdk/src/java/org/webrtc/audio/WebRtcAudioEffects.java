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

// This class wraps control of three different platform effects. Supported
// effects are: AcousticEchoCanceler (AEC) and NoiseSuppressor (NS).
// Calling enable() will active all effects that are
// supported by the device if the corresponding |shouldEnableXXX| member is set.
class WebRtcAudioEffects {
  private static final String TAG = "WebRtcAudioEffectsExternal";

  // Returns true if all conditions for supporting HW Acoustic Echo Cancellation (AEC) are
  // fulfilled.
  public static boolean isAcousticEchoCancelerSupported() {
      return false;
  }

  // Returns true if all conditions for supporting HW Noise Suppression (NS) are fulfilled.
  public static boolean isNoiseSuppressorSupported() {
      return false;
  }

  public WebRtcAudioEffects() {
    Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
  }

  // Call this method to enable or disable the platform AEC. It modifies
  // |shouldEnableAec| which is used in enable() where the actual state
  // of the AEC effect is modified. Returns true if HW AEC is supported and
  // false otherwise.
  public boolean setAEC(boolean enable) {
    return true;
  }

  // Call this method to enable or disable the platform NS. It modifies
  // |shouldEnableNs| which is used in enable() where the actual state
  // of the NS effect is modified. Returns true if HW NS is supported and
  // false otherwise.
  public boolean setNS(boolean enable) {
	  return true;
  }

  public void enable(int audioSession) {
  }

  // Releases all native audio effect resources. It is a good practice to
  // release the effect engine when not in use as control can be returned
  // to other applications or the native resources released.
  public void release() {
  }
}
