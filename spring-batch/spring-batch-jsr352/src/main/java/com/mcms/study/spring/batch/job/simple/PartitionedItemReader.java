package com.mcms.study.spring.batch.job.simple;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;

public class PartitionedItemReader extends AbstractItemReader {

    private static Map<String, StringTokenizer> data = new ConcurrentHashMap<>();
    static {
        data.put("key1", new StringTokenizer("a,b,c,d,e,f,g,h,i,j", ","));
        data.put("key2", new StringTokenizer("0,1,2,3,4,5,6,7,8,9", ","));
    }

    @Inject
    @BatchProperty(name = "key")
    private String key;

    @Override
    public Object readItem() throws Exception {
        return data.get(key).hasMoreElements() ? data.get(key).nextElement() : null;
    }

}
