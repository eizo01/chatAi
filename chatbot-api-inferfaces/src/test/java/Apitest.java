import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;



import java.io.IOException;

public class Apitest {
    /**
     * 爬虫知识星球向我提问的问题
     * @throws IOException
     */
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 不能轻易改掉 查询等我回答的所有问题
        HttpGet get = new HttpGet(
                "https://api.zsxq.com/v2/groups/15552585485252/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxq_access_token=4DED7012-CDF0-ACCB-2970-9969509B7D69_BFA4DCC8614FB74C; UM_distinctid=1879d72115613a-03318dc18cba4c-26031b51-144000-1879d7211571150; sensorsdata2015jssdkcross={\"distinct_id\":\"421155514152558\",\"first_id\":\"18053e2aed59a-034d41ab0490ae2-6b3e555b-921600-18053e2aed7f55\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgwNTNlMmFlZDU5YS0wMzRkNDFhYjA0OTBhZTItNmIzZTU1NWItOTIxNjAwLTE4MDUzZTJhZWQ3ZjU1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDIxMTU1NTE0MTUyNTU4In0=\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"421155514152558\"},\"$device_id\":\"18053e2aed59a-034d41ab0490ae2-6b3e555b-921600-18053e2aed7f55\"}; zsxqsessionid=0c0b588225e002b2feaf7316a8e505cc; abtest_env=product");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    // https://api.zsxq.com/v2/topics/412528412458448/answer
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 不能轻易改掉 这里是问题的id
        HttpPost post = new HttpPost(
                "https://api.zsxq.com/v2/topics/181415281242812/answer");

        post.addHeader("cookie","zsxq_access_token=4DED7012-CDF0-ACCB-2970-9969509B7D69_BFA4DCC8614FB74C; UM_distinctid=1879d72115613a-03318dc18cba4c-26031b51-144000-1879d7211571150; sensorsdata2015jssdkcross={\"distinct_id\":\"421155514152558\",\"first_id\":\"18053e2aed59a-034d41ab0490ae2-6b3e555b-921600-18053e2aed7f55\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgwNTNlMmFlZDU5YS0wMzRkNDFhYjA0OTBhZTItNmIzZTU1NWItOTIxNjAwLTE4MDUzZTJhZWQ3ZjU1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDIxMTU1NTE0MTUyNTU4In0=\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"421155514152558\"},\"$device_id\":\"18053e2aed59a-034d41ab0490ae2-6b3e555b-921600-18053e2aed7f55\"}; zsxqsessionid=0c0b588225e002b2feaf7316a8e505cc; abtest_env=product");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"测试：我也不会！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";
//        String paramJson = "{\n" +
//                "  \"req_data\": {\n" +
//                "    \"text\": \"测试：我也不会！\\n\",\n" +
//                "    \"image_ids\": [],\n" +
//                "    \"silenced\": false\n" +
//                "  }\n" +
//                "}";会发送到星球主页
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity( stringEntity);


        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }


    }
}
