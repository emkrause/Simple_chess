package com.simplechess.repositories;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

/**
 *
 * Example CouchBase implementation
 * http://docs.couchbase.com/developer/java-2.1/hello-couchbase.html
 */
public class CDBRepository {


    private final Cluster cluster;
    private final Bucket bucket;

    public CDBRepository() {
        cluster = CouchbaseCluster.create();
    //    Cluster cluster = CouchbaseCluster.create("192.168.0.101", "192.168.0.102");
        bucket = cluster.openBucket();
    //    Bucket bucket = cluster.openBucket("bucket", "password");


        // refactor this to Chess_client
        JsonObject example = JsonObject.empty()
                .put("firstname", "M")
                .put("lastname", "KR");
        JsonDocument response = updateObject("exampleKey", example);

        cluster.disconnect();
    }

    public JsonDocument getObject(String key) {
        JsonDocument result = bucket.get(key);
        System.out.println("Found: " + result);

        return result;
    }

    public JsonDocument updateObject(String key, JsonObject json) {
        JsonDocument doc = JsonDocument.create(key, json);
        return bucket.upsert(doc);

    }
}
