/*
 *  Copyright 2017 The WebRTC project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package org.webrtc;

import java.util.Arrays;
import java.util.LinkedHashSet;

/** Helper class that combines HW and SW encoders. */
public class DefaultVideoEncoderFactory implements VideoEncoderFactory {
  private final VideoEncoderFactory softwareVideoEncoderFactory = new SoftwareVideoEncoderFactory();

  @Override
  public VideoEncoder createEncoder(VideoCodecInfo info) {
    final VideoEncoder softwareEncoder = softwareVideoEncoderFactory.createEncoder(info);
    return softwareEncoder;
  }

  @Override
  public VideoCodecInfo[] getSupportedCodecs() {
    LinkedHashSet<VideoCodecInfo> supportedCodecInfos = new LinkedHashSet<VideoCodecInfo>();

    supportedCodecInfos.addAll(Arrays.asList(softwareVideoEncoderFactory.getSupportedCodecs()));

    return supportedCodecInfos.toArray(new VideoCodecInfo[supportedCodecInfos.size()]);
  }
}
