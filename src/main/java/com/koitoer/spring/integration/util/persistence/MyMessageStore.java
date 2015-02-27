/**
 * 
 */
package com.koitoer.spring.integration.util.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.integration.Message;
import org.springframework.integration.mongodb.store.ConfigurableMongoDbMessageStore;
import org.springframework.integration.store.MessageGroup;
import org.springframework.stereotype.Component;

/**
 * @author Koitoer
 *
 */
@Component("myMessageStore")
public class MyMessageStore extends ConfigurableMongoDbMessageStore {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String STORE_COLLECTION_NAME = "messageStoreCollection";
 
    @Autowired
    public MyMessageStore(MongoDbFactory mongoDbFactory) {
        super(mongoDbFactory, STORE_COLLECTION_NAME);
        logger.info("Creating message store '{}'", STORE_COLLECTION_NAME);
    }
     
    @Override
    public MessageGroup addMessageToGroup(Object groupId, Message<?> message) {
        logger.info("Adding message '{}' to group '{}'", message.getPayload(), groupId);
        return super.addMessageToGroup(groupId, message);
    }
 
    @Override
    public Message<?> pollMessageFromGroup(Object groupId) {
        Message<?> msg = super.pollMessageFromGroup(groupId);
        if (msg != null) {
            logger.info("polling message '{}' from group '{}'", msg.getPayload(), groupId);
        }
        else {
            logger.info("Polling null message from group {}", groupId);
        }
         
        return msg;
    }
}
