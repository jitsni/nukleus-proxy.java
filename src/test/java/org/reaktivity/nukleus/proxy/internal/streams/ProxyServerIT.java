/**
 * Copyright 2016-2021 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus.proxy.internal.streams;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;
import static org.reaktivity.reaktor.test.ReaktorRule.EXTERNAL_AFFINITY_MASK;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;
import org.reaktivity.reaktor.test.ReaktorRule;

public class ProxyServerIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("route", "org/reaktivity/specification/nukleus/proxy/control/route")
        .addScriptRoot("client", "org/reaktivity/specification/nukleus/proxy/streams/network.v2")
        .addScriptRoot("server", "org/reaktivity/specification/nukleus/proxy/streams/application");

    private final TestRule timeout = new DisableOnDebug(new Timeout(10, SECONDS));

    private final ReaktorRule reaktor = new ReaktorRule()
        .directory("target/nukleus-itests")
        .commandBufferCapacity(1024)
        .responseBufferCapacity(1024)
        .counterValuesBufferCapacity(4096)
        .nukleus("proxy"::equals)
        .affinityMask("app#0", EXTERNAL_AFFINITY_MASK)
        .clean();

    @Rule
    public final TestRule chain = outerRule(reaktor).around(k3po).around(timeout);

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local/client",
        "${server}/connected.local/server" })
    public void shouldConnectLocal() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.discard/client",
        "${server}/connected.local.discard/server" })
    public void shouldConnectLocalDiscard() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.client.sent.begin.ext/client",
        "${server}/connected.local.client.sent.begin.ext/server" })
    public void shouldConnectLocalClientSendsBeginExt() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.client.sent.data/client",
        "${server}/connected.local.client.sent.data/server"})
    public void shouldConnectLocalClientSendsData() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.client.sent.flush/client",
        "${server}/connected.local.client.sent.flush/server"})
    public void shouldConnectLocalClientSendsFlush() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.client.sent.challenge/client",
        "${server}/connected.local.client.sent.challenge/server"})
    public void shouldConnectLocalClientSendsChallenge() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.client.sent.close/client",
        "${server}/connected.local.client.sent.close/server"})
    public void shouldConnectLocalClientSendsClose() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.client.sent.abort/client",
        "${server}/connected.local.client.sent.abort/server"})
    public void shouldConnectLocalClientSendsAbort() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.client.sent.reset/client",
        "${server}/connected.local.client.sent.reset/server"})
    public void shouldConnectLocalClientSendsReset() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.server.sent.data/client",
        "${server}/connected.local.server.sent.data/server"})
    public void shouldConnectLocalServerSendsData() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.server.sent.flush/client",
        "${server}/connected.local.server.sent.flush/server"})
    public void shouldConnectLocalServerSendsFlush() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.server.sent.challenge/client",
        "${server}/connected.local.server.sent.challenge/server"})
    public void shouldConnectLocalServerSendsChallenge() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.server.sent.close/client",
        "${server}/connected.local.server.sent.close/server"})
    public void shouldConnectLocalServerSendsClose() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.server.sent.abort/client",
        "${server}/connected.local.server.sent.abort/server"})
    public void shouldConnectLocalServerSendsAbort() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.local.server.sent.reset/client",
        "${server}/connected.local.server.sent.reset/server"})
    public void shouldConnectLocalServerSendsReset() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server.tcp4/controller",
        "${client}/connected.tcp4/client",
        "${server}/connected.tcp4/server"})
    public void shouldConnectTcp4() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server.tcp4.alpn/controller",
        "${client}/connected.tcp4.alpn/client",
        "${server}/connected.tcp4.alpn/server"})
    public void shouldConnectTcp4WithAlpn() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.authority/client",
        "${server}/connected.tcp4.authority/server"})
    public void shouldConnectTcp4WithAuthority() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.crc32c/client",
        "${server}/connected.tcp4.crc32c/server"})
    public void shouldConnectTcp4WithCrc32c() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.identity/client",
        "${server}/connected.tcp4.identity/server"})
    public void shouldConnectTcp4WithIdentity() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.namespace/client",
        "${server}/connected.tcp4.namespace/server"})
    public void shouldConnectTcp4WithNamespace() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.noop/client",
        "${server}/connected.tcp4.noop/server"})
    public void shouldConnectTcp4WithNoop() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.ssl/client",
        "${server}/connected.tcp4.ssl/server"})
    public void shouldConnectTcp4WithSsl() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.ssl.client.cert/client",
        "${server}/connected.tcp4.ssl.client.cert/server"})
    public void shouldConnectTcp4WithSslClientCertificate() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.ssl.client.cert.session/client",
        "${server}/connected.tcp4.ssl.client.cert.session/server"})
    public void shouldConnectTcp4WithSslClientCertificateSession() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.ssl.experimental/client",
        "${server}/connected.tcp4.ssl.experimental/server"})
    public void shouldConnectTcp4WithSslExperimental() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.tcp4.experimental/client",
        "${server}/connected.tcp4.experimental/server"})
    public void shouldConnectTcp4WithExperimental() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.udp4/client",
        "${server}/connected.udp4/server"})
    public void shouldConnectUdp4() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server.tcp6/controller",
        "${client}/connected.tcp6/client",
        "${server}/connected.tcp6/server"})
    public void shouldConnectTcp6() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.udp6/client",
        "${server}/connected.udp6/server"})
    public void shouldConnectUdp6() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server.sock.stream/controller",
        "${client}/connected.sock.stream/client",
        "${server}/connected.sock.stream/server"})
    public void shouldConnectSockStream() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/connected.sock.datagram/client",
        "${server}/connected.sock.datagram/server"})
    public void shouldConnectSockDatagram() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.header.mismatch/client"})
    public void shouldRejectHeaderMismatch() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.header.version.mismatch/client"})
    public void shouldRejectHeaderVersionMismatch() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.tcp4.crc32c.mismatch/client"})
    public void shouldRejectTcp4WithCrc32cMismatch() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.tcp4.crc32c.overflow/client"})
    public void shouldRejectTcp4WithCrc32cOverflow() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.tcp4.crc32c.underflow/client"})
    public void shouldRejectTcp4WithCrc32cUnderflow() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.tcp4.ssl.underflow/client"})
    public void shouldRejectTcp4WithSslUnderflow() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.tcp4.underflow/client"})
    public void shouldRejectTcp4Underflow() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.tcp6.underflow/client"})
    public void shouldRejectTcp6Underflow() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.sock.stream.underflow/client"})
    public void shouldRejectSockStreamUnderflow() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.address.family.mismatch/client"})
    public void shouldRejectAddressFamilyMismatch() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/rejected.command.mismatch/client"})
    public void shouldRejectCommandMismatch() throws Exception
    {
        k3po.finish();
    }
}
