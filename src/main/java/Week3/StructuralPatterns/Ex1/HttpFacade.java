package Week3.StructuralPatterns.Ex1;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HttpFacade {
    static CloseableHttpClient httpClient = HttpClients.createDefault();
    static int statusCode;
    static String body;

    public static Response get(String url) {
        try {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(request)) {

                // Get HttpResponse Status
                statusCode = response.getStatusLine().getStatusCode();
                System.out.println(statusCode);   // 200

                HttpEntity entity = response.getEntity();
                body = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return new Response(statusCode, body);

    }


    public static Response delete(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(url);

        CloseableHttpResponse response = httpClient.execute(httpDelete);
        // Get HttpResponse Status
        statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);   // 200

        HttpEntity entity = response.getEntity();
        body = EntityUtils.toString(entity);
        return new Response(statusCode, body);
    }

    public static Response post(String url, String email, String password) {
        HttpPost post = new HttpPost(url);
        Response result = null;

        // add request parameters or form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("email", email));
        urlParameters.add(new BasicNameValuePair("password", password));
        try{
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(post)){

                result = new Response(response.getStatusLine().getStatusCode(),EntityUtils.toString(response.getEntity()));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Response put(String url, String name, String password) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("password", password));
        httpPut.setEntity(new UrlEncodedFormEntity(urlParameters));
        CloseableHttpResponse response = httpClient.execute(httpPut);
        // Get HttpResponse Status
         statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);   // 200

        HttpEntity entity = response.getEntity();
        body = EntityUtils.toString(entity);
        return new Response(statusCode, body);
    }

    public static Response patch(String url, String name, String job) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch(url);
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("job", job));
        httpPatch.setEntity(new UrlEncodedFormEntity(urlParameters));
        CloseableHttpResponse response = httpClient.execute(httpPatch);
        // Get HttpResponse Status
        statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);   // 200

        HttpEntity entity = response.getEntity();
        body = EntityUtils.toString(entity);
        return new Response(statusCode, body);
    }


}
