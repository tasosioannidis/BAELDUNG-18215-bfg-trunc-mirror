package org.baeldung.httpclient;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpClientRedirectLiveTest {

    private CloseableHttpClient instance;

    private CloseableHttpResponse response;

    @Before
    public final void before() {
        instance = HttpClientBuilder.create().build();
    }

    @After
    public final void after() throws IllegalStateException, IOException {
        if (response == null) {
            return;
        }

        try {
            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                final InputStream instream = entity.getContent();
                instream.close();
            }
        } finally {
            response.close();
        }
    }

    // tests

    @Test
    public final void givenRedirectsAreDisabledViaDeprecatedApi_whenConsumingUrlWhichRedirects_thenNotRedirected() throws ClientProtocolException, IOException {
        instance = new DefaultHttpClient();

        final HttpParams params = new BasicHttpParams();
        params.setParameter(ClientPNames.HANDLE_REDIRECTS, false);
        HttpClientParams.setRedirecting(params, false);

        final HttpGet httpGet = new HttpGet("http://t.co/I5YYd9tddw");
        httpGet.setParams(params);
        response = instance.execute(httpGet);

        assertThat(response.getStatusLine().getStatusCode(), equalTo(301));
    }

    @Test
    public final void givenRedirectsAreDisabled_whenConsumingUrlWhichRedirects_thenNotRedirected() throws ClientProtocolException, IOException {
        instance = HttpClientBuilder.create().disableRedirectHandling().build();
        response = instance.execute(new HttpGet("http://t.co/I5YYd9tddw"));
        assertThat(response.getStatusLine().getStatusCode(), equalTo(301));
    }

    // redirect with POST

    @Test
    public final void givenPostRequest_whenConsumingUrlWhichRedirects_thenNotRedirected() throws ClientProtocolException, IOException {
        instance = HttpClientBuilder.create().build();
        response = instance.execute(new HttpPost("http://t.co/I5YYd9tddw"));
        assertThat(response.getStatusLine().getStatusCode(), equalTo(301));
    }

    @Test
    public final void givenRedirectingPOSTViaPre4_2Api_whenConsumingUrlWhichRedirectsWithPOST_thenRedirected() throws ClientProtocolException, IOException {
        final DefaultHttpClient client = new DefaultHttpClient();
        client.setRedirectStrategy(new DefaultRedirectStrategy() {
            /** Redirectable methods. */
            private final String[] REDIRECT_METHODS = new String[] { HttpGet.METHOD_NAME, HttpPost.METHOD_NAME, HttpHead.METHOD_NAME };

            @Override
            protected boolean isRedirectable(final String method) {
                for (final String m : REDIRECT_METHODS) {
                    if (m.equalsIgnoreCase(method)) {
                        return true;
                    }
                }
                return false;
            }
        });

        response = client.execute(new HttpPost("http://t.co/I5YYd9tddw"));
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    }

    @Test
    public final void givenRedirectingPOSTVia4_2Api_whenConsumingUrlWhichRedirectsWithPOST_thenRedirected() throws ClientProtocolException, IOException {
        final DefaultHttpClient client = new DefaultHttpClient();
        client.setRedirectStrategy(new LaxRedirectStrategy());

        response = client.execute(new HttpPost("http://t.co/I5YYd9tddw"));
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    }

    @Test
    public final void givenRedirectingPOST_whenConsumingUrlWhichRedirectsWithPOST_thenRedirected() throws ClientProtocolException, IOException {
        instance = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        response = instance.execute(new HttpPost("http://t.co/I5YYd9tddw"));
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    }

}
