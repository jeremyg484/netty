/*
 * Copyright 2020 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty5.channel.uring;

import io.netty5.bootstrap.Bootstrap;
import io.netty5.bootstrap.ServerBootstrap;
import io.netty5.testsuite.transport.TestsuitePermutation;
import io.netty5.testsuite.transport.socket.SocketHalfClosedTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.List;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class IOUringSocketHalfClosedTest extends SocketHalfClosedTest {

    @BeforeAll
    public static void loadJNI() {
        assumeTrue(IOUring.isAvailable());
    }

    @Override
    protected List<TestsuitePermutation.BootstrapComboFactory<ServerBootstrap, Bootstrap>> newFactories() {
        return IOUringSocketTestPermutation.INSTANCE.socket();
    }

    @Override
    @Disabled // TODO was disabled in 4.1 code as well... figure out why?
    @Test
    public void testAutoCloseFalseDoesShutdownOutput(TestInfo testInfo) throws Throwable {
        super.testAutoCloseFalseDoesShutdownOutput(testInfo);
    }
}