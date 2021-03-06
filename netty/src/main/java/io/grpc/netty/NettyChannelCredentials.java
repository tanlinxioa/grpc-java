/*
 * Copyright 2020 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.ChannelCredentials;

/** A credential with full control over the security handshake. */
final class NettyChannelCredentials extends ChannelCredentials {
  public static ChannelCredentials create(ProtocolNegotiator.ClientFactory negotiator) {
    return new NettyChannelCredentials(negotiator);
  }

  private final ProtocolNegotiator.ClientFactory negotiator;

  private NettyChannelCredentials(ProtocolNegotiator.ClientFactory negotiator) {
    this.negotiator = Preconditions.checkNotNull(negotiator, "negotiator");
  }

  public ProtocolNegotiator.ClientFactory getNegotiator() {
    return negotiator;
  }
}
