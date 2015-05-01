package core.service;

/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */



/**
 * An example that performs GETs from multiple threads.
 *
 */
/*
public class ClientMultiThreadedExecution {
    public static List<String> requestHistoricalData(List<String> tickerList) throws Exception {
        // Create an HttpClient with the ThreadSafeClientConnManager.
        // This connection manager must be used if more than one thread will
        // be using the HttpClient.
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);

        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
        try {
            // create an array of URIs to perform GETs on
            ConcurrentLinkedDeque<String> urisToGet = new ConcurrentLinkedDeque<>();
            urisToGet.add("http://hc.apache.org/"); //debug - used ticker list TODO
            urisToGet.add("http://hc.apache.org/httpcomponents-core-ga/");
            urisToGet.add("http://hc.apache.org/httpcomponents-client-ga/");
            
            
            		
            // create a thread for each URI
            List<GetResponse> threads = new ArrayList<>(urisToGet.size());
            //GetThread[] threads = new GetThread[urisToGet.length];
            return threads.stream().map((t)->{
            	HttpGet temp = new HttpGet(urisToGet.remove());
            	t = new GetResponse(cm, temp, 0);
            	//debug
            	String toReturn = t.toString();
            	System.out.println(toReturn);
            	return toReturn;
            }).collect(Collectors.toList());

        } finally {
            httpclient.close();
        }
    }
}*/
/*
    /**
     * A thread that performs a GET.
     */
/*
    class GetResponse {

        private final CloseableHttpClient httpClient;
        private final HttpContext context;
        private final HttpGet httpget;
        private final int id;

        public GetResponse(CloseableHttpClient httpClient, HttpGet httpget, int id) {
            this.httpClient = httpClient;
            this.context = new BasicHttpContext();
            this.httpget = httpget;
            this.id = id;
        }

        public String toString() {
            try {
                System.out.println(id + " - about to get something from " + httpget.getURI());
                CloseableHttpResponse response = httpClient.execute(httpget, context);
                try {
                    System.out.println(id + " - get executed");
                    // get the response body as an array of bytes
                    HttpEntity entity = response.getEntity();
                    if (entity != null){
                       return EntityUtils.toString(entity);
                    }
                } finally {
                    response.close();
                }
            } catch (Exception e) {
                System.out.println(id + " - error: " + e);
                return null;
            }
			return null;
        }

    }
*/
