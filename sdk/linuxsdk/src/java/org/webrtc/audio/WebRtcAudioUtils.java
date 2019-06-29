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

final class WebRtcAudioUtils {
  // Helper method for building a string of thread information.
  public static String getThreadInfo() {
    return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId()
        + "]";
  }

  // Returns true if we're running on emulator.
  public static boolean runningOnEmulator() {
    return false;
  }

  // Information about the current build, taken from system properties.
  static void logDeviceInfo(String tag) {
    Logging.d(tag,
        "logDeviceInfo");
  }

  // Logs information about the current audio state. The idea is to call this
  // method when errors are detected to log under what conditions the error
  // occurred. Hopefully it will provide clues to what might be the root cause.
  static void logAudioState(String tag, AudioManager audioManager) {
    logDeviceInfo(tag);
    logAudioStateBasic(tag, audioManager);
    logAudioStateVolume(tag, audioManager);
    logAudioDeviceInfo(tag, audioManager);
  }

  // Reports basic audio statistics.
  private static void logAudioStateBasic(String tag, AudioManager audioManager) {
  }

  // Adds volume information for all possible stream types.
  private static void logAudioStateVolume(String tag, AudioManager audioManager) {
  }

  private static void logAudioDeviceInfo(String tag, AudioManager audioManager) {
  }

  // Converts media.AudioManager modes into local string representation.
  static String modeToString(int mode) {
        return "MODE_INVALID";
  }
}
