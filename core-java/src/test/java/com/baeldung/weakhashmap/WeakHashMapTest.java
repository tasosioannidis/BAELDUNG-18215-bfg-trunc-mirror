package com.baeldung.weakhashmap;


import org.junit.Test;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

public class WeakHashMapTest {

    @Test
    public void givenWeakHashMap_whenCacheValueThatHasNoReferenceToIt_GCShouldReclaimThatObject() {
        //given
        WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        BigImage bigImage = new BigImage("foo");
        UniqueImageName imageName = new UniqueImageName("name_of_big_image");

        map.put(imageName, bigImage);
        assertTrue(map.containsKey(imageName));

        //when big image is not in use anymore
        imageName = null;
        System.gc();

        //then GC will finally reclaim that object
        await().atMost(10, TimeUnit.SECONDS).until(map::isEmpty);
    }


    class BigImage {
        public final String imageId;

        BigImage(String imageId) {
            this.imageId = imageId;
        }
    }

    class UniqueImageName {
        public final String imageName;

        UniqueImageName(String imageName) {
            this.imageName = imageName;
        }
    }
}
