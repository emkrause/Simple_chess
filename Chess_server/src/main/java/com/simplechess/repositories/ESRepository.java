package com.simplechess.repositories;


import org.elasticsearch.client.Client;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example ES implementation.
 * Just to have a base
 */
public class ESRepository {

    private static final Logger logger = LoggerFactory.getLogger(ESRepository.class);

    private static final String CLUSTER_NAME = "logcluster";
    private static final String TEST_SEARCH = "localtestsearch";
    private static final String LOCATION = "localhost";
    private static final int PORT = 9300;

    private Settings settings;
    private TransportClient tsc;

    public ESRepository() {
        settings = ImmutableSettings.settingsBuilder().put(CLUSTER_NAME, TEST_SEARCH).build();
        tsc = new TransportClient(settings);
    }

//    public Client getTSC() {
//        tsc.addTransportAdress(new InetSocketTransportAddress(LOCATION, PORT));
//        return (Client) tsc;
//    }

    public void writeLog() {

    }


}
