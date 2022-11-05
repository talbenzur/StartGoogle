package week3.structuralPatterns.ex1;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FacadeHttp {
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static Response get(String url) {
        HttpGet httpGet = new HttpGet(url);
        return responseFromHttp(httpGet);
    }
    public static Response delete(String url) throws IOException {
        HttpDelete httpDelete = new HttpDelete(url);
        return responseFromHttp(httpDelete);
    }

    public static Response post(String url, String email, String password) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        Response result = null;

        // add request parameters or form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("email", email));
        urlParameters.add(new BasicNameValuePair("password", password));
        httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));

       return responseFromHttp(httpPost);
    }

    public static Response put(String url, String name, String password) throws IOException {
        HttpPut httpPut = new HttpPut(url);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("password", password));
        httpPut.setEntity(new UrlEncodedFormEntity(urlParameters));

        return responseFromHttp(httpPut);
    }
    public static Response patch(String url, String name, String job) throws IOException {
        HttpPatch httpPatch = new HttpPatch(url);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("job", job));
        httpPatch.setEntity(new UrlEncodedFormEntity(urlParameters));

        return responseFromHttp(httpPatch);
    }


    private static Response responseFromHttp (HttpRequestBase request){
        int statusCode=0;
        String body=null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try(CloseableHttpResponse response = httpClient.execute(request)) {

            // HttpResponse Status
            statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);   // 200

            // HttpResponse body
            HttpEntity entity = response.getEntity();
            body = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(body==null){//if there isn't body
            return new Response(statusCode);
        }
        return new Response(statusCode, body);
    }
}
