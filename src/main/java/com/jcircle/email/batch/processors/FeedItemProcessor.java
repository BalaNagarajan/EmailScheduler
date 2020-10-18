package com.jcircle.email.batch.processors;

import org.springframework.batch.item.ItemProcessor;

public class FeedItemProcessor implements ItemProcessor<String,String> {
	
	@Override
    public String process(final String xmlFeedFile) throws Exception {
       
       System.out.println("-----------Feed File For Processing----"+xmlFeedFile);
       
        return xmlFeedFile;
    }

}
